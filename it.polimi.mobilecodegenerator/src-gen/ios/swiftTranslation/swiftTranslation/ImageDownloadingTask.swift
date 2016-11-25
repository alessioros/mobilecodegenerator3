import UIKit

class ImageDownloadingTask {
    
    //Function to download the image
    static func downloadImage(_ url: URL, imageView: UIImageView){
        getDataFromUrl(url) { (data, response, error)  in
            DispatchQueue.main.async { () -> Void in
                guard let data = data, error == nil else { return }
                imageView.image = UIImage(data: data)
            }
        }
    }
    
    //Function to get the data from a url
    static func getDataFromUrl(_ url:URL, completion: @escaping ((_ data: Data?, _ response: URLResponse?, _ error: NSError? ) -> Void)) {
        URLSession.shared.dataTask(with: url, completionHandler: { (data, response, error) in
            completion(data, response, error)
            }) .resume()
        
    }

}
