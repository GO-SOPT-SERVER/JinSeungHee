## 💸 객체지향 개념을 활용하여 은행 구현해보기

## 기능 명세

### 사용자

- [x] 회원가입
- [x] 입금
- [x] 출금

### 계좌

- [x] 계좌 개설
- [x] 계좌번호 랜덤 생성 기능

## 객체들의 역할 -> SRP

- 하나의 객체가 하나의 역할만 하도록 역할을 분리

### Account 관련

1. Account : 계좌에 대하여 정의
2. AccountRepository : 계좌 관련 DB 저장 및 조회
3. AccountType : 계좌의 종류에 대하여 정의
4. TransactionType : 계좌를 이용한 거래의 종류에 대하여 정의
5. AccountRegisterDto : 계좌를 등록할 시에 사용하는 dto
6. AccountService : 저축 계좌, 입출금 계좌에 공통적으로 사용되는 비지니스 로직 명시
7. ChequingAccountService : 입출금 계좌에 사용되는 비지니스 로직 구현
8. SavingsAccountService : 저축계좌에 사용되는 비지니스 로직 구현
9. AccountController : 클라이언트로부터 들어온 계좌 관련 요청을 처리
10. LogGenerator : 계좌 거래 기록을 위해 일정한 형태로 가공
11. NumberGenerator : 계좌번호를 난수로 생성

### User 관련

1. User : 사용자에 대하여 정의
2. UserRepository : 사용자 관련 DB 저장 및 조회
3. UserService : 사용자 관련 비지니스 로직 구현
4. UserRegisterDto : 사용자 등록 시에 사용하는 dto
5. UserController : 클라이언트로부터 들어온 사용자 관련 요청을 처리

### 기타

1. CommandSign : 사용자의 입력값의 의미와 사인에 대하여 저장
2. BankController : 클라이언트의 요청을 처리
3. BankView : 입출력

## 활용 개념

1. 캡슐화

- UserRegisterDto, AccountRegisterDto: Dto 를 이용하여 클라이언트의 입력값을 캡슐화

1. 변경될 필요가 없는 파라미터에 안정성을 위해 final 키워드 사용
2. 전역적으로 접근할 수 있는 상수는 static final 이용
    - 계좌번호 관련 정보, 계좌 개설 가능 연령
    - 클라이언트가 입력하는 입력값에 대한 정보
3. 다형성
    - 계좌를 저축 / 입출금 계좌로 나누어 인터페이스에 정의된 register, deposit, withdraw 와 같은 공통적인 메서드들을 계좌의 타입에 따라서 다르게 구현
4. 추상화

- 인터페이스를 이용하여 저축 / 입출금 계좌에서 필요한 공통적인 메서드들을 정의

5. 리스코브 치환의 원칙

- SavingsAccountService, ChequingAccountService 모두 AccountService로 대체될 수 있음