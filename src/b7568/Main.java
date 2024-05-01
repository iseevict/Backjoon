package b7568;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        List<Map<Integer, Integer>> people = new ArrayList<>();
        int[] count = new int[N];
        Arrays.fill(count, 1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> entry = new HashMap<>();
            entry.put(x, y);
            people.add(entry);
        }
        for (int i = 0; i < N - 1; i++) {
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;
            for (Map.Entry<Integer, Integer> entry : people.get(i).entrySet()) {
                x1 = entry.getKey();
                y1 = entry.getValue();
            }
            for (int j = i + 1; j < N; j++) {
                for (Map.Entry<Integer, Integer> entry : people.get(j).entrySet()) {
                    x2 = entry.getKey();
                    y2 = entry.getValue();
                }
                if (x1 > x2 && y1 > y2) {
                    count[j]++;
                }
                else if (x1 < x2 && y1 < y2) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(count[i] + " ");
        }
        System.out.println(sb);
    }
}
