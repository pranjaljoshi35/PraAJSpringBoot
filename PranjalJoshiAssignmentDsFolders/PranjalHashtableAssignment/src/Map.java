import java.util.ArrayList;

class MyHashNode<K, V> {
    K key;
    V value;

    MyHashNode<K, V> next;

    public MyHashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class Map<K, V> {
    ArrayList<MyHashNode<K, V>> array;
    int capacity, size;

    public Map() {
        array = new ArrayList<>();
        capacity = 13;
        size = 0;
        for (int i = 0; i < capacity; i++)
            array.add(null);
    }

    int size() {
        return size;
    }
    ////FMIO System.out.println("The Size of Pranjal Hash table is" +  map.size());

    int getIndexForKey(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
        return index < 0 ? index * -1 : index;
    }

    void insert(K key, V value) {
        int index = getIndexForKey(key);

        MyHashNode<K, V> head = array.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;

        head = array.get(index);

        MyHashNode<K, V> node = new MyHashNode<>(key, value);

        node.next = head;

        array.set(index, node);

        //increasing the size
        if ((1.0 * size) / capacity >= 1.0) {
            ArrayList<MyHashNode<K, V>> temp = array;
            array = new ArrayList<>();
            capacity *= 2;
            size = 0;

            for (int i = 0; i < capacity; i++) array.add(null);

            for (MyHashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    insert(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
               
            }
        }
        
    }

    V getValueByKey(K key) {
        int index = getIndexForKey(key);

        MyHashNode<K, V> head = array.get(index);

        while (head != null) {
            if (head.key.equals(key)) return head.value;
        }
        return null;
    }
    //FMIO System.out.println("The VALUE of Pranjal Hash table is " +  map.getValueByKey(2));

    void delete(K key) {
        try {
            int index = getIndexForKey(key);

            MyHashNode<K, V> head = array.get(index);

            MyHashNode<K, V> prev = null;

            while (head != null) {
                if (head.key.equals(key)) {
                    if(prev == null) {
                        array.set(index, head.next);
                        size--;
                    } else {
                        prev.next = head.next;
                        size--;
                    }
                    break;
                }
                prev = head;
                head = head.next;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    

    boolean contains(K key) {
        int index = getIndexForKey(key);

        MyHashNode<K, V> head = array.get(index);

        while (head != null)
            if (head.key.equals(key)) 
            	return true;

        return false;
    }
    public void print(){
    	MyHashNode  obj = new MyHashNode(2, 3);
    	MyHashNode  obj1 = new MyHashNode(1, 5);
    	MyHashNode  obj2 = new MyHashNode(5, -1);
    	MyHashNode  obj3 = new MyHashNode(-99,23);
    	MyHashNode  obj4 = new MyHashNode(4,5);
    	
    
    	
    	
    	for(int i=0;i<=size();i++) {
    		
    		System.out.println("The Key Of Pranjal Hash table is " + obj.key + ". The Value of Pranjal Hash Table is " +  obj.value);
    		System.out.println("The Key Of Pranjal Hash table is " + obj1.key + ". The Value of Pranjal Hash Table is " +  obj1.value);
    		System.out.println("The Key Of Pranjal Hash table is " + obj2.key + ". The Value of Pranjal Hash Table is " +  obj2.value);
    		System.out.println("The Key Of Pranjal Hash table is " + obj3.key + ". The Value of Pranjal Hash Table is " +  obj3.value);
    		System.out.println("The Key Of Pranjal Hash table is " + obj4.key + ". The Value of Pranjal Hash Table is " +  obj4.value);
    		break;
    	}
    	
        		
        
    	
    }
}

    
    
    
