import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        //user uid, nickname
        Map<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        String[] cmd;
        
        for(String s : record){
            cmd = s.split(" ");
            int idx = 0;
            switch (cmd[0]) {
                case "Enter":
                    map.put(cmd[1], cmd[2]);
                    answer.add( cmd[1]+ "//님이 들어왔습니다.");
                    break;
                case "Change":
                    map.put(cmd[1], cmd[2]);
                    break;

                case "Leave":
                    answer.add(cmd[1] + "//님이 나갔습니다.");
                    break;

            }
        }

        String[] ans = new String[answer.size()];
        
        for(int i = 0; i<answer.size(); i++){
            String[] ss = answer.get(i).split("//");
            ans[i]  = map.get(ss[0]) + ss[1];
        }
        return ans;

    }
}