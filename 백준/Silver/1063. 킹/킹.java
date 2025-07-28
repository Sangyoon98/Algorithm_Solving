import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] x = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String king = st.nextToken();
        String stone = st.nextToken();
        int kingPosX = 0;
        int stonePosX = 0;
        for (int i = 0; i < 8; i++) {
            if (king.charAt(0) == x[i]) kingPosX = i;
            if (stone.charAt(0) == x[i]) stonePosX = i;
        }
        int kingPosY = king.charAt(1) - '0' - 1;
        int stonePosY = stone.charAt(1) - '0' - 1;

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int dx = 0, dy = 0;

            switch (command) {
                case "R": dx = 1; break;
                case "L": dx = -1; break;
                case "B": dy = -1; break;
                case "T": dy = 1; break;
                case "RT": dx = 1; dy = 1; break;
                case "LT": dx = -1; dy = 1; break;
                case "RB": dx = 1; dy = -1; break;
                case "LB": dx = -1; dy = -1; break;
            }

            int nextKingX = kingPosX + dx;
            int nextKingY = kingPosY + dy;

            if (nextKingX < 0 || nextKingX >= 8 || nextKingY < 0 || nextKingY >= 8) continue;

            if (nextKingX == stonePosX && nextKingY == stonePosY) {
                int nextStoneX = stonePosX + dx;
                int nextStoneY = stonePosY + dy;
                if (nextStoneX < 0 || nextStoneX >= 8 || nextStoneY < 0 || nextStoneY >= 8) continue;
                stonePosX = nextStoneX;
                stonePosY = nextStoneY;
            }

            kingPosX = nextKingX;
            kingPosY = nextKingY;
        }

        char kingResultX = 'A';
        char stoneResultX = 'A';
        for (int i = 0; i < 8; i++) {
            if (i == kingPosX) kingResultX = x[i];
            if (i == stonePosX) stoneResultX = x[i];
        }

        System.out.println(kingResultX + "" + (kingPosY + 1));
        System.out.println(stoneResultX + "" + (stonePosY + 1));
    }
}
