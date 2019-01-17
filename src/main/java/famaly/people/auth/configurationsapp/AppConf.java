package famaly.people.auth.configurationsapp;

import famaly.people.auth.obj.Token;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import famaly.people.auth.services.ResponseAuthSessionsToken;
import famaly.people.auth.sessions.SessionsMapWorker;
import famaly.people.auth.sessions.UserSession;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.usersession.UserAuthSession;
import famaly.people.auth.token.worker.NewTokenSession;
import famaly.people.auth.token.worker.TokenWorker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConf {


    @Autowired
    private Environment env;

    @Bean
    public ServletRegistrationBean dispatcherServleet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }
    @Bean
    public XsdSchema authSchema(){
        return new SimpleXsdSchema(new ClassPathResource("auth.xsd"));
    }

    @Bean(name = "auth")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AuthPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://people.famaly/auth/obj");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }


    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // See: application.properties
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        System.out.println("## getDataSource: " + dataSource);

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();

        // See: application.properties
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

        // Fix Postgres JPA Error:
        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        // Package contain entity classes
        factoryBean.setPackagesToScan(new String[]{""});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    @Bean
    public GeneratedTokenService getGeneratedTokenService() {
        return new ResponseAuthSessionsToken();
    }

    @Bean
    @Lazy
    public TokenWorker getTokenWorker() {
        return new NewTokenSession();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public UserAuthSession getUserAuthSession() {
        return new UserAuthSession();
    }

    @Bean
    @Scope(value = "prototype")
    public Token getToken() {
        return new Token();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Account getAccount(){
        return new Account();
    }

    @Bean
    public HashMap<String, UserAuthSession> getSessionsMap(){
        return new HashMap<>();
    }

    @Bean
    public UserSession getUserVorkSession() {
        return new SessionsMapWorker();
    }
}

