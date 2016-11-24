
import UIKit
import CoreData

class PhotoEditViewController: UIViewController
 {

	@IBOutlet weak var deletePhotoButton: UIButton!
	@IBOutlet weak var mImageView: UIImageView!
    
    var photoIndex: Int = 0
    var photo: NSManagedObject!

    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
        
        //Legge la foto
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Photo")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.photo = results[self.photoIndex] as! NSManagedObject
        } catch {
            print("Error")
        }
        
    }
    
    override func viewDidAppear(animated: Bool) {
        super.viewDidAppear(animated)
        //aggiorna ui
        let path = self.photo.valueForKey("path") as! String
        print(path)
        //self.mImageView.image = UIImage(contentsOfFile: path)
    }

	override func viewDidLoad() {
	    super.viewDidLoad()
		deletePhotoButton.layer.cornerRadius = 36
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	
	
	@IBAction func deletePhotoButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.7019608, green: 0.019607844, blue: 0.019607844, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func deletePhotoButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.8, green: 0.0, blue: 0.0, alpha: 1)
        //TODO Implement the action
        //Create the AlertController
        let deletePhotoDialog: UIAlertController = UIAlertController(title: "Delete Photo", message: "Are you sure?", preferredStyle: .Alert)
        
        //Create and add the Cancel action
        let deletePhotoDialogCancelAction: UIAlertAction = UIAlertAction(title: "Cancel", style: .Cancel) { action -> Void in
            //Just dismiss the alert
        }
        
        //Create and add the Ok action
        let deletePhotoDialogOkAction: UIAlertAction = UIAlertAction(title: "Ok", style: .Default) { action -> Void in
            
            let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
            let managedContext = appDelegate.managedObjectContext
            managedContext.deleteObject(self.photo)
            
            do {
                try managedContext.save()
            } catch {
                print("error")
            }
            
            self.navigationController?.popViewControllerAnimated(true)
            
        }
        
        deletePhotoDialog.addAction(deletePhotoDialogCancelAction)
        deletePhotoDialog.addAction(deletePhotoDialogOkAction)
        
        //Present the AlertController
        self.presentViewController(deletePhotoDialog, animated: true, completion: nil)
    }  
	
	override func viewWillDisappear(animated: Bool) {
		super.viewWillDisappear(animated)
	}
	
	override func didReceiveMemoryWarning() {
	    super.didReceiveMemoryWarning()
	    // Dispose of any resources that can be recreated.
	}
	
	override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {}
	
}
