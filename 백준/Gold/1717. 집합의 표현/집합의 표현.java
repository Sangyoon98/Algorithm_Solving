import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 각 원소마다 부모를 저장하는 부모 배열
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                // union
                union(a, b);
            } else {
                // find
                if (find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    // 대표 원소 찾기
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);  // 경로 압축
        return parent[x];
    }

    // 두 집합 합치기
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}