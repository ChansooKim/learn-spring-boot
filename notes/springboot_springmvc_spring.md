# SpringBoot vs SpringMVC vs Spring
***
### Spring Framework:
**Dependency Injection**
- `@Component`, `@Autowired`, Component Scan 등
- 단순한 의존성 주입(Dependency Injection)만으로는 충분하지 않음 (애플리케이션을 구축하려면 다른 프레임워크가 필요)
    - Spring Modules and Spring Projects: Spring 생태계를 확장
        - 다른 프레임워크(Hibernate/JPA, JUnit & Mockito 등)와의 우수한 통합 제공

### Spring MVC (Spring Module):
**웹 애플리케이션 및 REST API 구축 간소화**
- Struts를 사용한 웹 애플리케이션 구축은 매우 복잡했음
- `@Controller`, `@RestController`, `@RequestMapping("/courses")` 사용

### Spring Boot (Spring Project):
**빠른 애플리케이션 배포환경 구축**
- Starter Projects: 다양한 애플리케이션을 쉽게 구축할 수 있도록 지원
- Auto configuration: Spring, Spring MVC 및 기타 프레임워크 설정을 자동화하여 설정 부담 해소
- 비기능적 요구사항(NFRs) 지원:
    - Actuator: 애플리케이션의 고급 모니터링 기능 제공
    - Embedded Server: 별도의 애플리케이션 서버 불필요
    - 로깅 및 오류 처리
    - 프로파일 및 ConfigurationProperties1
