
import UIKit
import AVKit
import MobileCoreServices
import AVFoundation

class thridViewViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	@IBOutlet weak var recordButton: UIButton!
	var audioRecorder: AVAudioRecorder!
	var recordedAudioUrl = NSURL()
	let recordSettings = [
        AVFormatIDKey : Int(kAudioFormatAppleLossless),
		AVEncoderAudioQualityKey : AVAudioQuality.Max.rawValue,
		AVEncoderBitRateKey : 320000,
		AVNumberOfChannelsKey : 2,
		AVSampleRateKey : 44100.0
    ]
	var vaiadAudioPlayer: AVAudioPlayer!
	@IBOutlet weak var tjuekListView: UITableView!
	
	var tjuekListViewContents: [String] = [
		"newListItem",
		"newListItem",
		"newListItem",
	]

	var tjuekListViewImages: [UIImage] = [
		// Change the images for each row here
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
	]

	var tjuekListViewSubcontents: [String] = [
		"Content",
		"Content",
		"Content",
	]
	
	var tjuekListViewIcons: [UIImage] = [
		// Change the images for each row here
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
	]

	@IBOutlet weak var emlVideoView: UIWebView!


	override func viewDidLoad() {
	    super.viewDidLoad()

		self.tjuekListView.delegate = self
		self.tjuekListView.dataSource = self

	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
		if let vaiadAudioPlayerFileRemoteUrl = NSURL(string: "http://www.provam.mp3") {
			getDataFromUrl(vaiadAudioPlayerFileRemoteUrl) { (data, response, error)  in
				dispatch_async(dispatch_get_main_queue()) { () -> Void in
					guard let data = data where error == nil else {
						NSLog("Data error")
						return
					}
					do {
						try self.vaiadAudioPlayer = AVAudioPlayer(data: data)
					} catch let error as NSError {
						NSLog("Unable to initialize AVAudioPlayer: \(error.debugDescription)")
					}
				}
			}
		}
		if let emlVideoViewString = NSBundle.mainBundle().pathForResource("prov", ofType:"mp4") {
            let emlVideoViewUrl = NSURL(fileURLWithPath: emlVideoViewString)
            let h = self.emlVideoView.frame.height
            let w = self.emlVideoView.frame.width
            let emlVideoViewIframe = "<body style=\"margin:0;\"><iframe width=\"\(w)\" height=\"\(h)\" src=\"\(emlVideoViewUrl)\" frameborder=\"0\"></iframe></body>"
            self.emlVideoView.loadHTMLString(emlVideoViewIframe, baseURL: nil)
            self.emlVideoView.scrollView.bounces = false
            self.emlVideoView.scrollView.contentInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
        }
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
		if self.audioRecorder != nil && self.audioRecorder.recording {
		    self.recordButton.setTitle("Rec", forState: UIControlState.Normal)
			self.audioRecorder.stop()
		}
		if self.vaiadAudioPlayer != nil && self.vaiadAudioPlayer.playing {
		    self.vaiadAudioPlayer.pause()
		    self.vaiadAudioPlayer.currentTime = 0
		}
	}
	

	//Function to get the data from a url
	func getDataFromUrl(url:NSURL, completion: ((data: NSData?, response: NSURLResponse?, error: NSError? ) -> Void)) {
	    NSURLSession.sharedSession().dataTaskWithURL(url) { (data, response, error) in
	        completion(data: data, response: response, error: error)
	        }.resume()
	}

	@IBAction func vaiadAudioPlayerPlay(sender: UIButton) {
	
	    self.vaiadAudioPlayer.play()
	
	}
	
	@IBAction func vaiadAudioPlayerPause(sender: UIButton) {
	
	    self.vaiadAudioPlayer.pause()
	}
	
	@IBAction func vaiadAudioPlayerStop(sender: UIButton) {
	
	    self.vaiadAudioPlayer.pause()
	    self.vaiadAudioPlayer.currentTime = 0
	}

	@IBAction func record(sender: UIButton) {
		if self.recordButton.titleLabel?.text == "Rec" {
            self.recordButton.setTitle("Stop", forState: UIControlState.Normal)
            do {
                try self.audioRecorder = AVAudioRecorder(URL: createFileUrl(), settings: self.recordSettings as! [String : AnyObject])
            } catch {
                NSLog("Unable to initialize AVAudioRecorder")
            }
            self.audioRecorder.prepareToRecord()
            self.audioRecorder.record()
		} else {
            self.recordButton.setTitle("Rec", forState: UIControlState.Normal)
            self.audioRecorder.stop()
            
		}
	}
	
	func getCacheDirectory() -> String {
        let paths = NSSearchPathForDirectoriesInDomains(.DocumentDirectory, .UserDomainMask, true)
        return paths[0]
    }
    
    func createFileUrl() -> NSURL {
        let dateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd_HH-mm-ss"
        
        let fileName: String = dateFormatter.stringFromDate(NSDate()).stringByAppendingString(".m4a")
        let filePath: String = getCacheDirectory().stringByAppendingString("/\(fileName)")
        
        self.recordedAudioUrl = NSURL(fileURLWithPath: filePath)
        return self.recordedAudioUrl
    }
	
	
	func imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : AnyObject]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    // Check your model
        // You are missing the videocameraController or it does not match the imageview id
	    
	    if mediaType.isEqualToString(kUTTypeMovie as String) {
	        if let videoURL:NSURL = info[UIImagePickerControllerMediaURL] as? NSURL {
                if (UIVideoAtPathIsCompatibleWithSavedPhotosAlbum(videoURL.relativePath!)) {
                    self.iframeSrc = videoURL
                    UISaveVideoAtPathToSavedPhotosAlbum(videoURL.relativePath!, self, #selector(thridViewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
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
	

	@IBAction func openVideoCamera(sender: UIButton) {
	        
	    if UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.Camera) {
	        let picker = UIImagePickerController()
	        picker.delegate = self
	        picker.sourceType = .Camera
	        picker.mediaTypes = [kUTTypeMovie as String]
	        presentViewController(picker, animated: true, completion: nil)
	    }
	    
	}
	
	
	
	
	
	func numberOfSectionsInTableView(tableView: UITableView) -> Int {
	    return 1
	}

	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
	    // Return the number of rows
	    if tableView == self.tjuekListView {
	        return self.tjuekListViewContents.count;
	    }
	    return 0 
	}

	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.tjuekListView {
	    
	    	let tjuekListViewCell = tableView.dequeueReusableCellWithIdentifier("tjuekListViewTableViewCell", forIndexPath: indexPath) as! DetailedTableViewCell
	        tjuekListViewCell.img.image = self.tjuekListViewImages[indexPath.row]
	        tjuekListViewCell.label.text = self.tjuekListViewContents[indexPath.row]
	        tjuekListViewCell.content.text = self.tjuekListViewSubcontents[indexPath.row]
	        tjuekListViewCell.icon.image = self.tjuekListViewIcons[indexPath.row]
	        return tjuekListViewCell
	        
	    }
	
	    return UITableViewCell()
	}
	
	
	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	    tableView.deselectRowAtIndexPath(indexPath, animated: true)
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
