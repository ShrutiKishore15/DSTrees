package Trees;
import java.util.ArrayList;
import java.util.Arrays;
public class GenericTree <T> {
    T data;
    ArrayList<GenericTree<T>> children;

    public GenericTree(T data){
        this.data=data;
        children=new ArrayList<GenericTree<T>>();
    }
}
