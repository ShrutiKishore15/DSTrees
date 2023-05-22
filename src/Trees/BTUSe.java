package Trees;
import java.util.Scanner;
import java.lang.Math;
import java.util.LinkedList;
import  java.util.Queue;
public class BTUSe {

    public static BinaryTreeNode<Integer> treeInput(boolean isRoot, int parent, boolean isLeft){

        Scanner s=new Scanner(System.in);
        int data;
        if(isRoot){
            System.out.println("Enter the root data: ");
            data=s.nextInt();
        }else if(isLeft){
            System.out.println("Enter the left child of "+ parent+": ");
            data=s.nextInt();
        }else{
            System.out.println("Enter the right child of "+ parent+": ");
            data=s.nextInt();
        }
        if(data==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
        root.left=treeInput(false, data, true);
        root.right=treeInput(false, data, false);

        return root;
    }

    public static BinaryTreeNode<Integer> treeInputLevelwise(){
        Queue<BinaryTreeNode<Integer>> Q=new LinkedList<>();
        System.out.println("Enter root data: ");
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        if(data==-1){
            return null;
        }
        BinaryTreeNode<Integer> root= new BinaryTreeNode<>(data);
        Q.add(root);
        while(!Q.isEmpty()){
            BinaryTreeNode<Integer> parentNode= Q.remove();
            System.out.println("Enter the left child of "+ parentNode.data+": ");
            data=s.nextInt();
            if(data!=-1){
                BinaryTreeNode<Integer> newNodeLeft=new BinaryTreeNode<>(data);
                parentNode.left=newNodeLeft;
                Q.add(newNodeLeft);
            }
            System.out.println("Enter the right child of "+ parentNode.data+": ");
            data= s.nextInt();
            if(data!=-1) {
                BinaryTreeNode<Integer> newNodeRight = new BinaryTreeNode<>(data);
                parentNode.right = newNodeRight;
                Q.add(newNodeRight);
            }
        }
        return root;
    }
    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data+": ");
        if(root.left!=null){
            System.out.print("L->"+root.left.data);
        }
        if(root.right!=null){
            System.out.print(" R->"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> Q=new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            BinaryTreeNode<Integer> printNode=Q.remove();
            System.out.print(printNode.data+":");
            if(printNode.left!=null){
                Q.add(printNode.left);
                System.out.print("L:"+printNode.left.data+",");
            }else{
                System.out.print("L:-1,");
            }
            if(printNode.right!=null) {
                Q.add(printNode.right);
                System.out.print("R:"+printNode.right.data);
            }else{
                System.out.print("R:-1");
            }
            System.out.println();
        }
    }
    public static int heightOfTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int heightLeft= heightOfTree(root.left)+1;
        int heightRight=heightOfTree(root.right)+1;
        return Math.max(heightLeft, heightRight);
    }
    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return null;
        }
        root.left=removeLeaf(root.left);
        root.right=removeLeaf(root.right);
        return root;
    }
    public static boolean checkBalanced(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int heightLeft=heightOfTree(root.left);
        int heightRight=heightOfTree(root.right);
        int balanced=Math.abs(heightLeft-heightRight);
        if(balanced>1){
            return false;
        }
        boolean isLeftBalanced=checkBalanced(root.left);
        boolean isRightBalanced=checkBalanced(root.right);
        return isLeftBalanced && isRightBalanced;

    }
    public static BalancedTree checkBalancedBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            BalancedTree ans= new BalancedTree(0, true);
            return ans;
        }
        BalancedTree leftOutput= checkBalancedBetter(root.left);
        BalancedTree rightOutput=checkBalancedBetter(root.right);
        int height=1+Math.max(leftOutput.height, rightOutput.height);
        boolean balanced=true;
        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            balanced=false;
        }
        if(!leftOutput.isBalanced && !rightOutput.isBalanced){
            balanced=false;
        }
        BalancedTree ans=new BalancedTree(height, balanced);
        return ans;
    }

    public static DiameterTree diameterOfTree(BinaryTreeNode<Integer> root){
        if(root==null){
            DiameterTree ans=new DiameterTree(0, 0);
            return ans;
        }
        DiameterTree leftOutput=diameterOfTree(root.left);
        DiameterTree rightOutput=diameterOfTree(root.right);
        int height=Math.max(leftOutput.height, rightOutput.height)+1;
        int totalDiameter=leftOutput.height+rightOutput.height+1;
        int leftDiameter=1+leftOutput.diameter;
        int rightDiameter=1+rightOutput.diameter;
        int finalDiameter=Math.max(Math.max(totalDiameter, leftDiameter), rightDiameter);
        DiameterTree ans=new DiameterTree(height, finalDiameter);
        return ans;
    }
    public static void main(String[] args) {
        //BinaryTreeNode<Integer> root=treeInput(true, 0, true);
        BinaryTreeNode<Integer> root=treeInputLevelwise();
        printLevelWise(root);
        System.out.println();
        //System.out.println(heightOfTree(root));
        //System.out.println(checkBalancedBetter(root).isBalanced);
//        root=removeLeaf(root);
//        System.out.println();
//        printTreeDetailed(root);
        System.out.println(diameterOfTree(root).diameter);
    }

}
