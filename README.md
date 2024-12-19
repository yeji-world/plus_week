## 플러스 주차 개인과제

**1. Transactional에 대한 이해**
  - `creatReservation` 함수 내에서 하나라도 에러가 발생하면 모두 저장되지 않도록 `@Transactional` 적용
    
**2. 인가에 대한 이해**
  - `/admis`로 들어오는 요청은 `ADMIN` 권한만 할 수 있도록 API, interceptor, filter 수정
    
**3. N+1에 대한 이해**
  - N+1 문제를 방지하기 위해 `Fetch Join` 쿼리 실행
    
**4. DB 접근 최소화**
  - for문으로 각각 User 하나씩 탐색-> update -> save 하던 것을 List<User>로 한번에 받은 후 for문으로 각각 update 실행
    
**5. 동적 쿼리에 대한 이해**
  - `QueryDSL`을 활용하여 해당 조건에 맞는 쿼리 적용
  - N+1 문제 방지를 위해 각각 `Fetch Join` 사용
    
**6. 필요한 부분만 갱신하기**
  - 데이터가 null인 경우 기본값이 입력되도록 `@DynamicInsert` 적용
    
**7. 리팩토링**
  - 필요 없는 else 구문 제거
  - 컨트롤러 응답 데이터 타입을 `Dto`로 변경
  - findById 함수를 Repository Interface에서 `default` 메소드로 선언
  - String인 예약 상태값을 `Enum`으로 변경
  - @Transational로 불필요한 코드 제거
     
**8. 테스트 코드**
  - PasswordEncoder 메서드들을 BDD로 단위 테스트
  - Item Entity에서 status에 대한 제약 조건이 잘 동작하는지 BDD로 단위 테스트
