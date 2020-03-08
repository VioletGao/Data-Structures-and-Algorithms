class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int num: nums) {
            if (set.contains(num)) continue;
            queue.add(num);
            if (queue.size() > 3) {
                queue.poll();
            }
        }
        if (queue.size() < 3) {
            int res = queue.poll();
            while (queue.size() > 0) {
                res = queue.poll();
            }
            return res;
        }
        
        return queue.poll();
    }
}
