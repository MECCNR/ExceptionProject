import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoTests {
    Repository mock = new Repository();
    Manager manage = new Manager(mock);

    Product prod1 = new Product(1, "Sad", 120);
    Product prod2 = new Product(2, "Raven", 140);

    @Test
    public void searchByIdTest() {
        manage.add(prod1);
        manage.add(prod2);

        Product[] expected = {prod1};
        Product[] actual = mock.findById(1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeExceptionTest() {
        manage.add(prod1);
        manage.add(prod2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            mock.removeById(-100);
        });
    }
}
