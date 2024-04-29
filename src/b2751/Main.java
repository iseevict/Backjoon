package b2751;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(buf.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
