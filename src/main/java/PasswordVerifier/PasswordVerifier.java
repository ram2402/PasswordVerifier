package PasswordVerifier;

import java.util.regex.Pattern;

public class PasswordVerifier {
    public static final boolean verify(String password) {

        if (runAllChecks(password)) return true;
        return false;
    }

    private static boolean runAllChecks(String password) {
        try {
            if (isPasswordNotNull(password)
                    && isLengthLessThan8(password)
                    && isHavingAtleaseOneUpperCase(password)
                    && isHavingAtleaseOneLowerCase(password)
                    && isHavingAtleaseOneDigit(password)) return true;
        } catch (RuntimeException e) {
            System.out.println(password+" not verified ! "+e.getMessage());
        }
        return false;
    }

    private static boolean isHavingAtleaseOneUpperCase(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z]).+$");
        if(!pattern.matcher(password).matches())
            throw new RuntimeException("Password should have atleast 1 upper case letter");
        return true;
    }

    private static boolean isHavingAtleaseOneLowerCase(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z]).+$");
        if(!pattern.matcher(password).matches())
            throw new RuntimeException("Password should have atleast 1 lower case letter");
        return true;
    }

    private static boolean isHavingAtleaseOneDigit(String password) {
        Pattern pattern = Pattern.compile("^(?=.*\\d).+$");
        if(!pattern.matcher(password).matches())
            throw new RuntimeException("Password should have atleast 1 digit");
        return true;
    }

    private static boolean isLengthLessThan8(String password) {
        if(password.length() > 8)
            throw new RuntimeException("Password should have atleast 1 upper case letter");
        return true;
    }

    private static boolean isPasswordNotNull(String password) {
        if(password == null)
            throw new RuntimeException("Password cannot be null");
        return true;
    }
}
