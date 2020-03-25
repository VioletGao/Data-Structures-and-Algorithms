class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean[] status = new boolean[nums.length];
        status[0] = true;
        
        for (int i = 0; i < status.length; i++) {
            int step = nums[i];
            for (int j = 1; j <= step; j++) {
                if (i + j < status.length) {
                    status[i+j] = status[i];
                }
                else {
                    continue;
                }
            }
        }
        return status[nums.length-1];
    }
}
