package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceNotFinishedPlayerTest {

    @Test
    public void solution() throws Exception {
        // given
        RaceNotFinishedPlayer problem = new RaceNotFinishedPlayer();

        // when & then
        assertEquals("leo", problem.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        assertEquals("vinko", problem.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        assertEquals("mislav", problem.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));

    }

}