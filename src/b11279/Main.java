package b11279;

import java.io.*;
import java.util.*;

public class Main {
    static int N, x;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(buf.readLine());
            switch (x) {
                case 0:
                    if (que.isEmpty()) {
                        sb.append("0\n");
                    }
                    else {
                        int temp = que.poll();
                        sb.append(temp + "\n");
                    }
                    break;
                default:
                    que.add(x);
                    break;
            }
        }
        System.out.println(sb);
    }
}

