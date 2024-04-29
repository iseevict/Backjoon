package b1920;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(buf.readLine());
        StringTokenizer st2 = new StringTokenizer(buf.readLine());
        for (int i = 0; i < M; i++) {
            int check = 0;
            int left = 0;
            int right = N;
            int findNum = Integer.parseInt(st2.nextToken());
            while (left < right) {
                int mid = (left + right) / 2;
                if (A[mid] == findNum) {
                    sb.append("1\n");
                    check = 1;
                    break;
                }

                if(A[mid] > findNum) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            if (check == 0) {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
