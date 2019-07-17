package io.simpolor.quiz.doit.chapter03;

public class GenericClassTester {

    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t){
            this.xyz = t;
        }

        T getXyz(){
            return xyz;
        }
    }

    public static void main(String[] arg){
        // 다음과 같이 파라미터에 String을 넘길 수도 있고 Integer를 넘길 수도 있습니다.
        GenericClass<String> s = new GenericClass<String>("ABC");
        GenericClass<Integer> n = new GenericClass<Integer>(15);

        System.out.println(s.getXyz());
        System.out.println(s.getXyz());
    }
}