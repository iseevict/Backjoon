package b1929;

import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] arr = new int[1000001];

    static boolean check(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr[1] = 1;
        for (int i = 2; i * i <= arr.length; i++) {
            if (arr[i] == 0) {
                if (check(i)) {
                    for (int j = 2; j * i < arr.length; j++) {
                        if (arr[j * i] == 0) {
                            arr[j * i] = 1;
                        }
                    }
                }
                else {
                    arr[i] = 1;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] == 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}

