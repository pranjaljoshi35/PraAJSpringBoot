import java.util.concurrent.atomic.AtomicBoolean;

public class PriorityQueueOperations {
        Node prafront=null;
        Node prarear=null;

        public void enqueue(int data, int priority) {
            try {
            	Node newNode = new Node(data,priority);
                if(prafront==null || prafront.priority<priority){
                    newNode.next=prafront;
                    if(prafront==null)
                        prarear=newNode;
                    prafront=newNode;
                }
                else{
                    Node currentNode = prafront;
                    while(currentNode.next!=null && currentNode.next.priority>priority)
                        currentNode=currentNode.next;
                    newNode.next=currentNode.next;
                    currentNode.next=newNode;
                }
            }
            catch(Exception queueerr) {
            	System.out.println("Error has occured. Please check pranjal queue");
            	
            }
        }
        public void dequeue(){

            if(prafront==null){
                System.out.println("Queue is empty .Deletion is not possible");
                return;
            }
            Node current =prafront;
            prafront=prafront.next;
            if(prafront==null)
                prarear=null;
            current.next=null;
        }
        public void contains(int element){
            Node currentNode = prafront;
            AtomicBoolean flag= new AtomicBoolean(false);
            while(currentNode!=null){
                if(currentNode.pradata==element) {
                    flag.set(true);
                    break;
                }
                currentNode=currentNode.next;
            }
            if(flag.get()==true)
                System.out.println("Yes your data is present here in this queue. It contains ");
            else
                System.out.println("Element is not here. Please check qaagain you have entered correct value ");
        }
        public void size() {
            int count = 0;
            while (prafront != null) {
                count++;
                prafront = prafront.next;
            }
            System.out.println("The Size of Pranjal Queue is " + count);
        }
        
        
        public void reverse(){
            Node currentNode=prafront;
            Node forward = null;
            Node previous = null;
            while (currentNode!=null){
                forward = currentNode.next;
                currentNode.next = previous;
                previous=currentNode;
                currentNode=forward;
            }
            prafront = previous;
        }
        
        
        public  void print(){
            Node current = prafront;

            if(prafront==null){
                System.out.println(" Pranjal Priority Queue is empty. Please check your Queue Data And try again");
                return;
            }
            System.out.println("Pranjal Priority Queue nodes are");
            while (current!=null){
                System.out.println(current.pradata + " " + current.priority);
                current=current.next;
            }
            System.out.println();
        }
        public void peek(){
            if(prafront==null){
                System.out.println("Pranjal Priority Queue is empty. Please check again");
                return;
            }
            System.out.println("The Peek or top element of the Pranjal Priority Queue is " + prafront.pradata + " and the element's priority is " + prafront.priority);
        }
        public  void iterator(){
            Node current = prafront;

            if(prafront==null){
                System.out.println("Pranjal Priority Queue is cannot be iterated. ");
                return;
            }
            System.out.println("Pranjal Priority Queue nodes are");
            while (current!=null){
                System.out.println(current.pradata + " " + current.priority);
                current=current.next;
            }
            System.out.println();
        }
}
