//
//  AddBookViewController.swift
//  BookShelf
//
//  Created by alessio rossotti on 22/08/17.
//  Copyright © 2017 polimi. All rights reserved.
//

import UIKit

class AddBookViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate{
    
    @IBOutlet weak var pageCountText: UITextField!
    @IBOutlet weak var pubDateText: UITextField!
    @IBOutlet weak var publisherText: UITextField!
    @IBOutlet weak var descriptionText: UITextField!
    @IBOutlet weak var authorText: UITextField!
    @IBOutlet weak var titleText: UITextField!
    @IBOutlet weak var isbnText: UITextField!
    @IBOutlet weak var selectShelf: UIPickerView!
    
    var shelfName: String = ""
    var selectedShelf: String = ""
    var shelvesDataSource: [String] = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        selectShelf.delegate = self
        let shelves = DatabaseHandler().loadAllShelfs();
        if shelfName != "" {
            shelvesDataSource.append(shelfName)
            selectedShelf = shelfName
        }
        
        for shelf in shelves{
            if shelf.name != shelfName{
                shelvesDataSource.append(shelf.name)
            }
        }
        if selectedShelf == ""{
            selectedShelf = shelves[0].name
        }
    }
    
    @IBAction func addBook(_ sender: Any) {
        let ISBN = isbnText.text
        let title = titleText.text
        let description = descriptionText.text
        let publisher = publisherText.text
        let pubDate = pubDateText.text
        let pageCount = Int32(pageCountText.text!)
        let author = authorText.text
        
        if(ISBN == "" || title == "" || pageCount == nil || author == ""){
            displayError()
            return
        }
        let shelf = DatabaseHandler().loadShelf(name: selectedShelf)
        
        DatabaseHandler.saveBook(ISBN: ISBN!, title: title!, author: author!, description_: description!, pageCount: pageCount!, publisher: publisher!, publishedDate: pubDate!, imgUrl: "", shelf: shelf)
        
        //Go to the ShelfViewController
        _ = navigationController?.popViewController(animated: true)
    }
    
    @IBAction func saveBook(_ sender: UIBarButtonItem) {
        
        let ISBN = isbnText.text
        let title = titleText.text
        let description = descriptionText.text
        let publisher = publisherText.text
        let pubDate = pubDateText.text
        let pageCount = Int32(pageCountText.text!)
        let author = authorText.text
        
        if(ISBN == "" || title == "" || pageCount == nil || author == ""){
            displayError()
            return
        }
        let shelf = DatabaseHandler().loadShelf(name: selectedShelf)
        
        DatabaseHandler.saveBook(ISBN: ISBN!, title: title!, author: author!, description_: description!, pageCount: pageCount!, publisher: publisher!, publishedDate: pubDate!, imgUrl: "", shelf: shelf)
        
        //Go to the ShelfViewController
        _ = navigationController?.popViewController(animated: true)
    }
    
    func displayError(){
        
        let alert = UIAlertController(title: "Incomplete Info", message: "please insert all the book info", preferredStyle: UIAlertControllerStyle.alert)
        alert.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        self.present(alert, animated: true, completion: nil)
        
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return shelvesDataSource.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return shelvesDataSource[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
            selectedShelf = shelvesDataSource[pickerView.selectedRow(inComponent: 0)]
            print("hai scelto la shelf" + selectedShelf)
    }
}
