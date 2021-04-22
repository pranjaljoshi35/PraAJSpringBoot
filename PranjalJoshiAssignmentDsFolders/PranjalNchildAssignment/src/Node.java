import java.util.ArrayList;
import java.util.List;

class Node {
    int key;
    List<Node> child;

    public Node(int key) {
        this.key = key;
        child = new ArrayList<>();
        //Node root = new Node(-1);
    }
}

class NAryTree {

    public boolean insert(Node root, int parent, int key) {

        try {
        	if (root.key == parent) {
                root.child.add(new Node(key));
                return true;
            }

            for (int i = 0; i < root.child.size(); i++) {
                if (root.child.get(i).key == parent) {
                    root.child.get(i).child.add(new Node(key));
                    return true;
                } else if (insert(root.child.get(i), parent, key))
                    return true;
            }
            
        }
        catch(Exception e) {
        	System.out.println("Error has occoured");
        }
        return false;
    }

    private static boolean delete(Node root, int key) {

        if (root == null)
            return false;

        if (root.key == key) {
            root = null;
            return true;
        }
        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == key) {
                root.child.set(i, null);
                return true;
            } else if (delete(root.child.get(i), key))
                return true;
        }
        return false;
    }

    
    public List<Node> getElementsByValue(Node root, int value) {
        if (root.key == value) 
        {
            return root.child;
        }

        for (int i = 0; i < root.child.size(); i++) {
            if (root.child.get(i).key == value)
                return root.child.get(i).child;
            List<Node> list = getElementsByValue(root.child.get(i), value);
            if (list != null) 
            {
                    return list;
            }
        }
        return null;
    }


    
    	
}
    
    
    	
 

