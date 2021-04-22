public class LinkedList 
{
	static Node nodehead;
	
	public void insert(int data)
	{
		Node pranode = new Node();
		pranode.data = data;
		pranode.next = null;
		
		if(nodehead==null)
		{
			nodehead = pranode;
		}
		else
		{
			Node p = nodehead;
			while(p.next!=null)
			{
				p = p.next;
			}
			p.next =  pranode;
		}
		
	}
	public void insertAtHeadStart(int data)
	{
		Node pranode = new Node();
		pranode.data = data;
		pranode.next = null;
		pranode.next = nodehead;
		nodehead = pranode;
	}
	
	public void insertAtAnyPosition(int index,int data)
	{
		Node pranode = new Node();
		pranode.data = data;
		pranode.next = null;
		
		if(index==0)
		{
			insertAtHeadStart(data);
		}
		else{
		Node p = nodehead;
		for(int i=0;i<index-1;i++)
		{
			p = p.next;
		}
		pranode.next = p.next;
		p.next = pranode;
		}
	}
	public void center()
	{
		Node pranode = nodehead;
		Node ironode = nodehead;
		
		while(ironode != null && ironode.next != null)
		{
			pranode = pranode.next;
			ironode = pranode.next.next;
		}
		System.out.println("Center element of Pranjal Linked List is " +pranode.data);
	}
	
	public void deleteAtPosition(int index)
	{
		if(index==0)
		{
			nodehead = nodehead.next;
		}
		else
		{
			Node p = nodehead;
			Node my = null;
			for(int i=0;i<index-1;i++)
			{
				p = p.next;
			}
			my = p.next;
			p.next = my.next;
			my = null;
		}
	}
	
	public void show()
	{
		Node pranode = nodehead;
		
		while(pranode.next!=null)
		{
			System.out.println(pranode.data);
			pranode = pranode.next;
		}
		System.out.println(pranode.data);
	}
	public static void reverselinkedlist() {
		Node prev = null;
        Node current = nodehead;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        nodehead = prev;
         
        //return nodehead;
        //list.reverselinkedlist();
		//list.print();
        
	}
	public int size() {

		Node pratemp = nodehead;
		int count = 0;
		while (pratemp != null) {
			count++;
			pratemp = pratemp.next;
		}
		return count;
		//FMIO run System.out.println("Size of Pranjal Linked List is "+ list.size());
	}
	public void print() {
		try {
			//int a = 5/0;
		Node pratemp = nodehead;
		while(pratemp.next != null) {
			System.out.println(pratemp.data);
			pratemp=pratemp.next;
			}
			
		
		System.out.println(pratemp.data);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(int data) {
		Node p = nodehead;
		Node prevnode = null;
		while(p.data != data) {
			prevnode = p;
			p = p.next;
			}
		if(p==nodehead) {
			nodehead=nodehead.next;
	}
		else {
			prevnode.next=p.next;
		}
		
		
	}
	public void iterator() {
		try {
			
		Node pratemp = nodehead;
		while(pratemp.next != null) {
			
			pratemp=pratemp.next;
			System.out.println(pratemp);
			
			
			}
			
		
		//System.out.println(pratemp.data);
		pratemp.data++;
		}
		catch(Exception itterr) {
			System.out.println(itterr);
		}
}
}	
	
	
	
	
	
		


  
