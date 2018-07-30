package edu.zhangmeng.onlinedu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("edu.zhangmeng.onlinedu.manage.mapper")
public class OnlineduManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineduManageServiceApplication.class, args);
	}
}
