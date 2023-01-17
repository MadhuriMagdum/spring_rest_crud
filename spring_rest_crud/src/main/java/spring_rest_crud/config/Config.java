package spring_rest_crud.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("spring_rest_crud")
@PropertySource("classpath:db.properties")
@EnableWebMvc
public class Config {
	@Autowired
	Environment env;
	@Bean
	public LocalSessionFactoryBean factory() {
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setPackagesToScan(new String[] {"spring_rest_crud.model"});
//		factory.setAnnotatedPackages("spring_rest_crud.config.model");
		factory.setDataSource(datasource());
		factory.setHibernateProperties(hibernateProp());
		return factory;
	}
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName(env.getRequiredProperty("database.driver"));
		d.setUsername(env.getRequiredProperty("database.user"));
		d.setUrl(env.getRequiredProperty("database.url"));
		d.setPassword(env.getRequiredProperty("database.password"));
		return d;
	}
	
	public Properties hibernateProp() {
		Properties prop=new Properties();
		prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql",env.getRequiredProperty("hibernate.show_sql") );
		prop.put("hibernate.format_sql",env.getRequiredProperty("hibernate.format_sql") );
		prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}
	
	
	

}
