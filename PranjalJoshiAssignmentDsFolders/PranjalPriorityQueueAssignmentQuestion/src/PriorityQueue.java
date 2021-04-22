public class PriorityQueue {
    public static void main(String[] args) {
        PriorityQueueOperations praq = new PriorityQueueOperations();
        praq.enqueue(12, 4);
        praq.enqueue(13, 2);
        praq.enqueue(1, 42);
        praq.enqueue(3, 22);
        praq.enqueue(23, 12);
        praq.enqueue(-1,-1);
        praq.iterator();
        
            }
}
