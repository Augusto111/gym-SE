package test;

import bean.Course_live;
import controller.LiveCourseController;

import static org.junit.jupiter.api.Assertions.*;

class LiveCourseControllerTest {
    LiveCourseController liveCourseController = new LiveCourseController();
    @org.junit.jupiter.api.Test
    void getTrainerCourse() {
        liveCourseController.getTrainerCourse("tt");
    }

    @org.junit.jupiter.api.Test
    void addCourseLive() {
        String courseName ="YogaTest";
        String trainerName ="tt";
        String courseInfo = "This is a test Yoga course!";
        String url = "https://test.com";
        String time = "2021/5/20 14:00";
        String userName = "test_user";
        String admName = "x";
        Course_live course_live = new Course_live(courseName,trainerName,courseInfo,url,time,userName,admName);
        liveCourseController.addCourseLive("tt",course_live);
    }

    @org.junit.jupiter.api.Test
    void showCourseLive() {
        liveCourseController.showCourseLive("tt","YogaTest");
    }

    @org.junit.jupiter.api.Test
    void editCourseVideo() {
        String courseName ="YogaTest";
        String trainerName ="tt";
        String courseInfo = "This is a test Yoga course!";
        String url = "https://test.com";
        String time = "2021/5/20 17:00";
        String userName = "test_user";
        String admName = "x";
        Course_live course_live = new Course_live(courseName,trainerName,courseInfo,url,time,userName,admName);

        liveCourseController.editCourseVideo("tt","YogaTest",course_live);
    }
}