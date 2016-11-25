
import WatchKit
import Foundation
import WatchConnectivity

class newView2InterfaceController: WKInterfaceController, WCSessionDelegate
 {

	@IBOutlet weak var vtgnjWatchSlider: WKInterfaceSlider!
	@IBOutlet weak var vaqWatchSwitchButton: WKInterfaceSwitch!
	var session : WCSession!

    
    override func awake(withContext context: Any?) {
        super.awake(withContext: context)
    }

    override func willActivate() {
        super.willActivate()
	    if (WCSession.isSupported()) {
	        session = WCSession.default()
	        session.delegate = self
	        session.activate()
	    }
    }

    override func didDeactivate() {
        super.didDeactivate()
    }
    
    
	@IBAction func vtgnjWatchSliderAction(_ value: Float) {
        // You can reference to the progress value of the slider
        let progressValue: Float = value
    }
    
	@IBAction func vaqWatchSwitchButtonValueChangedAction(_ value: Bool) {
        // You can check the value of the switch
        let isChecked: Bool = value
    }
    
	@IBAction func sendVoiceMessage() {
        send("messageId")
    }
    
    fileprivate func send(_ messageId: String) {
        
        let phrases = ["I'm busy", "OK", "Bye"]
        
        presentTextInputController(
        	withSuggestions: phrases,
            allowedInputMode: .plain,
            completion: { (result) -> Void in
                
                let messageContent = String(describing: result)
                    .stringByReplacingOccurrences(of: "Optional([", with: "")
                    .stringByReplacingOccurrences(of: "])", with: "")
                
                let applicationData = [messageId: messageContent]
                
                self.session.sendMessage(applicationData, replyHandler: {
                    (_: [String : AnyObject]) -> Void in
                    // handle reply from iPhone app here
                    
                    }, errorHandler: {(error ) -> Void in
                    // catch any errors here
                
                })
                
            }
        )
 
    }

}
