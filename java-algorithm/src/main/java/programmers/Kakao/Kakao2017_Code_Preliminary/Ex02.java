package programmers.Kakao.Kakao2017_Code_Preliminary;


public class Ex02 {
    public int[] lastIdx(String sentence, char key, int start) {
        int idx = start;
        int cnt = 1;

        System.out.println("FIND START " + start + " " + cnt);
        for (int i = start + 1; i < sentence.length(); i++) {
            System.out.println(i + " " + sentence.charAt(i));
            if (key == sentence.charAt(i)) {
                System.out.println("SAME");
                idx = i;
                cnt++;
            } else if (key != sentence.charAt(i) && 'a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z') {
                return new int[]{idx, cnt};
            }
        }

        return new int[]{idx, cnt};
    }

    public String solution(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if ('a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z') {
                int[] result = lastIdx(sentence, sentence.charAt(i), i);
                int idx = result[0];
                int cnt = result[1];
                System.out.print(sentence.charAt(i) + " START ::: ");

                if (cnt == 2) {

                    if (i == 0) {
                        sentence = sentence.substring(i + 1, idx) + " " + sentence.substring(idx + 1);
                        i = idx - 1;
                    } else {
                        if (idx < sentence.length()) {
                            sentence = sentence.substring(0, i) + " " + sentence.substring(i + 1, idx) + " " + sentence.substring(idx + 1);
                        } else {
                            sentence = sentence.substring(0, i) + " " + sentence.substring(i + 1);
                        }
                        i = idx;
                    }
                } else {
                    if (i - 1 >= 0 && sentence.charAt(i - 1) == ' ') {
                        return "invalid";
                    }

                    if (i == 1) {
                        sentence = sentence.substring(0, idx + 2).replaceAll(String.valueOf(sentence.charAt(i)), "-") + " " + sentence.substring(idx + 2);
                        i = idx + 2;
                    } else {
                        if (idx == sentence.length() - 1) {
                            sentence = sentence.substring(0, i) + " " + sentence.substring(i + 1).replaceAll(String.valueOf(sentence.charAt(i)), "-");
                        } else {
                            sentence = sentence.substring(0, i) + " " + sentence.substring(i + 1, idx + 2).replaceAll(String.valueOf(sentence.charAt(i)), "-") + " " + sentence.substring(idx + 2);
                        }
                        i = idx + 3;
                    }
                }
                System.out.println("idx:" + idx + " cnt:" + cnt + " result:" + sentence);
            }
        }

        return sentence.replaceAll("-", "").replaceAll("  ", " ").strip();
    }

    public static void main(String[] args) {
        Ex02 main = new Ex02();
        System.out.println(main.solution("HaEaLaLaObWORLDb"));
        System.out.println(main.solution("SpIpGpOpNpGJqOqA"));

    }
}
