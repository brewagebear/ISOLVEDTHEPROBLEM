package week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TargetNumberTest {

    @Test
    public void solution() throws Exception {
        // given
        TargetNumber problem = new TargetNumber();

        // when & then
        assertEquals(5, problem.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

}