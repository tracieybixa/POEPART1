import org.example.Login;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    // ---------- USERNAME TESTS ----------
    @Test
    public void testValidUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("KYL_1"));
    }

    @Test
    public void testInvalidUserName() {
        Login login = new Login();
        assertFalse(login.checkUserName("KYL!")); // no underscore
    }

    // ---------- PASSWORD TESTS ----------
    @Test
    public void testValidPassword() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&se@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password")); // too weak
    }

    // ---- PHONE NUMBER TESTS ----
    @Test
    public void testValidPhoneNumber() {
        Login login = new Login();
        assertTrue(login.checkPhoneNumber("+2783049679"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        Login login = new Login();
        assertFalse(login.checkPhoneNumber("08904655"));
    }

    // --- REGISTER USER TESTS -----
    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        String result = login.registerUser("KYL_1", "Ch&&se@ke99!", "+2783049679");
        assertTrue(result.contains("User registered successfully"));
    }

    @Test
    public void testRegisterUserFail() {
        Login login = new Login();
        String result = login.registerUser("KYL", "password", "08904655");
        assertNotEquals("Username and password successfully captured. User registered successfully!", result);
    }

    // ------- LOGIN TESTS -------
    @Test
    public void testLoginSuccess() {
        Login login = new Login();
        login.registerUser("KYL_1", "Ch&&se@ke99!", "+2783049679");
        assertTrue(login.loginUser("KYL_1", "Ch&&se@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        Login login = new Login();
        login.registerUser("KYL_1", "Ch&&se@ke99!", "+2783049679");
        assertFalse(login.loginUser("KYL_1", "wrongPass"));
    }

    // ---------- RETURN LOGIN STATUS TESTS ----------
    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.registerUser("KYL_1", "Ch&&se@ke99!", "+2783049679");
        String status = login.returnLoginStatus("KYL_1", "Ch&&se@ke99!", "Kyle", "Smith");
        assertEquals("Welcome, Kyle Smith! It's great to see you again.", status);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        login.registerUser("KYL_1", "Ch&&se@ke99!", "+2783049679");
        String status = login.returnLoginStatus("KYL_1", "wrongPass", "Kyle", "Smith");
        assertEquals("Username or password is incorrect, please try again.", status);
    }
}