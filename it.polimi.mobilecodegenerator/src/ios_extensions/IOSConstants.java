/************************************************************************************************************************
 * Copyright 2016 Gregorio Perego, Stefania Pezzetti, Aldo Pintus
 * This file is part of it.polimi.mobilecodegenerator.
 * 
 * it.polimi.mobilecodegenerator is free software: 
 * you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or (at your option) any later version.
 * 
 * it.polimi.mobilecodegenerator is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.You should have received a copy of the GNU General Public License
 * along with it.polimi.mobilecodegenerator. If not, see <http://www.gnu.org/licenses/>
 * ***********************************************************************************************************************/

package ios_extensions;
import app_extensions.AppJavaUtil;

public class IOSConstants {
	
	public static String sourceFilesFolder = "utils/ios_default_files";
	
	public static String[] sourceFilesPaths = {
		sourceFilesFolder+"/Contents.json",
		sourceFilesFolder+"/AppIcon.appiconset/Contents.json",
		sourceFilesFolder+"/grid_image.imageset/Contents.json",
		sourceFilesFolder+"/grid_image.imageset/grid_image@3x.png",
		sourceFilesFolder+"/grid_image.imageset/grid_image@2x.png",
		sourceFilesFolder+"/grid_image.imageset/grid_image.png",
		sourceFilesFolder+"/card_image.imageset/Contents.json",
		sourceFilesFolder+"/card_image.imageset/card_image@3x.png",
		sourceFilesFolder+"/card_image.imageset/card_image@2x.png",
		sourceFilesFolder+"/card_image.imageset/card_image.png",
		sourceFilesFolder+"/list_image.imageset/Contents.json",
		sourceFilesFolder+"/list_image.imageset/list_image@3x.png",
		sourceFilesFolder+"/list_image.imageset/list_image@2x.png",
		sourceFilesFolder+"/list_image.imageset/list_image.png",
		sourceFilesFolder+"/list_icon.imageset/Contents.json",
		sourceFilesFolder+"/list_icon.imageset/list_icon@3x.png",
		sourceFilesFolder+"/list_icon.imageset/list_icon@2x.png",
		sourceFilesFolder+"/list_icon.imageset/list_icon.png",
		sourceFilesFolder+"/play_icon.imageset/Contents.json",
		sourceFilesFolder+"/play_icon.imageset/play_icon@3x.png",
		sourceFilesFolder+"/play_icon.imageset/play_icon@2x.png",
		sourceFilesFolder+"/play_icon.imageset/play_icon.png",
		sourceFilesFolder+"/pause_icon.imageset/Contents.json",
		sourceFilesFolder+"/pause_icon.imageset/pause_icon@3x.png",
		sourceFilesFolder+"/pause_icon.imageset/pause_icon@2x.png",
		sourceFilesFolder+"/pause_icon.imageset/pause_icon.png",
		sourceFilesFolder+"/stop_icon.imageset/Contents.json",
		sourceFilesFolder+"/stop_icon.imageset/stop_icon@3x.png",
		sourceFilesFolder+"/stop_icon.imageset/stop_icon@2x.png",
		sourceFilesFolder+"/stop_icon.imageset/stop_icon.png",
		sourceFilesFolder+"/photocamera_icon.imageset/Contents.json",
		sourceFilesFolder+"/photocamera_icon.imageset/photocamera_icon@3x.png",
		sourceFilesFolder+"/photocamera_icon.imageset/photocamera_icon@2x.png",
		sourceFilesFolder+"/photocamera_icon.imageset/photocamera_icon.png",
		sourceFilesFolder+"/videocamera_icon.imageset/Contents.json",
		sourceFilesFolder+"/videocamera_icon.imageset/videocamera_icon@3x.png",
		sourceFilesFolder+"/videocamera_icon.imageset/videocamera_icon@2x.png",
		sourceFilesFolder+"/videocamera_icon.imageset/videocamera_icon.png",
		
		sourceFilesFolder+"/WatchKit App/Assets.xcassets/AppIcon.appiconset/Contents.json",
		
	};
	
	public static String destinationFilesFolder = "src-gen/ios/"+AppJavaUtil.APPLICATION_NAME;
	
	public static String[] destinationFilesPaths = {
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/AppIcon.appiconset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/grid_image.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/grid_image.imageset/grid_image@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/grid_image.imageset/grid_image@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/grid_image.imageset/grid_image.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/card_image.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/card_image.imageset/card_image@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/card_image.imageset/card_image@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/card_image.imageset/card_image.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_image.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_image.imageset/list_image@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_image.imageset/list_image@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_image.imageset/list_image.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_icon.imageset/list_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_icon.imageset/list_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_icon.imageset/list_icon.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/play_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/play_icon.imageset/play_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/play_icon.imageset/play_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/play_icon.imageset/play_icon.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/pause_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/pause_icon.imageset/pause_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/pause_icon.imageset/pause_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/pause_icon.imageset/pause_icon.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/stop_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/stop_icon.imageset/stop_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/stop_icon.imageset/stop_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/stop_icon.imageset/stop_icon.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/photocamera_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/photocamera_icon.imageset/photocamera_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/photocamera_icon.imageset/photocamera_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/photocamera_icon.imageset/photocamera_icon.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/videocamera_icon.imageset/Contents.json",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/videocamera_icon.imageset/videocamera_icon@3x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/videocamera_icon.imageset/videocamera_icon@2x.png",
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/videocamera_icon.imageset/videocamera_icon.png",
		
		destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit App/Assets.xcassets/AppIcon.appiconset/Contents.json",
		
		
	};
}