
49일 동안 사용할 깃 사용 안내 가이드입니다.

본인의 브랜치를 만든 후,

해당 일에 해당하는 글을 작성합니다.

이후, main 브랜치로 Pull Request를 요청하면 끝!

---
1 깃 저장소 복제하기 (git clone + '저장소명')<br>
git clone https://github.com/ngngs/WDS_2023.git
<br><br>
2 깃 브랜치 생성하기 (git branch + '브랜치명')<br>
git branch GS_branch
<br><br>
3 깃 브랜치로 이동하기 (git checkout + '브랜치명')<br>
git checkout GS_branch
<br><br>
4 현재 브랜치 확인<br>
git branch (본인의 브랜치인지 확인)
<br><br>
5 브랜치 파일 추가<br>
git add *
혹은
git add <파일이름>
<br><br>
6 브랜치 파일 확정<br>
git commit -m "test 커밋"
<br><br>
7 원격 저장소로 보내기<br>
git push
<br><br>
8 Pull Requests 보내기<br>
Base : main <- Compare : 본인 브랜치
<br><br>
9 Merge Pull Request 완료
