package io.simpolor.quiz.doit.chapter03;

/***
 * 검색 알고리즘
 * - 데이터 집합에서 원하는 값을 가진 요소를 찾아내는 방법
 *
 * 검색과 키
 * - 검색
 *   1. 국적이 한국인 사람을 찾는다.
 *   2. 나이가 21세 이상 27세 미만인 사람을 찾는다.
 *   3. 찾으려는 이름과 가장 비슷한 이름의 사람을 찾는다.
 * - 키
 *   1. 키 값과 일치하도록 지정합니다. ( 한국 )
 *   2. 키 값읠 구간을 지정합니다. ( 21세 이상 27세 미만 )
 *   3. 키 값과 비슷하도록 지정합니다. ( 발음이 가장 비슷한 이름 )
 *
 *
 * 세가지 검색 기법
 * - 선형 검색 : 무작위로 늘어놓은 데이터 모임에서 검색을 수행합니다. ( 순차검색 )
 * - 이진 검색: 일정한 규칙으로 늘어놓은 데이터 모임에서 아주 빠른 검색을 수행합니다.
 * - 해시법 : 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색을 수행합니다.
 *   * 체인법 : 같은 해시 값의 데이터를 선형 리스트로 연결하는 방법
 *   * 오픈 주소법 : 데이터를 위한 해시 값이 충돌할 때 재해시하는 방법
 *
 *
 * 무한 루프 구현
 * - while(true)
 * - for( ; ; )
 * - do{ }while(true);
 *
 *
 * 보초법
 * - 종료 검사 비용을 줄이기 위하여, 검색하고자하는 숫자를 맨 마지막에 넣으므로써, 해당값을 만나면 리턴을 하도록 수정
 *
 *
 * 이진 검색
 * - 이 알고리즘을 적용하는 전제 조건은 데이터가 키 값으로 이미 정렬되어 있다는 것이다.
 * - 이진 검색은 요소가 오름차순 또는 내림차순으로으로 정렬된 배열에서 검색하는 알고리즘
 * - 커서가 중간으로가서 크기를 비교하고 또 중간으로 가서 비교하는 것을 반복
 *
 * 복잡도
 * - 프로그램 실행 속도는 프로그램이 동작하는 하드웨어나 컴파일러의 조건에 따라 달라집니다.
 * - 알고리즘의 성능 객관적으로 평가하는 기준을 복잡도라고 합니다.
 *    ㄴ 시간 복잡도 : 실행에 필요한 시간을 평가하는 것
 *    ㄴ 공간 복잡도 : 기억 영역과 파일 공간이 얼마나 필요한가를 평가한 것
 *
 *
 * Arrays.binarySearch에 의한 이진 검색
 * - 자바 배열에서 이진 검색을 하는 메서드를 표준 라이브러리로 제공합니다.
 *
 * static int binarySearch(object[] o, object key)
 * static int binarySearch(int[] o, int key)
 *
 *
 * 클래스 메서드와 인스턴스 메서드
 * - 인스턴스 메서드 ( 비정적 메서드 )
 * - 클래스 메서드 ( 정적 메서드 )
 *
 *
 * 자연정렬 ( natural ordering )
 * - 컴퓨터의 정렬방식과 사람이 보기 편한 방식의 정렬이 다른데, 사람이 보기좋게 자연스러운 순서를 정렬하는것을 말한다.
 *
 * public interface Comparator<T>{
 *     int compare(T o1, T o2);
 *     boolean equals(Object obj);
 * }
 *
 *
 * 제네릭
 * - 처리해야 할 대상의 자료형에 의존하지 않는 클래스(인터페이스) 구현 방식
 * - 자료형 의존하지 않기 때문에 범용으로 사용할 수 있음
 * - 제네릭 클래스는 크르새 이름 바로 뒤에 <Type>같은 형식의 파라미터를 붙여 선언합니다.
 * class 클래스 이름 <파라미터> { ... }
 * class 클래스 이름 <파라미터, 파라미터> { ... }
 * interface 인터페이스 이름 <파라미터, 파라미터> { ... }
 */