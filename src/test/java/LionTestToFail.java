import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;


public class LionTestToFail {

    @Mock
    private Feline feline;

    @Test
    public void lionTestExpectedException() {

        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Оно", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}