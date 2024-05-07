package b18870;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int[] ans = new int[N + 1];
        Map<Integer, List<Integer>> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (map.containsKey(n)) {
                map.get(n).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(n, list);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> tempList = entry.getValue();
            for (int i : tempList) {
                ans[i] = count;
            }
            count++;
        }
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}

