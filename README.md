# 깃 사용 방법

## 1. clone 받는다.
```bash
git clone [HTTPS 형식]
# 원격저장소를 로컬저장소에 복제(깃 클론)
```

## 2. 복제한 폴더에 들어가서 잘 받아졌는지 확인

```bash
cd algo_study
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

## 5. 본인 branch에 push하기
```bash
git checkout [자기 branch 이름]
git pull origin main
git add .
git commit -m '[message]'
git push (git push -u origin [자기 branch 이름] - 처음 github에 push할때만)
```

## 6. 메인에 병합(Merge)하기
```bash
git checkout main
git merge [자신의 branch 이름]
git push origin main
```

