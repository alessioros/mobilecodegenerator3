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
    
    var shelfName: String = ""
    var bookTitle: String = ""
    var book: Book? = nil
    var bookListContents: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.reloadBooks()
        navBarItem.title = shelfName
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.reloadBooks()
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
        
        let books = DatabaseHandler().loadShelfBooks(shelfName: shelfName)
        
        for book in books {
            bookListContents.append(book.title!)
        }
        
        self.tableView.reloadData()
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let indexPath = tableView.indexPathForSelectedRow;
        let currentCell = tableView.cellForRow(at: indexPath!) as UITableViewCell!;
        
        bookTitle = (currentCell?.textLabel?.text!)!
        book = DatabaseHandler().loadBookByTitle(title: bookTitle)
        performSegue(withIdentifier: "BookDetail", sender: self)
    }

    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if (segue.identifier == "BookDetail") {
            let vc = segue.destination as! BookDetailViewController
            vc.book = book
        }
        
        if (segue.identifier == "addBook") {
            let vc = segue.destination as! AddBookViewController
            vc.shelfName = shelfName
        }
    }

}
