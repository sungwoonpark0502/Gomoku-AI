package com.example.omok;

import java.util.*;

public class AINode {
    
    private AI data;
    private AINode parentNode; // for some reason it could be used.
    private static ArrayList<AINode> children = new ArrayList<>();

    public AINode(AI value) {
        data = value;
        parentNode = null;
    }

    public AI getData() {
        return data;
    }

    public AINode getChild(int index) {
        return children.get(index);
    }

    public AINode removeChild(int index) {
        return children.remove(index);
    }

    public void removeAllChild(AINode x){
        if ( getChildren(x).size() == 0) return;

        for ( int i = 0 ; i < getChildren(x).size() ; i++) {
            removeAllChild(getChildren(x).get(i));
        }
        
        for ( int i = 0 ; i < getChildren(x).size() ; i++) {
            getChildren(x).remove(i);
        }
    }

    public void setParent(AINode parent) {
        parentNode = parent;
    }

    public static ArrayList<AINode> getChildren(AINode x) {
        return children;
    }

    public void putChildrenNode() {
        ArrayList<Pair> temp = AI.getMinMaxList();

    }
}

// AI min board min 