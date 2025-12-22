import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> tab = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (tab.contains(arr[i])) continue;
            if (tab.size() < N) {
                tab.add(arr[i]);
                continue;
            }

            int remove = -1;
            int late = -1;

            for (int j = 0; j < tab.size(); j++) {
                int next = Integer.MAX_VALUE;

                for (int k = i + 1; k < K; k++) {
                    if (arr[k] == tab.get(j)) {
                        next = k;
                        break;
                    }
                }

                if (next == Integer.MAX_VALUE) {
                    remove = j;
                    break;
                }

                if (next > late) {
                    late = next;
                    remove = j;
                }
            }

            tab.remove(remove);
            tab.add(arr[i]);
            count++;
        }

        System.out.println(count);
    }
}