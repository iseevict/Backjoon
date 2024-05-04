package b1931;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int count = 0;
        Map<Integer, List<Integer>> time = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (time.containsKey(end)) {
                time.get(end).add(start);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(start);
                time.put(end, list);
            }
        }

        int pre = 0;
        for (Map.Entry<Integer, List<Integer>> entry : time.entrySet()) {
            int end = entry.getKey();
            List<Integer> startTime = entry.getValue();
            Collections.sort(startTime);
            for (int start : startTime) {
                if (pre <= start) {
                    pre = end;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

