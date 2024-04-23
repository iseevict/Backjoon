package b19949;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[10];
    static int ans = 0;

    static void setArr(int[] temp) {
        arr = temp;
    }

    static void back(int[] Y, int pos, int count) {
        if (10 - pos + count < 5) return;
        if (pos == 10) {
            if (count >= 5) { // 5점 이상일 때 경우의 수 + 1 후 리턴
                ans++;
                return;
            }
        }
        else {
            for (int i = 1; i <= 5; i++) {
                if (pos >= 2) {
                    if (Y[pos - 1] == i && Y[pos - 2] == i) { // 3번 연속으로 같은지 확인
                        continue;
                    }
                }
                Y[pos] = i;
                if (i == arr[pos]) {
                    back(Y, pos + 1, count + 1);
                }
                else {
                    back(Y, pos + 1, count);
                }
                Y[pos] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int[] temp = new int[10];
        for (int i = 0; i < 10; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        setArr(temp);
        int[] Y = new int[10];
        back(Y, 0, 0);
        System.out.println(ans);
    }
}
