package org.hsl.sample_api;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.hsl.sample_api.utils.ValidationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class SampleApplicationTests {

    @Test
    void testString() {
        //given
        String input = "http://www.Naver.com/1234";
        String result = TestClass.convert(input);

        String expected = "http www Naver com 1234";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testEmail() {
        //given
        String email1 = "test@test.com";
        String email2 = "test123@test.com";
        String email3 = "test123test.test@test.com";
        String email4 = "test-123_test@test.com";
        String email5 = "test-123_test@test-123.com";
        String email6 = "test-123_test@test-123.net";
        String email7 = "test-123_test@test-123.kr";
        String email8 = "test-123_test@test-123.asia";

        Assertions.assertEquals(ValidationUtils.isValidEmail(email1), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email2), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email3), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email4), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email5), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email6), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email7), true);
        Assertions.assertEquals(ValidationUtils.isValidEmail(email8), true);
    }
}
