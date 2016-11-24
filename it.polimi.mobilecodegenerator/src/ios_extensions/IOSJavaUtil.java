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

import java.awt.Color;
import java.io.File;
import java.util.HashMap;

import app_extensions.AppJavaUtil;

public class IOSJavaUtil {
	
	private static HashMap<String, String[]> hexadecimalIdsMap = new HashMap<String, String[]>();
	private static int count = 1000000;
	private static HashMap<String, String> storyboardImages = new HashMap<String, String>();
	
	/**
	 * Returns the first hex id
	 * @param key
	 * @return
	 */
	public static String getFirstHexadecimalId(String key){
		if(hexadecimalIdsMap.containsKey(key)){
			return hexadecimalIdsMap.get(key)[0];		
		}
		else{
			return generateNewHexadecimalIds(key)[0];
		}
	}
	
	/**
	 * Returns the second hex id
	 * @param key
	 * @return
	 */
	public static String getSecondHexadecimalId(String key){
		return hexadecimalIdsMap.get(key)[1];
	}
	
	/**
	 * Generates a couple of hex ids in the range 36181Axxxxxxx5260094950D
	 * @param key
	 * @return
	 */
	private static String[] generateNewHexadecimalIds(String key) {
		//36181A and 5260094950D have been chosen randomly
		String firstId 	= "36181A"+(++count)+"5260094950D";
		String secondId = "36181A"+(++count)+"5260094950D";
		String[] array = {firstId,secondId};
		hexadecimalIdsMap.put(key,array);
		
		return array;
	}
	
	/**
	 * Deletes application code folder and its content (if already exists)
	 */
	public static void deleteApplicationFolder(){
		File iosAppFolder = new File(IOSConstants.destinationFilesFolder);
		AppJavaUtil.deleteFolder(iosAppFolder);
	}
	
	/**
	 * Copies user files
	 */
	public static void copyUserFiles(){
		File folder = new File("utils/user_files");
		for(File source : folder.listFiles()){
			File destination = new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/"+source.getName());
			AppJavaUtil.copyFile(source, destination);
		}
	}
	
	/**
	 * Copies iOS default files
	 */
	public static void copyDefaultIOSFiles(){
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/AppIcon.appiconset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/grid_image.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/card_image.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_image.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/list_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/play_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/pause_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/stop_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/photocamera_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Assets.xcassets/videocamera_icon.imageset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+"/Base.lproj").mkdirs();
		
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit App").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit App/Assets.xcassets").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit App/Assets.xcassets/AppIcon.appiconset").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit App/Base.lproj").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit Extension").mkdirs();
		new File(IOSConstants.destinationFilesFolder+"/"+AppJavaUtil.APPLICATION_NAME+" WatchKit Extension/Assets.xcassets").mkdirs();
		
		for(int i=0; i<IOSConstants.sourceFilesPaths.length; i++){
			File source = new File(IOSConstants.sourceFilesPaths[i]);
			File destination = new File(IOSConstants.destinationFilesPaths[i]);
			AppJavaUtil.copyFile(source, destination);
		}
	}
	
	/**
	 * Returns the normalized rgb red
	 * @param hexColor
	 * @return
	 */
	public static float redFromHex(String hexColor) {
		try {
			hexColor = hexColor.replace("#", "0x");
			Color c = Color.decode(hexColor);
			return (float) c.getRed()/255;
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * Returns the normalized rgb green
	 * @param hexColor
	 * @return
	 */
	public static float greenFromHex(String hexColor) {
		try {
			hexColor = hexColor.replace("#", "0x");
			Color c = Color.decode(hexColor);
			return (float) c.getGreen()/255;
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * Returns the normalized rgb blue
	 * @param hexColor
	 * @return
	 */
	public static float blueFromHex(String hexColor) {
		try {
			hexColor = hexColor.replace("#", "0x");
			Color c = Color.decode(hexColor);
			return (float) c.getBlue()/255;
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * Returns the main domain of a URL string
	 * @param url
	 * @return
	 */
	public String domainFromUrl(String url) {
		String parts[] = url.split("//");
		String cleanUrl = parts[1];
		String results[] = cleanUrl.split("/");
		return results[0];
	}
	
	/**
	 * Removes the extensions .mp3 or .mp4 from file name
	 * @param fileName
	 * @return
	 */
	public String removeExtension(String fileName) {
		if (fileName.contains(".mp3"))		return fileName.split(".mp3")[0];
		else if (fileName.contains(".mp4")) return fileName.split(".mp4")[0];
		else return fileName;
	}
	
	public int numUiWatchControls(String watchControllerString) {
		watchControllerString = watchControllerString.replace("metamodel::WatchButton","MCGmetamodel::WatchButton");
		watchControllerString = watchControllerString.replace("metamodel::WatchSlider","MCGmetamodel::WatchSlider");
		watchControllerString = watchControllerString.replace("metamodel::WatchSwitch","MCGmetamodel::WatchSwitch");
		watchControllerString = watchControllerString.replace("metamodel::WatchTextView","MCGmetamodel::WatchTextView");
		watchControllerString = watchControllerString.replace("metamodel::WatchVoiceMessage","MCGmetamodel::WatchVoiceMessage");
		String[] watchControls = watchControllerString.split("MCG");
		return watchControls.length-1;
	}
	
	public static void addStoryboardImage(String imageName) {
		storyboardImages.put(imageName, "");
		System.out.println("Adding storyboard image ...");
		for(int i = 0; i < storyboardImages.size(); i++) {
			System.out.println("["+i+"] = "+storyboardImages.keySet().toArray()[i]);
		}
	}
	
	public static int numStoryboardImages() {
		return storyboardImages.size()-1;
	}
	
	public static String getStoryboardImage(Integer index) {
		return (String) storyboardImages.keySet().toArray()[index];
	}
	
}
