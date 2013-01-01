package interactionbeats.interview.algorithms.binaryheap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class HeapTest {

	/**
	 * @param args[0] - No of elements to find
	 * @param args[1] - path of file to parse
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		BufferedReader br=null;
		
		try {
			
			Heap new_heap=new Heap(Integer.parseInt(args[0]));
			
			
				String coordinates;
				br=new BufferedReader(new FileReader(args[1]));
				
				while((coordinates=br.readLine())!=null){
					
			
					int x=(int)Double.parseDouble(coordinates.split(":")[0]);
					int y=(int)Double.parseDouble(coordinates.split(":")[1]);
					int distance = x*x+y*y;
					if(new_heap.current_size<Integer.parseInt(args[0])){
						//Coordinates new_coord=new Coordinates(x, y);
						new_heap.Insert(x,y);
					}else{
						if(distance<new_heap.getRootElementDistance()){
							new_heap.DeleteMax();
							new_heap.Insert(x,y);
						}			
					}

					
				}
			
			new_heap.printHeap();
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (HeapException e) {
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
