
import UIKit

class fifthViewViewController: UIViewController
 {

	@IBOutlet weak var smiiaCard: UIView!


	override func viewDidLoad() {
	    super.viewDidLoad()


	}
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	
	
	@IBAction func smiiaCardAction1TouchUpInside(_ sender: UIButton) {
    	//TODO implement the action
    }
	@IBAction func smiiaCardAction2TouchUpInside(_ sender: UIButton) {
    	//TODO implement the action
    }
	@IBAction func smiiaCardAction3TouchUpInside(_ sender: UIButton) {
    	//TODO implement the action
    }
	
	
	
	
	
	
	
	
	override func viewWillAppear(_ animated: Bool) {
		super.viewWillAppear(animated)
	}
	
	override func viewWillDisappear(_ animated: Bool) {
		super.viewWillDisappear(animated)
	}
	
	override func didReceiveMemoryWarning() {
	    super.didReceiveMemoryWarning()
	    // Dispose of any resources that can be recreated.
	}
	
	override func prepare(for segue: UIStoryboardSegue, sender: AnyObject?) {
	}
	
}
