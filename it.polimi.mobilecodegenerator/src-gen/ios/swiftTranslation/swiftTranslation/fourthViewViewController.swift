
import UIKit
import MobileCoreServices
import AVFoundation

class fourthViewViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	var imvnAudioPlayer: AVAudioPlayer!
	@IBOutlet weak var slkqDatepickerPicker: UIDatePicker!
	@IBOutlet weak var stjrGridView: UICollectionView!

	var stjrGridViewContents: [String] = [
		// Change the text for each cell here
		"newGridCell",
		"newGridCell",
		"newGridCell",
		"newGridCell",
	]

	var stjrGridViewImages: [UIImage] = [
		// Change the images for each cell here
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
	]



	override func viewDidLoad() {
	    super.viewDidLoad()
		self.stjrGridView.delegate = self
		self.stjrGridView.dataSource = self


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
		if let imvnAudioPlayerFilePathString = NSBundle.mainBundle().pathForResource("provam", ofType: "mp3") {
			let imvnAudioPlayerFilePathUrl = NSURL(fileURLWithPath: imvnAudioPlayerFilePathString)
			do {
				try imvnAudioPlayer = AVAudioPlayer(contentsOfURL: imvnAudioPlayerFilePathUrl)
			} catch let error as NSError {
				NSLog("Unable to initialize AVAudioPlayer: \(error.debugDescription)")
			}
		}  
			
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
		if self.imvnAudioPlayer != nil && self.imvnAudioPlayer.playing {
		    self.imvnAudioPlayer.pause()
		    self.imvnAudioPlayer.currentTime = 0
		}
	}
	

	//Function to get the data from a url
	func getDataFromUrl(url:NSURL, completion: ((data: NSData?, response: NSURLResponse?, error: NSError? ) -> Void)) {
	    NSURLSession.sharedSession().dataTaskWithURL(url) { (data, response, error) in
	        completion(data: data, response: response, error: error)
	        }.resume()
	}

	@IBAction func imvnAudioPlayerPlay(sender: UIButton) {
	
	    self.imvnAudioPlayer.play()
	
	}
	
	@IBAction func imvnAudioPlayerPause(sender: UIButton) {
	
	    self.imvnAudioPlayer.pause()
	}
	
	@IBAction func imvnAudioPlayerStop(sender: UIButton) {
	
	    self.imvnAudioPlayer.pause()
	    self.imvnAudioPlayer.currentTime = 0
	}

	
	
	func imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : AnyObject]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    // Check your model
        // You are missing the videocameraController or it does not match the imageview id
	    
	    if mediaType.isEqualToString(kUTTypeMovie as String) {
	        if let videoURL:NSURL = info[UIImagePickerControllerMediaURL] as? NSURL {
                if (UIVideoAtPathIsCompatibleWithSavedPhotosAlbum(videoURL.relativePath!)) {
                    self.iframeSrc = videoURL
                    UISaveVideoAtPathToSavedPhotosAlbum(videoURL.relativePath!, self, #selector(fourthViewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
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
	
	
	
    @IBAction func slkqDatepickerPickerValueChangedAction(sender: UIDatePicker) {
        let dateString = String(sender.date)
        let day = dateString.substringWithRange(
            Range<String.Index>(dateString.startIndex.advancedBy(8)...dateString.startIndex.advancedBy(9))
        )
        let month = dateString.substringWithRange(
            Range<String.Index>(dateString.startIndex.advancedBy(5)...dateString.startIndex.advancedBy(6))
        )
        let year = dateString.substringWithRange(
            Range<String.Index>(dateString.startIndex.advancedBy(0)...dateString.startIndex.advancedBy(3))
        )
        NSLog("Date : \(day)-\(month)-\(year)")
    }
	
	func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
	    return 1
	}

	func collectionView(collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
	    if collectionView == self.stjrGridView {
	        return self.stjrGridViewContents.count
	    }
	    
	    return 0
	}

	func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
		// Configure the cell...
	    if collectionView == self.stjrGridView {
	        let stjrGridViewCollectionViewCell = collectionView.dequeueReusableCellWithReuseIdentifier("stjrGridViewCollectionViewCell", forIndexPath: indexPath) as! DetailedCollectionViewCell
	        stjrGridViewCollectionViewCell.label.text = stjrGridViewContents[indexPath.row]
	        stjrGridViewCollectionViewCell.img.image = stjrGridViewImages[indexPath.row]
	        return stjrGridViewCollectionViewCell
	    }
	    
		return UICollectionViewCell()
	}

	//Force the dimensions of the cells to half screen width
	func collectionView(collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAtIndexPath: NSIndexPath) -> CGSize {
	    let dim = (collectionView.bounds.width / 2.0) - 2.5 //2.5 is half cell spacing
	    return CGSize(width: dim, height: dim)
	}
	
	//Invalidate layout when rotating device to re-calculate the dimensions of the cells
	override func willRotateToInterfaceOrientation(toInterfaceOrientation: UIInterfaceOrientation, duration: NSTimeInterval) {
	    self.stjrGridView.collectionViewLayout.invalidateLayout()
	}

	func collectionView(collectionView: UICollectionView, didDeselectItemAtIndexPath indexPath: NSIndexPath) {
	    collectionView.deselectItemAtIndexPath(indexPath, animated: true)
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
