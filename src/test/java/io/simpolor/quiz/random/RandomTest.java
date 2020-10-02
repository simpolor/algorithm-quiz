package io.simpolor.quiz.random;

import org.junit.Test;

import java.util.Random;

public class RandomTest {

    @Test
    public void testRandom(){

        Random random = new Random();

        System.out.println("random.nextInt : "+random.nextInt());
        System.out.println("random.nextLong : "+random.nextLong());
        System.out.println("random.nextFloat : "+random.nextFloat());
        System.out.println("random.nextDouble : "+random.nextDouble());
        System.out.println("random.nextBoolean : "+random.nextBoolean());
    }

    @Test
    public void testRandomByIntBound(){

        Random random = new Random();

        System.out.println("random.nextInt(10) : "+random.nextInt(10));
        System.out.println("random.nextInt(100) : "+random.nextInt(100));
        System.out.println("random.nextInt(9999) : "+random.nextInt(9999));
    }
}
