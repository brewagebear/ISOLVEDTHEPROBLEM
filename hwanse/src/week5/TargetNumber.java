package week5;

public class TargetNumber {

    private static int target = 0;
    private static int count = 0;

    public int solution(int[] numbers, int target) {
        this.target = target;
        dfs(numbers, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(numbers, depth + 1, sum + numbers[depth]);
            dfs(numbers, depth + 1, sum - numbers[depth]);
        }
    }

}