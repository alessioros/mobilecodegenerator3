
import UIKit

class ExercisesViewController: UIViewController, UITableViewDelegate, UITableViewDataSource
 {

	@IBOutlet weak var newExerciseButton: UIButton!
	@IBOutlet weak var exercisesList: UITableView!
	
	var exercisesListContents: [String] = [
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
		"newListItem",
		"newListItem",
		"newListItem",
	]

	var exercisesListImages: [UIImage] = [
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
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
		UIImage(named: "list_image")!,
	]

	var exercisesListSubcontents: [String] = [
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
		"Content",
	]
	
	var exercisesListIcons: [UIImage] = [
		// Change the images for each row here
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
		UIImage(named: "list_icon")!,
	]



	override func viewDidLoad() {
	    super.viewDidLoad()
		newExerciseButton.layer.cornerRadius = 36

		self.exercisesList.delegate = self
		self.exercisesList.dataSource = self

	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func newExerciseButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.20392157, green: 0.2627451, blue: 0.6, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func newExerciseButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.24705882, green: 0.31764707, blue: 0.70980394, alpha: 1)
        //TODO Implement the action
    }  
	
	
	
	
	
	func numberOfSectionsInTableView(tableView: UITableView) -> Int {
	    return 1
	}

	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
	    // Return the number of rows
	    if tableView == self.exercisesList {
	        return self.exercisesListContents.count;
	    }
	    return 0 
	}

	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.exercisesList {
	    
	    	let exercisesListCell = tableView.dequeueReusableCellWithIdentifier("exercisesListTableViewCell", forIndexPath: indexPath) as! DetailedTableViewCell
	        exercisesListCell.img.image = self.exercisesListImages[indexPath.row]
	        exercisesListCell.label.text = self.exercisesListContents[indexPath.row]
	        exercisesListCell.content.text = self.exercisesListSubcontents[indexPath.row]
	        exercisesListCell.icon.image = self.exercisesListIcons[indexPath.row]
	        return exercisesListCell
	        
	    }
	
	    return UITableViewCell()
	}
	
	
	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	    if tableView == self.exercisesList {
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
		if segue.identifier == "SegueIdentifierFromexercisesListToExerciseEditViewControllerID" {
 	        let index = self.exercisesList.indexPathForSelectedRow!
			let destination = segue.destinationViewController as! ExerciseEditViewController
            // Pass the selected cell content to destination ...
		}
	}
	
}
