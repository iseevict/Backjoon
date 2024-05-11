package b7662;

import java.io.*;
import java.util.*;

public class Main {
    static int T, k;
    static Map<Integer, Integer> map = new HashMap<>();

    static int delete(Queue<Integer> q) {
        int r = 0;
        while (true) {
            r = q.poll();
            int temp = map.getOrDefault(r, 0);
            if (temp == 0) continue;

            if (temp == 1) map.remove(r);
            else {
                map.put(r, temp - 1);
            }
            break;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        Queue<Integer> lowQue = new PriorityQueue<>();
        Queue<Integer> highQue = new PriorityQueue<>(Collections.reverseOrder());
        while (T-- > 0) {
            k = Integer.parseInt(buf.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(buf.readLine());
                String s = st.nextToken();
                switch (s) {
                    case "I" :
                        int n1 = Integer.parseInt(st.nextToken());
                        lowQue.add(n1);
                        highQue.add(n1);
                        map.put(n1, map.getOrDefault(n1, 0) + 1);
                        break;
                    case "D" :
                        int n2 = Integer.parseInt(st.nextToken());
                        if (map.size() == 0) continue;
                        if (n2 == 1) {
                            delete(highQue);
                        }
                        else {
                            delete(lowQue);
                        }
                        break;
                }
            }
            if (map.size() == 0) {
                sb.append("EMPTY\n");
            }
            else {
                int tempN = delete(highQue);
                sb.append(tempN + " ");
                if (map.size() > 0) tempN = delete(lowQue);
                sb.append(tempN + "\n");
            }
            lowQue.clear();
            highQue.clear();
            map.clear();
        }

        System.out.println(sb);
    }
}


