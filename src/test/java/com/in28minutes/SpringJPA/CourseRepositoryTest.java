package com.in28minutes.SpringJPA;

import com.in28minutes.SpringJPA.Repository.CourseRepository;
import com.in28minutes.SpringJPA.entity.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaApplication.class)
public class CourseRepositoryTest {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById() {
        logger.info("Test is running ");
        Course byId = courseRepository.findById(10002L);
        assertEquals("JPA in 50 steps", byId.getName().trim());
    }

    @Test
    @DirtiesContext
    public void deleteById()
    {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }


    //Get a course
    // Update the details
    // check the value

    @DirtiesContext // Reset the db into old state Data gets the reset again
    @Test
    public void saveById()
    {
        //Get a course
        Course byId = courseRepository.findById(10002L);
        assertEquals("JPA in 1000 steps",byId.getName().trim());
        //Update details
        byId.setName("50 steps updated ");
        courseRepository.saveById(byId);

        //check the name
        Course byIds = courseRepository.findById(10002L);
        assertEquals("50 steps updated",byIds.getName().trim());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager()
    {
        courseRepository.entityManagerInDetail();
    }
}

