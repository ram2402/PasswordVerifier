import PasswordVerifier.PasswordVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PasswordVerifierTest {
    @Test
    public void verifyShouldReturnFalseIfPasswordGreaterThan8Characters() {
        assertEquals(false, PasswordVerifier.verify("Abcdefghijk"));
    }

    @Test
    public void verifyShouldReturnTrueIfPasswordLessThan8Characters() {
        assertEquals(true, PasswordVerifier.verify("Abcd1"));
    }

    @Test
    public void verifyShouldReturnFalseIfPasswordIsNull() {
        assertEquals(false, PasswordVerifier.verify(null));
    }

    @Test
    public void passwordShouldHaveOneAtleastOneUpperCaseLetter() {
        assertEquals(false, PasswordVerifier.verify("abcd"));

    }

    @Test
    public void passwordShouldHaveAtleaseOneLowerCase() {
        assertEquals(false, PasswordVerifier.verify("TTT"));
    }

    @Test
    public void passwordShouldHaveAtleaseOneDigit() {
        assertEquals(false, PasswordVerifier.verify("abcT"));
    }
}
