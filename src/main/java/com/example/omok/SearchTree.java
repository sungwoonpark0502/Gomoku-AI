package com.example.omok;
import java.util.*;

public class SearchTree {
    
    public Queue<AINode> queue = new LinkedList<>();
    public ArrayList<AINode> path = new ArrayList<>();
    public ArrayList<AINode> visited = new ArrayList<>();
    
    public void bfs(AINode x) {
        if ( x == null) return;

        queue.add(x);

        while(!queue.isEmpty()) {
            AINode temp = queue.remove();
            ArrayList<AINode> tempChildren = AINode.getChildren(temp);

            if(temp != null) {
                for ( int i = 0 ; i < tempChildren.size() ; i++) {
                    if (tempChildren.get(i) != null) {
                        queue.add(tempChildren.get(i));
                        break;
                    }
                }
            }
         }
    }
    
    //몇수를 볼수있는지에 대한 리밋 걸거나, 프루닝 << 레퍼런스가 많을거란말이지  >3<
    public int valueCal() {
        
        int size = queue.size();
        int totalVal = 0;

        for ( int i = 0 ; i < size; i++){
            AINode temp = queue.remove();

            totalVal += temp.getData();

            queue.add(temp);
        }

        return totalVal;
    }


}
