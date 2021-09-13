# Sample Project 셋팅 순서

 - Docker 설치 - https://docs.docker.com/compose/install/ (docker-compose를 실행할 수 있어야 한다.)
    - windows의 경우 WSL2가 설정이 된 상태여야한다. (https://www.44bits.io/ko/post/wsl2-install-and-basic-usage)
    - 과제 : docker에 관해서 조사 
 - Mysql 설치
    - docker-compose 참고 (https://docs.microsoft.com/ko-kr/visualstudio/docker/tutorials/use-docker-compose)
    - docker-compose 폴더의 mysql.yml을 이용함
    - docker-compose -f mysql.yml up -d
 - Mysql Workbench 설치 
    - https://dev.mysql.com/downloads/workbench/
    - 설치한 Mysql 서버 연결
 - POST MAN 설치한다 (rest client tool)
 - Local DB에 접속해서 Table을 만든다. (테이블을 만들때는 ERD를 이용해서 만들어보자)
    - user
    - login_history
    - 두 테이블은 1:N 관계다
 - openjdk 11을 다운로드 받고 설치한다. (https://jdk.java.net/archive/) 11 GA버전으로
 - Spring boot project를 만든다. (https://start.spring.io/)
    - Gradle, Java 11, Spring boot 2.5.3 버전으로 만든다.
    - dependency : Spring web, Mysql Driver, Mybatis Framework를 추가한다.
    - lombok을 추가한다.
        - compileOnly "org.projectlombok:lombok:1.18.20"
	    - annotationProcessor "org.projectlombok:lombok"
        - intelij - settings -> annotation processor를 검색해서 Enable 해준다.
 - 과제 : Spring bean에 관하여 조사
 - 과제 : @PathVariable, @RequestParam, @RequestBody 관하여 조사
 - Spring boot project를 Intellij 에서 연다.
    - src - resources - application.properties를 열어서 db접속 설정을 한다.
    - application.properties 파일에서 mybatis config 설정을 한다.
        - src - resources 안에 mybatis-config.xml 파일을 만들어 설정을 한다.
        - src - resources 안에 mybatis 폴더를 만들고 안에 mapper 파일을 넣는다.
 # 요구사항
 - API를 개발한다.
     - 회원가입
     - 회원존재하는지 체크 (중복 체크)
     - 회원정보 불러오기
     - 회원정보수정
     - 회원탈퇴

# 검색해볼 키워드
 - spring boot mybatis 
 - mysql docker 설치
 - form tag
 - ajax
 - mysql insert update delete select
 - mysql workbench erd
 - post man api
 - openjdk 11 설치
 - lombok 이란 
 