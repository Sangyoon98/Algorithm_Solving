import java.io.*;
import java.util.*;

public class Main {
    public static class Number {
        int value;
        int count;
        int order;

        public Number(int value, int count, int order) {
            this.value = value;
            this.count = count;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Number> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int index = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (map.containsKey(num)) map.get(num).count++;
            else map.put(num, new Number(num, 1, index++));
        }

        ArrayList<Number> list = new ArrayList<>(map.values());

        list.sort((a, b) -> {
            if (a.count != b.count) return b.count - a.count;
            return a.order - b.order;
        });

        StringBuilder sb = new StringBuilder();
        for (Number n : list) {
            for (int i = 0; i < n.count; i++) sb.append(n.value).append(" ");
        }

        System.out.println(sb);
    }
}