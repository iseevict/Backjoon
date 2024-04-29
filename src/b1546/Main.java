package b1546;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int[] arr = new int[N];
        int max = -1;
        double sum = 0;
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            arr[i] = score;
            if (max < score) max = score;
        }
        for (int i = 0; i < N; i++) {
            double newScore = arr[i];
            newScore = newScore / (double)max * (double)100;
            sum += newScore;
        }
        System.out.println(sum / N);
    }
}
