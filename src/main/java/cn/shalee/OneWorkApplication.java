package cn.shalee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.shalee.dao")
public class OneWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneWorkApplication.class, args);
    }

}
