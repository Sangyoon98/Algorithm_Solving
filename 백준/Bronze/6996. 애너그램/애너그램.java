import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            String A = st.nextToken();
            String B = st.nextToken();
            String[] arrA = A.split("");
            String[] arrB = B.split("");

            for (String s : arrA) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (String s : arrB) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            boolean isAnagram = true;

            for (int v : map.values()) {
                if (v % 2 != 0) {
                    isAnagram = false;
                    break;
                }
            }

            sb.append(A)
                    .append(" & ")
                    .append(B)
                    .append(" are ")
                    .append(isAnagram ? "" : "NOT ")
                    .append("anagrams.")
                    .append("\n");
        }

        System.out.print(sb);
    }
}
