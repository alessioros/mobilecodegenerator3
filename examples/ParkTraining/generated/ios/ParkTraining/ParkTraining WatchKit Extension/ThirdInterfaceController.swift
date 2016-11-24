
import WatchKit
import Foundation
import WatchConnectivity

class ThirdInterfaceController: WKInterfaceController, WCSessionDelegate
 {

	var session : WCSession!

    
    override func awakeWithContext(context: AnyObject?) {
        super.awakeWithContext(context)
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
                
                let messageContent = String(result)
                    .stringByReplacingOccurrencesOfString("Optional([", withString: "")
                    .stringByReplacingOccurrencesOfString("])", withString: "")
                
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
