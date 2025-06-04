import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        int[] score = new int[301];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        score[1] = stairs[1];
        score[2] = stairs[1] + stairs[2];
        score[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++) {
            score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
        }

        System.out.print(score[N]);
    }
}