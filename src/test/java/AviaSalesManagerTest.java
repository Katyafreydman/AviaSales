import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AviaSalesManagerTest {
    AviaSalesRepository repository = new AviaSalesRepository();
    AviaSalesManager manager = new AviaSalesManager(repository);
    AviaSales first = new AviaSales(1, 13_000, 300, "LED", "GYD");
    AviaSales second = new AviaSales(2, 14_000, 300, "LED", "EVN");
    AviaSales thirst = new AviaSales(3, 4_000, 120, "LED", "SEE");
    AviaSales fourth = new AviaSales(4, 10_000, 300, "LED", "TBS");
    AviaSales fifth = new AviaSales(5, 12_000, 200, "LED", "MSQ");
    AviaSales sixth = new AviaSales(6, 6_000, 200, "LED", "AER");

    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
        repository.save(thirst);
        repository.save(fourth);
        repository.save(fifth);

    }

    @Test
    public void addNew() {
        repository.save(sixth);
        AviaSales[] actual = repository.findAll();
        AviaSales[] expected = new AviaSales[]{first, second, thirst, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test
    public void checkByIdPrice() {
        AviaSales[] expected = new AviaSales[]{first, second, thirst, fourth, fifth, sixth};
        AviaSales[] actual = new AviaSales[]{thirst, sixth, fourth, fifth, first, second};
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }


    @Test
    public void removeById() {
        repository.removeById(4);
        Assertions.assertEquals(repository.findAll().length, 4);
    }

    @Test
    public void sortByTime() {
        AviaSales[] actual = manager.findAll("LED", "EVN");
        AviaSales[] expected = new AviaSales[]{second};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test
    public void wrongFrom() {
        AviaSales[] actual = manager.findAll("AAA", "SEE");
        AviaSales[] expected = new AviaSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    public void wrongTo() {
        AviaSales[] actual = manager.findAll("KUF", "ААА");
        AviaSales[] expected = new AviaSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

}