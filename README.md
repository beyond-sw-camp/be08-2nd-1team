# 👌꿔BORROW
- 주제 : 자주 사용하지 않는 물건을 빌려주고 필요한 물건을 대여하는 서비스
- 기간 : 2024.06.24 ~ 2024.07.31

<br><br>

## 🔎 프로젝트 개요
- 코로나-19 이전에 소비심리가 얼어붙었지만 필요한 물건은 저렴하게 구매하고, 필요 없는 물건을 판매해 이익을 남기는 사람이 많아졌다.
- 사람들의 인식이 변화하면서 “이전에 비해 중고물품에 대한 거부감이 덜한 것 같다”는 설문조사를 통해 다른 사람이 사용한 물건을 재사용 하는 것에 대한 우려와 불신이 낮아진 것 알 수 있다.
- 공유 서비스를 사용하지 않은 사람들은 대부분 공유 서비스에 대한 인식이 없거나 다른 대체 수단이 많기 때문이었다. 이를 통해 꿔Borrow는 자주 사용하지 않는 물건을 빌려주고 필요한 물건을 대여하는 서비스입니다.
<br>

![image](https://github.com/user-attachments/assets/f0e12139-4ad1-4389-9dfc-e15e3cf58003)

<br>

## 🍀 기대효과
- 경제 활성화
    - 공유 서비스를 통해 물품을 공유하면서 판매자는 추가 수익을 얻고, 소비자는 구매 비용을 절약할 수 있어 자원의 유휴 시간을 줄여 효율적으로 활용함으로써 자원 활용의 효율성이 증가한다.
- 환경 보호
    - 자원의 재사용과 효율적 이용으로 환경 오염을 감소시키고, 생산 및 폐기물 감소로 탄소 발자국을 축소할 수 있어 환경 보호에 기여한다.
- 접근성 향상
    - 다양한 자원에 대한 접근성이 증대되어 경제적 약자도 고가의 자산이나 서비스를 이용할 수 있다.
- 커뮤니티 강화
    - 지역 사회 구성원 간의 신뢰와 협력이 증대되고, 상호작용을 통한 사회적 연결망이 형성되어 커뮤니티가 강화된다.

<br><br>

## 🙋‍♀️ 팀원
|**김도하**|**김민지**|**이은서**|**전현규**|**조은희**|
|:--:|:--:|:--:|:--:|:--:|
|<img src="https://github.com/user-attachments/assets/c618db9b-111d-47a0-90e6-1418d93d3d64" width="150" height="150" alt="image">|<img src = "https://github.com/user-attachments/assets/36c1552b-57a2-4f6a-9171-76afb4d98ee7" width="160" height="160" alt="image">|<img src = "https://github.com/user-attachments/assets/bed84c54-2ba4-41ed-9eb9-0aeae998d68b" width="160" height="160" alt="image">|<img src = "https://github.com/user-attachments/assets/52c27549-ba7b-45e9-937b-a1b828ccae14" width="180" height="180" alt="image">|<img src = "https://github.com/user-attachments/assets/5265dba8-d674-42fb-b55b-5d3a44fc02e7" width="150" height="150" alt="image">|


<br><br>

## 🛠️ 기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"/> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"> <img src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white"/> <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">

<br><br>

## 💡 커밋 컨벤션
Udacity Commit Convention: [Udacity Commit Convention]: https://udacity.github.io/git-styleguide/ "commit convention"

### 타입

```
태그: 제목의 형태이며, :뒤에만 space가 있음에 유의한다.
feat: 새로운 기능 추가
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
refactor: 코드 리펙토링
test: 테스트 코드, 리펙토링 테스트 코드 추가
chore: 빌드 업무 수정, 패키지 매니저 수정
```

<details>
    <summary>예시</summary>
    <details>
        <summary>코드 예시</summary>
        <pre><code>
        feat: add user authentication feature
        Implemented OAuth2 based authentication for users. This includes
        login, logout, and session management. The feature uses Spring Security
        and supports Google and Facebook OAuth2 providers.
        Issue: #123
        타입: feat (새로운 기능 추가)
        변경 요약: 사용자 인증 기능 추가
        상세 설명: OAuth2를 사용한 사용자 인증 기능을 구현했다는 설명. 로그인, 로그아웃, 세션 관리 등을 포함하며, Spring Security를 사용하고 Google과 Facebook OAuth2 제공자를 지원한다고 명시.
        이슈 번호: #123 (해당 기능과 관련된 이슈 번호)
        </code></pre>
    </details>
    <details>
        <summary>메시지 구조</summary>
        <pre><code>
        type: Subject
        body
        footer
        </code></pre>
    </details>
</details>
<br><br>

## ⏰ WBS
[WBS 문서](https://docs.google.com/spreadsheets/d/1a-3ZwOdtigPyTlqB04m4GaJN9n2l6s8l3Ynwk6f4-O4/edit?gid=1835326347#gid=1835326347)
<br>

<img src="https://github.com/user-attachments/assets/8841f1ab-f3cc-4852-a7cf-4fc2ae33bbb5" alt="요구사항 정의서">

<br><br>

## ✏️ 요구사항 정의서
[요구사항 정의서](https://docs.google.com/spreadsheets/d/1de1OOTb09UcI2-DYKo18OVN5fab_uJpg2NqqRko5mMI/edit?gid=0#gid=0)
<br>
<details>
  <summary> 테이블 정의서 내용 </summary>
    <img src="https://github.com/user-attachments/assets/a236b4d7-68fd-4556-b155-5a188c9433c9" alt="요구사항 정의서">
</details>

<br><br>

## ✏️ 테이블 정의서
[테이블 정의서](https://docs.google.com/spreadsheets/d/1HpUgxdZUnYgveYcR3vomIEtFS47pDpVH/edit?usp=sharing&ouid=102494685802367589810&rtpof=true&sd=true)
<details>
  <summary> 테이블 정의서 내용 </summary>
    <img src="https://github.com/user-attachments/assets/0e7ae674-da07-4cf3-827d-7f34f532b570" alt="테이블 정의서 내용">
</details>

<br><br>

## ✏️ ERD 설계
[ERD Cloud](https://www.erdcloud.com/d/CDfBLfLMCZDoTdqp4)
<br>

<img src="https://github.com/user-attachments/assets/69fde1fd-86f1-44d2-9773-7f0932ef7621" alt="ERD 설계 내용">

<br><br>

## 🗂️ API 명세서
[API 명세서](https://www.notion.so/API-0f35268f5c644fd7a274c48a4497e6a6?pvs=4)

<br>

### [ 회원가입 ]
![image](https://github.com/user-attachments/assets/376197bf-4948-4d0a-b118-d53751b1bc07)

### [ 회원 ]
![image](https://github.com/user-attachments/assets/3627616d-49c2-4648-876b-c6aaec3c4dbe)

### [ 제품 ]
![image](https://github.com/user-attachments/assets/1f6cabab-d72d-4a74-8874-900a1016f3f0)

### [ 대여/반납 ]
![image](https://github.com/user-attachments/assets/dc8038b0-68b2-4b83-bfa4-da70e5f189b9)

### [ 예약 ]
![image](https://github.com/user-attachments/assets/b792cf59-4f60-4bfa-97f6-f9a0fd0c7839)

### [ 게시글 ]
![image](https://github.com/user-attachments/assets/94c56c38-44f4-4a31-b3cd-01b2d8f60b66)

### [ 채팅 / 문의사항 내용 ]
![image](https://github.com/user-attachments/assets/86a0ac2c-262c-4779-ad26-f0595c421f39)

### [ 채팅 목록 ]
![image](https://github.com/user-attachments/assets/40542b72-b0a0-4999-937c-d1aa9088172d)

### [ 문의사항 목록 ]
![image](https://github.com/user-attachments/assets/823cc461-bc48-450e-be84-8c1911b12221)

### [ 리뷰 ]
![image](https://github.com/user-attachments/assets/5fdd6342-659e-4d5d-8232-b093ffed0471)

### [ 알람 ]
![image](https://github.com/user-attachments/assets/e099b8f3-e803-40cc-9689-1f257edcfe2b)

### [ 신고 ]
![image](https://github.com/user-attachments/assets/0404c2ac-2a3a-48bf-ae21-833a73e8dcba)

<br><br>

## 🎯 주요 기능
[주요 기능 서비스](https://github.com/beyond-sw-camp/be08-2nd-AOSynergy-BORROW/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5)
- 로그인, 로그아웃, 및 회원 관리 기능
- 게시글 기능
- 물품 대여 및 반납 기능
- 물품 예약 및 알림 기능
- 채팅, 문의사항 및 신고 기능

<br><br>

## 📌 테스트
- [테스트 케이스](https://docs.google.com/spreadsheets/d/143o5n9nA6vpQzF20SksNWiuAj6WC3vqVa4pi4SzSH9s/edit?usp=sharing)
- [테스트 결과](https://www.notion.so/493b2029af3649ce843d4b43082114a4?v=46642e9b3a3f4749aa40217241f08f84&pvs=4)

<br><br>

## 🎉 회고록
|**김도하**|**김민지**|**이은서**|**전현규**|**조은희**|
|:--:|:--:|:--:|:--:|:--:|
|꽤나 준비를 하는데 넉넉한 시간이라고 생각했는데 spring 강의가 시작되기도 하였고, 개발 과정에서 개선 사항이 계속 보이다 보니 시간이 부족해졌습니다. 하지만 팀원들이 모두 열심히 할 일을 하여 결과물을 낼 수 있었다고 생각합니다. |||여러 팀원과 git을 사용해서 코드를 공유하며 같이 프로젝트를 구현해 볼 수 있는 좋은 기회였던 것 같습니다. spring과 spring boot로 API를 만들고, db도 연결해 보고, swagger를 사용해 테스트까지 해보며 좋은 경험을 쌓을 수 있던 시간이었습니다. 익숙하지 않은 코드가 많아 시간이 오래 걸렸지만, 팀원들 모두 고생한 결과 잘 마무리된 것 같습니다.|수업 진도에 맞춰서 진행하니까 시간이 조금 부족했지만 주어진 시간 안에 역할을 분배하고 맡은 역할을 해낸 것 같아 뿌듯합니다. 데이터베이스 설계시 중복된 내용을 줄이기 위해서 하나의 테이블에 id 값만 가지는 테이블을 join 해서 사용했는데, 구현하다보니까 되게 복잡해졌고 처음에 테이블 설계할 때 제대로 설계하는 것이 중요하다는 것을 몸소 느꼈습니다. 다들 고생하셨습니다 !|
