package wiki.laona.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laona
 */
@SpringBootApplication
@MapperScan("wiki.laona.boot.mapper")
public class BlogBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBootApplication.class, args);
    }

}