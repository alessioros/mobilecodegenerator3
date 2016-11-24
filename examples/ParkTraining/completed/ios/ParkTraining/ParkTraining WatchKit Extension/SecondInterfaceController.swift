
import WatchKit
import Foundation

class SecondInterfaceController: WKInterfaceController
 {

	@IBOutlet weak var secondNextButton: WKInterfaceButton!
	@IBOutlet weak var setsSlider: WKInterfaceSlider!
    var numReps = Float(0)
    var numSets = Float(0)

    
    override func awakeWithContext(context: AnyObject?) {
        super.awakeWithContext(context)
        if let val: Float = context as? Float {
            self.numReps = val
        }
    }

    override func willActivate() {
        super.willActivate()
    }

    override func didDeactivate() {
        super.didDeactivate()
    }
    
	@IBAction func secondNextButtonAction() {
        //TODO Implement the action
    }  
    
	@IBAction func setsSliderAction(value: Float) {
        // You can reference to the progress value of the slider
        self.numSets = value
    }
    
    override func contextForSegueWithIdentifier(segueIdentifier: String) -> AnyObject? {
        return [self.numReps, self.numSets]
    }

}
