import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> path = new ArrayList();
    static String[] answer;
    static boolean finished = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        path.add("ICN");
        
        dfs("ICN", tickets, 0);
        return answer;
    }
    
    void dfs(String current, String[][] tickets, int count) {
        if (finished) return;
        
        if (count == tickets.length) {
            answer = path.toArray(new String[0]);
            finished = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}