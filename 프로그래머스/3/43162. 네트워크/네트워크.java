class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                count++;
            }
        }
            
        return count;
    }
    
    public void dfs(int start, int n, int[][] computers, boolean[] visited) {
        visited[start] = true;
        
        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[i]) dfs(i, n, computers, visited);
        }
    }
}