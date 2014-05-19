package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFileMaker {

	FileOutputStream fos = null;

	//byte[][] byteArray,
	public void SaveLevel(byte[][] byteArray, String name){
		File save = new File("saves/"+ name + ".sav");
		try {
			save.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fos = new FileOutputStream(save, true);
			int size = byteArray.length;
			System.out.println(size);
			int i = 0;
			while (i<size){
				fos.write(byteArray[i],0,7);
				i++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (fos!= null ){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		
	}
}
