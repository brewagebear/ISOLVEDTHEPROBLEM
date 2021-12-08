import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] total = new int[n];

        Arrays.fill(total, 1);

        for(int i : reserve){
            total[i-1] = 2;
        }

        for(int i : lost){
            if(total[i-1] > 0)
                total[i-1]--;
        }

        for(int i = 0; i<total.length; i++){
            //체육복이 없으면 주변에서 서칭해서 가져오기
            if(total[i] == 0){
                if(i-1 >= 0 && total[i-1] == 2){
                    total[i-1]--;
                    total[i]++;
                }else if(i+1 < total.length && total[i+1] == 2){
                    total[i+1]--;
                    total[i]++;
                }
            }
        }

        return (int)Arrays.stream(total).filter(a->a>0).count();
    }
}