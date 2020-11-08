package com.infinite.lambda.primenumbers.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberServiceImplTest {

    private PrimeNumberService service;

    @BeforeEach
    void setUp() {
        service = new PrimeNumberServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("getPrimeNumbersTestData")
    void testPrimeNumber(long numberToCheck, boolean expectedAnswer) {
        boolean answerIsPrime = service.isPrime(numberToCheck);
        assertThat(answerIsPrime).isEqualTo(expectedAnswer);

    }


    @ParameterizedTest
    @MethodSource("getNextPrimeNumberTestData")
    void testGetNextPrimeNumber(long number, long expectedAnswer) {
        long nextPrimeAnswer = service.getNextPrime(number);
        assertThat(nextPrimeAnswer).isEqualTo(expectedAnswer);

    }

    private static List<Arguments> getPrimeNumbersTestData() {
        return Arrays.asList(
                Arguments.of(-5, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, true),
                Arguments.of(6, false),
                Arguments.of(7, true),
                Arguments.of(8, false),
                Arguments.of(9, false),
                Arguments.of(10, false),
                Arguments.of(11, true),
                Arguments.of(12, false),
                Arguments.of(13, true),
                Arguments.of(14, false),
                Arguments.of(15, false),
                Arguments.of(16, false),
                Arguments.of(17, true),
                Arguments.of(18, false),
                Arguments.of(19, true),
                Arguments.of(20, false),
                Arguments.of(23, true),
                Arguments.of(25, false),
                Arguments.of(49, false),
                Arguments.of(99, false),
                Arguments.of(101, true),
                Arguments.of(121, false),
                Arguments.of(283, true),
                Arguments.of(289, false),
                Arguments.of(Long.MAX_VALUE, false),
                Arguments.of(9181531581341931811L, true),
                Arguments.of(9223372036854775783L, true), //last prime number in long supported values
                Arguments.of(997153, true),
                Arguments.of(997155, false)
        );
    }

    private static List<Arguments> getNextPrimeNumberTestData() {
        return Arrays.asList(
                Arguments.of(-5, 2),
                Arguments.of(0, 2),
                Arguments.of(1, 2),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 5),
                Arguments.of(6, 7),
                Arguments.of(7, 7),
                Arguments.of(8, 11),
                Arguments.of(9, 11),
                Arguments.of(10, 11),
                Arguments.of(11, 11),
                Arguments.of(12, 13),
                Arguments.of(13, 13),
                Arguments.of(14, 17),
                Arguments.of(15, 17),
                Arguments.of(16, 17),
                Arguments.of(17, 17),
                Arguments.of(18, 19),
                Arguments.of(19, 19),
                Arguments.of(20, 23),
                Arguments.of(23, 23),
                Arguments.of(25, 29),
                Arguments.of(49, 53),
                Arguments.of(99, 101),
                Arguments.of(101, 101),
                Arguments.of(121, 127),
                Arguments.of(283, 283),
                Arguments.of(289, 293),
                Arguments.of(Long.MAX_VALUE, -1),
                Arguments.of(Long.MAX_VALUE - 1, -1),
                Arguments.of(Long.MAX_VALUE - 2, -1),
                Arguments.of(Long.MAX_VALUE - 3, -1),
                Arguments.of(9223372036854775781L, 9223372036854775783L),
                Arguments.of(9223372036854775783L, 9223372036854775783L),
                Arguments.of(9223372036854775785L, -1),
                Arguments.of(997149, 997151),
                Arguments.of(997150, 997151),
                Arguments.of(997151, 997151),
                Arguments.of(997152, 997153),
                Arguments.of(997153, 997153),
                Arguments.of(997154, 997163)
        );
    }

    @Test
    void name() {
        System.out.println(Long.MAX_VALUE);
    }
}