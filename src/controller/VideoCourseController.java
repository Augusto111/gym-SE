package controller;

import bean.Course_video;
import io.TxtIO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-4-23
 */
public class VideoCourseController {
    private String trainerVideoCoursePath = "./file/trainerVideoCourse/";
    private String videoCoursePath = "./file/videoCourse/";
    private TxtIO txtIO = new TxtIO();

    /**获取到教练的视频课程
     * @param trainerName 教练名
     * @return arraylist 课程列表，如果返回null则说明此教练没有视频课程
     */
    public ArrayList<String> getTrainerCourse(String trainerName){
        String trainerPath = trainerVideoCoursePath + trainerName + ".txt";
        File file = new File(trainerPath);
        if((!file.isFile()) || (!file.exists())){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        list = txtIO.readTxt(trainerPath);
        if(list.size() == 0){
            return null;
        }
        return list;
    }

    /**
     *教练添加视频课程
     * @param trainerName 教练名称
     * @param Course_video 视频课程信息
     * @return err = 0 添加成功；err = 1 课程已经存在
     */
    public int addCourseVideo(String trainerName, Course_video Course_video){
        int err = 0;
        String trainerPath = trainerVideoCoursePath + trainerName + ".txt";
//        File trainerFile = new File(trainerPath);
//        if(trainerFile.isFile() && trainerFile.exists()){
//            ArrayList<String> courseList = new ArrayList<String>();
//            for(int i = 0;i < courseList.size();i++){
//                if(video.getPMname() == courseList.get(i)){
//                    return 2;
//                }
//            }
//        }
        String coursePath = videoCoursePath + trainerName + "_" + Course_video.getCourseName()+".txt";
        File file = new File(coursePath);
        if(file.isFile() && file.exists()){
            err = 1;
            return err;
        }
        txtIO.writeTxt(trainerPath, Course_video.getCourseName());
        String content = Course_video.getCourseName()+"\n"+
                Course_video.getTrainerName()+"\n" +
                Course_video.getCourseInfo()+"\n" +
                Course_video.getUrl()+"\n" +
                Course_video.getCourseType();
        txtIO.writeTxt(coursePath, content);
        return err;
    }

    /**
     * 返回教练的视频课程详细信息
     * @param trainerName 教练名
     * @param videoName 课程名
     * @return 返回Video，null表示没有该课程
     */
    public Course_video showCourseVideo(String trainerName, String videoName){
        String coursePath = videoCoursePath + trainerName + "_" + videoName + ".txt";
        File file = new File(coursePath);
        if((!file.isFile()) || (!file.exists())){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        list = txtIO.readTxt(coursePath);
        Course_video Course_video = new Course_video(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        return Course_video;
    }

    /**
     * 修改课程详细信息
     * @param trainerName 教练名
     * @param videoName 修改之前的视频课程名
     * @param video 视频课程信息
     * @return err = 0 修改成功；err = 1 修改失败；
     */
    public int editCourseVideo(String trainerName, String videoName, Course_video video){
        int err = 0;
        String trainerPath = trainerVideoCoursePath + trainerName + ".txt";
        String coursePath = videoCoursePath + trainerName + "_" + videoName + ".txt";
        ArrayList<String> courseList = new ArrayList<String>();
        courseList = txtIO.readTxt(trainerPath);
        for(int i = 0;i < courseList.size();i++){
            if(videoName.equals(courseList.get(i))){
                courseList.remove(i);
            }
        }
        File trainerFile = new File(trainerPath);
        if(trainerFile.exists() && trainerFile.isFile()){
            trainerFile.delete();
        }
        if(courseList.size()!=0){
            String newline = listtoString(courseList);
            txtIO.writeTxt(trainerPath, newline);
        }
        File file = new File(coursePath);
        if(file.exists() && file.isFile()){
            file.delete();
        }
        err = addCourseVideo(trainerName, video);
        return err;
    }

    private String listtoString(ArrayList<String> list){
        String result = "";
        for(int i = 0;i<(list.size() - 1);i++){
            result = result + list.get(i) + "\n";
        }
        result = result + list.get(list.size()-1);
        return result;
    }
}
