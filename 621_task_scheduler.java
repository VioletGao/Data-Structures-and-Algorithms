class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c-'A'] ++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2)->n2-n1);
        for (int i: freq) {
            if (i > 0) pq.add(i);
        }
        
        int res = 0;
        while (pq.size() > 0) {
            int k = n+1;
            Stack<Integer> s = new Stack<>();
            while (k > 0 && pq.size() > 0) {
                int mostFreq = pq.poll();
                if (mostFreq-1 > 0) {
                    s.push(mostFreq-1);    
                }
                res ++;
                k --;
            }

            while (!s.isEmpty()) {
                pq.add(s.pop());
            }
            if (pq.size() == 0) break;
            res += k;
        }
        return res;
    }
}
