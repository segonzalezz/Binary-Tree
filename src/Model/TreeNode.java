package Model;

public class TreeNode <thing> {
    
    thing data;
    TreeNode<thing> left, right;
    
    public TreeNode(thing data){
        this.data = data;
        this.left = this.right = null;
    }

    public thing getData() {
        return data;
    }

    public void setData(thing data) {
        this.data = data;
    }
    

    public TreeNode<thing> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<thing> left) {
        this.left = left;
    }

    public TreeNode<thing> getRight() {
        return right;
    }

    public void setRight(TreeNode<thing> right) {
        this.right = right;
    }
    
    public void printlnData(){
        System.out.println(this.data);
    }
}
