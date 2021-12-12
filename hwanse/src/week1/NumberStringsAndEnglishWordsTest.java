package week1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberStringsAndEnglishWordsTest {

    @Test
    public void solution() throws Exception {
        // given
        NumberStringsAndEnglishWords problem = new NumberStringsAndEnglishWords();

        // when & then
        assertEquals(1478, problem.solution("one4seveneight"));
        assertEquals(234567, problem.solution("23four5six7"));
        assertEquals(234567, problem.solution("2three45sixseven"));
        assertEquals(123, problem.solution("123"));
    }

}