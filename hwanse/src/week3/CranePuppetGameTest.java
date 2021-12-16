package week3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CranePuppetGameTest {

    @Test
    public void solution() throws Exception {
        // given
        CranePuppetGame sol = new CranePuppetGame();
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves = new int[] {1,5,3,5,1,2,1,4};

        // when & then
        assertEquals(4, sol.solution(board, moves));
    }

}