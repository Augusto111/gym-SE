package io;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zhengyang Mu
 * @date 2020-4-17
 */
public class TxtIO {

    /**使用FileOutputStream来读取文件
     * @param txtPath txt文件路径
     * @return arraylist of file, one line one item
     */
    public static ArrayList<String> readTxt(String txtPath) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 
                ArrayList<String> lines = new ArrayList<String>();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    lines.add(text);
                }
                return lines;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    ArrayList<String> lines = new ArrayList<String>();
    /**使用FileOutputStream来写入txt文件
     * @param txtPath txt文件路径
     * @param content 需要写入的文本
     */
    public static void writeTxt(String txtPath,String content){    
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f=new File(txtPath);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
