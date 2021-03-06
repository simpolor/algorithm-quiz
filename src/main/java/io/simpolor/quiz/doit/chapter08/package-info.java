package io.simpolor.quiz.doit.chapter08;

/***
 * 문자열 검색이란
 * - 어떤 문자여루 안에 다른 문자열이 들어있는지 조사하고 들어있다면 그 위치는 찾아내는 것을 말합니다.
 * - 검색할 문자열을 패턴이라고 하고 문자열 원본을 텍스트라고 합니다.
 *
 * 브루트-포스법
 * - 선형 검색을 확장한 알고리즘이므로 단순법, 소박법이라고 합니다.
 *
 *
 * KMP법
 * - 패턴을 1칸씩 옮긴 다음 다시 패턴을 처음부터 검사하는 브루트-포스법과 달리 중간 검사결과를 효율적으로 사용하는 알고리즘입니다.
 * - 텍스트와 패턴의 겹치는 부분을 찾아내어 검사를 다시 시작할 위치는 구해냅니다 최소한의 횟수로 옮겨 알고리즘의 효율을 높입니다.
 *
 *
 * Boyer-Moore법
 * - KMP법보다 효율이 더 우수하여 문자열 검색에 널리 사용하는 알고리즘
 * - 패턴의 마지막 문자부터 앞쪽으로 검사를 진행하면서 일치하지 않는 문자가 있으면 미리 준비한 표에 따라 패턴을 옮길 크기를 정합니다.
 * - 패턴에 존재하는 모든 문자의 옮길 크기를 계산하고 저장해야 하기 때문에 건너뛰기 표의 요소 갯수는 Charater.MAX_VALUE + 1 입니다.
 *
 */