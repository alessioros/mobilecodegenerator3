
import UIKit
import CoreData

class ExercisesViewController: UIViewController, UITableViewDelegate, UITableViewDataSource
 {

	@IBOutlet weak var newExerciseButton: UIButton!
	@IBOutlet weak var exercisesList: UITableView!
    var exercises = [NSManagedObject]()

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
	    return self.exercises.count
	}

	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
	    // Configure the cell...
	    if tableView == self.exercisesList {
	    
	    	let exercisesListCell = tableView.dequeueReusableCellWithIdentifier("exercisesListTableViewCell", forIndexPath: indexPath) as! DetailedTableViewCell
            
            let exercise = exercises[indexPath.row]
            
	        exercisesListCell.img.image = UIImage(named: "list_image")
	        exercisesListCell.label.text = exercise.valueForKey("name") as? String
	        exercisesListCell.content.text = "\(exercise.valueForKey("sets")!) X \(exercise.valueForKey("reps")!)"
	        exercisesListCell.icon.image = UIImage(named: "list_icon")
            
	        return exercisesListCell
	        
	    }
	
	    return UITableViewCell()
	}
	
	
	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	    if tableView == self.exercisesList {}
	    tableView.deselectRowAtIndexPath(indexPath, animated: true)
	}
	
	
	override func viewWillAppear(animated: Bool) {
		super.viewWillAppear(animated)
        
        //Legge tutti gli esercizi e li assegna a exercises
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Exercise")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.exercises = results as! [NSManagedObject]
        } catch {
            print("Error")
        }
        
        self.exercisesList.reloadData()
        
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
            destination.exerciseIndex = index.row
		}
	}
	
}
