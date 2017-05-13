//
//  newViewViewController.swift"
//  newView//
//  Automatically generated by MobileCodeGenerator 3.
//  Copyright © 2017 . All rights reserved.
//
import UIKit
import MapKit
import AVKit

class newViewViewController: UIViewController, MKMapViewDelegate
 {

	@IBOutlet weak var hcglEditText: UITextField!
	@IBOutlet weak var cfoMap: MKMapView!

	
	override func viewDidLoad() {
	    super.viewDidLoad()


		self.cfoMap.delegate = self
	        
	    let lat = 45.478
	    let lon = 9.227
	    let coordinates = CLLocationCoordinate2D(latitude: lat, longitude: lon)
	    
	    let region = MKCoordinateRegionMake(CLLocationCoordinate2DMake(lat, lon), MKCoordinateSpanMake(0.005, 0.005))
	    
	    let annotation = MKPointAnnotation()
	    annotation.coordinate = coordinates
	    annotation.title = "MARKER TITLE HERE"
	    
	    self.cfoMap.setRegion(region, animated: true)
	    self.cfoMap.addAnnotation(annotation)
	}
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
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
	
	override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
	}
}