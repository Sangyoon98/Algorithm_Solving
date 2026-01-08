import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = 0;
    static int[] durability, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        durability = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int index) {
        if (index == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (durability[i] <= 0) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        // 현재 들 계란이 깨진 경우
        if (durability[index] <= 0) {
            dfs(index + 1);
            return;
        }

        // 안 깨진 다른 계란이 있는지 확인
        boolean target = false;
        for (int i = 0; i < N; i++) {
            if (i == index) continue;
            if (durability[i] > 0) {
                target = true;
                break;
            }
        }

        // 대상이 없으면 다음으로
        if (!target) {
            dfs(index + 1);
            return;
        }

        // 모든 타겟
        for (int i = 0; i < N; i++) {
            if (i == index) continue;
            if (durability[i] <= 0) continue;

            int oldIndex = durability[index];
            int oldI = durability[i];

            durability[index] -= weight[i];
            durability[i] -= weight[index];

            dfs(index + 1);

            durability[index] = oldIndex;
            durability[i] = oldI;
        }
    }
}