package Test_Result.Line;

import java.util.Arrays;

public class Ex01 {

    public int solution(String[] logs) {
        int answer = 0;
        boolean teamName = false;
        boolean applicationName = false;
        boolean errorLevel = false;
        boolean message = false;

        for (int i = 0; i < logs.length; i++) {
            System.out.println("check ::: "+logs[i]);
            String[] log = logs[i].split(" ");
            // 전체 개수 확인
            if (log.length - 1 < 11) {
                System.out.println("count error");
                answer++;
                continue;
            }

            // 컬럼 확인
            if (!(log[0].equals("team_name") && log[3].equals("application_name") && log[6].equals("error_level") && log[9].equals("message"))) {
                System.out.println("column error");
                answer++;
                continue;
            }

            // 형식 확인
            if (!(log[1].equals(":") && log[4].equals(":") && log[7].equals(":") && log[10].equals(":"))) {
                System.out.println("format error");
                answer++;
                continue;
            }

            //내용 확인
            if (!(log[2].matches("^[a-zA-Z]*$") && log[5].matches("^[a-zA-Z]*$") && log[8].matches("^[a-zA-Z]*$") && log[11].matches("^[a-zA-Z]*$"))) {
                System.out.println("content error");
                answer++;
                continue;
            }

            //길이 확인
            if (logs[i].length() > 100) {
                System.out.println("length error");
                answer++;
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex01 main = new Ex01();
        String str = "1  ㄲ 2";
        String str2 = "1aaa2";
        System.out.println(str.split(" ").length);
        System.out.println(str.matches("^[a-zA-Z0-9]*$"));
        System.out.println(str2.matches("^[a-zA-Z0-9]*$"));
//        System.out.println(main.solutions());
//        System.out.println(Arrays.toString(main.solutions()));
    }
}
