import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] alpha = new int[26][s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) alpha[j][i + 1] = alpha[j][i];
            alpha[s.charAt(i) - 'a'][i + 1]++;
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int answer = alpha[a][r + 1] - alpha[a][l];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}