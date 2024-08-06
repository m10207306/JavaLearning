package Udemy.No_04_Map;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public Main() {
        Map<String, Integer> incomeMap = new HashMap<>();
        incomeMap.put("A", 100);
        incomeMap.put("B", 200);
        incomeMap.put("C", 300);

        // // Iterate Method 1
        // for (Map.Entry<String, Integer> entry : incomeMap.entrySet()) {
        //     System.out.println(entry.getKey() + ", " + entry.getValue());
        // }

        // // Iterate Method 2
        // incomeMap.forEach((key, val) -> {
        //     System.out.println(key + ", " + val);
        // });

        /*
         * Java 有 Hashtable 跟 Hashmap 兩個 class
         * 先有 Hashtable 才有 Hashmap
         * Hashmap faster
         * 
         * Hashtable 是 synchronized, 代表支援 multi thread (但是官方有更建議使用的 class)
         * Hashmap 不是 synchronized, 適合 非 multi thread 環境
         * Hashmap 允許 1 個 null key, 他的 value 是 0, 還有任何 key 的 value 都可以為 null
         * Hashtable key 與 value 都不可為 null
         * 
         */

    }
    public static void main(String[] args) {
        new Main();
    }
}
