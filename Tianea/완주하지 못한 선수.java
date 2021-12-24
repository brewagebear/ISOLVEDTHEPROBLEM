import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        List<String> list = Arrays.stream(completion).sorted().collect(Collectors.toList());
        
        for(String s : participant){
            int find = Collections.binarySearch(list, s);
            if(find < 0){
                return s;
            }
            list.remove(find);
        }

        return answer;
    }
}