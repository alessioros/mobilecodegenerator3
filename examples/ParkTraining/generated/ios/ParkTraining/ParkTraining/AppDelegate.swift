import UIKit
import WatchConnectivity

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate, WCSessionDelegate {

    var window: UIWindow?

	var session: WCSession?
    var receivedMessages : [String : String] = [:]
	
	func session(session: WCSession, didReceiveMessage message: [String : AnyObject], replyHandler: ([String : AnyObject]) -> Void) {
        
        //the message contains only a single pair [key:value]
        //this loop is used to get a reference to that pair
        for (key,value) in message {
            
            //get message content
            let messageContent = value as! String
            
            //check if key exists and eventually update it
            var tmpKey = key
            var keyExists = receivedMessages[tmpKey] != nil
            var i = 1
            while(keyExists) {
                tmpKey = key.stringByAppendingString("_\(i)")
                keyExists = receivedMessages[tmpKey] != nil
                i += 1
            }
            
            //store the pair [tmpKey:messageContent]
            receivedMessages[tmpKey] = messageContent
            
            //you can reference to this messages from any viewcontroller like this
            //let appDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
            //let receivedMessages = appDelegate.receivedMessages
            //let numMessages = receivedMessages.count
            //if let lastMessage = receivedMessages.values.first {}
            
        }
        
	}

    func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
        // Override point for customization after application launch.
        if (WCSession.isSupported()) {
            self.session = WCSession.defaultSession()
            self.session!.delegate = self;
            self.session!.activateSession()
            print("WCSession activated")
        } else {
            print("WCSession is not supported")
        }
        return true
    }

    func applicationWillResignActive(application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(application: UIApplication) {
        // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }

}
