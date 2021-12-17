package week3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FailureRateTest {

    @Test
    public void solution() throws Exception {
        // given
        FailureRate sol = new FailureRate();

        // when & then
        assertArrayEquals(new int[]{3,4,2,1,5}, sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

}