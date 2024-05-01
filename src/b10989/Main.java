package b10989;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        List<Integer> arr = new ArrayList<>();
        int[] a = new int[10001];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(buf.readLine());
            if (a[temp] != 0) {
                a[temp]++;
            } else {
                arr.add(temp);
                a[temp]++;
            }
        }
        Collections.sort(arr);
        for (int i : arr) {
            int c = a[i];
            for (int j = 0; j < c; j++) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
