@Embedded - @Embeddable

@Bean must be --> @Configuration

@Component(value="t") --> use Autowired and Qualifier("t")
    ---> when same bean use(inheritance) --> use Primary when ambiguity occur
https://www.baeldung.com/spring-qualifier-annotation



1. check the authentication
2. generated by same user or not
3. then perform the action


define properties files and then configure
    - then define dynamic configuration based on env
