class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][] {};
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int[] interval: intervals) {
            int[] last = list.get(list.size()-1);
            if (interval[0] > last[1]) {
                list.add(interval);
            } else {
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}