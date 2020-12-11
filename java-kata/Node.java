
public class Node {

    private String data;
    private Node left;
    private Node right;
    
    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public String getData() {
        return data;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    public void updateValues(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
