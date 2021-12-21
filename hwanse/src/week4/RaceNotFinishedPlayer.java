package week4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RaceNotFinishedPlayer {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i < participant.length; i++) {
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for(int i=0; i < completion.length; i++) {
            String name = completion[i];
            map.put(name, map.get(name)-1);
        }

        Set<String> set = map.keySet();
        Iterator<String> keys = set.iterator();
        while(keys.hasNext()) {
            String name = keys.next();
            if(map.get(name) > 0) {
                answer = name;
                break;
            }
        }

        return answer;
    }

}
