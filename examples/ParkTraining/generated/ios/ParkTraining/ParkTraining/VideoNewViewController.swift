
import UIKit
import AVKit
import MobileCoreServices

class VideoNewViewController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	@IBOutlet weak var saveVideoButton: UIButton!
	@IBOutlet weak var takenVideo: UIWebView!
	var iframeSrc = NSURL()


	override func viewDidLoad() {
	    super.viewDidLoad()
		saveVideoButton.layer.cornerRadius = 2
	let iframe = "<body style=\"margin:0;background-color:#000\"></body>"
    self.takenVideo.loadHTMLString(iframe, baseURL: nil)


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func saveVideoButtonTouchDown(sender: UIButton) {
        //TODO Implement the action
    }
    
	@IBAction func saveVideoButtonTouchUpInside(sender: UIButton) {
        //TODO Implement the action
    }  
	
	func imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : AnyObject]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    // Check your model
        // You are missing the videocameraController or it does not match the imageview id
	    
	    if mediaType.isEqualToString(kUTTypeMovie as String) {
	        if let videoURL:NSURL = info[UIImagePickerControllerMediaURL] as? NSURL {
                if (UIVideoAtPathIsCompatibleWithSavedPhotosAlbum(videoURL.relativePath!)) {
                    self.iframeSrc = videoURL
                    UISaveVideoAtPathToSavedPhotosAlbum(videoURL.relativePath!, self, #selector(VideoNewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
                }
            }
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
        else {
            // Setup iFrame
            let iframe = "<body style=\"margin:0\"><iframe width=\"\(self.takenVideo.frame.width)\" height=\"\(self.takenVideo.frame.height)\" src=\"\(self.iframeSrc)\" frameborder=\"0\"></iframe></body>"
            self.takenVideo.loadHTMLString(iframe, baseURL: nil)
        }
    }


	@IBAction func openVideoCamera(sender: UIButton) {
	        
	    if UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.Camera) {
	        let picker = UIImagePickerController()
	        picker.delegate = self
	        picker.sourceType = .Camera
	        picker.mediaTypes = [kUTTypeMovie as String]
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
