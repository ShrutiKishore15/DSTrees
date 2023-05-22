package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeUse {

    public static void printTree(GenericTree<Integer> root){
        if(root==null){
            return;
        }

        System.out.print(root.data+": ");
        for(int i=0; i<root.children.size(); i++){
            System.out.print(root.children.get(i).data+" ");
        }
        System.out.println();
        for(int i=0; i<root.children.size(); i++){
           printTree(root.children.get(i));
        }
    }
    public static void printLevelWise(GenericTree<Integer> root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        Queue<GenericTree<Integer>> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            GenericTree<Integer> parent=q.remove();
            for(int i=0; i<parent.children.size(); i++){
                System.out.print(parent.children.get(i).data+" ");
                q.add(parent.children.get(i));
            }
            System.out.println();
        }

    }
    public static GenericTree<Integer> InputTree(){
        int rootData;
        System.out.println("Enter root data: ");
        Scanner s=new Scanner(System.in);
        rootData=s.nextInt();
        GenericTree<Integer> root= new GenericTree<>(rootData);
        Queue<GenericTree<Integer>> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            GenericTree<Integer> parent=q.remove();
            System.out.println("Enter num of children of "+ parent.data+": ");
            int numChild=s.nextInt();
            for(int i=0; i<numChild; i++){
                System.out.println("Enter data for child "+ i +": ");
                int childData=s.nextInt();
                GenericTree<Integer> child= new GenericTree<>(childData);
                parent.children.add(child);
                q.add(child);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        GenericTree<Integer> root=InputTree();
        printLevelWise(root);
    }
}
