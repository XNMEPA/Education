
import static org.mockito.Mockito.*;

public class App {
    private static final Happy happy = mock(Happy.class);

    public static void main(String[] args) {
        when(happy.getHappy()).thenReturn("Don't worry, by happy!");

        System.out.println(happy.getHappy());
    }
}
