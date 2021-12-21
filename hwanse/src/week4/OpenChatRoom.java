package week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {

    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();

        for (String str : record) {
            if (!str.contains("Leave")) {
                String[] tokens = str.split(" ");
                nickname.put(tokens[1], tokens[2]);
            }
        }

        for (String str : record) {
            String[] tokens = str.split(" ");

            String action = tokens[0];
            String id = tokens[1];
            String formatPattern = "%s님이 %s";
            if ("Enter".equals(action)) {
                result.add(String.format(formatPattern, nickname.get(id), "들어왔습니다."));
            }
            if ("Leave".equals(action)){
                result.add(String.format(formatPattern, nickname.get(id), "나갔습니다."));
            }
        }

        return result.toArray(new String[result.size()]);
    }

}
