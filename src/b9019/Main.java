package b9019;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static Deque<Integer> firstDeq = new LinkedList<>();
    static Deque<Integer> lastDeq = new LinkedList<>();
    static boolean[] visit = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            Queue<Map<Integer, List<Character>>> que = new LinkedList<>();
            Map<Integer, List<Character>> map = new TreeMap<>();
            List<Character> list = new ArrayList<>();
            map.put(first, list);
            que.add(map);
            visit[first] = true;
            List<Character> ans = new ArrayList<>();
            Loop1 :
            while (!que.isEmpty()) {
                Map<Integer, List<Character>> m = que.poll();
                for (Map.Entry<Integer, List<Character>> entry : m.entrySet()) {
                    int start = entry.getKey();
                    List<Character> tempList = entry.getValue();
                    String[] startS = Integer.toString(start).split("");
                    int startLen = startS.length;

                    Deque<Integer> startDeq = new LinkedList<>();
                    for (int i = 3; i >= startLen; i--) {
                        startDeq.addLast(0);
                    }
                    for (int i = 0; i < startLen; i++) {
                        startDeq.addLast(Integer.parseInt(startS[i]));
                    }

                    // D
                    if (!visit[(start * 2) % 10000]) {
                        int n = (start * 2) % 10000;
                        visit[n] = true;
                        List<Character> tL1 = new ArrayList<>();
                        tL1.addAll(tempList);
                        tL1.add('D');
                        if (n == last) {
                            ans.addAll(tL1);
                            break Loop1;
                        }
                        Map<Integer, List<Character>> tempM1 = new HashMap<>();
                        tempM1.put(n, tL1);
                        que.add(tempM1);
                    }

                    int sNum = start - 1;
                    if (sNum < 0) sNum = 9999;
                    // S
                    if (!visit[sNum]) {
                        visit[sNum] = true;
                        List<Character> tL2 = new ArrayList<>();
                        tL2.addAll(tempList);
                        tL2.add('S');
                        if (sNum == last) {
                            ans.addAll(tL2);
                            break Loop1;
                        }
                        Map<Integer, List<Character>> tempM2 = new HashMap<>();
                        tempM2.put(sNum, tL2);
                        que.add(tempM2);
                    }

                    Deque<Integer> deqL = startDeq;
                    int tempNum1 = deqL.removeFirst();
                    deqL.addLast(tempNum1);
                    int lNum = 0;
                    for (int i : deqL) {
                        lNum = lNum * 10 + i;
                    }
                    // L
                    if (!visit[lNum]) {
                        visit[lNum] = true;
                        List<Character> tL3 = new ArrayList<>();
                        tL3.addAll(tempList);
                        tL3.add('L');
                        if (lNum == last) {
                            ans.addAll(tL3);
                            break Loop1;
                        }
                        Map<Integer, List<Character>> tempM3 = new HashMap<>();
                        tempM3.put(lNum, tL3);
                        que.add(tempM3);
                    }

                    Deque<Integer> deqR = startDeq;
                    int tempNum2 = deqL.removeLast();
                    deqL.addFirst(tempNum2);
                    int rNum = 0;
                    for (int i : deqR) {
                        rNum = rNum * 10 + i;
                    }
                    //R
                    if (!visit[rNum]) {
                        visit[rNum] = true;
                        List<Character> tL4 = new ArrayList<>();
                        tL4.addAll(tempList);
                        tL4.add('R');
                        if (rNum == last) {
                            ans.addAll(tL4);
                            break Loop1;
                        }
                        Map<Integer, List<Character>> tempM4 = new HashMap<>();
                        tempM4.put(rNum, tL4);
                        que.add(tempM4);
                    }

                }
            }

            firstDeq.clear();
            lastDeq.clear();
            for (char c : ans) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

