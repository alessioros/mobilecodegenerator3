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

package app_extensions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppJavaUtil {
	
	public static String APPLICATION_NAME;
	
	/**
	 * Sets the application name
	 * @param applicationName
	 */
	public static void setApplicationName(String applicationName) {
		APPLICATION_NAME = applicationName;
	}
	
	/**
	 * Returns the list of user's files
	 * @return
	 */
	public static List<String> getUserFilesNames(){
		File folder = new File("utils/user_files");
		List<String> userFilesNames = new ArrayList<String>();
		for(File source : folder.listFiles()){
				userFilesNames.add(source.getName());
		}
		return userFilesNames;
	}

	/**
	 * Copies a file
	 * @param source
	 * @param destination
	 */
	public static void copyFile(File source, File destination){
		try {
			if(!destination.exists()){
				destination.createNewFile();
			}
			InputStream in = new FileInputStream(source);
			OutputStream out = new FileOutputStream(destination);
			byte[] buffer = new byte[1024];
			int length;
			while((length=in.read(buffer))>0){
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes a folder and all its content
	 * @param folder
	 */
	public static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) {
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	
	public static boolean existsAtLeastOne(Collection<?> c) {
		Object[] array = c.toArray();
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAMenuDestination(String name, List<?> menuItems) {
		for(int i = 0; i < menuItems.size(); i++) {
			if(name.equals(menuItems.get(i))) {
				return true;
			}
		}
		return false;
	}
}
