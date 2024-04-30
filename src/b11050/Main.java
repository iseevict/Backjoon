package b11050;

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
        int left = 1;
        int right = 1;

        if (K > N - K) { // nCk -> n - k보다 k가 크면 괜히 계산이 더 들어가서 바꿔줌
            K = N - K;
        }

        for (int i = 1; i <= K; i++) { // K! 구하기
            right *= i;
        }

        for (int i = N; i > N - K; i--) { // N! 나누기 (N - K)! 구하기
            left *= i;
        }

        sb.append(left / right);
        System.out.println(sb);
    }
}
