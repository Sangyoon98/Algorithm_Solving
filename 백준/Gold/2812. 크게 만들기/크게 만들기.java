import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] num = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && K > 0 && deque.peekLast() < num[i]) {
                deque.pollLast();
                K--;
            }
            deque.addLast(num[i]);
        }

        while (K > 0) {
            deque.pollLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : deque) sb.append(c);
        System.out.println(sb);
    }
};