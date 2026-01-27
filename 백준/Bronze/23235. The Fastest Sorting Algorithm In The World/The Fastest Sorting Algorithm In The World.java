import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =  Integer.parseInt(st.nextToken());
            if (N == 0) break;
            sb.append("Case ").append(index++).append(": Sorting... done!").append("\n");
        }

        System.out.println(sb);
    }
}