package org.hsl.sample_api.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isNotValidEmail(final String email) {
        String regExp = "^[0-9a-zA-Z._%+-]+@[0-9a-zA-Z.-]+\\.[a-zA-Z]+$";
        boolean result = !Pattern.matches(regExp, email);

        return result;
    }

    public static boolean isValidEmail(final String email) {
        return !isNotValidEmail(email);
    }

}
