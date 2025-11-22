package Test_Result.Software_Maestro_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    // 입력 키 가지고 키워드 찾기

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] keyword = new String[size];
        for (int i = 0; i < size; i++) {
            keyword[i] = br.readLine();
        }

        StringBuffer answer=new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            String target = br.readLine();
            for (int j = 0; j < keyword.length; j++) {
                if (keyword[j].startsWith(target)) {
                    cnt++;
                }
            }
            answer.append(cnt).append('\n');
        }

        System.out.print(answer.toString().strip());
    }
}


//4
//S
//SMNAME
//SMSNS
//SMBLOG
//3
//S
//MN
//SOFTWARE