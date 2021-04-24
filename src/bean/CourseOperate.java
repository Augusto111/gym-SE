package bean;
import io.TxtIO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-4-23
 */
public class CourseOperate {
    private String trainerCoursePath = "./file/trainerCourse/";
    private String videoCoursePath = "./file/videoCourse/";
    private TxtIO txtIO = new TxtIO();

    /**获取到教练的视频课程
     * @param trainerName 教练名
     * @return arraylist 课程列表，如果返回null则说明此教练没有视频课程
     */
    public ArrayList<String> getTrainerCourse(String trainerName){
        String trainerPath = trainerCoursePath + trainerName + ".txt";
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
     * @param videoCourse 视频课程信息
     * @return err = 0 添加成功；err = 1 课程已经存在
     */
    public int addCourseVideo(String trainerName, videoCourse videoCourse){
        int err = 0;
        String trainerPath = trainerCoursePath + trainerName + ".txt";
//        File trainerFile = new File(trainerPath);
//        if(trainerFile.isFile() && trainerFile.exists()){
//            ArrayList<String> courseList = new ArrayList<String>();
//            for(int i = 0;i < courseList.size();i++){
//                if(video.getPMname() == courseList.get(i)){
//                    return 2;
//                }
//            }
//        }
        String coursePath = videoCoursePath + trainerName + "_" + videoCourse.getCourseName()+".txt";
        File file = new File(coursePath);
        if(file.isFile() && file.exists()){
            err = 1;
            return err;
        }
        txtIO.writeTxt(trainerPath, videoCourse.getCourseName());
        String content = videoCourse.getCourseName()+"\n"+ videoCourse.getCourseType()+"\n"+ videoCourse.getCourseInfo()+"\n"+ videoCourse.getUrl();
        txtIO.writeTxt(coursePath, content);
        return err;
    }

    /**
     * 返回教练的视频课程详细信息
     * @param trainerName 教练名
     * @param videoName 课程名
     * @return 返回Video，null表示没有该课程
     */
    public videoCourse showCourseVideo(String trainerName, String videoName){
        String coursePath = videoCoursePath + trainerName + "_" + videoName + ".txt";
        File file = new File(coursePath);
        if((!file.isFile()) || (!file.exists())){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        list = txtIO.readTxt(coursePath);
        videoCourse videoCourse = new videoCourse(list.get(0), list.get(1), list.get(2), list.get(3));
        return videoCourse;
    }

    /**
     * 修改课程详细信息
     * @param trainerName 教练名
     * @param videoName 修改之前的视频课程名
     * @param videoCourse 视频课程信息
     * @return err = 0 修改成功；err = 1 修改失败；
     */
    public int editCourseVideo(String trainerName, String videoName, videoCourse videoCourse){
        int err = 0;
        String trainerPath = trainerCoursePath + trainerName + ".txt";
        String coursePath = videoCoursePath + trainerName + "_" + videoName + ".txt";
        ArrayList<String> courseList = new ArrayList<String>();
        courseList = txtIO.readTxt(trainerPath);
        for(int i = 0;i < courseList.size();i++){
            if(videoName == courseList.get(i)){
                courseList.remove(i);
            }
        }
        File file = new File(coursePath);
        if(file.exists() && file.isFile()){
            file.delete();
        }
        err = addCourseVideo(trainerName, videoCourse);
        return err;
    }
}