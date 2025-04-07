# Recommend-Book


### 주제 : chatgpt api를 활용하여 사용자의 감정에 기반한 책 추천 프로그램

## 메인페이지 
![image](https://github.com/user-attachments/assets/a188857e-44a0-4ed0-9de3-468f1ceaa5d4)

## 감정 입력
![image](https://github.com/user-attachments/assets/04e1eaea-7171-43b0-bba0-5aec98a102c6)

## 책 추천
![image](https://github.com/user-attachments/assets/4dcd73a8-158a-4dba-83f3-57a99d06900d)

## 위시리스트
![image](https://github.com/user-attachments/assets/9043f1ba-bd42-4e94-a9de-24796e053830)

## 북 라이브러리
![image](https://github.com/user-attachments/assets/22b13630-131a-4561-8d45-28fdcddf01a0)

## 책 세부내용
![image](https://github.com/user-attachments/assets/60025b72-130f-4a0e-8149-006dd573973d)

<br>

![image](https://github.com/Git-DDong-Chan/Recommend-Book/assets/101232265/a842eb53-5fa8-4a74-ba51-329a92523533)

## Flow
    1. main 화면에서 추천, 위시리스트, 책꽂이 기능을 선택한다.
    2. 추천을 통해 ChatGpt Api를 가져와 OpenAi Enbedding으로 가공을 해준다.
    3. 추천해준 책리스트를 추출하여 List를 만들어준다.
    4. List에서 사용자가 원하 책을 선택하고 확인을 누르면 책에 대한 정보는 ‘위시리스트’로 이동하게 된다.
    5. 위시리스트에서 읽은 책을 선택하고 한 줄 감상평을 남긴다.
    6. 읽은 책 정보는 책꽂이로 이동하게 된다.
<br>

### 역할 축약

- [ ]  로그인 기능, ChatGPT API 크롤링
- [ ]  DataBase, Wish List
- [ ]  DataBase, Library


<br>

##구현할 기술 세분화
- **로그인 기능, ChatGPT API 크롤링**
    - 회원 가입 기능 및 로그인 기능
    - Chat GPT API 추천 시스템 구현
    - 텍스트 추출해서 LIST DataBase구현
- **DataBase, Wish List**
    - DataBase 구현
    - 읽은 책을 선택할 수 있도록 체크 리스트 구현
    - 읽은 책을 선택하면 한 줄 평을 남길 수 있도록 구현
- **DataBase, Library**
    - DataBase에서 읽은 책 정보를 불러와 보여주기
    - 검색 기능
<br>

## 적용 기능
    1. Auth 기능
    2. OpenAi API
    3. MySQL
    4. SpringBoot
<br>

## 사용되는 기술

     1. SpringBoot
     2. Bootstrap
     3. MySQL
     4. Azure Service
     5. MSA
     6. React
     7. DevOps
     8. Docker
<br>

## 역할분담
    - 진영 김: 프로젝트 기획 및 총괄, 프론트엔드 개발
    - 민재 조: 백엔드 개발, 데이터베이스 관리
    - 태경 윤: OpenAi API 연동, 감정 분석 및 추천 알고리즘 개발

<br>

| 팀장 | 윤태경 | DataBase, Library | 기능3 |
| --- | --- | --- | --- |
| 팀원 | 김진영 | 로그인 기능, ChatGPT API 크롤링 | 기능1 |
| 팀원 | 조민재 | DataBase, Wish List | 기능2 |


<br>



## QnA 및 궁금사항

1. 회원DB,책DB 이렇게?

2. MSA방식으로 하나요?

3. 데이터베이스는 뭘 쓰나요?

4. 프론트는 신경쓰지말고 나중에 부트스트랩으로 하면 되나여?

5. 근데 chatgpt 구현이 되어야 뒤에 두개 기능이 가능한거 아닌가요?

6. ChatGPT 기능은 구현시에 텍스트 추출하는 것까지 해야하나요?

7. 텍스트 파일을 DB에 넣는게 위시리스트DB구현인거죠?

<br>


