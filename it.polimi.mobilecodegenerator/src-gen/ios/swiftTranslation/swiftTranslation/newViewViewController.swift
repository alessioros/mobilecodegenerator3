
import UIKit
import MapKit

class newViewViewController: UIViewController, MKMapViewDelegate
 {

	@IBOutlet weak var jaboaMap: MKMapView!
	@IBOutlet weak var usrsTimepickerPicker: UIDatePicker!


	override func viewDidLoad() {
	    super.viewDidLoad()


		self.jaboaMap.delegate = self
	        
	    let lat = 45.478
	    let lon = 9.227
	    let coordinates = CLLocationCoordinate2D(latitude: lat, longitude: lon)
	    
	    let region = MKCoordinateRegionMake(CLLocationCoordinate2DMake(lat, lon), MKCoordinateSpanMake(0.005, 0.005))
	    
	    let annotation = MKPointAnnotation()
	    annotation.coordinate = coordinates
	    annotation.title = "MARKER TITLE HERE"
	    
	    self.jaboaMap.setRegion(region, animated: true)
	    self.jaboaMap.addAnnotation(annotation)
	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	
	
	
	
	
	
	
	
	
    @IBAction func usrsTimepickerPickerValueChangedAction(sender: UIDatePicker) {
        let timeString = String(sender.date)
        let hh = timeString.substringWithRange(
            Range<String.Index>(timeString.startIndex.advancedBy(11)...timeString.startIndex.advancedBy(12))
        )
        let mm = timeString.substringWithRange(
            Range<String.Index>(timeString.startIndex.advancedBy(14)...timeString.startIndex.advancedBy(15))
        )
        NSLog("Time : \(hh):\(mm)")
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
