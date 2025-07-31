import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}

public class Main {
    static int V, E, K;
    static List<Node>[] list;
    static int[] distance;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        distance = new int[V + 1];

        Arrays.fill(distance, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(K);

        for (int i = 1;  i <= V; i++) {
            if (distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int u) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        queue.add(new Node(u, 0));
        distance[u] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.v;

            if (check[current]) continue;
            check[current] = true;

            for (Node node : list[current]) {
                if (distance[node.v] > distance[current] + node.w) {
                    distance[node.v] = distance[current] + node.w;
                    queue.add(new Node(node.v, distance[node.v]));
                }
            }
        }
    }
}
