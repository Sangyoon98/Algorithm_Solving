class Solution {
    static boolean[] visited;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                k -= dungeons[i][1];
                
                dfs(k, dungeons, count + 1);
                
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}