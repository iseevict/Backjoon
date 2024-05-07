package b11724;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] number = new boolean[1001];
    static Map<Integer, List<Integer>> map = new HashMap<>();

    static void count(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        number[start] = false;

        while (!que.isEmpty()) {
            int nn = que.poll();
            if (map.containsKey(nn)) {
                List<Integer> list = map.get(nn);
                for (int i : list) {
                    if (number[i]) {
                        number[i] = false;
                        que.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st2.nextToken());
            int right = Integer.parseInt(st2.nextToken());
            if (!number[left]) number[left] = true;
            if (!number[right]) number[right] = true;
            if (map.containsKey(left)) {
                map.get(left).add(right);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(right);
                map.put(left, list);
            }
            if (map.containsKey(right)) {
                map.get(right).add(left);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                map.put(right, list);
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!number[i]) {
                ans++;
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int left = entry.getKey();
            if (number[left]) {
                ans++;
                count(left);
            }
        }
        System.out.println(ans);
    }
}

