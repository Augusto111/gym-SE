package io;

import bean.User;
import java.io.*;

/**
 * 用户文件操作方法
 */
public class UserFileDB {

    //用户信息string格式排版
    public static String userDetailString(String userid,String firstname,String lastname,String sex,Integer age,String interested,String password,String telephone,Integer cardType,Integer courseBalance,Integer type,Integer balance){
        String userDetail="";
        userDetail=userid+"\n"+
                firstname+"\n"+
                lastname+"\n"+
                sex+"\n"+
                age+"\n"+
                interested+"\n"+
                password+"\n"+
                telephone+"\n"+
                cardType+"\n"+
                courseBalance+"\n"+
                type+"\n"+
                balance;
        return userDetail;
    }

    /**
     * 读取用户txt转换成user实体类
     * @param txtPath
     * @return
     */
    public static User readUserTxt(String txtPath) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                User usertemp = new User();
                String text = "";
                int lines = 0;
                while (text != null) {
                    lines++;
                    text = bufferedReader.readLine();
                    switch (lines){
                        case 1:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setUserid(text);
                            break;
                        case 2:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setFirstname(text);
                            break;
                        case 3:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setLastname(text);
                            break;
                        case 4:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setSex(text);
                            break;
                        case 5:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setAge(Integer.valueOf(text));
                            break;
                        case 6:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setInterested(text);
                            break;
                        case 7:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setPassword(text);
                            break;
                        case 8:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setTelephone(text);
                            break;
                        case 9:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setCardType(Integer.valueOf(text));
                            break;
                        case 10:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setCourseBalance(Integer.valueOf(text));
                            break;
                        case 11:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setType(Integer.valueOf(text));
                            break;
                        case 12:
//                            System.out.println("第1的内容是：" + text + "\n");
                            usertemp.setBalance(Integer.valueOf(text));
                            break;
                        default:
                            break;
                    }
                }
                return usertemp;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 删除文件
     * @param filepath
     * @return
     */
    public static boolean delete(String filepath){
        File file = new File(filepath);
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }
}
