
import WatchKit
import Foundation

class FirstInterfaceController: WKInterfaceController
 {

	@IBOutlet weak var firstNextButton: WKInterfaceButton!
	@IBOutlet weak var repsSlider: WKInterfaceSlider!
    var numReps = Float(0)

    
    override func awakeWithContext(context: AnyObject?) {
        super.awakeWithContext(context)
    }

    override func willActivate() {
        super.willActivate()
    }

    override func didDeactivate() {
        super.didDeactivate()
    }
    
	@IBAction func firstNextButtonAction() {
        //TODO Implement the action
    }  
    
	@IBAction func repsSliderAction(value: Float) {
        // You can reference to the progress value of the slider
        self.numReps = value
    }
    
    override func contextForSegueWithIdentifier(segueIdentifier: String) -> AnyObject? {
        return self.numReps
    }
    
    

}
