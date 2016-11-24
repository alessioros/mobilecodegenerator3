
import UIKit
import CoreData
import MapKit
import CoreLocation

class LocationsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, CLLocationManagerDelegate {

	@IBOutlet weak var locationButton: UIButton!
	@IBOutlet weak var locationsList: UITableView!
    var locations = [NSManagedObject]()
    let locationManager = CLLocationManager()
    var lon : CLLocationDegrees = CLLocationDegrees()
    var lat : CLLocationDegrees = CLLocationDegrees()


	override func viewDidLoad() {
	    super.viewDidLoad()
        
        locationManager.delegate = self
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.requestAlwaysAuthorization()
        locationManager.startUpdatingLocation()
        
		locationButton.layer.cornerRadius = 36

		self.locationsList.delegate = self
		self.locationsList.dataSource = self

	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	

    func locationManager(manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let locValue: CLLocationCoordinate2D = manager.location!.coordinate
        self.lat = locValue.latitude
        self.lon = locValue.longitude
    }

	
	@IBAction func locationButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.20392157, green: 0.2627451, blue: 0.6, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func locationButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.24705882, green: 0.31764707, blue: 0.70980394, alpha: 1)
        //TODO Implement the action
        
        //save cl in DB
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        
        let entity = NSEntityDescription.entityForName("Location", inManagedObjectContext: managedContext)
        
        let item = NSManagedObject(entity: entity!, insertIntoManagedObjectContext: managedContext)
        
        let name = "\(self.lat) : \(self.lon)"
        item.setValue(name, forKey: "name")
        item.setValue(lat, forKey: "lat")
        item.setValue(lon, forKey: "lon")
        
        do {
            try managedContext.save()
        } catch {
            print("Error")
        }
        
        //reload data
        let fetchRequest = NSFetchRequest(entityName: "Location")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.locations = results as! [NSManagedObject]
        } catch {
            print("Error")
        }
        
        self.locationsList.reloadData()
        
    }  
	
	
	
	
	
	func numberOfSectionsInTableView(tableView: UITableView) -> Int {
	    return 1
	}

	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
	    return self.locations.count;
	}

	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.locationsList {
	    
	    	let locationsListCell = tableView.dequeueReusableCellWithIdentifier("locationsListTableViewCell", forIndexPath: indexPath) as! ImageTableViewCell
            
            let location = locations[indexPath.row]
            
	        locationsListCell.img.image = UIImage(named: "list_image")
	        locationsListCell.label.text = (location.valueForKey("name") as! String)
	        
            return locationsListCell
	        
	    }
	
	    return UITableViewCell()
	}
	
	
	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	    if tableView == self.locationsList {
	    }
	    tableView.deselectRowAtIndexPath(indexPath, animated: true)
	}
	
	
	
	
	
	override func viewWillAppear(animated: Bool) {
		super.viewWillAppear(animated)
        
        //Legge tutti gli location e li assegna a locations
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Location")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.locations = results as! [NSManagedObject]
        } catch {
            print("Error")
        }
        
        self.locationsList.reloadData()
	}
	
	override func viewWillDisappear(animated: Bool) {
		super.viewWillDisappear(animated)
	}
	
	override func didReceiveMemoryWarning() {
	    super.didReceiveMemoryWarning()
	    // Dispose of any resources that can be recreated.
	}
	
	override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
		//You can reference to the next ViewController and the selected UITableViewRow     
		if segue.identifier == "SegueIdentifierFromlocationsListToLocationEditViewControllerID" {
 	        let index = self.locationsList.indexPathForSelectedRow!
			let destination = segue.destinationViewController as! LocationEditViewController
            // Pass the selected cell content to destination ...
            destination.locationIndex = index.row
		}
	}
	
}
