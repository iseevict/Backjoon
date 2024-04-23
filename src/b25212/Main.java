package b25212;

import java.io.*;
import java.util.*;

public class Main {
    static double[] arr;
    static int N;
    static int ans = 0;

    static void setArr(int pos, double value) {
        arr[pos] = value;
    }

    static void setValue() {
        ans++;
    }

    static void setValueN(int num) {
        N = num;
    }

    static void checkCake(int pos, int select, double total) {
        if (pos == N) {
            if (total >= 0.99 && total <= 1.01) {
                setValue();
                return;
            }
            else if ((total + arr[pos - 1]) >= 0.99 && (total + arr[pos - 1]) <= 1.01) {
                setValue();
                return;
            }
            else {
                return;
            }
        }
        checkCake(pos + 1, select, total);
        if (pos > 0) {
            checkCake(pos + 1, select + 1, total + arr[pos - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        setValueN(Integer.parseInt(buf.readLine()));
        arr = new double[N];
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            setArr(i, 1 / Double.parseDouble(st.nextToken()));
        }
        checkCake(0, 0, 0.0);
        System.out.println(ans);
    }
}
