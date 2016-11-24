
import UIKit

class VideosViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout
 {

	@IBOutlet weak var videoButton: UIButton!
	@IBOutlet weak var videosGrid: UICollectionView!

	var videosGridContents: [String] = [
		// Change the text for each cell here
		"00:00",
		"00:00",
		"00:00",
		"00:00",
		"00:00",
		"00:00",
	]

	var videosGridImages: [UIImage] = [
		// Change the images for each cell here
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
		UIImage(named: "grid_image")!,
	]



	override func viewDidLoad() {
	    super.viewDidLoad()
		videoButton.layer.cornerRadius = 36
		self.videosGrid.delegate = self
		self.videosGrid.dataSource = self


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func videoButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.20392157, green: 0.2627451, blue: 0.6, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func videoButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.24705882, green: 0.31764707, blue: 0.70980394, alpha: 1)
        //TODO Implement the action
    }  
	
	
	
	
	func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
	    return 1
	}

	func collectionView(collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
	    if collectionView == self.videosGrid {
	        return self.videosGridContents.count
	    }
	    
	    return 0
	}

	func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
		// Configure the cell...
	    if collectionView == self.videosGrid {
	        let videosGridCollectionViewCell = collectionView.dequeueReusableCellWithReuseIdentifier("videosGridCollectionViewCell", forIndexPath: indexPath) as! DetailedCollectionViewCell
	        videosGridCollectionViewCell.label.text = videosGridContents[indexPath.row]
	        videosGridCollectionViewCell.img.image = videosGridImages[indexPath.row]
	        return videosGridCollectionViewCell
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
	    self.videosGrid.collectionViewLayout.invalidateLayout()
	}

	func collectionView(collectionView: UICollectionView, didDeselectItemAtIndexPath indexPath: NSIndexPath) {
	    if collectionView == self.videosGrid {
	    }
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
		//You can reference to the next ViewController and the selected UICollectionViewCell     
		if segue.identifier == "SegueIdentifierFromvideosGridToVideoEditViewControllerID" {
 	        let index = self.videosGrid.indexPathsForSelectedItems()
			let destination = segue.destinationViewController as! VideoEditViewController
            // Pass the selected cell content to destination ...
		}
	}
	
}
