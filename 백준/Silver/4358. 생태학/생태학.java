import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int total = 0;

        String line;
        while ((line = br.readLine()) != null) {
            total++;
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        for (String tree : sortedMap.keySet()) {
           double per = sortedMap.get(tree) * 100.0 / total;
           System.out.printf("%s %.4f\n", tree, per);
        }
    }
}