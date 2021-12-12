import org.junit.Test;
import java.util.*;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}

public class BFS {
    Node root;
    public void solution(Node root){
         Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         int L = 0;
         System.out.println(queue);
         while(!queue.isEmpty()){
             int len  = queue.size();
             System.out.println(L + ":");
             for (int i = 0; i < len; i++) {
                 Node cur = queue.poll();
                 System.out.println(cur.data+" ");
                 if(cur.lt!=null) queue.offer(cur.lt);
                 if(cur.rt!=null) queue.offer(cur.rt);

             }
             L++;
             System.out.println();
         }

    }


    @Test
    public void _test(){
        BFS tree = new BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt= new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.solution(tree.root);

    }
}
