---
# 팀명       : 도레미
---
# 프로젝트명 : 놀라운 화요일 (노래,드라마,영화 퀴즈 게임)
---
---
## 프로젝트 정보
---
- 목적 : 자바를 활용하여 프로젝트 진행
- 개발 기간 : 2024.04.25 ~ 2024.05.03
- 배포 주소 :

---

## 프로젝트 소개
---
- JAVA를 활용하여 GitHub를 통해 팀으로 협력하여 학습하기 위한 프로젝트
- 로그인을 통해 영화 초성퀴즈와 노래 제목 맞추기 게임을 경험할 수 있고, 점수가 파일로 저장되어
  랭킹을 볼 수 있는 게임



---
## 구현 기능 소개
---
- 회원가입, 로그인, PW 찾기 기능  
  - 아이디 중복 체크  
  - 예외 처리  
  - 계정 파일로 저장 (txt)  
  - 계정 정보 읽어오기 (txt)
  - 아이디,비밀번호 틀리면 다시 입력하도록 구현
  - ID의 가입 당시 이름을 입력하면 PW 알려주도록 구현
  
- 게임 기능
  -힌트 및 입력 횟수 제한 기능 추가
  - 노래 제목 맞추기 게임
  - 영화 & 드라마 제목 맞추기 게임
- 랭킹 기능
   - 기존 로그인 점수에 합산 기능 추가
   - 게임 완료 후 기존 ID,SCORE 통해서 합산 하도록 구현

---
## 개발 일정
---
일정|내용|
|:------:|:---|
|4/25|주제 선정 후 컨셉 회의|
|4/26|USER 데이터 설계, 회원가입(중복 체크) 기능 구현|
|4/27~4/28| 노래 제목 맞추기, 영화 &드라마 게임 설계|
|4/29|로그인 로직 구현 - 비밀번호 입력 오류 수정|
|4/30|게임 제작- 내부 시스템 구성 / 최종 점수 저장 기능 구현|
|5/1|최종 점수 저장 안되는 버그 수정, 게임 별 로직 수정|
|5/2|게임 점수 기존 점수와 합산하는 기능 추가, 랭킹 기능 추가, 콘솔 ui 디자인 수정|
|5/3|랭킹 데이터 정리, 등수 표시, 게임<-> 메인 화면 디자인 통일화|
|5/4~ 5/6|디자인 업데이트, 버그 수정|
|5/7|README.MD 작성|


---
## 팀원 소개
---
- 🦉경곤 --팀장
  - https://github.com/ckk914
- 🐠예진
  - https://github.com/zinit95
- 🐻병모
  - https://github.com/kimbyeongmo
- 🐦혜린
  - https://github.com/hyerin11

--- 

## 역할 
---
- 🦉조경곤
  - 팀장, 회원 관리 시스템, 랭킹 관리, README 작성
     - 메인 메뉴 구현
       -숫자 아닌 데이터에 대한 예외 처리
     - 회원 관리 기능 구현
       -회원가입 (이름,ID,PW 등록)
       -로그인 기능 구현
       -PW 찾기
    - 랭킹 관리
       - 최종 점수 저장 기능
       - TOP10 랭킹 조회 기능
---
- 🐠 김예진
   - 게임 랭킹 합산 및 랭킹 관리
     - 게임 점수 관련 설계
     - 게임 2가지 점수 합산 기능 구현
     - 플레이어 랭킹 관리
     - 랭킹 조회 기능
---
- 🐦전혜린
   - 영화&드라마 초성 퀴즈 게임 / 햇님 기능 구현
     - 영화, 드라마 제목 초성 추출
     - 배열 리스트에 저장 후, 랜덤 출제
     - 한번 틀릴 때 마다 이벤트 부여
       -이모티콘 힌트 하나 제공하는 기능
       - 종료 기능
     - 목숨 기능(햇님 기능)
       - 기회 5번 제공 후, 틀릴 때 마다 햇님이 음식을 하나씩 먹는 기능
---
- 🐻 김병모
   - 노래 제목 이어 말하기 게임 / 힌트 제공 기능 구현
     - 배열 리스트에 노래 제목 저장 후, 랜덤 출제
     - 힌트 배열에 저장 후, 해당 문제의 힌트를 제공
     - 기회 소진 시, 종료, 문제 정답 출력, 입력 값 정답 여부 확인하는 로직 구현
    
---

       
     

---

## 기술스택
### 개발
<div>
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" />&nbsp
</div>

### 환경
<div>
  <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/git-007396.svg?style=for-the-badge&logo=git&logoColor=white" />&nbsp
  <img src="https://img.shields.io/badge/github-181717.svg?style=for-the-badge&logo=github&logoColor=white" />&nbsp
  
</div>

