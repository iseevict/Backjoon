package b1018;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] arr;
    static int sum = Integer.MAX_VALUE;

    static boolean check(int x, int y) { // 8x8 체스판 가능한지 확인 함수
        if (x + 8 > M || y + 8 > N) {
            return false;
        }
        else {
            return true;
        }
    }

    static char change(char word) {
        if (word == 'W') {
            return 'B';
        }
        else {
            return 'W';
        }
    }

    static int count(int x, int y) { // 칠해야 하는 정사각형의 개수 구하는 함수
        int count1 = 0;
        int count2 = 1;
        char temp = arr[x][y];
        char temp2 = change(temp);
        for (int i = y; i < y + 8; i++) { // count1 구하는 반복문 (가장 왼쪽 위의 값을 바꾸지 않은 경우)
            for (int j = x; j < x + 8; j++) {
                if (i == y && j == x) continue;
                if (arr[j][i] == temp) {
                    count1++;
                    temp = change(temp);
                }
                else {
                    temp = change(temp);
                }
                if (arr[j][i] == temp2) {
                    count2++;
                    temp2 = change(temp2);
                }
                else {
                    temp2 = change(temp2);
                }
            }
            temp = change(temp);
            temp2 = change(temp2);
        }
        if (count1 > count2) {
            return count2;
        }
        else {
            return count1;
        }
    }

    static void run() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check(j, i)) {
                    int num = count(j, i);
                    if (sum > num) {
                        sum = num;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        for (int i = 0; i < N; i++) {
            String temp = buf.readLine();
            char[] tempArr = temp.toCharArray();
            for (int j = 0; j < M; j++) {
                arr[j][i] = tempArr[j];
            }
        }
        run();
    }
}
