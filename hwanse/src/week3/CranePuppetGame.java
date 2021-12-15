package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CranePuppetGame {

    private static List<Stack<Integer>> board = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for (int y = 0; y < board.length; y++) {
            Stack<Integer> stack = new Stack<>();
            for (int x = board.length - 1; x >= 0; x--) {
                if (board[x][y] != 0) {
                    stack.push(board[x][y]);
                }
            }
            this.board.add(stack);
        }

        for (int i = 0; i < moves.length; i++) {
            Stack<Integer> stack = this.board.get(moves[i] - 1);

            if (!stack.isEmpty()) {
                int puppet = stack.pop();
                if (!bucket.isEmpty() && bucket.peek() == puppet) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(puppet);
                }
            }
        }


        return answer;
    }

}
