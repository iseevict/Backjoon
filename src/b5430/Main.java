package b5430;

import java.io.*;
import java.util.*;

public class Main {
    static int T, n;

    static int toInt (Deque<Integer> arr) {
        int len = arr.size();
        int num = 0;
        for (int i = 0; i < len; i++) {
            int s = arr.removeLast();
            s = s * (int)Math.pow(10, i);
            num += s;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        Loop1:
        while (T-- > 0) {
            Deque<Integer> deq1 = new LinkedList<>();
            Deque<Integer> deq2 = new LinkedList<>();
            char[] func = buf.readLine().toCharArray();
            boolean btn = false;
            int funcLen = func.length;
            int num = Integer.parseInt(buf.readLine());
            String[] numArr = buf.readLine().split("");
            int numArrLen = numArr.length;
            int numCount = num;
            Deque<Integer> deq = new LinkedList<>();
            for (int i = 1; i < numArrLen - 1; i++) {
                if (numArr[i].equals(",")) {
                    int nq = toInt(deq);
                    deq1.addLast(nq);
                    deq2.addFirst(nq);
                    deq.clear();
                }
                else {
                    int aa = Integer.parseInt(numArr[i]);
                    deq.add(aa);
                }
                if (i == numArrLen - 2) {
                    int nq = toInt(deq);
                    deq1.addLast(nq);
                    deq2.addFirst(nq);
                    deq.clear();
                    break;
                }
            }
            for (int i = 0; i < funcLen; i++) {
                if (func[i] == 'R') {
                    btn = !btn;
                }
                else if (func[i] == 'D') {
                    if (!btn) {
                        if (numCount == 0) {
                            sb.append("error\n");
                            continue Loop1;
                        }
                        else {
                            numCount--;
                            deq1.removeFirst();
                            deq2.removeLast();
                        }
                    }
                    else {
                        if (numCount == 0) {
                            sb.append("error\n");
                            continue Loop1;
                        }
                        else {
                            numCount--;
                            deq2.removeFirst();
                            deq1.removeLast();
                        }
                    }
                }
            }
            if (btn) {
                int deqLen = deq2.size();
                sb.append("[");
                for (int i = 0; i < deqLen; i++) {
                    if (i != deqLen - 1) {
                        sb.append(deq2.removeFirst() + ",");
                        continue;
                    }
                    sb.append(deq2.removeFirst());
                }
                sb.append("]\n");
            }
            else {
                int deqLen = deq1.size();
                sb.append("[");
                for (int i = 0; i < deqLen; i++) {
                    if (i != deqLen - 1) {
                        sb.append(deq1.removeFirst() + ",");
                        continue;
                    }
                    sb.append(deq1.removeFirst());
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}


