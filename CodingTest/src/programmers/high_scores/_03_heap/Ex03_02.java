package programmers.high_scores._03_heap;

import java.util.*;

public class Ex03_02 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        boolean isOrder = true;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                list.add(num);
                isOrder=false;
            } else {
                if (list.size() > 0) {
                    if (!isOrder) {
                        Collections.sort(list);
                        isOrder=true;
                    }

                    if (num == 1) {
                        list.removeLast();
                    } else if (num == -1) {
                        list.removeFirst();
                    }
                }
            }

            printList(list);
        }


        if (!isOrder) {
            Collections.sort(list);
            isOrder=true;
        }

        if (list.size() > 0) {
            answer[0] = list.getLast();
            answer[1] = list.getFirst();
        } else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }

    public static void printList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7","I 5","I -5","D -1"})));
    }
}
