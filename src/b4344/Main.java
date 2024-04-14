package b4344;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(buf.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int TotalScore = 0;
            int[] arr = new int[N];
            int count = 0;
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                TotalScore += temp;
                arr[j] = temp;
            }
            float avg = (float)TotalScore / N;
            for (int j = 0; j < N; j++) {
                if (arr[j] > avg) count++;
            }
            float late = (float)count / N * 100;
            System.out.println(String.format("%.3f", late) + "%");
        }
    }
}
