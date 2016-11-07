package com.niit.collaborationBackEnd.config;
import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationBackEnd.model.R_BaseDomain;
import com.niit.collaborationBackEnd.model.R_Blog;
import com.niit.collaborationBackEnd.model.R_BlogComment;
import com.niit.collaborationBackEnd.model.R_Chat;
import com.niit.collaborationBackEnd.model.R_Event;
import com.niit.collaborationBackEnd.model.R_Forum;
import com.niit.collaborationBackEnd.model.R_ForumComment;
import com.niit.collaborationBackEnd.model.R_Job;
import com.niit.collaborationBackEnd.model.R_JobApplication;
import com.niit.collaborationBackEnd.model.R_User;


@Configuration
@ComponentScan("com.niit.collaboration.*")
@EnableTransactionManagement
public class ApplicationContextConfiguration {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*--- Database connection settings ---*/
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");		//specify the driver...
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");		//specify the db_url...
		dataSource.setUsername("COLL");		//specify the db_username...
		dataSource.setPassword("COLL");		//specify the db_password...
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.showsql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(R_Blog.class);
		sessionBuilder.addAnnotatedClasses(R_Forum.class);
		sessionBuilder.addAnnotatedClasses(R_Event.class);
		sessionBuilder.addAnnotatedClasses(R_Job.class);
		sessionBuilder.addAnnotatedClasses(R_JobApplication.class);
		sessionBuilder.addAnnotatedClasses(R_BlogComment.class);
		sessionBuilder.addAnnotatedClasses(R_ForumComment.class);
		sessionBuilder.addAnnotatedClasses(R_BaseDomain.class);
		sessionBuilder.addAnnotatedClasses(R_Chat.class);
		sessionBuilder.addAnnotatedClasses(R_User.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
}
