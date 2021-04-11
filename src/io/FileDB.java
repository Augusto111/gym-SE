package io;

import bean.User;
import java.io.*;
import java.util.ArrayList;

public class FileDB {

    public static void storeUser(User user) {
        try {
            String username = user.getUsername();
            FileDB.store(user, "./file/users", username);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //读取用户信息
    public static User readUser(String username) {
        String path = "./file/users/" + username ;
        System.out.println( path);
        return (User) read(path);
    }

    //数据存储
    public static void store(Object obj, String fileName, String subName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.mkdirs();
        }

        File subFile = new File(fileName + "/" + subName + ".txt");
        System.out.println(subFile.getPath());
        //File subFile = new File(fileName + "/" + subName);
//        if (!subFile.exists()) {
//
//            subFile.createNewFile();
//        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(subFile));
            out.writeObject(obj);
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println(e);
        }


    }

    //璇诲彇瀵硅薄
    public static Object read(String fileName) {

        Object info = null;
        File file = new File(fileName + ".txt");

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            try {
                info = in.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Does not exists");
            }
            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return info;

    }

    //鍒ゆ柇鏈夋棤鏂囦欢
    public static boolean fileExist(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }


    public static ArrayList<User> getAllUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<User> list = new ArrayList<User>();
        User user = null;
        File f = new File("UserInfo");

        File file[] = f.listFiles();
        if (!f.exists() || file.length < 1) {

            list = null;
        } else {
            for (int i = 0; i < file.length; i++) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("UserInfo/" + file[i].getName())));
                user = (User) in.readObject();
                in.close();
                list.add(user);
            }
        }

        return list;
    }


}
