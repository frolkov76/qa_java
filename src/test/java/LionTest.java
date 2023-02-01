import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;
    private final int kittensCount;




    public LionTest (String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Тестовые данные[{index}] : пол {0}, грива {1}, котят {2}")
    public static Object[][] getLionTest() {
        return new Object[][]{
                {"Самец", true, 1},
                {"Самка", false, 1},

        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void getHasMane () throws Exception {

            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        }

    @Test
    public void getFoodTestLion () throws Exception {


            Lion lion = new Lion(sex, feline);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
            Assert.assertEquals(expected, lion.getFood());
    }

    @Test
    public void getKittensTestLion () throws Exception {

            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(kittensCount);
            Assert.assertEquals(1, lion.getKittens());

    }
}

