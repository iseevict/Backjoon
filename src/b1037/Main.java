package b1037;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        int min = 1000001;
        int max = -1;
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }
        System.out.println(max * min);
    }
}
