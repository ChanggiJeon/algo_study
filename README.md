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
    <ul>
    <li><a href="https://www.acmicpc.net/problem/16968">차량 번호판 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/16917">양념 반 후라이드 반</a></li>
    <li><a href="https://www.acmicpc.net/problem/16922">로마 숫자 만들기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16924">십자가 찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16936">나3곱2</a></li>
    <li><a href="https://www.acmicpc.net/problem/16937">두 스티커</a></li>
    <li><a href="https://www.acmicpc.net/problem/16938">캠프 준비</a></li>
    <li><a href="https://www.acmicpc.net/problem/16943">숫자 재배치</a></li>
    <li><a href="https://www.acmicpc.net/problem/16637">괄호 추가하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/15683">감시</a></li>
    <li><a href="https://www.acmicpc.net/problem/17088">등차수열 변환</a></li>
    <li><a href="https://www.acmicpc.net/problem/15686">치킨 배달</a></li>
    <li><a href="https://www.acmicpc.net/problem/2210">숫자판 점프</a></li>
    <li><a href="https://www.acmicpc.net/problem/3019">테트리스</a></li>
    <li><a href="https://www.acmicpc.net/problem/2422">한윤정이 이탈리아에 가서 아이스크림을 사먹는데</a></li>
    <li><a href="https://www.acmicpc.net/problem/9944">NxM 보드 완주하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/17089">세 친구</a></li>
    <li><a href="https://www.acmicpc.net/problem/17406">배열 돌리기 4</a></li>
    </ul>
    <h4 id="551-">551 - 브루트 포스 - 문제 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/17070">파이프 옮기기 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/17069">파이프 옮기기 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/16638">괄호 추가하기 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/17085">십자가 2개 놓기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16987">계란으로 계란치기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16988">Baaaaaaaaaduk2 (Easy)</a></li>
    <li><a href="https://www.acmicpc.net/problem/15684">사다리 조작</a></li>
    <li><a href="https://www.acmicpc.net/problem/4902">삼각형의 값</a></li>
    <li><a href="https://www.acmicpc.net/problem/16945">매직 스퀘어로 변경하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16953">A → B</a></li>
    </ul>
    <h4 id="552-">552 - 브루트 포스 - 문제 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/16985">Maaaaaaaaaze</a></li>
    <li><a href="https://www.acmicpc.net/problem/16986">인싸들의 가위바위보</a></li>
    <li><a href="https://www.acmicpc.net/problem/17090">미로 탈출하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/12931">두 배 더하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/16958">텔레포트</a></li>
    <li><a href="https://www.acmicpc.net/problem/12908">텔레포트 3</a></li>
    <li><a href="https://www.acmicpc.net/problem/16957">체스판 위의 공</a></li>
    <li><a href="https://www.acmicpc.net/problem/16971">배열 B의 값</a></li>
    </ul>
    <h4 id="560-">560 - 브루트 포스 - 기타</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/2003">수들의 합 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/1806">부분합</a></li>
    <li><a href="https://www.acmicpc.net/problem/1644">소수의 연속합</a></li>
    <li><a href="https://www.acmicpc.net/problem/1208">부분수열의 합 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/2143">두 배열의 합</a></li>
    <li><a href="https://www.acmicpc.net/problem/7453">합이 0인 네 정수</a></li>
    </ul>
    <h4 id="612-bfs-2-">612 - BFS (연습 2)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/16956">늑대와 양</a></li>
    <li><a href="https://www.acmicpc.net/problem/5014">스타트링크</a></li>
    <li><a href="https://www.acmicpc.net/problem/9376">탈옥</a></li>
    <li><a href="https://www.acmicpc.net/problem/2251">물통</a></li>
    <li><a href="https://www.acmicpc.net/problem/16932">모양 만들기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1600">말이 되고픈 원숭이</a></li>
    <li><a href="https://www.acmicpc.net/problem/17086">아기 상어 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/4991">로봇 청소기</a></li>
    <li><a href="https://www.acmicpc.net/problem/2151">거울 설치</a></li>
    <li><a href="https://www.acmicpc.net/problem/2234">성곽</a></li>
    <li><a href="https://www.acmicpc.net/problem/12906">새로운 하노이 탑</a></li>
    <li><a href="https://www.acmicpc.net/problem/17141">연구소 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/17142">연구소 3</a></li>
    </ul>
    <h4 id="900-2">900 - 자료구조 2</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/9935">문자열 폭발</a></li>
    <li><a href="https://www.acmicpc.net/problem/6549">히스토그램에서 가장 큰 직사각형</a></li>
    <li><a href="https://www.acmicpc.net/problem/3015">오아시스 재결합</a></li>
    <li><a href="https://www.acmicpc.net/problem/1717">집합의 표현</a></li>
    <li><a href="https://www.acmicpc.net/problem/2606">바이러스</a></li>
    <li><a href="https://www.acmicpc.net/problem/11279">최대 힙</a></li>
    <li><a href="https://www.acmicpc.net/problem/1927">최소 힙</a></li>
    <li><a href="https://www.acmicpc.net/problem/1655">가운데를 말해요</a></li>
    <li><a href="https://www.acmicpc.net/problem/7785">회사에 있는 사람</a></li>
    <li><a href="https://www.acmicpc.net/problem/1764">듣보잡</a></li>
    </ul>
    <h4 id="901-2-">901 - 자료구조 2 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/3111">검열</a></li>
    <li><a href="https://www.acmicpc.net/problem/16909">카드 구매하기 3</a></li>
    <li><a href="https://www.acmicpc.net/problem/12767">Ceiling Function</a></li>
    </ul>
    <h4 id="910-1">910 - 문자열 알고리즘 1</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/16916">부분 문자열</a></li>
    <li><a href="https://www.acmicpc.net/problem/1786">찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1305">광고</a></li>
    <li><a href="https://www.acmicpc.net/problem/1701">Cubeditor</a></li>
    <li><a href="https://www.acmicpc.net/problem/14425">문자열 집합</a></li>
    <li><a href="https://www.acmicpc.net/problem/14426">접두사 찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/13505">두 수 XOR</a></li>
    <li><a href="https://www.acmicpc.net/problem/9250">문자열 집합 판별</a></li>
    <li><a href="https://www.acmicpc.net/problem/10256">돌연변이</a></li>
    </ul>
    <h4 id="911-1-">911 - 문자열 알고리즘 1 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/12104">순환 순열</a></li>
    <li><a href="https://www.acmicpc.net/problem/13506">카멜레온 부분 문자열</a></li>
    <li><a href="https://www.acmicpc.net/problem/13576">Prefix와 Suffix</a></li>
    <li><a href="https://www.acmicpc.net/problem/9202">Boggle</a></li>
    <li><a href="https://www.acmicpc.net/problem/5052">전화번호 목록</a></li>
    <li><a href="https://www.acmicpc.net/problem/13504">XOR 합</a></li>
    <li><a href="https://www.acmicpc.net/problem/13445">부분 수열 XOR</a></li>
    <li><a href="https://www.acmicpc.net/problem/2809">아스키 거리</a></li>
    </ul>
    <h4 id="912-1-">912 - 문자열 알고리즘 1 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/10538">빅 픽쳐</a></li>
    </ul>
    <h4 id="1000-2">1000 - 다이나믹 프로그래밍 2</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/11048">이동하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/11060">점프 점프</a></li>
    <li><a href="https://www.acmicpc.net/problem/15486">퇴사 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/10942">팰린드롬?</a></li>
    <li><a href="https://www.acmicpc.net/problem/15989">1, 2, 3 더하기 4</a></li>
    <li><a href="https://www.acmicpc.net/problem/11066">파일 합치기</a></li>
    <li><a href="https://www.acmicpc.net/problem/12865">평범한 배낭</a></li>
    <li><a href="https://www.acmicpc.net/problem/1495">기타리스트</a></li>
    <li><a href="https://www.acmicpc.net/problem/12869">뮤탈리스크</a></li>
    <li><a href="https://www.acmicpc.net/problem/10422">괄호</a></li>
    </ul>
    <h4 id="1001-2-">1001 - 다이나믹 프로그래밍 2 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/2293">동전 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/2294">동전 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/11058">크리보드</a></li>
    <li><a href="https://www.acmicpc.net/problem/1890">점프</a></li>
    <li><a href="https://www.acmicpc.net/problem/11049">행렬 곱셈 순서</a></li>
    <li><a href="https://www.acmicpc.net/problem/5557">1학년</a></li>
    <li><a href="https://www.acmicpc.net/problem/12969">ABC</a></li>
    <li><a href="https://www.acmicpc.net/problem/14238">출근 기록</a></li>
    <li><a href="https://www.acmicpc.net/problem/12026">BOJ 거리</a></li>
    <li><a href="https://www.acmicpc.net/problem/12996">Acka</a></li>
    <li><a href="https://www.acmicpc.net/problem/2281">데스노트</a></li>
    <li><a href="https://www.acmicpc.net/problem/3012">올바른 괄호 문자열</a></li>
    <li><a href="https://www.acmicpc.net/problem/2616">소형기관차</a></li>
    <li><a href="https://www.acmicpc.net/problem/1413">박스 안의 열쇠</a></li>
    <li><a href="https://www.acmicpc.net/problem/10564">팔굽혀펴기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1970">건배</a></li>
    <li><a href="https://www.acmicpc.net/problem/2163">초콜릿 자르기</a></li>
    </ul>
    <h4 id="1002-2-">1002 - 다이나믹 프로그래밍 2 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/12872">플레이리스트</a></li>
    <li><a href="https://www.acmicpc.net/problem/1767">N-Rook II</a></li>
    </ul>
    <h4 id="1100-1">1100 - 수학 1</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/1629">곱셈</a></li>
    <li><a href="https://www.acmicpc.net/problem/10830">행렬 제곱</a></li>
    <li><a href="https://www.acmicpc.net/problem/2747">피보나치 수</a></li>
    <li><a href="https://www.acmicpc.net/problem/2748">피보나치 수 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/2749">피보나치 수 3</a></li>
    <li><a href="https://www.acmicpc.net/problem/11444">피보나치 수 6</a></li>
    <li><a href="https://www.acmicpc.net/problem/11050">이항 계수 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/11051">이항 계수 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/17436">소수의 배수</a></li>
    </ul>
    <h4 id="1102-1-">1102 - 수학 1 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/1016">제곱 ㄴㄴ 수</a></li>
    <li><a href="https://www.acmicpc.net/problem/1557">제곱 ㄴㄴ</a></li>
    </ul>
    <h4 id="1103-1-">1103 - 수학 1 (참고)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/11402">이항 계수 4</a></li>
    <li><a href="https://www.acmicpc.net/problem/11439">이항 계수 5</a></li>
    <li><a href="https://www.acmicpc.net/problem/11689">GCD(n, k) = 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/11401">이항 계수 3</a></li>
    </ul>
    <h4 id="1110-1">1110 - 기하 알고리즘 1</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/11758">CCW</a></li>
    <li><a href="https://www.acmicpc.net/problem/2166">다각형의 면적</a></li>
    <li><a href="https://www.acmicpc.net/problem/17386">선분 교차 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/17387">선분 교차 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/1688">지민이의 테러</a></li>
    <li><a href="https://www.acmicpc.net/problem/1708">볼록 껍질</a></li>
    <li><a href="https://www.acmicpc.net/problem/2261">가장 가까운 두 점</a></li>
    <li><a href="https://www.acmicpc.net/problem/11873">최대 직사각형</a></li>
    <li><a href="https://www.acmicpc.net/problem/1689">겹치는 선분</a></li>
    <li><a href="https://www.acmicpc.net/problem/2170">선 긋기</a></li>
    </ul>
