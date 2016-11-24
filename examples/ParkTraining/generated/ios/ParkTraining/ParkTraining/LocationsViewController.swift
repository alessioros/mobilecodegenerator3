
import UIKit

class LocationsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource
 {

	@IBOutlet weak var locationButton: UIButton!
	@IBOutlet weak var locationsList: UITableView!
	
	var locationsListContents: [String] = [
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
		"newListItem",
	]

	var locationsListImages: [UIImage] = [
		// Change the images for each row here
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
	]




	override func viewDidLoad() {
	    super.viewDidLoad()
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
	



	
	@IBAction func locationButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.20392157, green: 0.2627451, blue: 0.6, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func locationButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.24705882, green: 0.31764707, blue: 0.70980394, alpha: 1)
        //TODO Implement the action
    }  
	
	
	
	
	
	func numberOfSectionsInTableView(tableView: UITableView) -> Int {
	    return 1
	}

	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
	    // Return the number of rows
	    if tableView == self.locationsList {
	        return self.locationsListContents.count;
	    }
	    return 0 
	}

	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.locationsList {
	    
	    	let locationsListCell = tableView.dequeueReusableCellWithIdentifier("locationsListTableViewCell", forIndexPath: indexPath) as! ImageTableViewCell
	        locationsListCell.img.image = self.locationsListImages[indexPath.row]
	        locationsListCell.label.text = self.locationsListContents[indexPath.row]
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
		}
	}
	
}
