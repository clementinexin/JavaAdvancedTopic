/**
 * Created by daijiajia on 2016/12/16.
 */
@Configuration
@ComponentScan(basePackages = {"xx.xxx.xx"})
@PropertySources(value = {
        @PropertySource("classpath:application.yml"),
        @PropertySource("classpath:test-application.yml")
})
@EnableAutoConfiguration
public class IntegrationTestConfiguration {
}
