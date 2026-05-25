import org.junit.Test;
import static org.junit.Assert.*;

public class FullAppTest{

    //  Registration: Username tests
    @Test
    public void testValidUsername() {
        Registration reg = new Registration();
        assertTrue(reg.checkUsername("abc_")); // valid: <=5 chars and contains "_"
    }

    @Test
    public void testInvalidUsernameTooLong() {
        Registration reg = new Registration();
        assertFalse(reg.checkUsername("abcd_")); // too long
    }

    @Test
    public void testInvalidUsernameNoUnderscore() {
        Registration reg = new Registration();
        assertFalse(reg.checkUsername("abcd")); // missing "_"
    }

    // Registration: Password tests
    @Test
    public void testValidPassword() {
        Registration reg = new Registration();
        assertTrue(reg.checkPassword("Password!")); // has uppercase, digit, special
    }

    @Test
    public void testInvalidPasswordTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Pw1!")); // too short
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("password1!")); // no uppercase
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password!")); // missing digit
    }

    @Test
    public void testInvalidPasswordNoSpecialChar() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password1")); // missing special char
    }

    //
    //  Registration: Phone number tests
    @Test
    public void testValidPhoneNumberLocal() {
        Registration reg = new Registration();
        assertTrue(reg.checkPhoneNumber("0123456789")); // starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumberInternational() {
        Registration reg = new Registration();
        assertTrue(reg.checkPhoneNumber("+27123456789")); // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkPhoneNumber("12345")); // too short
    }

    @Test
    public void testInvalidPhoneNumberWrongPrefix() {
        Registration reg = new Registration();
        assertFalse(reg.checkPhoneNumber("9912345678")); // wrong prefix
    }

    // Login: Successful login
    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("user123", "pass123", "John", "Doe");
        String result = login.loginUser("user123", "pass123");
        assertTrue(result.startsWith("Welcome John Doe"));
    }

    // Login: Failed login
    @Test
    public void testFailedLogin() {
        Login login = new Login("user123", "pass123", "John","Doe");
        String result = login.loginUser("wrongUser", "wrongPass");
        assertEquals("Username or Password incorrect. Please try again.", result);
    }
}
