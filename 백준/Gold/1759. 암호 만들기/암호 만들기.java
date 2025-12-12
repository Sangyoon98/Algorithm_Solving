import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0, 0, 0, new StringBuilder());
        System.out.println(sb);
    }

    public static void dfs(int index, int depth, int vowels, int consonants, StringBuilder key) {
        if (depth == L) {
            if (vowels >= 1 && consonants >= 2) sb.append(key).append("\n");
            return;
        }

        if (index >= C) return;

        key.append(arr[index]);

        if ("aeiou".indexOf(arr[index]) != -1) dfs(index + 1, depth + 1, vowels + 1, consonants, key);
        else dfs(index + 1, depth + 1, vowels, consonants + 1, key);

        key.deleteCharAt(key.length() - 1);
        dfs(index + 1, depth, vowels, consonants, key);
    }
}