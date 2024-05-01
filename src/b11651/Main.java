package b11651;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        Map<Integer, List<Integer>> pos = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (pos.containsKey(y)) {
                pos.get(y).add(x);
            }
            else {
                List<Integer> arr = new ArrayList<>();
                arr.add(x);
                pos.put(y, arr);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : pos.entrySet()) {
            List<Integer> temp = entry.getValue();
            Collections.sort(temp);
            int len = temp.size();
            int x = entry.getKey();
            for (int i = 0; i < len; i++) {
                sb.append(temp.get(i) + " " + x + "\n");
            }
        }
        System.out.println(sb);
    }
}
