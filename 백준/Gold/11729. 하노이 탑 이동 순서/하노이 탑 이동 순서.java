import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = (int) (Math.pow(2, n) - 1);
        sb.append(count).append("\n");
        hanoi(n, 1, 2, 3);
        System.out.print(sb);
    }

    static void hanoi(int n, int from, int via, int to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, from, to);
    }
}