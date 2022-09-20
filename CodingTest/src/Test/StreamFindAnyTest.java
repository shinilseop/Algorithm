package Test;

import java.util.ArrayList;
import java.util.List;

public class StreamFindAnyTest {
    public static void main(String[] args) {
        String target = "test";

        List<String> list = new ArrayList<>();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.add("test");

        if(list.stream().parallel().filter(d -> d.equals(target)).findAny().isPresent()) {
            System.out.println("!");
        }
    }
}
