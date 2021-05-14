# :fire: Spring Boot-JPA

<hr>

### :question: JPA(Java Persistence API)

- 자바 ORM 기술에 대한 표준 명세로, JAVA에서 제공하는 API
- 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스 ( 라이브러리 x )
- sql 매핑이 아닌, 자바 클래스와 DB테이블을 매핑함

### :question: ORM(Object-Relation Mapping,객체-관계 매핑)

- DB와 Object 필드를 맵핑함
- 객체를 통해 간접적으로 DB 데이터를 다룸
- 객체와 디비의 데이터를 자동으로 매핑함
- SQL 쿼리가 아닌 메소드로 데이터를 조작함.
- JPA, Hibernate

<hr>

### :question: 왜 JPA를 쓰는가

:rage: <b> sql 중심 (과거) </b>

<b> 1. 반복 </b>

- DB에 객체 CRUD 작업을 하려면 너무 많은 SQL과 JDBC API 코드를 반복해야 한다.

- DB 테이블이 100개라면 위 작업을 100번 반복해야 하는 것이다.

<b> 2. SQL에 의존적인 개발 </b>

- 엔티티를 신뢰할 수 없음

- 진정한 의미의 계층 분할이 어렵다

- 필드를 하나 추가 할 때도 DAO의 CRUD 코드와 SQL 대부분을 변경해야 한다.


<b> 3. 패러다임의 불일치 </b>

- 객체와 관계형 DB는 지향하는 목적이 서로 다르다. 둘의 기능과 표현 방법도 다르다.

- 객체 구조를 테이블 구조로 저장하는 데는 한계가 있다. 이것이 객체와 관계형DB의 패러다임 불일치 문제이다.

<hr>

:smirk: <b> JPA (현재) </b>

- 자바 객체와 DB 테이블 사이의 매핑 설정을 통해 SQL을 생성한다.
- 객체를 통해 쿼리를 작성할 수 있는 JPQL(Java Persistence Query Language)를 지원
- sql 중심적인 개발에서 객체 중심적인 개발이 가능하다. 따라서 개발자는 비즈니스 로직에 집중할 수 있다.

:muscle: 생산성이 증가

:muscle: 간단한 메소드로 CRUD가 가능하다

:muscle: 유지보수가 쉽다

:muscle: Object와 RDB 간의 패러다임 불일치를 해결한다.

<hr>

