# 🏦 은행 환전 JPA

#### - 고객(User)과 통화(Currency) 간의 연관관계
#### - 환전 요청 중간 테이블
- 고객 고유 식별자 
- 환전 대상 통화 식별자 
- 환전 전 금액
- 환전 후 금액
- 상태

#### 요구 사항

- 한 고객이 여러 통화로 환전할 수 있고 한 통화는 여러 고객들에 의해 환전될 수 있다.
- 환전 요청 테이블은 중간 테이블이고 User와 Currency 간 관계를 관리한다.

### 환전 요청 수행
- 환전 후 금액 = 환전 전 금액 / 환율 (환전 후 금액에 대해 소수점 두번째 반올림 수행)

### 환전 요청 조회
- 고객 고유 식별자를 기반으로 특정 고객이 수행한 환전 요청 조회

### 특정 환전 요청 상태를 취소로 변경
- 상태 값은 NORMAL or CANCELLED

### 환전 요청 삭제
- 고객이 삭제될 때 해당 고객이 수행한 모든 환전 요청 삭제 
  - CASCADE, 영속성 전이

### API 명세서와 ERD
<details>
  <summary>자세히 보기</summary>
  https://www.notion.so/CH-4-14a1a3a45274807488b3d22c09b91972
</details>