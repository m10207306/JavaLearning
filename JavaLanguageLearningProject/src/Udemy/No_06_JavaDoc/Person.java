/*
 * This class shows how to create a person by name and nationality 
 */
package Udemy.No_06_JavaDoc;

// TODO: 連結Class/Method的說明
public class Person {
    private String name;
    private int nationality;

    /*
     * This constructor instantiates a person by name and nationality
     * @param name person name
     * @param nationality enum nationality
     */
    public Person(String name, int nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    /*
     * Getter method for private field name
     * @return a string, person's name
     */
    public String getName() {
        return this.name;
    }
}
