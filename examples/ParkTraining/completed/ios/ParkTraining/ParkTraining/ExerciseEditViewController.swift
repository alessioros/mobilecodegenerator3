
import UIKit
import CoreData

class ExerciseEditViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate
 {

	@IBOutlet weak var editSaveButton: UIButton!
	@IBOutlet weak var editDeleteButton: UIButton!
	@IBOutlet weak var editNameEditText: UITextField!
	@IBOutlet weak var editRepsSpinner: UIPickerView!
    var editSetsSpinnerDataSource = ["1", "2", "3"]
    var numSets: Int = 1
	@IBOutlet weak var editSetsSpinner: UIPickerView!
    var editRepsSpinnerDataSource = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"]
    var numReps: Int = 1
    
    var exerciseIndex: Int = 0
    var exercise: NSManagedObject!


	override func viewDidLoad() {
	    super.viewDidLoad()
		editSaveButton.layer.cornerRadius = 36
		editDeleteButton.layer.cornerRadius = 36

		self.editRepsSpinner.dataSource = self
    	self.editRepsSpinner.delegate = self
		self.editSetsSpinner.dataSource = self
    	self.editSetsSpinner.delegate = self
	}
	
    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
        
        //Legge l'esercizio
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        let fetchRequest = NSFetchRequest(entityName: "Exercise")
        do {
            let results = try managedContext.executeFetchRequest(fetchRequest)
            self.exercise = results[self.exerciseIndex] as! NSManagedObject
        } catch {
            print("Error")
        }
        
    }
    
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
        //aggiorna ui
        let name = self.exercise.valueForKey("name") as? String
        let sets = self.exercise.valueForKey("sets") as! Int
        let reps = self.exercise.valueForKey("reps") as! Int
        self.editNameEditText.text = name
        self.editSetsSpinner.selectRow(sets-1, inComponent: 0, animated: true)
        self.editRepsSpinner.selectRow(reps-1, inComponent: 0, animated: true)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	
	@IBAction func editSaveButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.050980393, green: 0.7411765, blue: 0.20392157, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func editSaveButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.03529412, green: 0.9411765, blue: 0.23529412, alpha: 1)
        //TODO Implement the action
        let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let managedContext = appDelegate.managedObjectContext
        
        self.exercise.setValue(self.editNameEditText.text, forKey: "name")
        self.exercise.setValue(self.numSets, forKey: "sets")
        self.exercise.setValue(self.numReps, forKey: "reps")
        
        do {
            try managedContext.save()
        } catch {
            print("error")
        }
        
        navigationController?.popViewControllerAnimated(true)
        
    }
    
	@IBAction func editDeleteButtonTouchDown(sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.7019608, green: 0.019607844, blue: 0.019607844, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func editDeleteButtonTouchUpInside(sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.8, green: 0.0, blue: 0.0, alpha: 1)
        //TODO Implement the action
        //Create the AlertController
        let deleteExerciseDialog: UIAlertController = UIAlertController(title: "Delete Exercise", message: "Are you sure?", preferredStyle: .Alert)
        
        //Create and add the Cancel action
        let deleteExerciseDialogCancelAction: UIAlertAction = UIAlertAction(title: "Cancel", style: .Cancel) { action -> Void in
            //Just dismiss the alert
        }
        
        //Create and add the Ok action
        let deleteExerciseDialogOkAction: UIAlertAction = UIAlertAction(title: "Ok", style: .Default) { action -> Void in
            let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
            let managedContext = appDelegate.managedObjectContext
            managedContext.deleteObject(self.exercise)
            
            do {
                try managedContext.save()
            } catch {
                print("error")
            }
        
            self.navigationController?.popViewControllerAnimated(true)
            
        }
        
        deleteExerciseDialog.addAction(deleteExerciseDialogCancelAction)
        deleteExerciseDialog.addAction(deleteExerciseDialogOkAction)
        
        //Present the AlertController
        self.presentViewController(deleteExerciseDialog, animated: true, completion: nil)
    }
	
	
	func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == self.editRepsSpinner {
            return editRepsSpinnerDataSource.count
        }
        if pickerView == self.editSetsSpinner {
            return editSetsSpinnerDataSource.count
        }
        return 0
    }
    
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == self.editRepsSpinner {
            self.numReps = Int(editRepsSpinnerDataSource[row])!
            return editRepsSpinnerDataSource[row]
        }
        if pickerView == self.editSetsSpinner {
            self.numSets = Int(editSetsSpinnerDataSource[row])!
            return editSetsSpinnerDataSource[row]
        }
        return nil
    }
    
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView == self.editRepsSpinner {
        	self.numReps = Int(editRepsSpinnerDataSource[row])!
        }
        if pickerView == self.editSetsSpinner {
        	self.numSets = Int(editSetsSpinnerDataSource[row])!
        }
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
