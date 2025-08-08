class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        return Math.max(getMax(sticker, 0, sticker.length - 2), getMax(sticker, 1, sticker.length - 1));
    }
    
    int getMax(int[] sticker, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return sticker[start];
        
        int[] dp = new int[len];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);
        
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }
        
        return dp[len - 1];
    }
}