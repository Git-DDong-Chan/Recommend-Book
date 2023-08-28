# Recommend-Book


###주제 : chatgpt api를 활용하여 사용자의 감정에 기반한 책 추천 프로그램
<br>

![image.png](https://dev.azure.com/taegung/2c7b3894-ce2c-43ff-a406-b5cda3afb630/_apis/git/repositories/78bcf984-fd14-4eb6-8eb6-76cfe1c1953f/Items?path=/.attachments/image-986180ec-31ee-46d8-a94f-e07576809071.png&download=false&resolveLfs=true&%24format=octetStream&api-version=5.0-preview.1&sanitize=true&versionDescriptor.version=wikiMaster)

##Flow
    1. main 화면에서 추천, 위시리스트, 책꽂이 기능을 선택한다.
    2. 추천을 통해 ChatGpt Api를 가져와 OpenAi Enbedding으로 가공을 해준다.
    3. 추천해준 책리스트를 추출하여 List를 만들어준다.
    4. List에서 사용자가 원한느 책을 선택하고 확인을 누르면 책에 대한 정보는 ‘위시리스트’로 이동하게 된다.
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

- ##적용 기능
    1. Auth 기능
    2. OpenAi API
    3. MySQL
    4. SpringBoot
<br>

- ##사용되는 기술

     1. SpringBoot
     2. Bootstrap
     3. MySQL
     4. Azure Service
     5. MSA
     6. React
     7. DevOps
     8. Docker
<br>

- ##역할분담
    - 진영 김: 프로젝트 기획 및 총괄, 프론트엔드 개발
    - 민재 조: 백엔드 개발, 데이터베이스 관리
    - 태경 윤: OpenAi API 연동, 감정 분석 및 추천 알고리즘 개발

<br>

| 팀장 | 윤태경 | DataBase, Library | 기능3 |
| --- | --- | --- | --- |
| 팀원 | 김진영 | 로그인 기능, ChatGPT API 크롤링 | 기능1 |
| 팀원 | 조민재 | DataBase, Wish List | 기능2 |


<br>



##QnA 및 궁금사항

1. 회원DB,책DB 이렇게?

2. MSA방식으로 하나요?

3. 데이터베이스는 뭘 쓰나요?

4. 프론트는 신경쓰지말고 나중에 부트스트랩으로 하면 되나여?

5. 근데 chatgpt 구현이 되어야 뒤에 두개 기능이 가능한거 아닌가요?

6. ChatGPT 기능은 구현시에 텍스트 추출하는 것까지 해야하나요?

7. 텍스트 파일을 DB에 넣는게 위시리스트DB구현인거죠?

<br>



