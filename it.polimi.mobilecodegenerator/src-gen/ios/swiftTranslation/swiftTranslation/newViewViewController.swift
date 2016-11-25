
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
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	
	
	
	
	
	
	
	
	
    @IBAction func usrsTimepickerPickerValueChangedAction(_ sender: UIDatePicker) {
        let timeString = String(describing: sender.date)
        let hh = timeString.substring(with: 
            Range<String.Index>(timeString.characters.index(timeString.startIndex, offsetBy: 11)...timeString.characters.index(timeString.startIndex, offsetBy: 12))
        )
        let mm = timeString.substring(with:
            Range<String.Index>(timeString.characters.index(timeString.startIndex, offsetBy: 14)...timeString.characters.index(timeString.startIndex, offsetBy: 15))
        )
        NSLog("Time : \(hh):\(mm)")
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
