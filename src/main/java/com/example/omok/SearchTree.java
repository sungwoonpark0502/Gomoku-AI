package com.example.omok;
import java.util.*;

public class SearchTree {
    
    public Queue<AINode> queue = new LinkedList<>();
    public ArrayList<AINode> path = new ArrayList<>();
    public ArrayList<AINode> visited = new ArrayList<>();
    
    public ArrayList<AINode> bfs(AINode x) {
        if ( x == null) return null;

        queue.add(x);

        while(!queue.isEmpty()) {
            AINode temp = queue.remove();
            ArrayList<AINode> tempChildren = AINode.getChildren(temp);

            if (WinCon.isWinCon(temp)) {
                return path;
            }

            if (visited.contains(temp)) continue;

            visited.add(temp);

            if(temp != null) {
                for ( int i = 0 ; i < tempChildren.size() ; i++) {
                    if (tempChildren.get(i) != null) {
                        queue.add(tempChildren.get(i));
                        path.add(tempChildren.get(i));
                    }
                }
            }
         }
         return null;
    }
}


