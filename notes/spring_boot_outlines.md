# SpringBoot 개요
***
SpringBoot 전에는 프로젝트 셋업이 쉽지 않았다.
1. 의존성 관리
    - 기초적인 의존성에 대한 것을 설정해야 하고, 그 버전을 관리해야 했다
2. web.xml
    - Spring Context에서 여러 설정을 제공해야 했다
3. Spring Config
    - 컴포넌트 스캔 정의, View Resolver 등의 설정이 필요했다
4. NFRs(Non Functional Requirements)
    - 로깅, 에러 핸들링, 모니터링 등

위 모든 작업들을 새로운 프로젝트를 만들 때 마다 반복해야 했다.


### SpringBoot의 목표
***
1. 프로덕션 환경에서 사용 가능한 애플리케이션을 빠르게 빌드하는 것
    - Spring Initializr
    - Spring Boot Starter Projects
    - Spring Boot Auto Configuration
    - Spring Boot DevTools
2. 프로적션 환경에서 사용할 수 있게 준비하는 것
    - 로깅
    - 환경 별 설정 (Profiles, ConfigurationProperties)
    - 모니터링 (Spring Boot Actuator)


#### Spring initializr
***
url: start.spring.io

MO 로 된 SpringBoot 버전을 선택
M: Milestone
SNAPSHOT: SpringBoot팀에서 개발중인 버전으로, 사용하지 않는 것이 좋음

JSON Formatter -> chrome 사용 시 JSON을 beautify해줌