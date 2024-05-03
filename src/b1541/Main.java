package b1541;

import java.io.*;
import java.util.*;

public class Main {
    static int toInt(List<Integer> arr) {
        int size = arr.size();
        int num = 0;
        for (int i = 0; i < size; i++) {
            int temp = arr.get(i);
            num = num + temp * (int)Math.pow(10, size - i - 1);
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new LinkedList<>();
        String[] sArr = buf.readLine().split("");
        List<Integer> num = new LinkedList<>();
        List<Character> pm = new LinkedList<>();
        for(int i = 0; i < sArr.length; i++) {
            String c = sArr[i];
            if (c.equals("+")) {
                pm.add('+');
                num.add(toInt(arr));
                arr.clear();
            }
            else if (c.equals("-")) {
                pm.add('-');
                num.add(toInt(arr));
                arr.clear();
            }
            else {
                arr.add(Integer.parseInt(c));
            }
        }
        num.add(toInt(arr));
        if (pm.isEmpty()) {
            System.out.println(num.get(0));
            return;
        }
        /**
         * 최우선 : -+
         * 다음 : --
         * 다음 : +-
         * 다음 : ++
         */

        while(num.size() != 2) {
            int pos = 0;
            for (int i = 0; i < pm.size() - 1; i++) { // case 1 : -+
                if (pm.get(i) == '-') {
                    if (pm.get(i + 1) == '+') {
                        num.set(i + 1, num.get(i + 1) + num.get(i + 2));
                        num.remove(i + 2);
                        pm.remove(i + 1);
                        i--;
                    }
                    else if (pm.get(i + 1) == '-') {
                        num.set(i + 1, num.get(i + 1) + num.get(i + 2));
                        num.remove(i + 2);
                        pm.remove(i + 1);
                        i--;
                    }
                }
                else if (pm.get(i) == '+') {
                    if (pm.get(i + 1) == '-') {
                        if (i + 1 == pm.size() - 1) {
                            num.set(i + 1, num.get(i + 1) - num.get(i + 2));
                            num.remove(i + 2);
                            pm.remove(i + 1);
                        }
                        else {
                            pos = i;
                        }
                    }
                    else if (pm.get(i + 1) == '+') {
                        num.set(i + 1, num.get(i + 1) + num.get(i + 2));
                        num.remove(i + 2);
                        pm.remove(i + 1);
                        i--;
                    }
                }
            }
        }

        if (num.size() == 2) {
            if (pm.get(0) == '-') {
                num.set(0, num.get(0) - num.get(1));
            }
            else {
                num.set(0, num.get(0) + num.get(1));
            }
            num.remove(1);
        }

        System.out.println(num.get(0));
    }
}

