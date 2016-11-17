package com.niit.collaborationBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.collaborationBackEnd.model.R_Blog;
import com.niit.collaborationBackEnd.model.R_Event;
import com.niit.collaborationBackEnd.model.R_Forum;
import com.niit.collaborationBackEnd.model.R_Job;
import com.niit.collaborationBackEnd.model.R_User;

@Configuration
@ComponentScan("com.niit.collaborationBackEnd")
@EnableTransactionManagement
public class ApplicationContextConfiguration {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");		
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");		
		dataSource.setUsername("CL");		
		dataSource.setPassword("cl");		

		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle11gDialect");
		connectionProperties.setProperty("hibernate.format_sql", "true");
		connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
		dataSource.setConnectionProperties(connectionProperties);
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClass(R_Blog.class);
		sessionBuilder.addAnnotatedClass(R_Event.class);
		sessionBuilder.addAnnotatedClass(R_User.class);
		sessionBuilder.addAnnotatedClass(R_Forum.class);
		sessionBuilder.addAnnotatedClass(R_Job.class);
		//sessionBuilder.addAnnotatedClass(R_Job.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
