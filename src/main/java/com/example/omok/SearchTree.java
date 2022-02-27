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

            if (isWinCon(temp)) {
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

    public boolean isWinCon(AINode AItree) {
        boolean result = false;
        
        AI temp = AItree.getData();

        int xCord = AItree.getLastCord().x;
        int yCord = AItree.getLastCord().y;

        GameBoard tmpGameBoard = temp.getGameBoard();
        Stone[][] tempBoard = tmpGameBoard.getBoard();
        
        result = checkDiagonol(tempBoard, xCord, yCord) || checkStraight(tempBoard, xCord, yCord);

        return result;
    }

    public boolean checkStraight(Stone[][] board, int x, int y) {
        int count = 1;
        Stone checker = board[y][x];

        for ( int i = x - 1 ; x > 0 ; i-- ) {
            if ( checker.getColor() == board[y][i].getColor() ) count++;
            else break;
        }

        for ( int i = x ; x < board.length ; i++ ) {
            if ( checker.getColor() == board[y][i].getColor() ) count++;
            else break;
        }

        return count == 5;
    }

    public boolean checkDiagonol(Stone[][] board, int x, int y) {
        int count = 1;
        Stone checker = board[y][x];
        int j = x + 1;
        int k = y + 1;

        while ( j < board.length && k < board.length) {
            if (board[k][j].getColor() == checker.getColor()) {
                count++;
                k++;
                j++;
            }
            else break;
        }
        
        j = x - 1;
        k = y - 1;

        while ( j > 0 && k > 0) {
            if (board[k][j].getColor() == checker.getColor()) {
                count++;
                j--;
                k--;
            }
            else break;
        }

        return count == 5;
    }
}


