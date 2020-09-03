package component;

public class BinaryTree {
    Node root;

    public BinaryTree() {}

    private Node addRecursive(Node current, int value) {
        if (current == null)            // case base
            return new Node(value);

        if (root.value > value)       // recursive steps
            current.left = addRecursive(current.left, value);

        else if(root.value < value)
            current.right = addRecursive(current.right, value);

        else
            return current;

        return current;
    }

    public void add(int value) {
        this.root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)    // if value < current.value is true
                : containsNodeRecursive(current.right, value);  // if value < current.value is false
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if(current == null)
            return null;

        if(value == current.value)
            // code to delete the node
            /*
            * 3 main cases:
            * 1 -> node has no children
            * 2 -> node has exactly one child
            * 3 -> node has 2 children
            * */
            if(current.right == null && current.left == null)
                return null;

            if(current.right == null)
                return current.left;

            if(current.left == null)
                return current.right;

            if(current.right != null && current.left != null) {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, value);
                return current;
            }

        if(value > current.value) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }

        current.left = deleteRecursive(current.left, value);
        return current;

    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

}
