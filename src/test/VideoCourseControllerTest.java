package test;

import bean.Course_video;
import controller.VideoCourseController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoCourseControllerTest {
    VideoCourseController videoCourseController = new VideoCourseController();
    @Test
    void getTrainerCourse() {
        videoCourseController.getTrainerCourse("tt");
    }

    @Test
    void addCourseVideo() {
        String courseName = "YogaTest2";
        String trainerName = "tt";
        String courseInfo = "This is a test Yoga!";
        String url = "https://tets.com";
        String courseType = "Yoga";
        Course_video course_video = new Course_video(courseName,trainerName,courseInfo,url,courseType);
        videoCourseController.addCourseVideo("tt",course_video);
    }

    @Test
    void showCourseVideo() {
        videoCourseController.showCourseVideo("tt","YogaTest2");
    }

    @Test
    void editCourseVideo() {
        String courseName = "YogaTest2";
        String trainerName = "tt";
        String courseInfo = "This is a test Yoga!!!!";
        String url = "https://tets.com";
        String courseType = "Yoga";
        Course_video course_video = new Course_video(courseName,trainerName,courseInfo,url,courseType);
        videoCourseController.editCourseVideo("tt","YogaTest2",course_video);
    }
}