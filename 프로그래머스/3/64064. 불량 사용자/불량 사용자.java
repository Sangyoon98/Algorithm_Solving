import java.util.*;

class Solution {
    Set<String> results = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, new ArrayList<>(), visited);
        return results.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int idx, List<String> selected, boolean[] visited) {
        if (idx == banned_id.length) {
            List<String> sorted = new ArrayList<>(selected);
            Collections.sort(sorted);
            results.add(String.join(",", sorted));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (match(user_id[i], banned_id[idx])) {
                visited[i] = true;
                selected.add(user_id[i]);
                
                dfs(user_id, banned_id, idx + 1, selected, visited);
                
                visited[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }
    
    private boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}