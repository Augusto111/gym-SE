package controller;

import bean.Constant;
import bean.User;
import io.TxtIO;
import io.UserFileDB;

/**
 *用户操作接口
 */
public class UserController {

    /**
     * 用户注册：生成txt文件
     * 返回：用户id
     * @param firstname
     * @param lastname
     * @param sex
     * @param age
     * @param interested
     * @param password
     * @return
     */
    public String register(String firstname,String lastname,String sex,Integer age,String interested,String password){
        String userid="";
        Long startTs = System.currentTimeMillis();
        userid=Long.toString(startTs);
        String userDetailString=UserFileDB.userDetailString(userid,firstname,lastname,sex,age,interested,password,"null",-1,-1,0,0);
        String filePath=(Constant.FilePath+"/users/"+userid+".txt");
        try {
            TxtIO.writeTxt(filePath,userDetailString);
            return userid;
        }catch (Exception e){
            return "ERROR";
        }
    }

    /**
     * 登录页面:userid 密码
     * 返回：行不行 用户身份 -1未找到该用户 -2密码错误 -3io操作出错 0访客 1cm 2pm
     * @param userid
     * @param password
     * @return
     */
    public Integer login(String userid,String password){
        String filePath=(Constant.FilePath+"/users/"+userid+".txt");
        try {
            User user=UserFileDB.readUserTxt(filePath);
            if(user == null){
                return -1;
            }else{
                if(user.getUserid().equals(userid)&&user.getPassword().equals(password)){
                    return user.getType();
                }else{
                    return -2;
                }
            }
        }catch (Exception e){
            return -3;
        }
    }

    /**
     * 购买课程：传coursetype userid修改用户表
     * 返回成功 用户身份 -1未找到该用户 -3io操作出错 0访客 1cm 2pm
     * @param userid
     * @param cardtype 0: 月卡 1: 季卡 2: 年卡
     * @return
     */
    public Integer modifyUserCourseBalance(String userid,Integer cardtype){
        String filePath=(Constant.FilePath+"/users/"+userid+".txt");
        try {
            User user=UserFileDB.readUserTxt(filePath);
            if(user == null){
                return -1;
            }else{
                user.setCardType(cardtype);
                user.setType(1);
                try {
                    UserFileDB.delete(filePath);
                }catch (Exception e){
                    return -3;
                }
                String userDetailString=UserFileDB.userDetailString(userid,user.getFirstname(),user.getLastname(),user.getSex(),user.getAge(),user.getInterested(),user.getPassword(),user.getTelephone(),user.getCardType(),user.getCourseBalance(),user.getType(),user.getBalance());
                try {
                    TxtIO.writeTxt(filePath,userDetailString);
                    return user.getType();
                }catch (Exception e){
                    return -3;
                }
            }
        }catch (Exception e){
            return -3;
        }
    }

    /**
     * @Description:
     * @Param: [courseNum, userId]
     * @return: java.lang.Integer 课程余量 -1未找到该用户 -3io操作出错 -2访客无权限
     * @Author: YuBen
     * @Date: 2021-04-26
     */
    public Integer purchaseCourse(Integer courseNum, String userId){
        String filePath = (Constant.FilePath+"/users/"+userId+".txt");
        try {
            User user = UserFileDB.readUserTxt(filePath);
            if(user == null) {
                return -1;}
            else if(user.getType()==0){
                return  -2;
            }
            else{
                Integer courseBalance = user.getCourseBalance();
                courseBalance += courseNum;
                user.setCourseBalance(courseBalance);
                user.setType(2);
            }
            try {
                UserFileDB.delete(filePath);
            }catch (Exception e){
                return -3;
            }
            String userDetailString=UserFileDB.userDetailString(user.getUserid(),user.getFirstname(),user.getLastname(),user.getSex(),user.getAge(),user.getInterested(),user.getPassword(),user.getTelephone(),user.getCardType(),user.getCourseBalance(),user.getType(),user.getBalance());
            try {
                TxtIO.writeTxt(filePath,userDetailString);
                return user.getCourseBalance();
            }catch (Exception e){
                return -3;
            }
        }catch (Exception e){
            return -3;
        }
    }

    /**
     * @Description:
     * @Param: [userId]
     * @return: bean.User:wq
     *:q::qq
     *
     * @Author: YuBen
     * @Date: 2021-04-26
     */
    public User getUserInfo(String userId){
        String filePath = (Constant.FilePath+"/users/"+userId+".txt");
        try {
            User user = UserFileDB.readUserTxt(filePath);
            if(user == null){
                return  new User();
            }
            else {
                return user;
            }
        }catch (Exception exception){
            return new User();
        }
    }

    /**
     * @Description:
     * @Param: [user]
     * @return: java.lang.Boolean
     * @Author: YuBen
     * @Date: 2021-04-26
     */
    public Boolean setUserInfo(User user) {
        String filePath = (Constant.FilePath + "/users/" + user.getUserid() + ".txt");
        try {
            UserFileDB.delete(filePath);
        } catch (Exception e) {
            return false;
        }
        String userDetailString = UserFileDB.userDetailString(user.getUserid(), user.getFirstname(), user.getLastname(), user.getSex(), user.getAge(), user.getInterested(), user.getPassword(), user.getTelephone(), user.getCardType(), user.getCourseBalance(), user.getType(), user.getBalance());
        try {
            TxtIO.writeTxt(filePath, userDetailString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
