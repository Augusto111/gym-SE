package io;

import bean.BookCourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 预约课程文件操作方法
 */
public class BookCourseFileDB {

    //预约课程string格式排版
    public static String bookCourseDetailString(String userid,String coursename,String trainerName){
        String bookCourseDetail="";
        bookCourseDetail=userid+"\n"+
                coursename+"\n" +
                trainerName + "\n";
        return bookCourseDetail;
    }

    //获取所有的userid开头的课程内容
    public static ArrayList<BookCourse> getFilebyUserid(String userid, String fileDirec){
        ArrayList<BookCourse> arrayList=new ArrayList<>();
        File dataDirectory = new File(fileDirec);
        File[] dataFiles = dataDirectory.listFiles(new FilenameFilter() {
            //以userid开头的将被选出来，其余被过滤掉
            @Override
            public boolean accept(File dir, String name) {
                String fileName = name.toLowerCase();

                if(fileName.startsWith(userid+"_")) {
                    return true;
                }
                return false;
            }
        });
        for(File file:dataFiles){
            BookCourse bookCourse = new BookCourse();
            if(file.isFile() && file.exists()){
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String text = "";
                    int lines = 0;
                    while (text != null) {
                        lines++;
                        text = bufferedReader.readLine();
                        switch (lines){
                            case 1:
                                bookCourse.setUserid(text);
                                break;
                            case 2:
                                bookCourse.setCoursename(text);
//                            System.out.println("第1的内容是：" + text + "\n");
//                                arrayList.add(text);
                                break;
                            case 3:
                                bookCourse.setTrainerName(text);
                                break;
                            default:
                                break;
                        }
                    }
                    arrayList.add(bookCourse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
