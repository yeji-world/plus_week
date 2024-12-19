package com.example.demo.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncoderTest {

    private String rawPassword;
    private String encodedPassword;
    private String wrongPassword;

    @BeforeEach
    void setup() {
        rawPassword = "test";
        encodedPassword = PasswordEncoder.encode(rawPassword);
        wrongPassword = "rest";
    }

    @Test
    void testencode() {
        //given @BeforeEach
        //when @BeforeEach

        //then
        assertThat(encodedPassword).isNotNull();
        assertThat(encodedPassword).isNotEqualTo(rawPassword);
    }

    @Test
    void testmatches() {
        //when
        boolean matches = PasswordEncoder.matches(rawPassword, encodedPassword);

        //then
        assertThat(matches).isTrue();
    }

    @Test
    void testNotmatches() {
        //when
        boolean matches = PasswordEncoder.matches(wrongPassword, encodedPassword);

        //then
        assertThat(matches).isFalse();
    }
}