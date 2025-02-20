# 프로덕션 환경 배포 준비

### Profile
***
`application.properties`
`application-dev.properties`
`application-prod.properties`
처럼 프로퍼티를 환경 별로 나눠 저장하고

application.properties에 `spring.profiles.active=dev`를 추가하여 환경을 지정한다.

```
logging.level.org.springframework=debug
```
로깅 수준
trace: 로그에 있는 모든 정보를 출력
debug: 훨씬 더 많은 정보를 출력
info: info 수준에서 로깅된 모든 정보 출력
warning: error보다 조금 더 많은 정보 출력
error: 오류와 예외만 출력
off: 전체 로깅 끔

환경이 다를 수록 로깅 레벨도 달라져야 한다.

### ConfigurationProperties
***
> 애플리케이션을 위해 애플리케이션 설정을 많이 생성하려는 경우 SpringBoot에서 권장하는 방식은 configuration properties 사용이다.

모든 애플리케이션 관련 설정을 위한 중앙집중화된 클래스의 역할을 한다

@ConfigurationProperties 클래스
``` java
@ConfigurationProperties(prefix = "currency-service")  
@Component  
public class CurrencyServiceConfiguration {  
    private String url;  
    private String username;  
    private String key;  
  
    public String getUrl() {  
        return url;  
    }  
  
    public void setUrl(String url) {  
        this.url = url;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getKey() {  
        return key;  
    }  
  
    public void setKey(String key) {  
        this.key = key;  
    }  
}
```

properties 정의
```
currency-service.url=http://default.in28minutes.com  
currency-service.username=defaultusername  
currency-service.key=defaultkey
```
```
currency-service.url=http://dev.in28minutes.com  
currency-service.username=devusername  
currency-service.key=devkey
```

``` java
@RestController  
public class CurrencyConfigurationController {  
  
    @Autowired  
    private CurrencyServiceConfiguration currencyServiceConfiguration;  
  
    @RequestMapping("/currency-configuration")  
    public CurrencyServiceConfiguration retrieveAllCourses() {  
        return currencyServiceConfiguration;  
    }  
}
```
테스트 해보면 profile에 따라 configuration 값을 가져오는 것을 확인할 수 있다.


### Embedded Server
***
- 기존의 배포 방법
1. Java 설치
2. Web/Application Server 설치
    - Tomcat/WebSphere/WebLogic etc
3. WAR(Web ARchive) 배포

- Embedded Server
1. Java 설치
2. JAR 파일 실행

*웹 서버가 JAR 파일의 일부이기 때문에, 웹 서버는 설치하지 않아도 됨*

이 처럼, 배포 프로세스가 간소화됨

Embedded Server 종류
- spring-boot-starter-tomcat
- spring-boot-starter-jetty
- spring-boot-starter-undertow


### Actucator
***
SpringBoot Actuator가 제공하는 엔드포인트
1. beans: 애플리케이션에 포함된 모든 Spring beans를 확인
2. health: 애플리케이션이 제대로 작동하는지 확인
3. metrics: 애플리케이션 매트릭스 확인
4. mappings: 애플리케이션에 설정된 모든 요청 매핑 관련 세부 사항 확인
5. 등

http://localhost:8080/actuator
``` json
{
	"_links": {
		"self": {
			"href": "http://localhost:8080/actuator",
			"templated": false
		},
		"health": {
			"href": "http://localhost:8080/actuator/health",
			"templated": false
		},
		"health-path": {
			"href": "http://localhost:8080/actuator/health/{*path}",
			"templated": true
		}
	}
}
```

http://localhost:8080/actuator/health
애플리케이션의 상태 확인

일반적으로는 health만 노출하지만,
Actuator의 더 많은 기능을 사용하고 싶다면 application.properties에서 추가 엔드포인트를 설정한다.
```
management.endpoints.web.exposure.include=*
```

http://localhost:8080/actuator/metrics/http.server.requests
http.server.request에 대한 모든 정보가 표시됨

```
management.endpoints.web.exposure.include=health,metrics
```
필요한 actuator만 사용하도록 설정한다

