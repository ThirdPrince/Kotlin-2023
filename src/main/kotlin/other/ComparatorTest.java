package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("redpack","score","card");
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(o1 ==null){
                    return -1;
                }
                if(o2 == null){
                    return 1;
                }
                return o1.compareTo(o2);
            }
        };
        Collections.sort(list,comparator);
        System.out.println(list);

    }
}
