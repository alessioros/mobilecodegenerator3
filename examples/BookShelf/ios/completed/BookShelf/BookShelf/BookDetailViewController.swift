//
//  BookDetailViewController.swift
//  BookShelf
//
//  Created by alessio rossotti on 03/09/17.
//  Copyright © 2017 polimi. All rights reserved.
//

import UIKit

class BookDetailViewController: UIViewController{
    
    var bookTitle = ""
    var book : Book? = nil
    @IBOutlet weak var bookTitleL: UILabel!
    @IBOutlet weak var bookDescL: UILabel!
    @IBOutlet weak var bookPagesL: UILabel!
    @IBOutlet weak var bookPublishedDateL: UILabel!
    @IBOutlet weak var bookPublisherL: UILabel!
    @IBOutlet weak var bookAuthorL: UILabel!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        self.bookTitleL.text = book?.title
        self.bookAuthorL.text = book?.author
        self.bookDescL.text = book?.description_
        self.bookPagesL.text = (book?.pageCount.description)! + " pages"
        self.bookPublisherL.text = book?.publisher
        self.bookPublishedDateL.text = book?.publishedDate
        
    }
}
