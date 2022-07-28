package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("JDBC implementation");
        UsersRepositoryJdbcImpl jdbc = applicationContext.getBean("jdbc", UsersRepositoryJdbcImpl.class);
        System.out.println("find by id:\t" + jdbc.findById(2L));
        System.out.println("find all:\t" + jdbc.findAll().toString());
        System.out.println("find by email:\t" + jdbc.findByEmail("bob@icloud.com"));
        System.out.println();

        System.out.println("JDBC Template implementation");
        UsersRepositoryJdbcTemplateImpl jdbcTemplate = applicationContext.getBean("jdbcTemplate", UsersRepositoryJdbcTemplateImpl.class);

    }

}
