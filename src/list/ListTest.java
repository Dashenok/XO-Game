package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dashenka on 26.08.15.
 */
public class ListTest {

    public static void main(String[] args) {
        List arrList = new ArrayList<>();
        arrList.add(12);
        Object a = arrList.get(0);
        Integer b = (Integer)arrList.get(0);
    }
}
