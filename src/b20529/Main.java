package b20529;

import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            String[] mbti = new String[100001];
            int sum = 100;
            N = Integer.parseInt(buf.readLine());
            StringTokenizer st = new StringTokenizer(buf.readLine());
            for (int i = 1; i <= N; i++) {
                mbti[i] = st.nextToken();
            }
            if (N > 32) {
                sb.append("0\n");
            }
            else {
                for (int i = 1; i <= N - 2; i++) {
                    for (int j = i + 1; j <= N - 1; j++) {
                        for (int k = j + 1; k <= N; k++) {
                            int tempSum = 0;
                            String A = mbti[i];
                            String B = mbti[j];
                            String C = mbti[k];
                            for (int m = 0; m <= 3; m++) {
                                if (A.charAt(m) != B.charAt(m)) tempSum++;
                                if (A.charAt(m) != C.charAt(m)) tempSum++;
                                if (B.charAt(m) != C.charAt(m)) tempSum++;
                            }
                            if (tempSum < sum) sum = tempSum;
                        }
                    }
                }
                sb.append(sum + "\n");
            }
        }
        System.out.println(sb);
    }
}


