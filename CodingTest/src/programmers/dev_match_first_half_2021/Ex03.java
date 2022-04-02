package programmers.dev_match_first_half_2021;

import java.util.Arrays;
import java.util.HashMap;

public class Ex03 {
    static HashMap<String, Node> map;
    static Node[] nodes;

    public class Node{
        String name;
        Node parent;
        int profit;

        public Node(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }

        public void getProfit(int money) {
            if (parent == null) {
                System.out.println(name+" "+money+" ROOT");
                profit+=money;
            } else {
                int giveParent = (int)(money*0.1);
                profit += (money-giveParent);
                System.out.println(name+" "+(money-giveParent)+" CHILD");
                parent.getProfit(giveParent);
            }
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map = new HashMap<>();
        nodes = new Node[enroll.length];
        Node root = new Node("center");
        map.put("center", root);
        for (int i = 0; i < enroll.length; i++) {
            nodes[i] = new Node(enroll[i]);
            map.put(enroll[i], nodes[i]);
        }

        for (int i = 0; i < referral.length; i++) {
            Node child = map.get(enroll[i]);
            if (referral[i].equals("-")) {
                child.parent = map.get("center");
            } else {
                child.parent = map.get(referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            map.get(seller[i]).getProfit(amount[i] * 100);
        }

        int[] answer = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            answer[i] = nodes[i].profit;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03 main = new Ex03();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(main.solution(enroll, referral, seller, amount)));
    }
}
