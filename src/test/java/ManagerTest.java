import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository mock = new Repository();
    Manager manage = new Manager(mock);

    Product prod1 = new Product(1, "Sad", 120);
    Product prod2 = new Product(2, "Raven", 140);
    Product prod3 = new Product(3, "Blast", 110);
    Product prod4 = new Product(4, "Process", 160);
    Product prod5 = new Product(5, "Power", 220);
    Product prod6 = new Product(6, "Turn", 300);

    Book book1 = new Book(11, "Peter Pan", 100, "Pushkin");

    Book book2 = new Book(22, "Peter Pan", 101, "Barry");

    Smartphone smart1 = new Smartphone(111, "Samsun", 11111, "Sam");

    Smartphone smart2 = new Smartphone(22, "Noka", 12221, "Finns");

    @Test
    public void searchTest() {
        manage.add(prod1);
        manage.add(prod2);
        manage.add(prod3);
        manage.add(prod4);
        manage.add(prod5);
        manage.add(prod6);

        Product[] expected = {prod1};
        Product[] actual = manage.searchBy("Sad");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void bookTest() {
        manage.add(book1);
        manage.add(book2);

        Product[] expected = {book1, book2};
        Product[] actual = manage.searchBy("Peter Pan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void smartTest() {
        manage.add(smart1);
        manage.add(smart2);

        Product[] expected = {smart2};
        Product[] actual = manage.searchBy("Noka");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        manage.add(smart1);
        manage.add(smart2);
        mock.removeById(111);


        Product[] expected = {smart2};
        Product[] actual = mock.getGoods();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByIdTest() {
        manage.add(prod1);
        manage.add(prod2);
        manage.add(prod3);
        manage.add(prod4);
        manage.add(prod5);
        manage.add(prod6);

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
