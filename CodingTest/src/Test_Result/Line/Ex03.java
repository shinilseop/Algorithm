package Test_Result.Line;

import java.util.*;

public class Ex03 {
    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<String, Boolean> isOffice = new HashMap<>(); // 업무, 사무실?
        for(int i=0;i<remote_tasks.length;i++) isOffice.put(remote_tasks[i], false);
        for(int i=0;i<office_tasks.length;i++) isOffice.put(office_tasks[i], true);

        ArrayList<Integer>[] remoteMan = new ArrayList[num_teams+1];
        for (int i = 0; i <= num_teams; i++) remoteMan[i] = new ArrayList<>();
        boolean[] officeTeam = new boolean[num_teams+1];

        for (int i = 0; i < employees.length; i++) {
            String[] input = employees[i].split(" ");
            int num = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length; j++) {
                if (isOffice.get(input[j])) {
                    officeTeam[num] = true;
                    break;
                }

                if (j == input.length - 1) {
                    remoteMan[num].add(i+1);
                }
            }
        }

//        for (int i = 1; i < remoteMan.length; i++) {
//            System.out.print(i+"team :: ");
//            for (int j = 0; j < remoteMan[i].size(); j++) {
//                System.out.print(remoteMan[i].get(j)+" ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < officeTeam.length; i++) {
            if (!officeTeam[i]) {
                Collections.sort(remoteMan[i]);
                remoteMan[i].remove(0);
                officeTeam[i]=true;
            }

            for (int j = 0; j < remoteMan[i].size(); j++) {
                ans.add(remoteMan[i].get(j));
            }
        }

        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i]=ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03 main = new Ex03();
        int num_teams = 3;
        String[] remote_tasks = {"development","marketing","hometask"};
        String[] office_tasks = {"recruitment","education","officetask"};
        String[] employees = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};

        System.out.println(Arrays.toString(main.solution(num_teams, remote_tasks, office_tasks, employees)));
//        System.out.println(Arrays.toString(main.solutions()));
    }
}
