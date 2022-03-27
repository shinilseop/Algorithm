package Test_Result.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Ex06 {
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
        int removeIdx=0;

        for (int i = 0; i < sell.size(); i++) {
            Sell trade = sell.get(i);
            if (price < trade.price) {
                break;
            }

            if (amount > trade.amount) {
                amount -= trade.amount;
                trade.amount -= trade.amount;

                Have have = map.get(name);
                have.gold += trade.amount;
                have.money -= (trade.amount * Math.min(price, trade.price));
                map.put(name, have);

                have = map.get(trade.name);
                have.gold -= trade.amount;
                have.money += (trade.amount * Math.min(price, trade.price));
                map.put(trade.name, have);

                removeIdx++;
            } else {
                trade.amount -= amount;
                amount -= amount;

                Have have = map.get(name);
                have.gold += amount;
                have.money -= (amount * Math.min(price, trade.price));
                map.put(name, have);

                have = map.get(trade.name);
                have.gold -= amount;
                have.money += (amount * Math.min(price, trade.price));
                map.put(name, have);

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
        int removeIdx=0;

        for (int i = 0; i < buy.size(); i++) {
            Buy trade = buy.get(i);
            if (price < trade.price) {
                continue;
            }

            if (amount > trade.amount) {
                amount -= trade.amount;
                trade.amount -= trade.amount;

                Have have = map.get(name);
                have.gold -= trade.amount;
                have.money += (trade.amount * Math.max(price, trade.price));
                map.put(name, have);

                have = map.get(trade.name);
                have.gold += trade.amount;
                have.money -= (trade.amount * Math.max(price, trade.price));
                map.put(trade.name, have);

                removeIdx++;
            } else {
                trade.amount -= amount;
                amount -= amount;

                Have have = map.get(name);
                have.gold -= amount;
                have.money += (amount * Math.max(price, trade.price));
                map.put(name, have);

                have = map.get(trade.name);
                have.gold += amount;
                have.money -= (amount * Math.max(price, trade.price));
                map.put(name, have);

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
        Ex06 main = new Ex06();
//        System.out.println(main.solutions());
//        System.out.println(Arrays.toString(main.solutions()));
    }
}
