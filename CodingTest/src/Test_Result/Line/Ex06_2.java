package Test_Result.Line;

import java.util.*;

public class Ex06_2 {
    static HashMap<String, Have> map;
    static ArrayList<Sell> sell;
    static ArrayList<Buy> buy;

    public class Have {
        int gold;
        int money;

        public Have(int gold, int money) {
            this.gold = gold;
            this.money = money;
        }
    }

    public class Sell implements Comparable<Sell> {
        String name;
        int seq;
        int amount, price;

        public Sell(String name, int amount, int price, int seq) {
            this.name = name;
            this.amount = amount;
            this.price = price;
            this.seq = seq;
        }

        @Override
        public int compareTo(Sell o) {
            if (this.price == o.price) {
                return this.seq - o.seq;
            }
            return this.price - o.price;
        }
    }

    public class Buy implements Comparable<Buy> {
        String name;
        int seq;
        int amount, price;

        public Buy(String name, int amount, int price, int seq) {
            this.name = name;
            this.amount = amount;
            this.price = price;
            this.seq = seq;
        }

        @Override
        public int compareTo(Buy o) {
            if (this.price == o.price) {
                return this.seq - o.seq;
            }
            return -(this.price - o.price);
        }
    }

    public void buy(String name, int amount, int price, int seq) {
        System.out.println("Trade "+name+" buy +"+amount+" "+price);
        int removeIdx=0;

        for (int i = 0; i < sell.size(); i++) {
            Sell trade = sell.get(i);
            System.out.println(trade.name+" sell : "+trade.price+" "+trade.amount);
            if (price < trade.price) {
                System.out.println("fail");
                break;
            }

            System.out.println("success");
            if (amount > trade.amount) {
                Have have = map.get(name);
                have.gold += trade.amount;
                have.money -= (trade.amount * Math.min(price, trade.price));
                System.out.println(name+" "+have.gold+" "+have.money);
                map.put(name, have);

                have = map.get(trade.name);
                have.gold -= trade.amount;
                have.money += (trade.amount * Math.min(price, trade.price));
                System.out.println(trade.name+" "+have.gold+" "+have.money);
                map.put(trade.name, have);

                amount -= trade.amount;
                trade.amount -= trade.amount;

                removeIdx++;
            } else {
                Have have = map.get(name);
                have.gold += amount;
                have.money -= (amount * Math.min(price, trade.price));
                map.put(name, have);

                have = map.get(trade.name);
                have.gold -= amount;
                have.money += (amount * Math.min(price, trade.price));
                map.put(trade.name, have);

                trade.amount -= amount;
                amount -= amount;

                if (trade.amount == 0) {
                    removeIdx++;
                }
                break;
            }
        }

        for (int i=0;i<removeIdx;i++) {
            sell.remove(0);
        }

        if (amount > 0) {
            buy.add(new Buy(name, amount, price, seq));
            Collections.sort(buy);
        }
    }

    public void sell(String name, int amount, int price, int seq) {
        System.out.println("Trade "+name+" sell +"+amount+" "+price);
        int removeIdx=0;

        for (int i = 0; i < buy.size(); i++) {
            Buy trade = buy.get(i);
            System.out.println(trade.name+" buy : "+trade.price+" "+trade.amount);
            if (price > trade.price) {
                System.out.println("fail");
                break;
            }

            System.out.println("success");
            if (amount > trade.amount) {
                Have have = map.get(name);
                have.gold -= trade.amount;
                have.money += (trade.amount * Math.min(price, trade.price));
                System.out.println(name+" "+have.gold+" "+have.money);
                map.put(name, have);

                have = map.get(trade.name);
                have.gold += trade.amount;
                have.money -= (trade.amount * Math.min(price, trade.price));
                System.out.println(trade.name+" "+have.gold+" "+have.money);
                map.put(trade.name, have);

                amount -= trade.amount;
                trade.amount -= trade.amount;

                removeIdx++;
            } else {
                Have have = map.get(name);
                have.gold -= amount;
                have.money += (amount * Math.min(price, trade.price));
                System.out.println(name+" "+have.gold+" "+have.money);
                map.put(name, have);

                have = map.get(trade.name);
                have.gold += amount;
                have.money -= (amount * Math.min(price, trade.price));
                System.out.println(trade.name+" "+have.gold+" "+have.money);
                map.put(trade.name, have);

                trade.amount -= amount;
                amount -= amount;

                if (trade.amount == 0) {
                    removeIdx++;
                }
                break;
            }
        }

        for (int i=0;i<removeIdx;i++) {
            buy.remove(0);
        }

        if (amount > 0) {
            sell.add(new Sell(name, amount, price, seq));
            Collections.sort(sell);
        }
    }

    public String[] solution(String[] req_id, int[][] req_info) {
        map = new HashMap<>();
        for (int i = 0; i < req_id.length; i++) map.put(req_id[i], new Have(0, 0));
        sell = new ArrayList<>();
        buy = new ArrayList<>();

        for (int i = 0; i < req_id.length; i++) {
            if (req_info[i][0] == 0) { // buy
                buy(req_id[i], req_info[i][1], req_info[i][2], i);
            } else {
                sell(req_id[i], req_info[i][1], req_info[i][2], i);
            }
        }

        Iterator<String> iter = map.keySet().iterator();
        ArrayList<String> names = new ArrayList<>();
        while (iter.hasNext()) {
            names.add(iter.next());
        }

        Collections.sort(names);
        String[] answer = new String[names.size()];
        for (int i=0;i<names.size();i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(names.get(i)).append(' ');
            Have have = map.get(names.get(i));
            if (have.gold > 0) {
                sb.append('+');
            }
            sb.append(have.gold).append(' ');


            if (have.money > 0) {
                sb.append('+');
            }
            sb.append(have.money);

            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex06_2 main = new Ex06_2();
        String[] req_id = {"William", "Andy", "Rohan", "Rohan", "Louis", "Andy"};
        int[][] req_info = {{1, 7, 20}, {0, 10, 10}, {1, 10, 40}, {1, 4, 25}, {0, 5, 11}, {0, 20, 30}};
        System.out.println(Arrays.toString(main.solution(req_id, req_info)));
//        ["Andy +11 -240", "Louis 0 0", "Rohan -4 +100", "William -7 +140"}

        String[] req_id2 = {"Morgan", "Teo", "Covy", "Covy", "Felix"};
        int[][] req_info2 = {{0, 10, 50}, {1, 35, 70}, {0, 10, 30}, {0, 10, 50}, {1, 11, 40}};
        System.out.println(Arrays.toString(main.solution(req_id2, req_info2)));
//        ["Covy +1 -40", "Felix -11 +440", "Morgan +10 -400", "Teo 0 0"]
//        System.out.println(main.solutions());
//        System.out.println(Arrays.toString(main.solutions()));
    }
}
