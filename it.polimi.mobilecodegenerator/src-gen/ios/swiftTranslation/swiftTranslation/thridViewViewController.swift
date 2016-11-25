
import UIKit
import AVKit
import MobileCoreServices
import AVFoundation

class thridViewViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UINavigationControllerDelegate, UIImagePickerControllerDelegate
 {

	@IBOutlet weak var recordButton: UIButton!
	var audioRecorder: AVAudioRecorder!
	var recordedAudioUrl = URL()
	let recordSettings = [
        AVFormatIDKey : Int(kAudioFormatAppleLossless),
		AVEncoderAudioQualityKey : AVAudioQuality.max.rawValue,
		AVEncoderBitRateKey : 320000,
		AVNumberOfChannelsKey : 2,
		AVSampleRateKey : 44100.0
    ] as [String : Any]
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
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
		if let vaiadAudioPlayerFileRemoteUrl = URL(string: "http://www.provam.mp3") {
			getDataFromUrl(vaiadAudioPlayerFileRemoteUrl) { (data, response, error)  in
				DispatchQueue.main.async { () -> Void in
					guard let data = data, error == nil else {
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
		if let emlVideoViewString = Bundle.main.path(forResource: "prov", ofType:"mp4") {
            let emlVideoViewUrl = URL(fileURLWithPath: emlVideoViewString)
            let h = self.emlVideoView.frame.height
            let w = self.emlVideoView.frame.width
            let emlVideoViewIframe = "<body style=\"margin:0;\"><iframe width=\"\(w)\" height=\"\(h)\" src=\"\(emlVideoViewUrl)\" frameborder=\"0\"></iframe></body>"
            self.emlVideoView.loadHTMLString(emlVideoViewIframe, baseURL: nil)
            self.emlVideoView.scrollView.bounces = false
            self.emlVideoView.scrollView.contentInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
        }
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
		if self.audioRecorder != nil && self.audioRecorder.isRecording {
		    self.recordButton.setTitle("Rec", for: UIControlState())
			self.audioRecorder.stop()
		}
		if self.vaiadAudioPlayer != nil && self.vaiadAudioPlayer.isPlaying {
		    self.vaiadAudioPlayer.pause()
		    self.vaiadAudioPlayer.currentTime = 0
		}
	}
	

	//Function to get the data from a url
	func getDataFromUrl(_ url:URL, completion: @escaping ((_ data: Data?, _ response: URLResponse?, _ error: NSError? ) -> Void)) {
	    URLSession.shared.dataTask(with: url, 
	    completionHandler{ (data, response, error) in 
	    completion(data, response, error)
	    }).resume()
	}

	@IBAction func vaiadAudioPlayerPlay(_ sender: UIButton) {
	
	    self.vaiadAudioPlayer.play()
	
	}
	
	@IBAction func vaiadAudioPlayerPause(_ sender: UIButton) {
	
	    self.vaiadAudioPlayer.pause()
	}
	
	@IBAction func vaiadAudioPlayerStop(_ sender: UIButton) {
	
	    self.vaiadAudioPlayer.pause()
	    self.vaiadAudioPlayer.currentTime = 0
	}

	@IBAction func record(_ sender: UIButton) {
		if self.recordButton.titleLabel?.text == "Rec" {
            self.recordButton.setTitle("Stop", for: UIControlState())
            do {
                try self.audioRecorder = AVAudioRecorder(url: createFileUrl(), settings: self.recordSettings as [String : AnyObject])
            } catch {
                NSLog("Unable to initialize AVAudioRecorder")
            }
            self.audioRecorder.prepareToRecord()
            self.audioRecorder.record()
		} else {
            self.recordButton.setTitle("Rec", for: UIControlState())
            self.audioRecorder.stop()
            
		}
	}
	
	func getCacheDirectory() -> String {
        let paths = NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)
        return paths[0]
    }
    
    func createFileUrl() -> URL {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd_HH-mm-ss"
        
        let fileName: String = dateFormatter.string(from: Date()) + (".m4a")
        let filePath: String = getCacheDirectory() + ("/\(fileName)")
        
        self.recordedAudioUrl = URL(fileURLWithPath: filePath)
        return self.recordedAudioUrl
    }
	
	
	func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [String : Any]) {
	        
	    let mediaType = info[UIImagePickerControllerMediaType] as! NSString
	    
	    // Check your model
        // You are missing the videocameraController or it does not match the imageview id
	    
	    if mediaType.isEqual(to: kUTTypeMovie as String) {
	        if let videoURL:URL = info[UIImagePickerControllerMediaURL] as? URL {
                if (UIVideoAtPathIsCompatibleWithSavedPhotosAlbum(videoURL.relativePath)) {
                    self.iframeSrc = videoURL
                    UISaveVideoAtPathToSavedPhotosAlbum(videoURL.relativePath, self, #selector(thridViewViewController.completionSelector(wasSavedSuccessfully:didFinishSavingWithError:contextInfo:)), nil)
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
	
	
	
	
	
	func numberOfSections(in: tableView: UITableView) -> Int {
	    return 1
	}

	func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
	    // Return the number of rows
	    if tableView == self.tjuekListView {
	        return self.tjuekListViewContents.count;
	    }
	    return 0 
	}

	func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.tjuekListView {
	    
	    	let tjuekListViewCell = tableView.dequeueReusableCell(withIdentifier: "tjuekListViewTableViewCell", forIndexPath: indexPath) as! DetailedTableViewCell
	        tjuekListViewCell.img.image = self.tjuekListViewImages[indexPath.row]
	        tjuekListViewCell.label.text = self.tjuekListViewContents[indexPath.row]
	        tjuekListViewCell.content.text = self.tjuekListViewSubcontents[indexPath.row]
	        tjuekListViewCell.icon.image = self.tjuekListViewIcons[indexPath.row]
	        return tjuekListViewCell
	        
	    }
	
	    return UITableViewCell()
	}
	
	
	func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
	    tableView.deselectRow(at: indexPath, animated: true)
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
