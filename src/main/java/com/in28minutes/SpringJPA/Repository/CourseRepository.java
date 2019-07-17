package com.in28minutes.SpringJPA.Repository;

import com.in28minutes.SpringJPA.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.slf4j.LoggerFactory.getLogger;


@Repository
@Transactional
public class CourseRepository {
    // In any repo class what we need to do is to talk to entityManager
    Logger logger = getLogger(CourseRepository.class);

    @Autowired
    EntityManager entityManager;


    public Course findById(Long ID) {
        Course course = entityManager.find(Course.class, ID);
        return course;
    }

    public void deleteById(Long Id) {
        Course byId = findById(Id);
        entityManager.remove(byId);
    }

    public Course saveById(Course course) {
        // Insert or update
        if (course.getId() == null) {
            // insert
            entityManager.persist(course); // insert
        } else {
            entityManager.merge(course); // merge
        }
        return course;
    }


    public void entityManagerInDetail() {
        Course course1 = new Course("hihaha service in 100 steps");
        entityManager.persist(course1);
        entityManager.flush();//inserting
        course1.setName("hahaha services in 100 steps updated ");
        entityManager.flush(); // updating


        Course course2 = new Course("pappu service in 100 steps");
        entityManager.persist(course1);
        entityManager.flush();//inserting
        entityManager.detach(course2);
        course1.setName("pappu services in 100 steps updated ");
        entityManager.flush();//updating
    }


}
