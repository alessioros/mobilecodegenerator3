
import UIKit
import MapKit
import CoreData

class LocationEditViewController: UIViewController, MKMapViewDelegate
 {

	@IBOutlet weak var deleteLocationButton: UIButton!
	@IBOutlet weak var mMap: MKMapView!

    var locationIndex: Int = 0
    var location: NSManagedObject!
    
    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
    }
    
	override func viewDidLoad() {
	    super.viewDidLoad()
		deleteLocationButton.layer.cornerRadius = 36


		self.mMap.delegate = self
        
        //Legge la loc
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Location")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.location = results[self.locationIndex] as! NSManagedObject
        } catch {
            print("Error")
        }
        
	    let lat = self.location.valueForKey("lat") as? Double
	    let lon = self.location.valueForKey("lon") as? Double
        
	    let coordinates = CLLocationCoordinate2D(latitude: lat!, longitude: lon!)
	    
	    let region = MKCoordinateRegionMake(CLLocationCoordinate2DMake(lat!, lon!), MKCoordinateSpanMake(0.005, 0.005))
	    
	    let annotation = MKPointAnnotation()
	    annotation.coordinate = coordinates
	    annotation.title = "MARKER TITLE HERE"
	    
	    self.mMap.setRegion(region, animated: true)
	    self.mMap.addAnnotation(annotation)
	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	

	
	@IBAction func deleteLocationButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.7019608, green: 0.019607844, blue: 0.019607844, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func deleteLocationButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.8, green: 0.0, blue: 0.0, alpha: 1)
        //TODO Implement the action
        //Create the AlertController
        let deleteLocationDialog: UIAlertController = UIAlertController(title: "Delete Location", message: "Are you sure?", preferredStyle: .Alert)
        
        //Create and add the Cancel action
        let deleteLocationDialogCancelAction: UIAlertAction = UIAlertAction(title: "Cancel", style: .Cancel) { action -> Void in
            //Just dismiss the alert
        }
        
        //Create and add the Ok action
        let deleteLocationDialogOkAction: UIAlertAction = UIAlertAction(title: "Ok", style: .Default) { action -> Void in
            let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
            let managedContext = appDelegate.managedObjectContext
            managedContext.deleteObject(self.location)
            
            do {
                try managedContext.save()
            } catch {
                print("error")
            }
            
            self.navigationController?.popViewControllerAnimated(true)
        }
        
        deleteLocationDialog.addAction(deleteLocationDialogCancelAction)
        deleteLocationDialog.addAction(deleteLocationDialogOkAction)
        
        //Present the AlertController
        self.presentViewController(deleteLocationDialog, animated: true, completion: nil)
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
