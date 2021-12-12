import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int totalPeaple = 0;
        
        Map<Integer, Double> map = new HashMap<>();
       
        //stages 오름차순으로 정렬
        Arrays.sort(stages);
        Integer i=0;
        for(i = 1; i<=N; i++){
            final int n = i;
            long mo = Arrays.stream(stages).filter((num) -> num >= n).count();
                
            long ja = Arrays.stream(stages).filter((num) -> num == n).count();
        
            double temp = (mo != 0)? (double)ja/mo : 0;
            
            map.put(n,temp);
        }
        
        
        System.out.println(map);
        
        return map.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
            .mapToInt(a->a.getKey()).toArray();
    }
}