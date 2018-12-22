//package hibernate.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import hibernate.model.Subject;
//import hibernate.model.Topic;
//import hibernate.model.Users;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
//@Configuration
//@EnableWebMvc
//@EnableTransactionManagement
//@ComponentScan({"hibernate"})
//public class WebAppConfig {
//
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/forum");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//        return dataSource;
//    }
//
//    @Bean
//    @Autowired
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        sessionFactory.setAnnotatedClasses(Subject.class, Topic.class, Users.class);
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }
//
//    public Properties hibernateProperties() {
//        Properties dialect = new Properties();
//        dialect.setProperty("hibernate.dialect",
//                "org.hibernate.dialect.PostgreSQL9Dialect");
//        dialect.setProperty("hibernate.enable_lazy_load_no_trans","true");
//        return dialect;
//    }
//
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//}