package io.simpolor.quiz;

/***
 * Type        Bits      Range of Values
 * ----------------------------------------------------------------------------------------
 * byte         8bits    -2^7 ~ 2^7-1 (-128 ~ 127)
 * short       16bits    -2^15 ~ 2^15-1 (-32768 ~ 32767)
 * int         32bits    -2^31 ~ 2^31-1 (-2147483648 ~ 2147483647)
 * long        64bits    -2^63 ~ 2^63-1 (-9223372036854775808 ~ 9223372036854775807)
 * float       32bits    0x0.000002P-126f ~ 0x1.fffffeP+127f
 * double      64bits    0x0.0000000000001P-1022 ~ 0x1.fffffffffffffP+1023
 * char        16bits    \u0000 ~ \uffff (0 ~ 2^15-1) * 자바에서 unsgined로 동작하는 자료형
 * boolean      1bit     true, false
 */