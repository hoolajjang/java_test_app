Java Test Application
===

# 과제
```
[서버개발자 사전과제 프로젝트 내용]
URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro
: URL 입력폼 제공 및 결과 출력
: URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
: 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
: Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
: Database 사용은 필수 아님
```

# 개발 환경
- java 8
- spring-boot
- Gradle 2.9
- Gradle Wrapper
- MyBatis 3

# 실행 환경
- port 18181
- JVM option "-Dspring.config.location=file:{PROJECT_ROOT}/config/localhost/application.yml" 추가 필요

