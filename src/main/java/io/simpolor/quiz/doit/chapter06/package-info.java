package io.simpolor.quiz.doit.chapter06;

/***
 * 정렬
 * - 데이터 집합을 일정한 순서로 줄지어 늘어서도록 바꾸는 작업을 말한다.
 * - 작은 데이터부터 놓는 오름차순, 큰 데이터부터 놓는 내림차순 ( 오름차순 : abc.., 내림차순 : zyx.. )
 *
 *
 * 안정된 정렬이란
 * - 같은 값의 키를 가진 요소의 순서가 정렬 전후에도 유지되는 것을 말함.
 * - 안정되지 않을 경우 같은 점수의 경우 동일하게 정렬되지 않음
 *
 *
 * 내부정렬과 외부정렬
 * - 내부정렬 : 정렬할 모든 데이터가 하나의 배열에 저장할 수 있는 경우에 사용하는 알고리즘
 * - 외부정렬 : 정렬할 데이터가 너무 많아서 하나의 배열에 저장할 수 없는 경우에 사용하는 알고리즘
 *
 *
 * 정렬 알고리즘의 핵심 요소
 * - 교환, 선택, 삽입
 * - 대부분의 정렬 알고리즘 위의 세가지 요소를 응용한 것입니다.
 *
 *
 * 버블 정렬
 * - 이웃한 두 요소의 대소 관계를 비교하여 교환을 반복합니다.
 * - 끝에 있는 두 요소부터 비교하여 왼쪽 같이 오른쪽 값보다 작도록 교환합니다.
 * - 요소의 개수가 n개인 배열에서는 n - 1회 비교, 교환하고, 가장 작은 요소가 처음으로 이동하도록 반복합니다.
 *
 *
 * 단순 선택 정렬
 * - 가장 작은 요소붙어 선택해 알맞은 위치로 옮겨서 순서대로 정렬하는 알고리즘입니다.
 *
 *
 * 단순 삽입 정렬
 * - 선택한 요소를 그보다 더 앞쪽에 알맞은 위치에 '삽입하는' 작업을 반복하여 정렬하는 알고리즘입니다.
 * - 단순 선택 정렬은 값이 가장 작은 요소를 선택해 알맞은 위치로 옮긴다는 점과 다릅니다.
 * - 장점 : 정렬을 마쳤거나, 마친 상태에 가까우면 정렬 속도가 매우 빨라집니다.
 * - 단점 : 삽입할 위치가 멀리 떨어져 있으면 이동(대입)해야하는 횟수가 많아집니다.
 *
 * 셸 정렬
 * - 단순 삽입 정렬의 장점을 살리고 단점을 보완하여 좀 더 빠르게 정렬하는 알고리즘입니다.
 * - 먼저 정렬할 배열의 요소를 그룹으로 나눠 각 그룹별로 단순 삽입 정렬을 수행하고, 그 그룹을 합치면서 정렬을 반복하여 이동 회수를 줄이는 방법입니다.
 *
 *
 * 퀵 정렬
 * - 일반적으로 사용되고 있는 아주 빠른 정렬 알고리즘입니다.
 * - 분할 정복 알고리즘으로 재귀 호출을 사용하여 구현할 수 있음
 *
 *
 * 병합 정렬
 * - 배열의 앞부분과 뒷부분을 나누어 각각 정렬한 다음 병합하는 작업을 반복하여 정렬을 수행하는 알고리즘입니다.
 *
 *
 * 클래스 객체 배열의 정렬 ( 병합 정렬 )
 * - 자연 정렬이 필요한 배열
 *   > static void sort(Object[] a)
 *   > static void sort(Object[] a, int fromIndex, int toIndex)
 * - 자연 정렬이 필요하지 않은 배열
 *   > static <T> void(T [] a, Comparator<? super T> c)
 *   > static <T> void(T [] a, int fromIndex, int toIndex, Comparator<? super T> c)
 *
 * 힙 정렬
 * - 힙 정렬은 힙을 사용하여 정렬하는 알고리즘입니다. 힙은 '부모의 값이 자식의 값보다 항상 크다'라는 조건을 만족하는 완전이진트리입니다.
 * - 이때 부모의 값이 자식보다 항상 작아도 힙이라고 합니다.
 *
 * 도수 정렬
 * - 대소 관계를 판단하지 않고 빠르게 정렬하고 있는 알고리즘
 * - 도수 정렬 알고리즘은 도수분포표 작성, 누적도수분포표 작성, 목적 배열만들기, 배열 복사 4단계로 이루어진다.
 *
 */