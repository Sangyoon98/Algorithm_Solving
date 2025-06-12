import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) map.remove(arr[start]);
                start++;
            }

            length = Math.max(length, end - start + 1);
        }

        System.out.print(length);
    }
}