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


    @Test
    public void getEatTestFeline() throws Exception {

        Feline feline = new Feline();
        List <String> expectedFoodKind = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodKind = feline.eatMeat();
        Assert.assertEquals( expectedFoodKind,actualFoodKind);

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
        Assert.assertEquals("Некорректный ввод количества котят", expectedKittens, actualKittens);
    }

}
