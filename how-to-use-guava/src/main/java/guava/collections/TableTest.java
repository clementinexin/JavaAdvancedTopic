package guava.collections;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * Created by daijiajia on 16/7/3.
 */
public class TableTest {
    public static void main(String[] args) {
//        Table

//        它具有2个Key[行,列]，对应一个值

//                HashBasedTable

        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "Rook");
        table.put(1, 2, "Knight");
        table.put(1, 3, "Bishop");
        System.out.println(table.contains(1, 1)); //true
        System.out.println(table.containsColumn(2)); //true
        System.out.println(table.containsRow(1)); //true
        System.out.println(table.containsValue("Rook")); //true
        System.out.println(table.remove(1, 3)); //Bishop
        System.out.println(table.get(3, 4)); //null

// Table views，表行列视图
        Map<Integer, String> columnMap = table.column(1);
        Map<Integer, String> rowMap = table.row(2);

    }
}
