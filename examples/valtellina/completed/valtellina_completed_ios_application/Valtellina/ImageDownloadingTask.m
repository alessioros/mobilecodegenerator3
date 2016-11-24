//	This task attempts to download an image from the Network:
//	in case of success, it sets the proper ImageView,
//	in case of failure, it does nothing (ImageView remains without image).

#import "ImageDownloadingTask.h"

@interface ImageDownloadingTask()
@property (strong, nonatomic) NSString *imageUrl;
@property (strong, nonatomic) UIImageView *imageView;
@end

@implementation ImageDownloadingTask

-(void) downloadImageFromUrl:(NSString *)url forImageView: (UIImageView *)imageView 
{
    self.imageUrl = url;
    self.imageView = imageView;
    [self performSelectorInBackground:@selector(executeInBackGround) withObject:nil];
}

//Attempts to download the image at the url passed as parameter.
-(void)executeInBackGround 
{
    NSData * data = [NSData dataWithContentsOfURL:[NSURL URLWithString:self.imageUrl]];
    UIImage * result = [UIImage imageWithData:data];
    [self performSelectorOnMainThread:@selector(executeOnMainThread:) withObject:result waitUntilDone:NO];
}

//If the image has been downloaded properly it sets the ImageView.
-(void)executeOnMainThread:(UIImage *)image
{
    self.imageView.image = image;
}

@end
