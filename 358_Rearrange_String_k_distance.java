class Solution {
    public String reorganizeString(String S, int k) {
        if (S == null || S.length() <= 1) return S;
        char[] s = S.toCharArray();
        int[] counts = new int[26];
        for (char c: s) {
            counts[c-'a'] ++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2)->n2[1]-n1[1]);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                pq.add(new int[] {i, counts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int count = k;
            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty() && count > 0) {
                int[] pair = pq.poll();
                list.add(new int[] { pair[0], pair[1]-1 });
                count --;
            }
            for (int[] l: list) {
                sb.append((char)(l[0]+'a'));
                if (l[1] > 0) {
                    pq.add(l);
                }
            }
            if (pq.isEmpty()) break;
            if (count > 0) return "";
        }
        return sb.toString();
    }
}