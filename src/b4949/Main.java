package b4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = buf.readLine();
            Stack<Character> stack = new Stack<>();
            if (s.equals(".")) {
                break;
            }
            else {
                String[] sArr = s.split(" ");
                int len = sArr.length;
                String last = sArr[len - 1];
                char[] lastArr = last.toCharArray();
                int lastArrLen = lastArr.length;
                if (lastArr[lastArrLen - 1] != '.') { // 온점 확인
                    sb.append("no\n");
                }
                else {
                    for (int i =0; i < len; i++) {
                        int num = sArr[i].length();
                        for(int j = 0; j < num; j++) {
                            char tempChar = sArr[i].charAt(j);
                            if (tempChar == '(') {
                                stack.add(tempChar);
                            }
                            else if (tempChar == ')') {
                                stack.add(tempChar);
                            }
                            else if (tempChar == '[') {
                                stack.add(tempChar);
                            }
                            else if (tempChar == ']') {
                                stack.add(tempChar);
                            }
                        }
                    }
                    int check = 1;
                    Stack<Character> stack2 = new Stack<>();
                    while(!stack.empty()) {
                        char temp = stack.pop();
                        if (temp == '('){
                            if (stack2.empty()) {
                                check = 0;
                                break;
                            }
                            else {
                                char temp2 = stack2.pop();
                                if (temp2 != ')') {
                                    check = 0;
                                    break;
                                }
                            }
                        }
                        else if (temp == '[') {
                            if (stack2.empty()) {
                                check = 0;
                                break;
                            }
                            else {
                                char temp2 = stack2.pop();
                                if (temp2 != ']') {
                                    check = 0;
                                    break;
                                }
                            }
                        }
                        else {
                            stack2.add(temp);
                        }
                    }
                    if (!stack2.empty()) {
                        check = 0;
                    }
                    if (check == 1) {
                        sb.append("yes\n");
                    }
                    else {
                        sb.append("no\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
