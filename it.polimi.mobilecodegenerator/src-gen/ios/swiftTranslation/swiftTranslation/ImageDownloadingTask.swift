import UIKit

class ImageDownloadingTask {
    
    //Function to download the image
    static func downloadImage(url: NSURL, imageView: UIImageView){
        getDataFromUrl(url) { (data, response, error)  in
            dispatch_async(dispatch_get_main_queue()) { () -> Void in
                guard let data = data where error == nil else { return }
                imageView.image = UIImage(data: data)
            }
        }
    }
    
    //Function to get the data from a url
    static func getDataFromUrl(url:NSURL, completion: ((data: NSData?, response: NSURLResponse?, error: NSError? ) -> Void)) {
        NSURLSession.sharedSession().dataTaskWithURL(url) { (data, response, error) in
            completion(data: data, response: response, error: error)
            }.resume()
    }

}
