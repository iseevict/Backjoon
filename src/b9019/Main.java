package b9019;

import java.io.*;
import java.util.*;

public class Main {
    static int T;

    static int D(int left) {
        left = left * 2;
        if (left > 9999) {
            left = left % 10000;
        }
        return left;
    }

    static int S(int left) {
        left -= 1;
        if (left == -1) left = 9999;
        return left;
    }

    static int L(int left) {
        if (left == 0) {
            return 0;
        }
        String leftTempString = Integer.toString(left);
        int leftLen = (int)Math.log10(left);
        String leftS = "";
        for (int i = 1; i < 4 - leftLen; i++) {
            leftS += "0";
        }
        for (int j = 0; j <= leftLen; j++) {
            leftS = leftS + leftTempString.charAt(j);
        }
        char[] tempCharArr = leftS.toCharArray();
        for (int i = 0; i < 3; i++) {
            char tempChar = tempCharArr[i];
            tempCharArr[i] = tempCharArr[i + 1];
            tempCharArr[i + 1] = tempChar;
        }
        leftS = "";
        for (int i = 0; i <= 3; i++) {
            leftS = leftS + tempCharArr[i];
        }
        left = Integer.parseInt(leftS);
        return left;
    }

    static int R(int left) {
        if (left == 0) {
            return 0;
        }
        String leftTempString = Integer.toString(left);
        int leftLen = (int)Math.log10(left);
        String leftS = "";
        for (int i = 1; i < 4 - leftLen; i++) {
            leftS += "0";
        }
        for (int j = 0; j <= leftLen; j++) {
            leftS = leftS + leftTempString.charAt(j);
        }
        char[] tempCharArr = leftS.toCharArray();
        for (int i = 3; i > 0; i--) {
            char tempChar = tempCharArr[i];
            tempCharArr[i] = tempCharArr[i - 1];
            tempCharArr[i - 1] = tempChar;
        }
        leftS = "";
        for (int i = 0; i <= 3; i++) {
            leftS = leftS + tempCharArr[i];
        }
        left = Integer.parseInt(leftS);
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int[] visit = new int[10000];
        }
    }
}

