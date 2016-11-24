
import WatchKit
import Foundation

class SecondInterfaceController: WKInterfaceController
 {

	@IBOutlet weak var secondNextButton: WKInterfaceButton!
	@IBOutlet weak var setsSlider: WKInterfaceSlider!

    
    override func awakeWithContext(context: AnyObject?) {
        super.awakeWithContext(context)
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
        let progressValue: Float = value
    }
    
    

}
