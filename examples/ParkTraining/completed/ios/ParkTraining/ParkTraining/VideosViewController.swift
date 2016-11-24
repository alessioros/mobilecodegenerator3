
import UIKit
import CoreData

class VideosViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout
 {

	@IBOutlet weak var videoButton: UIButton!
	@IBOutlet weak var videosGrid: UICollectionView!

	var videos = [NSManagedObject]()

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
	        return self.videos.count
	    }
	    
	    return 0
	}

	func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
		// Configure the cell...
	    if collectionView == self.videosGrid {
	        let videosGridCollectionViewCell = collectionView.dequeueReusableCellWithReuseIdentifier("videosGridCollectionViewCell", forIndexPath: indexPath) as! DetailedCollectionViewCell
            
            let video = videos[indexPath.row]
            let duration = (video.valueForKey("duration") as! String)
            let path = (video.valueForKey("path") as! String)
            
            print(duration)
            print(path)
            
            videosGridCollectionViewCell.label.text = duration
            videosGridCollectionViewCell.img.image = UIImage(contentsOfFile: path)
            
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
        
        //Legge tutti gli video e li assegna a videos
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Video")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.videos = results as! [NSManagedObject]
        } catch {
            print("Error")
        }
        
        self.videosGrid.reloadData()
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
 	        let index = self.videosGrid.indexPathForCell(sender as! DetailedCollectionViewCell)
			let destination = segue.destinationViewController as! VideoEditViewController
            // Pass the selected cell content to destination ...
            destination.videoIndex = index!.row
		}
	}
	
}
