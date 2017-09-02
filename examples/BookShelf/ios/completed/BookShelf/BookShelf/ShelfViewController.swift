//
//  ShelfViewController.swift
//  BookShelf
//
//  Created by alessio rossotti on 22/08/17.
//  Copyright © 2017 polimi. All rights reserved.
//

import UIKit


class ShelfViewController: UITableViewController
{
    
    @IBOutlet weak var navBarItem: UINavigationItem!
    @IBOutlet weak var addButton: UIBarButtonItem!
    @IBOutlet weak var backButton: UIBarButtonItem!
    
    var shelfName: String = ""
    var bookTitle: String = ""
    var book: Book? = nil
    var bookListContents: [String] = []
    
    @IBAction func backPressed(_ sender: Any) {
        //Go to the LibraryViewController
        let vc = self.storyboard?.instantiateViewController(withIdentifier: "LibraryNav")
        self.present(vc!, animated: true, completion: nil)

    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.reloadBooks()
        navBarItem.title = shelfName
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        
        cell.textLabel?.text = bookListContents[indexPath.row]
        return cell
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return bookListContents.count
    }
    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == UITableViewCellEditingStyle.delete {
            tableView.deleteRows(at: [indexPath], with: .bottom)
            DatabaseHandler().deleteBook(isbn: bookListContents[indexPath.row])
            bookListContents.remove(at: indexPath.row)
        }
    }
    
    func reloadBooks(){
        
        bookListContents = []
        
        let books = DatabaseHandler().loadAllBooks()
        
        for book in books {
            bookListContents.append(book.title!)
        }
        
        self.tableView.reloadData()
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("You selected cell #\(indexPath.row)!")
        
        // Get Cell Label
        let indexPath = tableView.indexPathForSelectedRow;
        let currentCell = tableView.cellForRow(at: indexPath!) as UITableViewCell!;
        
        bookTitle = (currentCell?.textLabel?.text!)!
        book = DatabaseHandler().loadBookByTitle(title: bookTitle)
        performSegue(withIdentifier: "BookDetail", sender: self)
        
    }

    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if (segue.identifier == "BookDetail") {
            let vc = segue.destination as! BookDetailViewController
            vc.titleText = bookTitle
            //vc.book = book
        }
    }

}
