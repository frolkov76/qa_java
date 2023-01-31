import com.example.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;
public class FelineTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Animal animal;

    @Test
    public void getEatTestFeline() {
        try {
            Feline feline = new Feline();
            Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        } catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    exception.getMessage());
        }
    }

    @Test
    public void getFamilyTestFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Некорректный ввод семейства", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTestFeline() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Assert.assertEquals("Некорректный ввоод колличесва котят", expectedKittens, actualKittens);
    }

}
