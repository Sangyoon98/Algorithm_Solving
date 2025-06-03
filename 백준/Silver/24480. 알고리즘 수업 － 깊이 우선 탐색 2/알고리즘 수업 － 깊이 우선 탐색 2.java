import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count = 1;
    static int[] node;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        node = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(node[i]);
        }
    }

    static void dfs(int start) {
        node[start] = count;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int newNode = graph.get(start).get(i);
            if (node[newNode] == 0) {
                count++;
                dfs(newNode);
            }
        }
    }
}