package programmers.high_scores._06_greedy;

import java.util.Arrays;

public class Ex02_past {
    public int solution(String name) {
        return minMove(name)+countChangeAlphabet(name);
    }

    static int minMove(String name) {
        int move[] =new int[name.length()];
        int rvsmove[] =new int[name.length()];
        int min=Integer.MAX_VALUE;
        Arrays.fill(move, -1);
        Arrays.fill(rvsmove, -1);
        for(int i=1;i<name.length();i++) {
            if(name.charAt(i)!='A') {
                move[i]=i;
            }
        }
        int idx=1;
        for(int i=name.length()-1;i>0;i--) {
            if(name.charAt(i)!='A') {
                rvsmove[i]=idx;
            }
            idx++;
        }

        for(int i=0;i<name.length();i++) {
            if(rvsmove[i]!=-1) {
                min=Math.min(min, rvsmove[i]);
                break;
            }
        }
        for(int i=move.length-1;i>=0;i--) {
            if(move[i]!=-1) {
                min=Math.min(min, move[i]);
                break;
            }
        }
        for(int i=0;i<move.length;i++) {
            if(move[i]!=-1) {
                for(int j=i+1;j<move.length;j++) {
                    if(rvsmove[j]!=-1) {
                        min=Math.min(min, move[i]*2+rvsmove[j]);
                        break;
                    }
                }
            }
        }
        for(int i=move.length-1;i>=0;i--) {
            if(rvsmove[i]!=-1) {
                for(int j=i-1;j>=0;j--) {
                    if(move[j]!=-1) {
                        min=Math.min(min, rvsmove[i]*2+move[j]);
                        break;
                    }
                }
            }
        }


        return min;
    }

    public int countChangeAlphabet(String name) {
        int cnt=0;
        char[] ch=name.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(ch[i]!='A') {
                if(ch[i]<='N') {
                    cnt+=ch[i]-'A';
                } else {
                    cnt+=13-(ch[i]-'N');
                }
            }
        }

        return cnt;
    }
}
