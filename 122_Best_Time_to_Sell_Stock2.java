    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        int start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] <= prices[i]) {
                res += (i == prices.length-1) ? prices[i] - prices[start] : 0;
            } else {
                res += prices[i-1] - prices[start];
                start = i;
            }
        }
        return res;
    }
