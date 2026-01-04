import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visit(N, r, c);
        System.out.println(answer);
    }

    static void visit(int n, int r, int c) {
        if (n == 0) return;

        int half = (int) Math.pow(2, n - 1);
        int area = half * half;

        if (r < half && c < half) {}
        else if (r < half && c >= half) {
            answer += area;
            visit(n - 1, r, c - half);
            return;
        } else if (r >= half && c < half) {
            answer += area * 2;
            visit(n - 1, r - half, c);
            return;
        } else {
            answer += area * 3;
            visit(n - 1, r - half, c - half);
            return;
        }

        visit(n - 1, r, c);
    }
}