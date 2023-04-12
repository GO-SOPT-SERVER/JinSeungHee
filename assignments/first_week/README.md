## 💸 객체지향 개념을 활용하여 은행 구현해보기

### 사용자

- [ ] 회원가입
- [ ] 입금
- [ ] 출금
- [ ] 내역 조회

### 계좌

- [ ] 계좌 개설
- [ ] 계좌번호 랜덤 생성 기능

### 객체들의 역할

1. Account : 계좌에 대하여 정의한다.
2. User : 사용자에 대하여 정의한다.
3. NumberGenerator : 계좌번호를 난수를 이용해 생성한다.
4. UserService : 사용자와 관련된 서비스들을 인터페이스에 정의한다.
    - 회원가입
5. AccountService : 계좌와 관련된 서비스들을 인터페이스에 정의한다.
    - 계좌 생성
6. UserRegisterDto : 회원가입 시 정보를 캡슐화
7. AccountRegisterDto : 계좌생성 시 정보를 캡슐화

### 활용 개념

1. 캡슐화

- UserRegisterDto

2. 변경될 필요가 없는 파라미터에 안정성을 위해 final 키워드
3. getter 를 지양하는 대신 메시지를 던짐
    - User.isAccountAvailableAge
4. 전역적으로 접근할 수 있는 상수는 static final 이용
    - 계좌번호 관련 정보, 계좌 개설 가능 연령
5. 다형성
    - 계좌를 저축 / 입출금 계좌로 나누어 인터페이스에 정의된 register, deposit, withdraw 와 같은 공통적인 메서드들을 계좌의 타입에 따라서 다르게 구현
6. 추상화

- 인터페이스를 이용하여 저축 / 입출금 계좌에서 필요한 공통적인 메서드들을 정의

7. 리스코브 치환의 원칙

- SavingsAccount, ChequingAccount 객체들 모두 Account로 대체될 수 있음