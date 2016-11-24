
import UIKit
import AVKit
import CoreData

class VideoEditViewController: UIViewController
 {

	@IBOutlet weak var deleteVideoButton: UIButton!
	@IBOutlet weak var mVideoView: UIWebView!
    
    var videoIndex: Int = 0
    var video: NSManagedObject!

    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
        
        //Legge la foto
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Video")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.video = results[self.videoIndex] as! NSManagedObject
        } catch {
            print("Error")
        }
        
    }

	override func viewDidLoad() {
	    super.viewDidLoad()
		deleteVideoButton.layer.cornerRadius = 36


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
        
        let path = self.video.valueForKey("path") as! String
        print(path)
		
		/*
		if let mVideoViewString = NSBundle.mainBundle().pathForResource("URI", ofType:"mp4") {
            let mVideoViewUrl = NSURL(fileURLWithPath: mVideoViewString)
            let h = self.mVideoView.frame.height
            let w = self.mVideoView.frame.width
            let mVideoViewIframe = "<body style=\"margin:0;\"><iframe width=\"\(w)\" height=\"\(h)\" src=\"\(mVideoViewUrl)\" frameborder=\"0\"></iframe></body>"
            self.mVideoView.loadHTMLString(mVideoViewIframe, baseURL: nil)
            self.mVideoView.scrollView.bounces = false
            self.mVideoView.scrollView.contentInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
        }
		*/
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func deleteVideoButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.7019608, green: 0.019607844, blue: 0.019607844, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func deleteVideoButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.8, green: 0.0, blue: 0.0, alpha: 1)
        //TODO Implement the action
        //Create the AlertController
        let deleteVideoDialog: UIAlertController = UIAlertController(title: "Delete Video", message: "Are you sure?", preferredStyle: .Alert)
        
        //Create and add the Cancel action
        let deleteVideoDialogCancelAction: UIAlertAction = UIAlertAction(title: "Cancel", style: .Cancel) { action -> Void in
            //Just dismiss the alert
        }
        
        //Create and add the Ok action
        let deleteVideoDialogOkAction: UIAlertAction = UIAlertAction(title: "Ok", style: .Default) { action -> Void in
            
            let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
            let managedContext = appDelegate.managedObjectContext
            managedContext.deleteObject(self.video)
            
            do {
                try managedContext.save()
            } catch {
                print("error")
            }
            
            self.navigationController?.popViewControllerAnimated(true)
            
        }
        
        deleteVideoDialog.addAction(deleteVideoDialogCancelAction)
        deleteVideoDialog.addAction(deleteVideoDialogOkAction)
        
        //Present the AlertController
        self.presentViewController(deleteVideoDialog, animated: true, completion: nil)
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
