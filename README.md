# 깃 사용 방법

## 1. clone 받는다.
```bash
git clone [HTTPS 형식]
# 원격저장소를 로컬저장소에 복제(깃 클론)
```

## 2. 복제한 폴더에 들어가서 잘 받아졌는지 확인

```bash
cd SSAFY_STUDY
# 복제한 로컬저장소로 이동

git log
# 기존에 있던 로그 확인

git branch -a
# 기존에 있던 branch 확인
```

## 3. branch 생성

```bash
git branch [생성할 이름]
```

## 4. branch 이동

```bash
git checkout [이동할 branch 이름]
```

## 5. 작업한거 add, commit, pull, push 하기
#### 전체적인 순서는 pull main&mybranch -> add/commit/push(mybranch) -> merge (main) -> push(main) 입니다 
```bash
git checkout [자기 branch 이름]
git pull origin main
git add .
git commit -m '[message]'
git push [자신의 branch 이름]
git checkout main
git merge [자신의 branch 이름]
git push origin main
```

## 6. pull requests하기(5번에서 못넘어가겟다 -> github에서 직접 pull request 해주시면 됩니다)
git pull origin main


## 7. 문제
<h4 id="521-">521 - 브루트 포스 - 순열 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/2529">부등호</a></li>
<li><a href="https://www.acmicpc.net/problem/1339">단어 수학</a></li>
<li><a href="https://www.acmicpc.net/problem/14888">연산자 끼워넣기</a></li>
<li><a href="https://www.acmicpc.net/problem/14889">스타트와 링크</a></li>
</ul>
<h4 id="531-">531 - 브루트 포스 - 재귀 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/6603">로또</a></li>
<li><a href="https://www.acmicpc.net/problem/1182">부분수열의 합</a></li>
<li><a href="https://www.acmicpc.net/problem/14225">부분수열의 합</a></li>
<li><a href="https://www.acmicpc.net/problem/14888">연산자 끼워넣기</a></li>
<li><a href="https://www.acmicpc.net/problem/15658">연산자 끼워넣기 (2)</a></li>
<li><a href="https://www.acmicpc.net/problem/14500">테트로미노</a></li>
<li><a href="https://www.acmicpc.net/problem/16197">두 동전</a></li>
<li><a href="https://www.acmicpc.net/problem/16198">에너지 모으기</a></li>
<li><a href="https://www.acmicpc.net/problem/9663">N-Queen</a></li>
<li><a href="https://www.acmicpc.net/problem/2580">스도쿠</a></li>
<li><a href="https://www.acmicpc.net/problem/4574">스도미노쿠</a></li>
<li><a href="https://www.acmicpc.net/problem/1987">알파벳</a></li>
</ul>
<h4 id="533-">533 - 브루트 포스 - 재귀 (참고)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/14501">퇴사</a></li>
</ul>
<h4 id="541-">541 - 브루트 포스 - 비트마스크 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/14225">부분수열의 합</a></li>
<li><a href="https://www.acmicpc.net/problem/1062">가르침</a></li>
<li><a href="https://www.acmicpc.net/problem/13460">구슬 탈출 2</a></li>
<li><a href="https://www.acmicpc.net/problem/12100">2048 (Easy)</a></li>
</ul>
<h4 id="611-bfs-">611 - BFS (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/16928">뱀과 사다리 게임</a></li>
<li><a href="https://www.acmicpc.net/problem/16948">데스 나이트</a></li>
<li><a href="https://www.acmicpc.net/problem/9019">DSLR</a></li>
<li><a href="https://www.acmicpc.net/problem/14502">연구소</a></li>
<li><a href="https://www.acmicpc.net/problem/12886">돌 그룹</a></li>
<li><a href="https://www.acmicpc.net/problem/2206">벽 부수고 이동하기</a></li>
<li><a href="https://www.acmicpc.net/problem/16946">벽 부수고 이동하기 4</a></li>
<li><a href="https://www.acmicpc.net/problem/14442">벽 부수고 이동하기 2</a></li>
<li><a href="https://www.acmicpc.net/problem/16933">벽 부수고 이동하기 3</a></li>
<li><a href="https://www.acmicpc.net/problem/16954">움직이는 미로 탈출</a></li>
<li><a href="https://www.acmicpc.net/problem/3055">탈출</a></li>
<li><a href="https://www.acmicpc.net/problem/16236">아기 상어</a></li>
<li><a href="https://www.acmicpc.net/problem/6087">레이저 통신</a></li>
<li><a href="https://www.acmicpc.net/problem/1963">소수 경로</a></li>
<li><a href="https://www.acmicpc.net/problem/10026">적록색약</a></li>
<li><a href="https://www.acmicpc.net/problem/14395">4연산</a></li>
</ul>
<h4 id="710-">710 - 그리디 알고리즘</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/11047">동전 0</a></li>
<li><a href="https://www.acmicpc.net/problem/1931">회의실배정</a></li>
<li><a href="https://www.acmicpc.net/problem/11399">ATM</a></li>
<li><a href="https://www.acmicpc.net/problem/1080">행렬</a></li>
<li><a href="https://www.acmicpc.net/problem/2138">전구와 스위치</a></li>
<li><a href="https://www.acmicpc.net/problem/1285">동전 뒤집기</a></li>
<li><a href="https://www.acmicpc.net/problem/1202">보석 도둑</a></li>
<li><a href="https://www.acmicpc.net/problem/2109">순회강연</a></li>
<li><a href="https://www.acmicpc.net/problem/12015">가장 긴 증가하는 부분 수열 2</a></li>
</ul>
<h4 id="711-">711 - 그리디 알고리즘 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/1541">잃어버린 괄호</a></li>
<li><a href="https://www.acmicpc.net/problem/1744">수 묶기</a></li>
<li><a href="https://www.acmicpc.net/problem/2875">대회 or 인턴</a></li>
<li><a href="https://www.acmicpc.net/problem/10610">30</a></li>
<li><a href="https://www.acmicpc.net/problem/1783">병든 나이트</a></li>
<li><a href="https://www.acmicpc.net/problem/12970">AB</a></li>
<li><a href="https://www.acmicpc.net/problem/12904">A와 B</a></li>
</ul>
<h4 id="712-">712 - 그리디 알고리즘 (도전)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/1201">NMK</a></li>
<li><a href="https://www.acmicpc.net/problem/2873">롤러코스터</a></li>
<li><a href="https://www.acmicpc.net/problem/12919">A와 B 2</a></li>
</ul>
<h4 id="800-">800 - 분할 정복</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/10815">숫자 카드</a></li>
<li><a href="https://www.acmicpc.net/problem/10816">숫자 카드 2</a></li>
<li><a href="https://www.acmicpc.net/problem/11728">배열 합치기</a></li>
</ul>
<h4 id="801-">801 - 분할 정복 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/1780">종이의 개수</a></li>
<li><a href="https://www.acmicpc.net/problem/11729">하노이 탑 이동 순서</a></li>
<li><a href="https://www.acmicpc.net/problem/2263">트리의 순회</a></li>
<li><a href="https://www.acmicpc.net/problem/1074">Z</a></li>
<li><a href="https://www.acmicpc.net/problem/1891">사분면</a></li>
<li><a href="https://www.acmicpc.net/problem/2447">별 찍기 - 10</a></li>
<li><a href="https://www.acmicpc.net/problem/2448">별 찍기 - 11</a></li>
<li><a href="https://www.acmicpc.net/problem/1517">버블 소트</a></li>
</ul>
<h4 id="802-">802 - 분할 정복 (도전)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/1933">스카이라인</a></li>
<li><a href="https://www.acmicpc.net/problem/2261">가장 가까운 두 점</a></li>
</ul>
<h4 id="810-">810 - 정렬</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/2751">수 정렬하기 2</a></li>
<li><a href="https://www.acmicpc.net/problem/11650">좌표 정렬하기</a></li>
<li><a href="https://www.acmicpc.net/problem/11651">좌표 정렬하기 2</a></li>
<li><a href="https://www.acmicpc.net/problem/10814">나이순 정렬</a></li>
<li><a href="https://www.acmicpc.net/problem/10825">국영수</a></li>
<li><a href="https://www.acmicpc.net/problem/10989">수 정렬하기 3</a></li>
<li><a href="https://www.acmicpc.net/problem/11652">카드</a></li>
<li><a href="https://www.acmicpc.net/problem/1377">버블 소트</a></li>
</ul>
<h4 id="820-">820 - 이분 탐색</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/1790">수 이어 쓰기 2</a></li>
<li><a href="https://www.acmicpc.net/problem/1654">랜선 자르기</a></li>
<li><a href="https://www.acmicpc.net/problem/2805">나무 자르기</a></li>
<li><a href="https://www.acmicpc.net/problem/2110">공유기 설치</a></li>
<li><a href="https://www.acmicpc.net/problem/1939">중량제한</a></li>
<li><a href="https://www.acmicpc.net/problem/2022">사다리</a></li>
<li><a href="https://www.acmicpc.net/problem/11664">선분과 점</a></li>
</ul>
<h4 id="821-">821 - 이분 탐색 (연습)</h4>
<ul>
<li><a href="https://www.acmicpc.net/problem/2343">기타 레슨</a></li>
<li><a href="https://www.acmicpc.net/problem/13397">구간 나누기 2</a></li>
<li><a href="https://www.acmicpc.net/problem/1981">배열에서 이동</a></li>
<li><a href="https://www.acmicpc.net/problem/1300">K번째 수</a></li>
<li><a href="https://www.acmicpc.net/problem/1561">놀이 공원</a></li>
</ul>
