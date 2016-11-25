
import UIKit

class firstViewViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate
 {

	@IBOutlet weak var bqbgtButton: UIButton!
	@IBOutlet weak var pdirEditText: UITextField!
	@IBOutlet weak var eltsSlider: UISlider!
	@IBOutlet weak var jlhtqSpinner: UIPickerView!
    var jlhtqSpinnerDataSource = ["Option A", "Option B", "Option C"]
	@IBOutlet weak var ukjpSwitchButton: UISwitch!
	@IBOutlet weak var audbWebView: UIWebView!


	override func viewDidLoad() {
	    super.viewDidLoad()
		bqbgtButton.layer.cornerRadius = 2


		self.jlhtqSpinner.dataSource = self
    	self.jlhtqSpinner.delegate = self
		let audbWebViewFileName = "provah"
		if let audbWebViewUrl = Bundle.main.url(forResource: audbWebViewFileName, withExtension:"html") {
	        let request = URLRequest(url: audbWebViewUrl)
	        self.audbWebView.loadRequest(request)
	    }
	}
	
	override func viewDidAppear(_ animated: Bool) {
	    super.viewDidAppear(animated)
	}
	
	override func viewDidDisappear(_ animated: Bool) {
		super.viewDidDisappear(animated)
	}
	



	
	@IBAction func bqbgtButtonTouchDown(_ sender: UIButton) {
        // Changes background color of button when clicked
		sender.backgroundColor = UIColor(red: 0.43137255, green: 0.15294118, blue: 0.7882353, alpha: 1)
        //TODO Implement the action
    }
    
	@IBAction func bqbgtButtonTouchUpInside(_ sender: UIButton) {
        // Restore original background color of button after click
		sender.backgroundColor = UIColor(red: 0.7490196, green: 0.07058824, blue: 0.39607844, alpha: 1)
        //TODO Implement the action
    }  
	
	
	
	
	
	
	@IBAction func eltsSliderValueChangedAction(_ sender: UISlider) {
        // You can reference to the progress value of the slider
        let progressValue: Float = sender.value
    }
	
	func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == self.jlhtqSpinner {
            return jlhtqSpinnerDataSource.count
        }
        return 0
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == self.jlhtqSpinner {
            return jlhtqSpinnerDataSource[row]
        }
        return nil
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView == self.jlhtqSpinner {
        	print("\(jlhtqSpinnerDataSource[row])")
        }
    }
	
	@IBAction func ukjpSwitchButtonValueChangedAction(_ sender: UISwitch) {
        // You can check the value of the switch
        let isChecked: Bool = sender.isOn
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
