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
}
