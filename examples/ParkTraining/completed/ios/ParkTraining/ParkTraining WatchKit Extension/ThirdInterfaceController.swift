
import WatchKit
import Foundation
import WatchConnectivity

class ThirdInterfaceController: WKInterfaceController, WCSessionDelegate
 {

	var session : WCSession!
    var numReps = Float(0)
    var numSets = Float(0)

    
    override func awakeWithContext(context: AnyObject?) {
        super.awakeWithContext(context)
        if let val: [Float] = context as? [Float] {
            self.numReps = val[0]
            self.numSets = val[1]
        }
    }

    override func willActivate() {
        super.willActivate()
	    if (WCSession.isSupported()) {
	        session = WCSession.defaultSession()
	        session.delegate = self
	        session.activateSession()
	    }
    }

    override func didDeactivate() {
        super.didDeactivate()
    }
    
    
    
    
	@IBAction func sendVoiceMessage() {
        send("messageId")
    }
    
    private func send(messageId: String) {
        
        let phrases = ["I'm busy", "OK", "Bye"]
        
        presentTextInputControllerWithSuggestions(
            phrases,
            allowedInputMode: .Plain,
            completion: { (result) -> Void in
                
                var messageContent = String(result)
                    .stringByReplacingOccurrencesOfString("Optional([", withString: "")
                    .stringByReplacingOccurrencesOfString("])", withString: "")
                
                messageContent = "\(messageContent),\(self.numSets),\(self.numReps)"
                print(messageContent)
                
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
