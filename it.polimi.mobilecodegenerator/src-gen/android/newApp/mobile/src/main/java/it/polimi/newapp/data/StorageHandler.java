package it.polimi.newapp.data;

import android.content.Context;
import java.io.File;
import java.io.OutputStream.FileOutputStream;
import java.io.InputStream.FileInputStream;
import java.io.Reader.InputStreamReader;
import java.io.Reader.BufferedReader;
import java.lang.StringBuilder;

public StorageHandler{
	String provaUno = "provaUno";
	String provaDue = "provaDue";
	String provaTre = "provaTre";
	
	private Context context;
	
	/**
	* Constructor
	* 
	* @param context
	*/
	public StorageHandler(Context context){
		this.context=context;
	}
	
	/**
	* Method that writes the content to the file
	* 
	* @param fileName the name of the file
	* @param content the string content to write
	* @return boolean success
	*/
	public boolean writeFile(String fileName, String content){
	
		FileOutputStream outputStream = null;
		try {
		    outputStream = new FileOutputStream(file);
		    outputStream.write(content.getBytes());
		    outputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
		return true;
	}
	
    /**
	* Method that reads the content of a file
	* 
	* @param fileName the name of the file
	* @param isTemp if the file is temporary or not
	* @return content
	*/
	public String readfile(String fileName, boolean isTemp){
 
        String content = null;
 		FileInputStream inputStream = null;
		try {
			File file = null;
			if(isTemp){
				file = new File(this.context.getCacheDir(), filename);
			}else{
				file = new File(this.context.getFilesDir(), filename);
			}
		    inputStream = openFileInput(fileName, Context.MODE_PRIVATE);
		    InputStreamReader isr = new InputStreamReader(inputStream);
		    BufferedReader bufferedReader = new BufferedReader(isr);
		    StringBuilder content = new StringBuilder();
   			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line).append("\n");
			}
		   	inputStream.close();
		   	
		} catch (Exception e) {
		    e.printStackTrace();
		    return '';
		}
		return content;
	}
     
    /**
    * Method that deletes the file
	* 
	* @param fileName the name of the file
	* @param isTemp if the file is temporary or not
	* @return boolean success
	*/
	public boolean deleteFile(String fileName, boolean isTemp){
		
		File file = null;
		try {
			if(isTemp){
				file = new File(this.context.getCacheDir(), filename);
			}else{
				file = new File(this.context.getFilesDir(), filename);
			}
		    file.delete();
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
		return true;
	}
}
