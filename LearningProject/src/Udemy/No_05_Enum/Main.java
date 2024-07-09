package Udemy.No_05_Enum;

public class Main {
    public static void main(String[] args) {
        // 沒有 enum 以前, 都使用 public static final int
        Person p1 = new Person("Wilson", Nationality.CANADIAN);
        Person p2 = new Person("Grace", Nationality.JAPANESE);
        
        // 缺點：但是如果兩個相加會出問題: 加拿大人跟日本人混血變成中國人？
        Person p3 = new Person("Baby", Nationality.CANADIAN + Nationality.JAPANESE);
        
        // 缺點：假如直接寫數值, 但是未來1不再是CANADIAN, 2不再是JAPANESE, 就需要回來再修改數值
        p1 = new Person("Wilson", 1);
        p2 = new Person("Grace", 2);
        
        // 缺點：假如數值定義就錯了, CANADIAN 跟 JAPANESE 都是 2
        
        // Enum
        EnumPerson p4 = new EnumPerson("Wilson", EnumNationality.CANADIAN);
        EnumPerson p5 = new EnumPerson("Grace", EnumNationality.JAPANESE);

        /*
         * 使用 enum 可以跟 public static final int 做區分
         * 以前可以 int color = Constants.RED; 
         * 然後 color 被指定成 不存在於 Constants 的數值
         * 
         * 現在是 Color color = Color.RED; 
         * 無法賦予超過 enum 範圍的值
         * 
         * 編譯器會進行檢查
         * 
         */

    }
}
