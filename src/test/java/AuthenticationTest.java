import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationTest {

    AuthenticationService auth = new AuthenticationService();

    @Test
    public void testCorrectAuthentication() {
        assertTrue(auth.authenticate("admin123","456789"));
    }

    @Test
    public void testWrongPassword() {
        assertFalse(auth.authenticate("wrong","456789"));
    }

    @Test
    public void testWrongOTP() {
        assertFalse(auth.authenticate("admin123","000000"));
    }
}
