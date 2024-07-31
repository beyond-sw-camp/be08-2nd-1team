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

<details>
    <summary>회원가입</summary>
    <img src="https://github.com/user-attachments/assets/269ce5c3-cd51-4a9d-9c6b-1e9cb92b5b86" alt="회원가입">
</details>
<details>
    <summary>회원</summary>
    <img src="https://github.com/user-attachments/assets/157cbc17-bb8b-40b9-8b83-8c20787229ae" alt="회원">
</details>
<details>
    <summary>제품</summary>
    <img src="https://github.com/user-attachments/assets/87e01b53-d1b1-4720-8544-a3b81b4d7fdb" alt="제품">
</details>
<details>
    <summary>대여/반납</summary>
    <img src="https://github.com/user-attachments/assets/16692ea4-789b-4aa3-be66-26ad0b9ba1a8" alt="대여/반납">
</details>
<details>
    <summary>예약</summary>
     <img src="https://github.com/user-attachments/assets/26d165a0-e912-4565-b20b-8c13b2d13e67" alt="예약">
</details>
<details>
    <summary>게시글</summary>
     <img src="https://github.com/user-attachments/assets/7b1f7b46-8c1b-4972-9dfe-45223a3b71b9" alt="게시글">
</details>
<details>
    <summary>채팅</summary>
</details>
<details>
    <summary>리뷰</summary>
    <img src="https://github.com/user-attachments/assets/4db0aa17-c189-487c-aec8-6d01430d7254" alt="리뷰">
</details>
<details>
    <summary>알람</summary>
    <img src="https://github.com/user-attachments/assets/a882870f-8cce-4bea-baae-3de707feb9d4" alt="알람">
</details>
<details>
    <summary>신고</summary>
    <img src="https://github.com/user-attachments/assets/efcff866-1a88-4b2e-a4f5-44864f0c4f35" alt="신고">
</details>
<details>
    <summary>문의사항</summary>
    <img src="https://github.com/user-attachments/assets/65a2d0cc-4cd7-4cf5-bf6d-c55969a57739" alt="문의사항">
</details>


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
[테스트 결과](https://www.notion.so/a5374073e0b14bcfa7d674048bd326ee?pvs=4)
