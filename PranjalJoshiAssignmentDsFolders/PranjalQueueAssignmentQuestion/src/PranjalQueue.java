
public class PranjalQueue {
	int queue[] = new int[5];
	int queuesize = 0;
	int front=0;
	int rear=0;
	

	public void enqueue(int pradata){
		try {
		queue[rear] = pradata;
		rear++;
		queuesize++;
		System.out.println("The element in Pranjal Queue is " + pradata);
		
	}
		catch(Exception queue) {
			System.out.println("Error due to Pranjal Queue Array Size. Please check your queue array size");
		}
	}
	public int dequeue() {
		int pradata = queue[front];
		front++;
		queuesize--;
		return pradata;
		//FYIO System.out.println("The data which is dequeued from Pranjal Queue is " + queue.dequeue());
	}
	public int size() {
		//System.out.println("The size of Pranjal Queue is " + queue.size()); check again
		return queue.length;
		
	}
	public boolean contains(int value)
		{
			for(int i=0;i<queue.length;i++)
			{
				if(queue[i]==value)
				{
					return true;
				}
			}
			return false;
		}	
	public int peek(){
		return queue[front];
	}
	
	public void clear() {
		if(queue[rear++]==0) {
			
		
		System.out.println("Everything on Pranjal Queue is clear. It doesn't contain anything");
		}
		else {
			System.out.println("Pranjal Queue is not clear. There are some elements");
			
		}
		//System.out.println("Checking element in Pranjal Queue " + queue.contains(9));
	}
	public void print() {
		int count=front;
		System.out.print("Data or Elements in Pranjal Queue is:");
		
		for(int i=0; i<queuesize; i++) {
			
			System.out.print(queue[count] + " ");
			count++;
			//queue.print()
		}
   }
   public void reversequeue() {
	   try {

		   System.out.println("");
		   for(int i=queuesize-1;i>=0;i--) {
			   System.out.println(queue[i]);
		   }
		   
	   }
	   catch(Exception e) {
	   System.out.println("Exception found please check your code size");
	   }
	   
	   
   }
   public void iterator(){
		try {
			for(int i=0; i<queuesize; i++) {
				int count=front++;
				System.out.println(" ");
				System.out.print("The iterated element in Pranjal Queue is " +queue[count] + " ");
				count++;
			}	
		}
		catch(Exception e) {
			System.out.println(" ");
			System.out.println("Please check your Queue size " + e);
		}
	}
   //front+i; up ln89
   
}