package programmers.Kakao.Kakao2021_CareerChained_Internship;

import java.util.Stack;

public class Ex03_01_timefailed {
    public String solution(int n, int k, String[] cmd) {
        boolean[] isDeleted=new boolean[n];
        Stack<Integer> deleteIdx = new Stack<>();
        for (int i = 0; i < cmd.length; i++) {
            String[] cmds = cmd[i].split(" ");
            if (cmds[0].equals("U")) {
                int cnt = Integer.parseInt(cmds[1]);
                int lastIdx=k;
                while (cnt != 0) {
                    k--;
                    if (!isDeleted[k]) {
                        cnt--;
                        lastIdx=k;
                    }
                }

                if (isDeleted[k]) {
                    k=lastIdx;
                }
            } else if (cmds[0].equals("D")) {
                int cnt = Integer.parseInt(cmds[1]);
                int lastIdx=k;
                while (cnt != 0) {
                    k++;
                    if (!isDeleted[k]) {
                        cnt--;
                        lastIdx=k;
                    }
                }

                if (isDeleted[k]) {
                    k=lastIdx;
                }
            } else if (cmds[0].equals("C")) {
                isDeleted[k]=true;
                deleteIdx.push(k);
                boolean find=false;
                for (int j = k+1 ; j < isDeleted.length; j++) {
                    if (!isDeleted[j]) {
                        k=j;
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    for (int j = k-1 ; j >=0; j--) {
                        if (!isDeleted[j]) {
                            k=j;
                            break;
                        }
                    }
                }
            } else if (cmds[0].equals("Z")) {
                int recoveryIdx = deleteIdx.pop();
                isDeleted[recoveryIdx]=false;
            }

            System.out.print(cmd[i]+"::\t");
            for (int j = 0; j < isDeleted.length; j++) {
                System.out.print(isDeleted[j] ? 'X' : 'O');
            }
            System.out.println(" "+k);
        }

        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < isDeleted.length; i++) {
            if (isDeleted[i]) {
                answer.append('X');
            } else {
                answer.append('O');
            }
        }

        return answer.toString();
    }
}
