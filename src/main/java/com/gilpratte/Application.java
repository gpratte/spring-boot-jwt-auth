package com.gilpratte;

import com.gilpratte.dao.UserDao;
import com.gilpratte.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return (args) -> {
            // save a few users
            userDao.save(new User(1, "Alex123", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", 3456, 33));
            userDao.save(new User(2, "Tom234", "$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK", 7823, 23));
            userDao.save(new User(3, "Adam", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", 4234, 45));

            log.info("--------------------------------------------");
            userDao.findAll().forEach(user -> {
                log.info("---> {}", user.toString());
            });
        };
    }
}
