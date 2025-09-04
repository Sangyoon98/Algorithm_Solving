import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] name = br.readLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : name) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) oddCount++;
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        char middle = 0;
        for (char c : keys) {
            int count = map.get(c);
            for (int i = 0; i < count / 2; i++) sb.append(c);
            if (count % 2 == 1) middle = c;
        }

        StringBuilder answer = new StringBuilder();
        answer.append(sb);
        if (middle != 0) answer.append(middle);
        answer.append(sb.reverse());
        System.out.println(answer);
    }
}