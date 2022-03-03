package programmers.high_scores._01_hash;

import java.util.ArrayList;

public class Ex03 {
    public static int dfs(ArrayList<Cloth> cloth, int start, int sum) {
        int thisSum = 0;

        for (int i = start; i < cloth.size(); i++) {
            thisSum += sum * cloth.get(i).cnt;
            thisSum += dfs(cloth, i + 1, sum * cloth.get(i).cnt);
        }

        return thisSum;
    }

    public static class Cloth {
        String type;
        int cnt;

        Cloth(String type, int cnt) {
            this.type = type;
            this.cnt = cnt;
        }
    }

    public static int solution(String[][] clothes) {
        ArrayList<Cloth> cloth = new ArrayList<>();
        for (int i = 0; i < clothes.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < cloth.size(); j++) {
                if (cloth.get(j).type.equals(clothes[i][1])) {
                    cloth.get(j).cnt++;
                    isFind = true;
                }
            }

            if (!isFind) {
                cloth.add(new Cloth(clothes[i][1], 1));
            }
        }

        for (Cloth c : cloth) {
            System.out.println(c.type + " " + c.cnt);
        }

        return dfs(cloth, 0, 1);
    }

    public static void main(String[] args) {
        String[][] input = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] input2 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
        String[][] input3 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}, {"yellow_hat", "yellow_hat"}, {"blue_sunglasses", "yellow_hat"}, {"green_turban", "blue_sunglasses"}, {"blue_sunglasses", "blue_sunglasses"}, {"green_turban", "blue_sunglasses"}};
        System.out.println(solution(input3));
    }
}
