class Solution {
    public int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int lcm(int a,int b){
        return a * b / gcd(a,b);
    }
    
    public int solution(int[] arr) {
        int answer = 1;
        for(int num: arr){
            answer = lcm(answer, num);
        }
        return answer;
    }
}