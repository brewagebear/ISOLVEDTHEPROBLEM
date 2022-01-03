package week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CorrectParenthesisTest {

    @Test
    public void solution() throws Exception {
        // given
        CorrectParenthesis problem = new CorrectParenthesis();

        // when & then
        assertEquals(true, problem.solution("()()"	));
        assertEquals(true, problem.solution("(())()"));
        assertEquals(false, problem.solution(")()("));
        assertEquals(false, problem.solution("(()("));
    }

}