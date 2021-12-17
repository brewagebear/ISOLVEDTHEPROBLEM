package week3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Float> map = new LinkedHashMap<Integer, Float>();

        for (int i = 0; i < N; i++) {
            int challengeNo = i + 1;
            int failCount = 0;
            int challengerCount = 0;

            for (int j = 0; j < stages.length; j++) {
                if (challengeNo <= stages[j]) {
                    challengerCount++;

                    if (challengeNo >= stages[j]) {
                        failCount++;
                    }
                }
            }

            float failRate = (failCount * 1.0f) / challengerCount;
            map.put(challengeNo, failRate);
        }

        List<Map.Entry<Integer, Float>> sortedList = sortByValue(map);
        for (int i = 0; i < sortedList.size(); i++) {
            answer[i] = sortedList.get(i).getKey();
        }

        return answer;
    }

    private List<Map.Entry<Integer, Float>> sortByValue(Map<Integer, Float> map) {
        List<Map.Entry<Integer, Float>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return entries;
    }

}
