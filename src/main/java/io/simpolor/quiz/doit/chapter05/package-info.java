package io.simpolor.quiz.doit.chapter05;

/***
 * 재귀 알고리즘
 *
 * 재귀란?
 * - 자기 자신을 포함하고 다시 자기 자신을 사용하여 정의될 때 재귀적(recursive)이라고 합니다.
 * - 자기 자신을 호출하기 때문에 무한히 반복도 가능합니다.
 * - 재귀에는 직접 재귀와 간접 재귀가 있다.
 *
 * 팩토리얼
 * - 확인이 필요하다.
 * 1 * 1
 * 2 * 1
 * 3 * 2
 *
 * 유클리드 호제법
 * - 두 정수의 최대공약수를 재귀적으로 구하는 방법
 *
 *
 * 재귀 알고리즘
 * - 하양식 분석과 상향식 분석이 있음
 *
 *
 * 하노이의 탑
 * - 쌓아 놓은 원반을 최소의 횟수로 옮기기 위한 알고리즘이다.
 *
 *
 * 8퀸 알고리즘
 * - 재귀 알고리즘에 대한 이해를 돋기 위한 예제로 자주 등장
 * - 서로 공격하여 잡을 수 없도록 8개 퀸을 8x8 체스판에 놓는다.
 * - 체판 은 64개의 칸으로 이루어져서 아래와 같은 공식을 가집니다.
 *   64 x 63 x 62 x 61 x 60 x 59 x 58 x 57 = 178,462,987,637,760
 */