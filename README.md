# 구현 사항

 - 간단한 API 개발 및 JWT(java Web Token) 기반 로그인 구현
    - 회원 가입, 회원 로그인, 회원 정보 조회, 회원 정보 수정, 로그아웃(저장된 토큰 정보 삭제)
    - Lombok을 사용한 Client 요청 값 유효성 검증
    - @RestControllerAdvice와 @ExceptionHandler로 예외처리 일원화
    - 예외 발생 시 Slack Message로 Notification 기능
    - 정규표현식을 사용한 이메일 형식 검증 (Spring AOP 적용) 
	- POSTMAN으로 API 검증
	 
	 
 - JWT 기반 로그인 구현 (interceptor에서 random uuid 비교를 통해 token 검증)
	- Login 페이지 구현(HTML, JQuery, Ajax)
	- Login 성공 시 
	    - Token-Random UUID 값을 Redis에 저장
	    - 발급한 Token 정보를 페이지에 띄워 확인(JSP)
	- User Service 요청 시
	    - Interceptor에서 Random UUID 값으로 Token 검증 후 서비스 로직 수행
	    - Expire time이 지났을 경우 로그인 페이지로 이동
# 메모

 - Cookie, Session기반 로그인과 Token 기반 로그인의 차이
 - Lombok을 남용하면 안 된다
     - 가령 @Setter나 @AllArgsConstructor @Data 등은 잠재적인 오류를 초래할 수 있다
     - @Setter는 꼭 필요한 변수에만 사용
     - @AllArgsConstructor 사용 시 같은 type의 변수에 의미가 다른 값을 혼동하여 전달할 여지가 있으므로, Builder Pattern을 사용하자
 - Controller, Service의 역할을 분명히 하여 코드를 깔끔하게 짜는 것이 좋다.
     - Controller Layer에는 사용자(Front-End)의 요청 값에 대한 검증 로직만 구현하고, Service 로직에 대한 처리(예외 등)은 Service Layer에 구현하자
 - Apache의 Util Class들을 활용하여 값이나 객체의 null, empty 검사 코드를 깔끔하게 작성할 수 있다
 - Static class는 기본 생성자에 private 접근제한자를 사용해 불필요한 Instance 생성을 방지하는 것이 좋다
 - @RestController와 @Controller의 차이
 - @RequestBody @RequestParam @PathVariable 용도
 - Spring boot CGLIB, JDK Dynamic Porxy의 차이점
# Project Setting

 - Docker 설치 
    - windows의 경우 WSL2가 설정이 된 상태여야한다.
 - Mysql 설치
    - docker-compose -f mysql.yml up -d
 - Mysql Workbench 설치 
    - https://dev.mysql.com/downloads/workbench/
    - 설치한 Mysql 서버 연결
 - POST MAN 설치한다 (rest client tool)
 - openjdk 11 GA version
 - Spring boot project (https://start.spring.io/)
    - Gradle, Java 11, Spring boot 2.5.3 version
    - dependency : Spring web, Mysql Driver, Mybatis Framework
    - Lombok 설정
        - compileOnly "org.projectlombok:lombok:1.18.20"
        - annotationProcessor "org.projectlombok:lombok"
        - intelij - settings -> annotation processor
 - DB 접속 설정
    - src - resources - application.properties
    - application.properties 파일에서 mybatis config 설정
        - src - resources 안에 mybatis-config.xml 파일을 만들어 설정을 한다.
        - src - resources 안에 mybatis 폴더를 만들고 안에 mapper 파일을 넣는다.		
 - Redis 설치
    - docker로 redis 설치 및 redis network 생성
	- redis-cli로 redis 서버 접속


 
