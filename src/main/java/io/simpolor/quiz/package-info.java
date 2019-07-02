package io.simpolor.quiz;

/***
 * ----------------------------------------------------------------------------------------
 * 자료형의 크기
 * ----------------------------------------------------------------------------------------
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
 *
 *
 * ----------------------------------------------------------------------------------------
 * 자료형의 초깃값
 * ----------------------------------------------------------------------------------------
 * Type        초깃값
 * ----------------------------------------------------------------------------------------
 * byte         (byte) 0
 * short        (short) 0
 * int          0
 * long         0L
 * float        0.0f
 * double       0.0d
 * char         '\u0000'
 * boolean      false
 * 참조형       공백 참조 또는 null
 *
 *
 * ----------------------------------------------------------------------------------------
 * Scanner 메소드
 * ----------------------------------------------------------------------------------------
 * nextBoolean() : true/false
 * nextByte() : -128 ~ 127
 * nextShort()
 * nextInt()
 * nextLong()
 * nextFloat()
 * nextDouble()
 * next() : 문자열(스페이스, 줄 바꿈으로 문자를 구분)
 * nextLine() : 문자열 1줄
 *
 *
 * ----------------------------------------------------------------------------------------
 * 접근 제한자란?
 * ----------------------------------------------------------------------------------------
 * 제한자 종류
 * - public : 모든 접근 허용
 * - protected : 같은 패키지(폴더)의 객체, 상속 관계의 객체 허용
 * - default : 같은 패키지의 객체 허용
 * - private : 현재 객체 안에서만 허용
 *
 * 접근 제한자 사용
 * - 클래스 : public, default
 * - 생성자 : public, protected, default, private
 * - 멤버 변수 : public, protected, default, private
 * - 멤버 메서드 : public, protected, default, private
 * - 지역변수 : 접근 제한자를 사용할 수 없음
 *
 */