
import UIKit
import CoreData

class PhotosViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout
 {

	@IBOutlet weak var photoButton: UIButton!
	@IBOutlet weak var photosGrid: UICollectionView!

    var photos = [NSManagedObject]()

	override func viewDidLoad() {
	    super.viewDidLoad()
		photoButton.layer.cornerRadius = 36
		self.photosGrid.delegate = self
		self.photosGrid.dataSource = self

        

	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func photoButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.20392157, green: 0.2627451, blue: 0.6, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func photoButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.24705882, green: 0.31764707, blue: 0.70980394, alpha: 1)
        //TODO Implement the action
    }  
	
	
	
	
	func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
	    return 1
	}

	func collectionView(collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
	    return self.photos.count
	}

	func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
		// Configure the cell...
	    if collectionView == self.photosGrid {
	        let photosGridCollectionViewCell = collectionView.dequeueReusableCellWithReuseIdentifier("photosGridCollectionViewCell", forIndexPath: indexPath) as! ImageCollectionViewCell
            
            let photo = photos[indexPath.row]
            let path = (photo.valueForKey("path") as! String)
            
            print(path)
            
	        photosGridCollectionViewCell.img.image = UIImage(contentsOfFile: path)
	        
            return photosGridCollectionViewCell
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
	    self.photosGrid.collectionViewLayout.invalidateLayout()
	}

	func collectionView(collectionView: UICollectionView, didDeselectItemAtIndexPath indexPath: NSIndexPath) {
	    if collectionView == self.photosGrid {}
	    collectionView.deselectItemAtIndexPath(indexPath, animated: true)
	}
	
	
	
	
	
	
	override func viewWillAppear(animated: Bool) {
		super.viewWillAppear(animated)
        
        //Legge tutti gli photo e li assegna a photos
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Photo")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.photos = results as! [NSManagedObject]
        } catch {
            print("Error")
        }
        
        self.photosGrid.reloadData()
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
		if segue.identifier == "SegueIdentifierFromphotosGridToPhotoEditViewControllerID" {
 	        let index = self.photosGrid.indexPathForCell(sender as! ImageCollectionViewCell)
			let destination = segue.destinationViewController as! PhotoEditViewController
            // Pass the selected cell content to destination ...
            destination.photoIndex = index!.row
		}
	}
	
}
