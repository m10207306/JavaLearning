package optionalClass;

import java.util.List;
import java.util.Optional;

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango");

        Optional<String> optional = fruits.stream()
            .filter(fruit -> fruit.startsWith("c"))
            .findFirst();

        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> empty = Optional.empty();
    }
}
