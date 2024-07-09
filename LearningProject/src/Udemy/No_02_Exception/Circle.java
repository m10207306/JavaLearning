package Udemy.No_02_Exception;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can't be negative");
        }
        else {
            this.radius = radius;
        }
    }

    // throws: 執行此func, 如果func出錯拋出指定錯誤
    public void testThrows(String input) throws IllegalArgumentException {
        System.out.println(Double.parseDouble(input));
    }
}
