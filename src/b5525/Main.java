package b5525;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        M = Integer.parseInt(buf.readLine());
        char[] arr = buf.readLine().toCharArray();
        int count = 0;
        int ch = 0;
        boolean check = false;
        int pos = 0;
        for (int i = 1; i < M - 1;) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                ch++;
                if (ch == N) {
                    if (arr[i - 2 * N + 1] == 'I') {
                        count++;
                    }
                    ch--;
                }
                i += 2;
            }
            else {
                ch = 0;
                i++;
            }
        }
        System.out.println(count);
    }
}

