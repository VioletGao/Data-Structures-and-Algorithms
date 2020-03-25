class Solution {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            for (int j = 1; j <= step; j ++) {
                if (i + j < nums.length) {
                    steps[i+j] = steps[i+j] == 0 ? steps[i]+1 : Math.min(steps[i+j], steps[i]+1);
                }
            }
        }
            
        return steps[steps.length-1];
    }
}
