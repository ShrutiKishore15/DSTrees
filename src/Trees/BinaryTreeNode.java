package Trees;

public class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    public BinaryTreeNode(){};

}
