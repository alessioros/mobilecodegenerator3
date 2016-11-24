
import UIKit
import MobileCoreServices

class PhotoNewViewController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	@IBOutlet weak var savePhotoButton: UIButton!
	@IBOutlet weak var takenPhoto: UIImageView!


	override func viewDidLoad() {
	    super.viewDidLoad()
		savePhotoButton.layer.cornerRadius = 2


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func savePhotoButtonTouchDown(sender: UIButton) {
        //TODO Implement the action
    }
    
	@IBAction func savePhotoButtonTouchUpInside(sender: UIButton) {
        //TODO Implement the action
    }  
	
	func imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : AnyObject]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    if mediaType.isEqualToString(kUTTypeImage as String) {
	        let image = info[UIImagePickerControllerOriginalImage] as! UIImage
	        self.takenPhoto.image = image
	        UIImageWriteToSavedPhotosAlbum(image, self, #selector(PhotoNewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
	    }
	    
	    
	    dismissViewControllerAnimated(true, completion: nil)
	    
	}
	    
	func imagePickerControllerDidCancel(picker: UIImagePickerController) {
	    dismissViewControllerAnimated(true, completion: nil)
	}
	
	func completionSelector(wasSavedSuccessfully saved: Bool, didFinishSavingWithError error: NSErrorPointer, contextInfo:UnsafePointer<Void>) {
        if error != nil {
            let alert = UIAlertController(title: "Save Failed", message: "Failed to save from camera", preferredStyle: UIAlertControllerStyle.Alert)
            let cancelAction = UIAlertAction(title: "OK", style: .Cancel, handler: nil)
            alert.addAction(cancelAction)
            self.presentViewController(alert, animated: true, completion: nil)
        } 
        // Check your model
        // You are missing the videocameraController or it does not match the videoview id
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
