package com.example.omok;

import java.util.*;

public class AINode {
    
    private AI data;
    private static ArrayList<AINode> children = new ArrayList<>();
    private int depth;
    private static Pair lastCord;

    public AINode(AI value, int depth, Pair lastCord) {
        data = value;
        this.depth = depth;
        this.lastCord = lastCord;

        ArrayList<Pair> temp = AI.getMinMaxList();
        
        for ( Pair cord : temp ) {
            int xCord = cord.x;
            int yCord = cord.y;

            GameBoard newGameBoard = AI.getGameBoard();
            Stone tempStone = newGameBoard.fillBoard(yCord, xCord);
            AI tempAi = new AI(newGameBoard);
            tempAi.setResultBoard(tempStone);

            AINode child = new AINode(tempAi, this.depth + 1, cord);
            
            children.add(child);
        }
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

    public static Pair getLastCord() {
        return lastCord;
    }

    public static ArrayList<AINode> getChildren(AINode x) {
        return children;
    }
}

