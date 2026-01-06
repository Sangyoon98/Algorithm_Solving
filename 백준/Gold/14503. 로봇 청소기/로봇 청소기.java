import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            // 1. 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }

            // 2. 주변에 청소 안 된 칸 있는지 확인
            boolean hasUnclean = false;
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if (map[nextR][nextC] == 0) {
                    hasUnclean = true;
                    break;
                }
            }

            if (!hasUnclean) {
                int backR = r + dr[(d + 2) % 4];
                int backC = c + dc[(d + 2) % 4];
                // 2-1 후진 할 수 있는 경우
                if (map[backR][backC] != 1) {
                    r = backR;
                    c = backC;
                }
                // 2-2 후진 할 수 없는 경우
                else break;
            } else {
                // 3-1 90도 회전
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int frontR = r + dr[d];
                    int frontC = c + dc[d];
                    // 3-2 회전한 방향이 빈 칸인 경우 전진
                    if (map[frontR][frontC] == 0) {
                        r = frontR;
                        c = frontC;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}