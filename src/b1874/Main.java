package b1874;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static List<Character> arrChar = new ArrayList<Character>();
    static boolean check = true;

    static void run() {
        Stack<Integer> intStack = new Stack<Integer>();
        int count = 0;
        for(int i = 1; i <= n; i++) {
            intStack.push(i);
            arrChar.add('+');
            if (i > arr[count]) {
                check = false;
                break;
            }
            else if (i == arr[count]) {
                intStack.pop();
                arrChar.add('-');
                count++;
                if (!intStack.empty()) {
                    int temp = intStack.size();
                    for (int j = 1; j <= temp; j++) {
                        if (intStack.peek() > arr[count]) {
                            check = false;
                            break;
                        }
                        if (intStack.peek() == arr[count]) {
                            intStack.pop();
                            arrChar.add('-');
                            count++;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
        if (check) {
            while(!intStack.empty()) {
                intStack.pop();
                arrChar.add('-');
            }
            for(char c : arrChar) {
                System.out.println(c);
            }
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buf.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(buf.readLine());
        }
        run();
    }
}
