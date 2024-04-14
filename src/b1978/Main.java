package b1978;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 2 && temp % 2 == 0) {
                continue;
            }
            else if (temp > 2) {
                for (int j = 2; j < temp; j++) {
                    if (temp % j == 0) break;
                    if (j == temp - 1) {
                        count++;
                    }
                }
            }
            else if (temp == 1) continue;
            else {
                count++;
            }
        }
        System.out.println(count);
    }
}
