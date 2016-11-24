
import UIKit
import CoreData

class ExerciseNewViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {

	@IBOutlet weak var newSaveButton: UIButton!
	@IBOutlet weak var newNameEditText: UITextField!
	@IBOutlet weak var newSetsSpinner: UIPickerView!
    var newSetsSpinnerDataSource = ["1", "2", "3"]
    var numSets: Int = 1
	@IBOutlet weak var newRepsSpinner: UIPickerView!
    var newRepsSpinnerDataSource = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"]
    var numReps: Int = 1

	override func viewDidLoad() {
	    super.viewDidLoad()
		newSaveButton.layer.cornerRadius = 36


		self.newSetsSpinner.dataSource = self
    	self.newSetsSpinner.delegate = self
		self.newRepsSpinner.dataSource = self
    	self.newRepsSpinner.delegate = self
	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	
    
    func createExercise(name: String, sets: Int, reps: Int) {
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        
        let entity = NSEntityDescription.entityForName("Exercise", inManagedObjectContext: managedContext)
        
        let item = NSManagedObject(entity: entity!, insertIntoManagedObjectContext: managedContext)
        
        item.setValue(name, forKey: "name")
        item.setValue(sets, forKey: "sets")
        item.setValue(reps, forKey: "reps")
        
        do {
            try managedContext.save()
        } catch {
            print("Error")
        }
    
    }


	
	@IBAction func newSaveButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.050980393, green: 0.7411765, blue: 0.20392157, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func newSaveButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.03529412, green: 0.9411765, blue: 0.23529412, alpha: 1)
        //TODO Implement the action
        let name: String = newNameEditText.text!
        createExercise(name, sets: self.numSets, reps: self.numReps)
        navigationController?.popViewControllerAnimated(true)
    }  
	
	
	
	
	
	
	
	func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == self.newSetsSpinner {
            return newSetsSpinnerDataSource.count
        }
        if pickerView == self.newRepsSpinner {
            return newRepsSpinnerDataSource.count
        }
        return 0
    }
    
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == self.newSetsSpinner {
            return newSetsSpinnerDataSource[row]
        }
        if pickerView == self.newRepsSpinner {
            return newRepsSpinnerDataSource[row]
        }
        return nil
    }
    
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView == self.newSetsSpinner {
        	self.numSets = Int(newSetsSpinnerDataSource[row])!
        }
        if pickerView == self.newRepsSpinner {
        	self.numReps = Int(newRepsSpinnerDataSource[row])!
        }
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
