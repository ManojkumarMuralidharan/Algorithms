package interactionbeats.interview.algorithms.binaryheap;

public class Heap {

	int heap_store[];
	int current_size;

	
	public Heap(int size){
		heap_store = new int[size];
		current_size=0;
	}
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
	
	void Insert(int data) throws HeapException{
		
		if(current_size==heap_store.length){
			throw new HeapException("Heap is Full");
		}
		int insert_index=current_size;
		heap_store[insert_index]=data;
		current_size++;
		TrickleUp(insert_index);
		
	}
	
	
	
	//CheckHeapUpwards - Trickle Up
	void TrickleUp(int index){
		if(index==0)
			return ;
		else{
			int parent=parentIndex(index);
			if(heap_store[parent]<heap_store[index]){
				int temp=heap_store[parent];
				heap_store[parent]=heap_store[index];
				heap_store[index]=temp;
			}
			TrickleUp(parent);
		}
		
		
	}
	
	int getRootElement(){
		if(current_size==0)
			return -1;
		else
			return heap_store[0];
		
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
			if(heap_store[left]<heap_store[right]){	
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
		
		
				
		if(traverse_index>=0&&heap_store[index]<heap_store[traverse_index]){
			int temp=heap_store[index];
			heap_store[index]=heap_store[traverse_index];
			heap_store[traverse_index]=temp;
			TrickleDown(traverse_index);
		}
		
	}
	
	//DeleteMax from Heap
	
	int DeleteMax() throws HeapException{
		if(current_size==0)
			throw new HeapException("Heap is empty");
		else{
			int deletedElement=heap_store[0];
			heap_store[0]=heap_store[current_size-1];
			heap_store[current_size-1]=0;
			current_size--;
			if(current_size>0)
			TrickleDown(0);
			return deletedElement;
		}
		
		
	}

	
	public static Heap BuildHeap(int heapData[]) throws HeapException{
		
		Heap new_Heap= new Heap(heapData.length);
		for(int data:heapData){
			new_Heap.Insert(data);
		}
		return new_Heap;
		
	}
	
	void printHeap(){
		if(current_size<=0)
			return;
		else{
			for(int i=0;i<current_size;i++)
				System.out.println(heap_store[i]);
		}
		
	}
	
	
}
