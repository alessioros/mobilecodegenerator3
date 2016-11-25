
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
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
		if let imvnAudioPlayerFilePathString = Bundle.main.path(forResource : "provam", ofType: "mp3") {
			let imvnAudioPlayerFilePathUrl = URL(fileURLWithPath: imvnAudioPlayerFilePathString)
			do {
				try imvnAudioPlayer = AVAudioPlayer(contentsOf: imvnAudioPlayerFilePathUrl)
			} catch let error as NSError {
				NSLog("Unable to initialize AVAudioPlayer: \(error.debugDescription)")
			}
		}  
			
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
		if self.imvnAudioPlayer != nil && self.imvnAudioPlayer.isPlaying {
		    self.imvnAudioPlayer.pause()
		    self.imvnAudioPlayer.currentTime = 0
		}
	}
	

	//Function to get the data from a url
	func getDataFromUrl(_ url:URL, completion: @escaping ((_ data: Data?, _ response: URLResponse?, _ error: NSError? ) -> Void)) {
	    URLSession.shared.dataTask(with: url, 
	    completionHandler{ (data, response, error) in 
	    completion(data, response, error)
	    }).resume()
	}

	@IBAction func imvnAudioPlayerPlay(_ sender: UIButton) {
	
	    self.imvnAudioPlayer.play()
	
	}
	
	@IBAction func imvnAudioPlayerPause(_ sender: UIButton) {
	
	    self.imvnAudioPlayer.pause()
	}
	
	@IBAction func imvnAudioPlayerStop(_ sender: UIButton) {
	
	    self.imvnAudioPlayer.pause()
	    self.imvnAudioPlayer.currentTime = 0
	}

	
	
	func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : Any]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    // Check your model
        // You are missing the videocameraController or it does not match the imageview id
	    
	    if mediaType.isEqual(to: kUTTypeMovie as String) {
	        if let videoURL:URL = info[UIImagePickerControllerMediaURL] as? URL {
                if (UIVideoAtPathIsCompatibleWithSavedPhotosAlbum(videoURL.relativePath)) {
                    self.iframeSrc = videoURL
                    UISaveVideoAtPathToSavedPhotosAlbum(videoURL.relativePath, self, #selector(fourthViewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
                }
            }
	    }
	    
	    dismiss(animated: true, completion: nil)
	    
	}
	    
	func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
	    dismiss(animated: true, completion: nil)
	}
	
	func completionSelector(wasSavedSuccessfully saved: Bool, didFinishSavingWithError error: NSErrorPointer?, contextInfo:UnsafeRawPointer) {
        if error != nil {
            let alert = UIAlertController(title: "Save Failed", message: "Failed to save from camera", preferredStyle: UIAlertControllerStyle.alert)
            let cancelAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
            alert.addAction(cancelAction)
            self.present(alert, animated: true, completion: nil)
        } 
        // Check your model
        // You are missing the videocameraController or it does not match the videoview id
    }


	@IBAction func openPhotoCamera(_ sender: UIButton) {
	    
	    if UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera) {
	        let picker = UIImagePickerController()
	        picker.delegate = self
	        picker.sourceType = .camera
	        picker.mediaTypes = [kUTTypeImage as String]
	        present(picker, animated: true, completion: nil)
	    }
	    
	}
	

	@IBAction func openVideoCamera(_ sender: UIButton) {
	        
	    if UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera) {
	        let picker = UIImagePickerController()
	        picker.delegate = self
	        picker.sourceType = .camera
	        picker.mediaTypes = [kUTTypeMovie as String]
	        present(picker, animated: true, completion: nil)
	    }
	    
	}
	
	
	
    @IBAction func slkqDatepickerPickerValueChangedAction(_ sender: UIDatePicker) {
        let dateString = String(describing: sender.date)
        let day = dateString.substring( with:
            Range<String.Index>(dateString.characters.index(dateString.startIndex, offsetBy: 8)...dateString.characters.index(dateString.startIndex, offsetBy: 9))
        )
        let month = dateString.substring( with:
            Range<String.Index>(dateString.characters.index(dateString.startIndex, offsetBy: 5)...dateString.characters.index(dateString.startIndex, offsetBy: 6))
        )
        let year = dateString.substring( with:
            Range<String.Index>(dateString.characters.index(dateString.startIndex, offsetBy: 0)...dateString.characters.index(dateString.startIndex, offsetBy: 3))
        )
        NSLog("Date : \(day)-\(month)-\(year)")
    }
	
	func numberOfSections(in collectionView: UICollectionView) -> Int {
	    return 1
	}

	func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
	    if collectionView == self.stjrGridView {
	        return self.stjrGridViewContents.count
	    }
	    
	    return 0
	}

	func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
		// Configure the cell...
	    if collectionView == self.stjrGridView {
	        let stjrGridViewCollectionViewCell = collectionView.dequeueReusableCell(withReuseIdentifier: "stjrGridViewCollectionViewCell", for: indexPath) as! DetailedCollectionViewCell
	        stjrGridViewCollectionViewCell.label.text = stjrGridViewContents[indexPath.row]
	        stjrGridViewCollectionViewCell.img.image = stjrGridViewImages[indexPath.row]
	        return stjrGridViewCollectionViewCell
	    }
	    
		return UICollectionViewCell()
	}

	//Force the dimensions of the cells to half screen width
	func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt: IndexPath) -> CGSize {
	    let dim = (collectionView.bounds.width / 2.0) - 2.5 //2.5 is half cell spacing
	    return CGSize(width: dim, height: dim)
	}
	
	//Invalidate layout when rotating device to re-calculate the dimensions of the cells
	override func willRotate(to toInterfaceOrientation: UIInterfaceOrientation, duration: TimeInterval) {
	    self.stjrGridView.collectionViewLayout.invalidateLayout()
	}

	func collectionView(_ collectionView: UICollectionView, didDeselectItemAt indexPath: IndexPath) {
	    collectionView.deselectItem(at: indexPath, animated: true)
	}
	
	
	
	
	
	
	override func viewWillAppear(_ animated: Bool) {
		super.viewWillAppear(animated)
	}
	
	override func viewWillDisappear(_ animated: Bool) {
		super.viewWillDisappear(animated)
	}
	
	override func didReceiveMemoryWarning() {
	    super.didReceiveMemoryWarning()
	    // Dispose of any resources that can be recreated.
	}
	
	override func prepare(for segue: UIStoryboardSegue, sender: AnyObject?) {
	}
	
}
