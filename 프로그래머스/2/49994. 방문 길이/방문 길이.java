import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        int answer = 0;
        
        for (char c : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            if (c == 'U') ny++;
            else if (c == 'D') ny--;
            else if (c == 'R') nx++;
            else if (c == 'L') nx--;
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String path1 = x + " " + y + " " + nx + " " + ny;
            String path2 = nx + " " + ny + " " + x + " " + y;
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}