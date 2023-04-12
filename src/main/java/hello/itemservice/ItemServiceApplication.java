package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
@Slf4j
//@Import(JdbcTemplateV3Config.class)
//@Import(MyBatisConfig.class)
//@Import(JpaConfig.class)
//@Import(SpringDataConfig.class)
//@Import(QuerydslConfig.class)
@Import(V2Config.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

//	@Bean
//	@Profile("test")
//	public DataSource dataSource() {
//		log.info("메모리 데이터베이스 초기화");
////		DriverManagerDataSource dataSource = new DriverManagerDataSource();
////		dataSource.setDriverClassName("org.h2.Driver");
////		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
////		dataSource.setUrl("sa");
////		dataSource.setPassword("");
////		return dataSource;
//
//		EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.H2)
//				.setName("test")
//				.build();
//		return embeddedDatabase;
//	}

}
