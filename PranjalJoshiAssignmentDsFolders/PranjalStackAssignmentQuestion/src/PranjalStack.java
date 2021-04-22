
public class PranjalStack 
{
	int Prastack[] = new int[5];
	int Stacktop = 0;
	int count = Stacktop;
	
	public void push(int data) {
		try
		{
			Prastack[Stacktop] = data;
			Stacktop++;
			System.out.println(data);
			
		}
		catch(Exception e) {
			System.out.println("Prastack is Full");
			System.out.print(e);
		}
	}
	
	public int pop() {
		int data=0;
		if(clear())
		{
			System.out.println("Prastack is not completely filled it is EMPTY");
		}
		else {
			Stacktop--;
			data=Prastack[Stacktop];
			Prastack[Stacktop]=0;
			}
		    return data;
		    //FYIO System.out.println("Item popped out of Prastack is " + stack.pop());
			//System.out.println("Item popped out of Prastack is " + stack.pop());
		    }

	public boolean clear() {
		return Stacktop<=0;
	}
	
	public boolean contains(int value)
	{
		for(int i=0;i<Prastack.length;i++)
		{
			if(Prastack[i]==value)
			{
				return true;
			}
		}
		return false;
	}
	
	public int peek() {
		int data=Prastack[Stacktop-1];
		return data;
		}
	public int size() {
		return Stacktop;
	}
	//ask sachin
	
	public void print() {
		try {
	    for (int i=0;i<=Stacktop-1;i++) {
	      System.out.print(Prastack[i] + ", ");
	    }
		}
		catch(Exception err) {
			System.out.println("Stack is completely filled AND THE ERROR IS" +  err);
			
		}
	  }
	public void reverse() {
		System.out.println("Prastack in reverse order is  ");
		for( int i=Stacktop-1;i>=0;i--) {
			System.out.print(Prastack[i] + " ");
		}
		
	}
	public void iterator(){
		try {
			for (int i=0;i<=Stacktop-1;i++) {
			      System.out.print(Prastack[i+1] + ", ");
                  
			    }
		}
		catch(Exception e) {
			System.out.println(" ");
			System.out.println("Please check your array size " + e);
		}
	}
}
