
import UIKit
import AVKit
import AVFoundation

class secondViewViewController: UIViewController
 {

	var pnesAudioPlayer: AVAudioPlayer!
	@IBOutlet weak var rrrImageView: UIImageView!
	@IBOutlet weak var lkihpImageView: UIImageView!


	override func viewDidLoad() {
	    super.viewDidLoad()

		// Download the image and set the ImageView
		if let url = NSURL(string: "http://www.prova.it/prova.jpg") {
	        self.lkihpImageView.contentMode = .ScaleAspectFit
	        ImageDownloadingTask.downloadImage(url, imageView: self.lkihpImageView)
	    }

	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
		if self.pnesAudioPlayer != nil && self.pnesAudioPlayer.playing {
		    self.pnesAudioPlayer.pause()
		    self.pnesAudioPlayer.currentTime = 0
		}
	}
	


	@IBAction func pnesAudioPlayerPlay(sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
	
	}
	
	@IBAction func pnesAudioPlayerPause(sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
	}
	
	@IBAction func pnesAudioPlayerStop(sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
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
