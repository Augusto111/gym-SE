package controller;

import bean.Course_live;
import io.TxtIO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-5-14
 */
public class LiveCourseController {
    private String trainerLiveCoursePath = "./file/trainerLiveCourse/";
    private String liveCoursePath = "./file/liveCourse/";
    private TxtIO txtIO = new TxtIO();

    /**获取到教练的直播课程
     * @param trainerName 教练名
     * @return arraylist 课程列表，如果返回null则说明此教练没有直播课程
     */
    public ArrayList<String> getTrainerCourse(String trainerName){
        String trainerPath = trainerLiveCoursePath + trainerName + ".txt";
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
     *教练添加直播课程
     * @param trainerName 教练名称
     * @param course_live 直播课程信息
     * @return err = 0 添加成功；err = 1 课程已经存在
     */
    public int addCourseLive(String trainerName, Course_live course_live){
        int err = 0;
        String trainerPath = trainerLiveCoursePath + trainerName + ".txt";
//        File trainerFile = new File(trainerPath);
//        if(trainerFile.isFile() && trainerFile.exists()){
//            ArrayList<String> courseList = new ArrayList<String>();
//            for(int i = 0;i < courseList.size();i++){
//                if(video.getPMname() == courseList.get(i)){
//                    return 2;
//                }
//            }
//        }
        String coursePath = liveCoursePath + trainerName + "_" + course_live.getCourseName()+".txt";
        File file = new File(coursePath);
        if(file.isFile() && file.exists()){
            err = 1;
            return err;
        }
        txtIO.writeTxt(trainerPath, course_live.getCourseName());
        String content = course_live.getCourseName()+"\n"+
                course_live.getTrainerName()+"\n" +
                course_live.getCourseInfo()+"\n" +
                course_live.getUrl()+"\n" +
                course_live.getTime()+"\n"+
                course_live.getUserName()+"\n"+
                course_live.getAdmName();
        txtIO.writeTxt(coursePath, content);
        return err;
    }

    /**
     * 返回教练的直播课程详细信息
     * @param trainerName 教练名
     * @param videoName 课程名
     * @return 返回Video，null表示没有该课程
     */
    public Course_live showCourseLive(String trainerName, String videoName){
        String coursePath = liveCoursePath + trainerName + "_" + videoName + ".txt";
        File file = new File(coursePath);
        if((!file.isFile()) || (!file.exists())){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        list = txtIO.readTxt(coursePath);
        Course_live course_live = new Course_live(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
        return course_live;
    }

    /**
     * 修改直播课程详细信息
     * @param trainerName 教练名
     * @param videoName 修改之前的直播课程名
     * @param course_live 直播课程信息
     * @return err = 0 修改成功；err = 1 修改失败；
     */
    public int editCourseVideo(String trainerName, String videoName, Course_live course_live){
        int err = 0;
        String trainerPath = trainerLiveCoursePath + trainerName + ".txt";
        String coursePath = liveCoursePath + trainerName + "_" + videoName + ".txt";
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
        err = addCourseLive(trainerName, course_live);
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
