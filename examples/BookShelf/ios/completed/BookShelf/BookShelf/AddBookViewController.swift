//
//  AddBookViewController.swift
//  BookShelf
//
//  Created by alessio rossotti on 22/08/17.
//  Copyright © 2017 polimi. All rights reserved.
//

import UIKit

class AddBookViewController: UIViewController{
    
    @IBOutlet weak var pageCountText: UITextField!
    @IBOutlet weak var pubDateText: UITextField!
    @IBOutlet weak var publisherText: UITextField!
    @IBOutlet weak var descriptionText: UITextField!
    @IBOutlet weak var authorText: UITextField!
    @IBOutlet weak var titleText: UITextField!
    @IBOutlet weak var isbnText: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @IBAction func saveBook(_ sender: UIBarButtonItem) {
        
        let ISBN = isbnText.text
        let title = titleText.text
        let description = descriptionText.text
        let publisher = publisherText.text
        let pubDate = pubDateText.text
        let pageCount = Int32(pageCountText.text!)
        
        if(ISBN == "" || title == "" || pageCount == nil){
            displayError()
            return
        }
        DatabaseHandler.saveBook(ISBN: ISBN!, title: title!, description_: description!, pageCount: pageCount!, publisher: publisher!, publishedDate: pubDate!, imgUrl: "")
    }
    
    func displayError(){
        
        let alert = UIAlertController(title: "Incomplete Info", message: "please insert all the book info", preferredStyle: UIAlertControllerStyle.alert)
        alert.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        self.present(alert, animated: true, completion: nil)
        
    }
}
