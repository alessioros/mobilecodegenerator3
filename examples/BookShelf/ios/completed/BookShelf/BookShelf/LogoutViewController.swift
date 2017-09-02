//
//  LogoutViewController.swift
//  BookShelf
//
//  Created by alessio rossotti on 19/08/17.
//  Copyright © 2017 polimi. All rights reserved.
//

import UIKit

class LogoutViewController: UIViewController
{
    override func viewDidLoad() {
        super.viewDidLoad()
        //Go to the LoginViewController
        let vc = self.storyboard?.instantiateViewController(withIdentifier: "Login")
        self.present(vc!, animated: true, completion: nil)
        
        let prefHandler = PreferenceHandler()
        prefHandler.resetUser()
    }

}
