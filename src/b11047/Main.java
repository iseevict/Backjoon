package b11047;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> cash = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(buf.readLine());
            cash.add(temp);
        }
        int sum = 0;
        int count = 0;
        while (!cash.isEmpty()) {
            int n = cash.poll();
            if (n + sum > K) continue;
            else {
                while (sum + n <= K) {
                    sum += n;
                    count++;
                }
            }
            if (sum == K) {
                break;
            }
        }
        System.out.println(count);
    }
}

