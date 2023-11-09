package Model;

public class Controller<T> {

    private Tree<T> tree;

    public Controller(Tree<T> tree) {
        this.tree = tree;
    }

    //Insert Data
    public void insertData(T data) {
        tree.setRoot(insertData(tree.getRoot(), data));
    }
    
    private TreeNode<T> insertData(TreeNode<T> node, T data) {
        if (node == null) {
            node = new TreeNode<>(data);
        } else if (data.hashCode() < node.getData().hashCode()) {
            node.setLeft(insertData(node.getLeft(), data));
        } else if (data.hashCode() > node.getData().hashCode()) {
            node.setRight(insertData(node.getRight(), data));
        }
        return node;
    }
    
    //LookUp Data
    public TreeNode<T> lookUp(T data){
        TreeNode<T> root = tree.getRoot();
        return lookUp(root, data);
    }
    
    private TreeNode<T> lookUp(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.equals(node.getData())) {
            return node;
        } else if (data.hashCode() < node.getData().hashCode()) {
            return lookUp(node.getLeft(), data);
        } else {
            return lookUp(node.getRight(), data);
        }
    }
    
    //Look Size
    public int treeSize(){
        TreeNode <T> root = tree.getRoot();
        return treeSize(root);
    }
    
    public int treeSize(TreeNode<T> node){
        if(node == null){
            return 0;
        }else if(node.left == null && node.getRight() == null){
            return 1;
        }else{
            return treeSize(node.left) + treeSize(node.right) + 1;
        }
    }
    
    //Pop Data
    public void pop(T data){
        TreeNode root = tree.getRoot();
        root = removeNode(root, data);
    }
    
    private TreeNode<T> removeNode(TreeNode<T> node, T data){
        if(node == null){
            return null;
        }
        if(data.equals(node.getData())){
            if(node.getLeft() == null && node.getRight() == null){
                return null;
            }
            if(node.getLeft() == null){
                return node.getRight();
            }
            if(node.getRight() == null){
                return node.getLeft();
            }
            TreeNode<T> successor = findMin(node.getRight());
            node.setData(successor.getData());
            node.setRight(removeNode(node.getRight(), successor.getData()));
        }else if(data.hashCode() < node.getData().hashCode()){
            node.setLeft(removeNode(node.getLeft(), data));
        }else{
            node.setRight(removeNode(node.getRight(), data));
        }
        return node;
    }
    
    //Find Min Data
    private  TreeNode<T> findMin(TreeNode<T> node){
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }
    
    
    //Traversals
    //PreOrder
    public void preOrder(){
        TreeNode<T> root = tree.getRoot();
        preOrder(root);
    }
    
    public void preOrder(TreeNode <T> node){
        if(node != null){
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    //Traversals 
    //InOrder
    public void inOrder(){
        TreeNode<T> root = tree.getRoot();
        inOrder(root);
    }
    
    public void inOrder(TreeNode <T> node){
        if(node  != null){
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }
    
    //Traversals
    //PostOrder
    public void postOrder(){
        TreeNode<T> root = tree.getRoot();
        postOrder(root);
    }
    public void postOrder(TreeNode<T> node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
            
        }
    }
}
