package controller;

import bean.Constant;
import io.BookCourseFileDB;
import io.TxtIO;
import io.UserFileDB;

import java.util.ArrayList;

/**
 * 预约课程接口
 */
public class BookCourseController {

    /**
     * 预约课程接口，创建用户Id_课程name文件
     * @param userid 用户id
     * @param coursename 课程名称
     * @return
     */
    public String bookcourse(String userid,String coursename){
        String bookcourseDetailString= BookCourseFileDB.bookCourseDetailString(userid,coursename);
        String filePath=(Constant.FilePath+"/BookCourseRecord/"+userid+"_"+coursename+".txt");
        try {
            TxtIO.writeTxt(filePath,bookcourseDetailString);
            return "SUCCESS";
        }catch (Exception e){
            return "ERROR";
        }
    }

    /**
     * 获取用户预约的所有课程名称
     * @param userid
     * @return
     */
    public ArrayList<String> bookcourseList(String userid){
        ArrayList<String> arrayList=new ArrayList<>();
        String fileDirecPath=(Constant.FilePath+"/BookCourseRecord");
        arrayList=BookCourseFileDB.getFilebyUserid(userid,fileDirecPath);
        return arrayList;
    }

    /**
     * 删除用户已预约课程
     * @param userid 用户id
     * @param coursename 课程名称
     * @return
     */
    public String deleteBookcourse(String userid,String coursename){
        String filePath=(Constant.FilePath+"/BookCourseRecord/"+userid+"_"+coursename+".txt");
        try {
            if(UserFileDB.delete(filePath)){
                return "SUCCESS";
            }else {
                return "ERROR";
            }
        }catch (Exception e){
            return "ERROR";
        }
    }
}
