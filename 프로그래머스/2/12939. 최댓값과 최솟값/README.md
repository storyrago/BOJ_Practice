# [level 2] 최댓값과 최솟값 - 12939 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12939) 

### 피드백
1. 문자열로된 여러 숫자들을 int형 배열에 집어넣을 때 stream API 를 사용하면 코드를 더욱 간결하게 작성가능하지만 극한의 성능 최적화가 필요하거나 아주 작은 단위 반복문에서는 기존 for문이 더 빠를 수 있다.
ex) Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

### 성능 요약

메모리: 79.5 MB, 시간: 11.83 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 28일 23:12:51

### 문제 설명

<p>문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.<br>
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.</p>

<h5>제한 조건</h5>

<ul>
<li>s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th style="text-align: center">return</th>
</tr>
</thead>
        <tbody><tr>
<td>"1 2 3 4"</td>
<td style="text-align: center">"1 4"</td>
</tr>
<tr>
<td>"-1 -2 -3 -4"</td>
<td style="text-align: center">"-4 -1"</td>
</tr>
<tr>
<td>"-1 -1"</td>
<td style="text-align: center">"-1 -1"</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
