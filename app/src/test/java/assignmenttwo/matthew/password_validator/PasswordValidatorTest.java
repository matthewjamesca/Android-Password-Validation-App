package assignmenttwo.matthew.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PasswordValidatorTest {
    @Test
    public void testValidateNoString() throws Exception {
        assertFalse(MainActivity.validate(null));
    }

    @Test
    public void testValidateLessThanEightChars() throws Exception {
        assertFalse(MainActivity.validate("test"));
    }

    @Test
    public void testValidateEightChars() throws Exception {
        assertTrue(MainActivity.validate("1aB@5678"));
    }

    @Test
    public void testValidateMoreThanEight() throws Exception {
        assertTrue(MainActivity.validate("thiS2@ is longer than eight"));
    }

    @Test
    public void testValidateForStringPassword() throws Exception {
        assertFalse(MainActivity.validate("password"));
    }

    @Test
    public void testValidateForStringPasswordRandomCase() throws Exception {
        assertFalse(MainActivity.validate("PaSsWoRD"));
    }

    @Test
    public void testValidateNoUpperCase() throws Exception {
        assertFalse(MainActivity.validate("abc123@#"));
    }

    @Test
    public void testValidateNoLowerCase() throws Exception {
        assertFalse(MainActivity.validate("ABC123@#"));
    }

    @Test
    public void testValidateNoSpecialCharacters() throws Exception {
        assertFalse(MainActivity.validate("abc123456"));
    }

    @Test
    public void testValidateNoDigits() throws Exception {
        assertFalse(MainActivity.validate("abcdef@#"));
    }

    @Test
    public void testValidateWithValidPassword() throws Exception {
        assertTrue(MainActivity.validate("aBc123@#@##$"));
    }
}