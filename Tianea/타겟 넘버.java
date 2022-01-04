class Solution {
    public int binaryTreeSearch(int[] nums, int idx, int target,int value){
        if(idx == nums.length){
            if(value == target)
                return 1;
            else
                return 0;
        }
        
        return binaryTreeSearch(nums, idx+1, target, value+nums[idx]) + 
            binaryTreeSearch(nums, idx+1, target, value-nums[idx]);
    }
    
    
    public int solution(int[] numbers, int target) {
        return binaryTreeSearch(numbers, 0,target, 0);
    }
}