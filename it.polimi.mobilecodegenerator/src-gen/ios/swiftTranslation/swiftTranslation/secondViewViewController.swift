
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
		if let url = URL(string: "http://www.prova.it/prova.jpg") {
	        self.lkihpImageView.contentMode = .scaleAspectFit
	        ImageDownloadingTask.downloadImage(url, imageView: self.lkihpImageView)
	    }

	}
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
		if self.pnesAudioPlayer != nil && self.pnesAudioPlayer.isPlaying {
		    self.pnesAudioPlayer.pause()
		    self.pnesAudioPlayer.currentTime = 0
		}
	}
	


	@IBAction func pnesAudioPlayerPlay(_ sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
	
	}
	
	@IBAction func pnesAudioPlayerPause(_ sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
	}
	
	@IBAction func pnesAudioPlayerStop(_ sender: UIButton) {
	
        // Check your model
        // You are missing the audiorecorder or it does not match the audioplayer id
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
