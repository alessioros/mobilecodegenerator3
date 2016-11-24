
import UIKit

class fifthViewViewController: UIViewController
 {

	@IBOutlet weak var smiiaCard: UIView!


	override func viewDidLoad() {
	    super.viewDidLoad()


	}
	
	override func viewDidAppear(animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	
	
	@IBAction func smiiaCardAction1TouchUpInside(sender: UIButton) {
    	//TODO implement the action
    }
	@IBAction func smiiaCardAction2TouchUpInside(sender: UIButton) {
    	//TODO implement the action
    }
	@IBAction func smiiaCardAction3TouchUpInside(sender: UIButton) {
    	//TODO implement the action
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
