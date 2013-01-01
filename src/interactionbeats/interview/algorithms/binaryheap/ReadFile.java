package interactionbeats.interview.algorithms.binaryheap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadFile {
	
	BufferedReader br=null;
	String path;
	public LinkedList<String> linebylineData;
	
	
	public ReadFile(String file_path) {
		// TODO Auto-generated constructor stub
		path=file_path;
		linebylineData=new LinkedList<String>();
	}

	public void Read(){

		try {
			String coordinates;
			br=new BufferedReader(new FileReader(path));
			
			while((coordinates=br.readLine())!=null){
				
				linebylineData.add(coordinates);
				
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
	}
	
}
