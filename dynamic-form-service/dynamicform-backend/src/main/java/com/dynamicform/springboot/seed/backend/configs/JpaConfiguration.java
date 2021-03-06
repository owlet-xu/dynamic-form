package  com.dynamicform.springboot.seed.backend.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Administrator on 2017/3/3.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.dynamicform.springboot.seed")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.dynamicform.springboot.seed"})
public class JpaConfiguration {
}
