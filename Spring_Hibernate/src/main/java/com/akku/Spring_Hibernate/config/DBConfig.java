package com.akku.Spring_Hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.akku.Spring_Hibernate")
public class DBConfig {
	
	private static  final String DBURL="jdbc:h2:tcp://localhost/~/Project";
	private static  final String DBUSERNAME="sa";
	private static  final String DBPASSWORD="";
	private static  final String DBDIALECT="org.hibernate.dialect.H2Dialect";
	private static  final String DBDRIVER="org.h2.Driver";
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(DBDRIVER);
		dataSource.setUrl(DBURL);
		dataSource.setUsername(DBUSERNAME);
		dataSource.setPassword(DBPASSWORD);
		
		return dataSource;
	}
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(dataSource);	
	lsfb.addProperties(getHibernateProperties());
	lsfb.scanPackages("com.akku.Spring_Hibernate");
	
	return lsfb.buildSessionFactory();
	
}
private Properties getHibernateProperties() {
	Properties prop=new Properties();
	//required
	prop.put("hibernate.dialect", DBDIALECT);
	//optional
	prop.put("hibernate.hbm2ddl.auto", "update");
	                                  //update
	                                  //create-drop
	                                  //validate
	
	prop.put("hibernate.show_sql", "true");
	prop.put("hibernate.format_sql", "true");
	
	
	
	return prop;
}
@Bean
public HibernateTransactionManager getTM(SessionFactory sessionFactory) {
	return new HibernateTransactionManager(sessionFactory);
	
}
}
