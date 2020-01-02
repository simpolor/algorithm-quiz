package io.simpolor.quiz.doit.chapter10;

import java.util.Scanner;

public class BinTreeTester {

    static Scanner scanner =  new Scanner(System.in);

    // 데이터 ( 회원번호 + 이름 )
    static class Data {
        public static final int NO = 1; // 번호를 입력 받습니까?
        public static final int NAME = 2; // 이름을 입력 받습니까?

        private Integer no;
        private String name;

        // 키 값
        Integer keyCode(){
            return no;
        }

        // 문자열을 반환합니다.
        public String toString(){
            return name;
        }

        // 데이터를 입력합니다.
        void scanData(String guide, int sw){
            System.out.println(guide + "할 데이터를 입력하세요.");

            if((sw & NO) == NO){
                System.out.print("번호 : ");
                no = scanner.nextInt();
            }

            if((sw & NAME) == NAME){
                System.out.print("이름 : ");
                name = scanner.next();
            }
        }
    }

    enum Menu {
        ADD ("삽입"),
        REMOVE("삭제"),
        SEARCH("검색"),
        PRINT("표시"),
        TERMINATE("종료");

        private final String message; // 출력할 문자열

        static Menu MenuAt(int idx) { // 서수가 idx인 열거를 반환
            for(Menu m : Menu.values()){
                if(m.ordinal() == idx){
                    return m;
                }
            }
            return null;
        }

        Menu(String string){
            message = string;
        }

        String getMessage(){
            return message;
        }
    }

    //  메뉴 선택
    static Menu SelectMenu(){
        int key;
        do{
            for (Menu m : Menu.values()){
                System.out.printf("(%d) %s", m.ordinal(), m.getMessage());
            }
            System.out.print(" : ");
            key = scanner.nextInt();
        }while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args){
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();
        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()){
                case ADD :
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE :
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH :
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.keyCode());
                    if(ptr != null){
                        System.out.println("그 번호의 이름은 "+ptr+"입니다.");
                    }else{
                        System.out.println("해당 데이터가 없습니다.");
                    }
                    break;

                case PRINT :
                    tree.print();
                    break;
            }

        }while (menu != Menu.TERMINATE);



    }
}
