package b2501;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer. parseInt(st.nextToken());
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (N % (i + 1) == 0) {
                count++;
            }
            if (count == K) {
                System.out.println(i + 1);
                break;
            }
        }
        if (count < K) {
            System.out.print("0");
        }
    }
}
