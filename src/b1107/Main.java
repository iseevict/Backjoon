package b1107;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int click;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = buf.readLine();
        String[] sArr = s.split("");
        int sLen = s.length();
        int[] target = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            target[i] = Integer.parseInt(sArr[i]);
        }

        N = Integer.parseInt(s);
        M = Integer.parseInt(buf.readLine());

        boolean[] error = new boolean[10];
        Arrays.fill(error, true);

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            for (int i = 0; i < M; i++) {
                int n = Integer.parseInt(st.nextToken());
                error[n] = false;
            }
        }

        if (M == 10) { // case 1. 누를 수 있는 숫자가 없을 때
            System.out.println(Math.abs(N - 100));
            return;
        }

        click = Math.abs(N - 100);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) { // 누를 수 있는 수들 중에서 가장 큰 수와 작은 수 저장
            if (error[i]) {
                if (i > max) max = i;
                if (i < min) min = i;
            }
        }

        if (N == 100) { // case 2. 목표가 이미 100일 때
            System.out.println(0);
            return;
        }

        // case 3. 숫자 입력 후 + / - 로 이동
        int pos = 0;
        Stack<Integer> lowStack = new Stack<>();
        Loop1 :
        while (pos != sLen) { // case 3-1. 목표보다 작은 수 중 만들 수 있는 가장 큰 수
            int num = target[pos];
            if (error[num]) {
                lowStack.push(num);
                pos++;
            }
            else {
                for (int i = num - 1; i >= 0; i--) {
                    if (error[i]) {
                        lowStack.push(i);
                        for (int j = lowStack.size(); j < sLen; j++) {
                            lowStack.push(max);
                        }
                        break Loop1;
                    }
                }
                while(!lowStack.empty()) {
                    int tempNum = lowStack.pop();
                    for (int i = tempNum - 1; i >= 0; i--) {
                        if (error[i]) {
                            if (i == 0 && lowStack.empty()) {
                                continue;
                            }
                            lowStack.push(i);
                            for (int j = lowStack.size(); j < sLen; j++) {
                                lowStack.push(max);
                            }
                            break Loop1;
                        }
                    }
                }
                for (int i = 0; i < sLen - 1; i++) {
                    lowStack.push(max);
                }
                break Loop1;
            }
        }

        pos = 0; // 초기화
        Stack<Integer> highStack = new Stack<>();
        Loop1 :
        while (pos != sLen) { // case 3-2. 목표보다 큰 수 중 만들 수 있는 가장 작은 수
            int num = target[pos];
            if (error[num]) {
                highStack.push(num);
                pos++;
            }
            else {
                for (int i = num + 1; i < 10; i++) {
                    if (error[i]) {
                        highStack.push(i);
                        for (int j = highStack.size(); j < sLen; j++) {
                            highStack.push(min);
                        }
                        break Loop1;
                    }
                }
                while(!highStack.empty()) {
                    int tempNum = highStack.pop();
                    for (int i = tempNum + 1; i < 10; i++) {
                        if (error[i]) {
                            highStack.push(i);
                            for (int j = highStack.size(); j < sLen; j++) {
                                highStack.push(min);
                            }
                            break Loop1;
                        }
                    }
                }
                Loop2 :
                for (int i = 0; i < sLen + 1; i++) {
                    if (min == 0 && i == 0) {
                        for (int j = 1; j < 10; j++) {
                            if (error[j]) {
                                highStack.push(j);
                                continue Loop2;
                            }
                        }
                    }
                    highStack.push(min);
                }
                break Loop1;
            }
        }


        int lowNum = 0; // lowNum 스택 -> 정수 변환
        int count = 0;
        if (lowStack.empty()) {
            lowNum = Integer.MAX_VALUE;
        }
        else {
            while (!lowStack.empty()) {
                int n = lowStack.pop();
                lowNum += n * (int)Math.pow(10, count);
                count++;
            }
        }
        String lowString = String.valueOf(lowNum);
        if (lowNum != Integer.MAX_VALUE) {
            int temp = Math.abs(N - lowNum) + lowString.length();
            if (temp < click) click = temp;
        }

        int highNum = 0; // lowNum 스택 -> 정수 변환
        int count2 = 0;
        if (highStack.empty()) {
            highNum = Integer.MAX_VALUE;
        }
        else {
            while (!highStack.empty()) {
                int n = highStack.pop();
                highNum += n * (int)Math.pow(10, count2);
                count2++;
            }
        }
        String highString = String.valueOf(highNum);
        if (highNum != Integer.MAX_VALUE) {
            int temp = Math.abs(highNum - N) + highString.length();
            if (temp < click) click = temp;
        }

        System.out.println(click);
    }
}

