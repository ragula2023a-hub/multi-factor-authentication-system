import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {

    AuthenticationService auth = new AuthenticationService();

    @Test
    public void testCorrectPasswordAndOTP() {
        assertTrue(auth.authenticate("admin123", "456789"));
    }

    @Test
    public void testWrongPassword() {
        assertFalse(auth.authenticate("wrongpass", "456789"));
    }

    @Test
    public void testWrongOTP() {
        assertFalse(auth.authenticate("admin123", "000000"));
    }

    @Test
    public void testBothWrong() {
        assertFalse(auth.authenticate("wrongpass", "000000"));
    }
}