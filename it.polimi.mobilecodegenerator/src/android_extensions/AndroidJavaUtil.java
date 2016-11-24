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

package android_extensions;

import java.io.File;
import app_extensions.AppJavaUtil;

public class AndroidJavaUtil {
	
	/**
	 * Deletes application code folder and its content (if already exists) 
	 */
	public static void deleteApplicationFolder(){
		File androidAppFolder = new File(AndroidConstants.destinationFilesFolder);
		AppJavaUtil.deleteFolder(androidAppFolder);
	}
	
	/**
	 * Copies all user's files according to their extension
	 * Raw 		folder contains .html .txt .mp4 .3gp
	 * Assets 	folder contains .css .mp3
	 * Drawable folder contains .png .jpg .gif
	 */
	public static void copyUserFiles(){
		File folder = new File("utils/user_files");
		for(File source : folder.listFiles()) {
			String sourceFileName = source.getName();
			String sourceFileExtension = source.getName().split("\\.")[1];
			if(sourceFileExtension.equalsIgnoreCase("html") || sourceFileExtension.equalsIgnoreCase("txt") || 
					sourceFileExtension.equalsIgnoreCase("mp4") || sourceFileExtension.equalsIgnoreCase("3gp")) {
				File destination = new File(AndroidConstants.rawFolder+"/"+sourceFileName);
				AppJavaUtil.copyFile(source, destination);
			}
			else if(sourceFileExtension.equalsIgnoreCase("css") || sourceFileExtension.equalsIgnoreCase("mp3")){
				File destination = new File(AndroidConstants.assetsFolder+"/"+sourceFileName);
				AppJavaUtil.copyFile(source, destination);
			}
			else if(sourceFileExtension.equalsIgnoreCase("png") || sourceFileExtension.equalsIgnoreCase("jpg") || sourceFileExtension.equalsIgnoreCase("gif")) {
				File destination = new File(AndroidConstants.drawableFolder+"/"+sourceFileName);
				AppJavaUtil.copyFile(source, destination);
			}
		}
	}
	
	/**
	 * Copies default Android files
	 */
	public static void copyDefaultAndroidFiles(){
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/assets").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/mipmap-hdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/mipmap-mdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/mipmap-xhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/mipmap-xxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/mipmap-xxxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable-hdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable-mdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable-xhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable-xxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/drawable-xxxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/menu").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/raw").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/values").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/values-v21").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/mobile/src/main/res/values-w820dp").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/gradle").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/gradle/wrapper").mkdirs();
		

		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/mipmap-hdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/mipmap-mdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/mipmap-xhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/mipmap-xxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/mipmap-xxxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable-hdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable-mdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable-xhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable-xxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/drawable-xxxhdpi").mkdirs();
		new File(AndroidConstants.destinationFilesFolder+"/wear/src/main/res/values").mkdirs();
		
		for(int i = 0; i < AndroidConstants.sourceFilesPaths.length; i++) {
			File source = new File(AndroidConstants.sourceFilesPaths[i]);
			File destination = new File(AndroidConstants.destinationFilesPaths[i]);
			AppJavaUtil.copyFile(source, destination);
		}
	}

}