<h4 id="1200-2">1200 - 그래프 2</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/2252">줄 세우기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1766">문제집</a></li>
    <li><a href="https://www.acmicpc.net/problem/2056">작업</a></li>
    <li><a href="https://www.acmicpc.net/problem/1922">네트워크 연결</a></li>
    <li><a href="https://www.acmicpc.net/problem/1197">최소 스패닝 트리</a></li>
    <li><a href="https://www.acmicpc.net/problem/11657">타임머신</a></li>
    <li><a href="https://www.acmicpc.net/problem/1865">웜홀</a></li>
    <li><a href="https://www.acmicpc.net/problem/1916">최소비용 구하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/11779">최소비용 구하기 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/1753">최단경로</a></li>
    <li><a href="https://www.acmicpc.net/problem/11403">경로 찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/11404">플로이드</a></li>
    <li><a href="https://www.acmicpc.net/problem/11780">플로이드 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/1389">케빈 베이컨의 6단계 법칙</a></li>
    </ul>
    <h4 id="1201-2-">1201 - 그래프 2 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/1948">임계경로</a></li>
    <li><a href="https://www.acmicpc.net/problem/1504">특정한 최단 경로</a></li>
    <li><a href="https://www.acmicpc.net/problem/1162">도로포장</a></li>
    <li><a href="https://www.acmicpc.net/problem/1854">K번째 최단경로 찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1507">궁금한 민호</a></li>
    <li><a href="https://www.acmicpc.net/problem/1956">운동</a></li>
    <li><a href="https://www.acmicpc.net/problem/1533">길의 개수</a></li>
    <li><a href="https://www.acmicpc.net/problem/12930">두 가중치</a></li>
    <li><a href="https://www.acmicpc.net/problem/1412">일방통행</a></li>
    <li><a href="https://www.acmicpc.net/problem/1613">역사</a></li>
    <li><a href="https://www.acmicpc.net/problem/1647">도시 분할 계획</a></li>
    <li><a href="https://www.acmicpc.net/problem/2099">The game of death</a></li>
    </ul>
    <h4 id="1202-2-">1202 - 그래프 2 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/17361">배열 A 찾기</a></li>
    </ul>
    <h4 id="1210-2">1210 - 트리 2</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/11437">LCA</a></li>
    <li><a href="https://www.acmicpc.net/problem/1761">정점들의 거리</a></li>
    <li><a href="https://www.acmicpc.net/problem/11438">LCA 2</a></li>
    </ul>
    <h4 id="1211-2-">1211 - 트리 2 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/17435">합성함수와 쿼리</a></li>
    <li><a href="https://www.acmicpc.net/problem/3176">도로 네트워크</a></li>
    <li><a href="https://www.acmicpc.net/problem/15480">LCA와 쿼리</a></li>
    </ul>
    <h4 id="1220-bfs-2">1220 - BFS 2</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/8111">0과 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/17071">숨바꼭질 5</a></li>
    <li><a href="https://www.acmicpc.net/problem/1525">퍼즐</a></li>
    <li><a href="https://www.acmicpc.net/problem/16973">직사각형 탈출</a></li>
    <li><a href="https://www.acmicpc.net/problem/1175">배달</a></li>
    <li><a href="https://www.acmicpc.net/problem/16959">체스판 여행 1</a></li>
    <li><a href="https://www.acmicpc.net/problem/16952">체스판 여행 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/12851">숨바꼭질 2</a></li>
    <li><a href="https://www.acmicpc.net/problem/3197">백조의 호수</a></li>
    <li><a href="https://www.acmicpc.net/problem/9328">열쇠</a></li>
    <li><a href="https://www.acmicpc.net/problem/16920">확장 게임</a></li>
    <li><a href="https://www.acmicpc.net/problem/15653">구슬 탈출 4</a></li>
    <li><a href="https://www.acmicpc.net/problem/15558">점프 게임</a></li>
    </ul>
    <h4 id="1230-">1230 - 세그먼트 트리</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/10868">최솟값</a></li>
    <li><a href="https://www.acmicpc.net/problem/14438">수열과 쿼리 17</a></li>
    </ul>
    <h4 id="1240-">1240 - 펜윅 트리</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/11659">구간 합 구하기 4</a></li>
    <li><a href="https://www.acmicpc.net/problem/2015">수들의 합 4</a></li>
    <li><a href="https://www.acmicpc.net/problem/10986">나머지 합</a></li>
    <li><a href="https://www.acmicpc.net/problem/11660">구간 합 구하기 5</a></li>
    <li><a href="https://www.acmicpc.net/problem/2042">구간 합 구하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/11658">구간 합 구하기 3</a></li>
    </ul>
    <h4 id="1300-3">1300 - 다이나믹 프로그래밍 3</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/4811">알약</a></li>
    <li><a href="https://www.acmicpc.net/problem/1937">욕심쟁이 판다</a></li>
    <li><a href="https://www.acmicpc.net/problem/1520">내리막 길</a></li>
    <li><a href="https://www.acmicpc.net/problem/1915">가장 큰 정사각형</a></li>
    <li><a href="https://www.acmicpc.net/problem/15992">1, 2, 3 더하기 7</a></li>
    <li><a href="https://www.acmicpc.net/problem/16195">1, 2, 3 더하기 9</a></li>
    <li><a href="https://www.acmicpc.net/problem/1328">고층 빌딩</a></li>
    <li><a href="https://www.acmicpc.net/problem/3948">홍준이의 친위대</a></li>
    <li><a href="https://www.acmicpc.net/problem/12911">좋아하는 배열</a></li>
    <li><a href="https://www.acmicpc.net/problem/13392">방법을 출력하지 않는 숫자 맞추기</a></li>
    <li><a href="https://www.acmicpc.net/problem/2494">숫자 맞추기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1514">자물쇠</a></li>
    </ul>
    <h4 id="1301-3-">1301 - 다이나믹 프로그래밍 3 (연습)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/2169">로봇 조종하기</a></li>
    <li><a href="https://www.acmicpc.net/problem/2157">여행</a></li>
    <li><a href="https://www.acmicpc.net/problem/2228">구간 나누기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1234">크리스마스 트리</a></li>
    <li><a href="https://www.acmicpc.net/problem/2240">자두나무</a></li>
    <li><a href="https://www.acmicpc.net/problem/1983">숫자 박스</a></li>
    <li><a href="https://www.acmicpc.net/problem/2922">즐거운 단어</a></li>
    <li><a href="https://www.acmicpc.net/problem/5069">미로에 갇힌 상근</a></li>
    <li><a href="https://www.acmicpc.net/problem/2602">돌다리 건너기</a></li>
    </ul>
    <h4 id="1302-3-">1302 - 다이나믹 프로그래밍 3 (도전)</h4>
    <ul>
    <li><a href="https://www.acmicpc.net/problem/1994">등차수열</a></li>
    <li><a href="https://www.acmicpc.net/problem/1947">선물 전달</a></li>
    <li><a href="https://www.acmicpc.net/problem/2092">집합의 개수</a></li>
    <li><a href="https://www.acmicpc.net/problem/2172">팰린드롬 경로</a></li>
    <li><a href="https://www.acmicpc.net/problem/12950">팰린드롬 보행</a></li>
    <li><a href="https://www.acmicpc.net/problem/2008">사다리 게임</a></li>
    <li><a href="https://www.acmicpc.net/problem/1126">같은 탑</a></li>
    <li><a href="https://www.acmicpc.net/problem/1513">경로 찾기</a></li>
    <li><a href="https://www.acmicpc.net/problem/2618">경찰차</a></li>
    <li><a href="https://www.acmicpc.net/problem/1801">직사각형 만들기</a></li>
    <li><a href="https://www.acmicpc.net/problem/1750">서로소의 개수</a></li>
    <li><a href="https://www.acmicpc.net/problem/3644">그래프 매칭</a></li>
    </ul>
