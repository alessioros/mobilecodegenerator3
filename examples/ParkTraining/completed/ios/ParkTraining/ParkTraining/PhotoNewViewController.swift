
import UIKit
import MobileCoreServices
import CoreData
import AssetsLibrary

class PhotoNewViewController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	@IBOutlet weak var savePhotoButton: UIButton!
	@IBOutlet weak var takenPhoto: UIImageView!


	override func viewDidLoad() {
	    super.viewDidLoad()
		savePhotoButton.layer.cornerRadius = 36
	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	

    func createPhoto(path: NSURL) {
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        
        let entity = NSEntityDescription.entityForName("Photo", inManagedObjectContext: managedContext)
        
        let item = NSManagedObject(entity: entity!, insertIntoManagedObjectContext: managedContext)
        
        item.setValue(path.absoluteString, forKey: "path")
        
        print(path.absoluteString)
        
        do {
            try managedContext.save()
        } catch {
            print("Error")
        }
        
    }

	
	@IBAction func savePhotoButtonTouchDown(sender: UIButton) {
        //TODO Implement the action
    }
    
	@IBAction func savePhotoButtonTouchUpInside(sender: UIButton) {
        //TODO Implement the action
        //Questo e fatto solo perche il simulatore non accede alla fotocamera
        let rect: CGRect = CGRectMake(0, 0, 100, 100)
        let color: UIColor = UIColor.redColor()
        UIGraphicsBeginImageContextWithOptions(CGSizeMake(1, 1), false, 0)
        color.setFill()
        UIRectFill(rect)
        let image: UIImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        
        ALAssetsLibrary().writeImageToSavedPhotosAlbum(
            image.CGImage,
            orientation: ALAssetOrientation(rawValue: image.imageOrientation.rawValue)!,
            completionBlock:{ (path:NSURL!, error:NSError!) -> Void in
                self.createPhoto(path)
                self.navigationController?.popViewControllerAnimated(true)
        })
        
    }  
	
	func imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : AnyObject]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    if mediaType.isEqualToString(kUTTypeImage as String) {
	        let image = info[UIImagePickerControllerOriginalImage] as! UIImage
	        self.takenPhoto.image = image
        }
	    
	    
	    dismissViewControllerAnimated(true, completion: nil)
	    
	}
	    
	func imagePickerControllerDidCancel(picker: UIImagePickerController) {
	    dismissViewControllerAnimated(true, completion: nil)
	}

	@IBAction func openPhotoCamera(sender: UIButton) {
	    
	    if UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.Camera) {
	        let picker = UIImagePickerController()
	        picker.delegate = self
	        picker.sourceType = .Camera
	        picker.mediaTypes = [kUTTypeImage as String]
	        presentViewController(picker, animated: true, completion: nil)
	    }
	    
    }
	
	
	override func viewWillAppear(animated: Bool) {
		super.viewWillAppear(animated)
	}
	
	override func viewWillDisappear(animated: Bool) {
		super.viewWillDisappear(animated)
	}
	
	override func didReceiveMemoryWarning() {
	    super.didReceiveMemoryWarning()
	    // Dispose of any resources that can be recreated.
	}
	
	override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
	}
	
}
