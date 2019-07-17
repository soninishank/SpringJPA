package com.in28minutes.SpringJPA;

import com.in28minutes.SpringJPA.Repository.CourseRepository;
import com.in28minutes.SpringJPA.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// CLR whatever is there in run method gets executed
public class SpringJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SpringJpaApplication.class);

    @Autowired
    CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
     /*   Course courseId = courseRepository.findById(10001L);

        courseRepository.deleteById(10001L);

        courseRepository.saveById(new Course("Microservices in 100 steps"));
        logger.info("Course 10001-> {} " + courseId);
*/

     courseRepository.entityManagerInDetail();

    }


}
