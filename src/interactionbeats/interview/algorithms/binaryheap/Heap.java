package interactionbeats.interview.algorithms.binaryheap;


import java.util.ArrayList;

public class Heap {
	/**
	 * 
	 * Heap is a 
	 * 	 - Complete Binary tree
	 *   - Two types (i) Max Heap - Every node is greater than its left and right child
	 *               (ii)Min Heap - Every node is smaller than its left and right child
	 *   - Heap is loosely sorted, the root is the smallest element in case of minHeap or max element in case of maxHeap
	 *   - Heap in arrays allow us to store children without pointer, hence avoiding the extra memory as in a binary tree
	 * 	 Disadvantages-
	 *    Since array based implementation doesn't use pointer, we cannot move nodes around instead have to move the content around
	 *    It's no good for searching as we cannot do a log n search as in binary search tree, but we can do a linear search
	 *    
	 *    Usage- 
	 *      -Given a set of values if you need to find the first 'x' no of values that match a filter criteria
	 *      [will be updated]
	 */
	
	
	ArrayList<Coordinates> heap_store;
	int total_size;
	int current_size;

	
	public Heap(int size){
	
		heap_store = new ArrayList<Coordinates>(size);
		current_size=0;
		total_size=size;
		
	}

	
	//getLeftChildIndex
	int leftChildIndex(int index){
		return ((2 * index)+1); 
	}
	
	
	//getRightChildIndex
	int rightChildIndex(int index){
		
		return ((2 * index)+2);
	}
	
	//getParentIndex
	int parentIndex(int index){
		return (index-1)/2;
	}
	
	//Insert into Heap
	
	void Insert(int x, int y) throws HeapException{
		
		if(current_size==total_size){
			throw new HeapException("Heap is Full");
		}
		int insert_index=current_size;
		Coordinates insert_data=new Coordinates(x,y);
		heap_store.add(insert_index, insert_data);
		current_size++;
		TrickleUp(insert_index);
		
	}
	
	
	
	//CheckHeapUpwards - Trickle Up
	void TrickleUp(int index){
		if(index==0)
			return ;
		else{
			int parent=parentIndex(index);
			if(heap_store.get(parent).compareTo(heap_store.get(index))<0){
				Coordinates temp=heap_store.get(parent);
				
				heap_store.add(parent,heap_store.get(index));
				heap_store.add(index,temp);
			}
			TrickleUp(parent);
		}
		
		
	}
	
	int getRootElementDistance(){
		if(current_size==0)
			return -1;
		else
			return heap_store.get(0).getDistance();
		
	}
	
	//CheckHeadDownwards - Trickle Down
	void TrickleDown(int index){
		//if(index>current_size-1)
		//	return;
		//int parent=parentIndex(index);
		int left=leftChildIndex(index);
		int right=rightChildIndex(index);
		int traverse_index=-1;
		
		if(left<current_size&&right<current_size){
			if(heap_store.get(left).compareTo(heap_store.get(right))<1){	
				traverse_index=right;
			}else{
				
				traverse_index=left;
			}

		}else if(left<current_size){
			traverse_index=left;
			
		}else if(right<current_size){
			traverse_index=right; 				// May not be needed
		}else{
			return;
		}
		
		
				
		if(traverse_index>=0&& (heap_store.get(index).compareTo(heap_store.get(traverse_index))<0)){
			Coordinates temp=heap_store.get(index);
			heap_store.add(index,heap_store.get(traverse_index));
			heap_store.add(traverse_index,temp);
			TrickleDown(traverse_index);
		}
		
	}
	
	//DeleteMax from Heap
	
	void DeleteMax() throws HeapException{
		if(current_size==0)
			throw new HeapException("Heap is empty");
		else{
			Coordinates deletedElement=heap_store.get(0);
			heap_store.add(0,heap_store.get(current_size-1));
			heap_store.remove(current_size-1);
			current_size--;
			if(current_size>0)
			TrickleDown(0);
			//return deletedElement;
		}
		
		
	}

	
	public static Heap BuildHeap(int heapData[]) throws HeapException{
		
		Heap new_Heap= new Heap(heapData.length);
		for(int data:heapData){
			//new_Heap.Insert(data);
		}
		return new_Heap;
		
	}
	
	void printHeap(){
		if(current_size<=0)
			return;
		else{
			for(int i=0;i<current_size;i++)
				System.out.println("X:"+heap_store.get(i).getX()+"Y:"+heap_store.get(i).getY()+"distance :"+heap_store.get(i).getDistance());
		}
		
	}
	
	
	
	
}
