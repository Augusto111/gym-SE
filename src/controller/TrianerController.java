package controller;

import bean.Course_live;
import bean.Trainer;
import io.TxtIO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-4-23
 */
public class TrianerController {
    private String trainerFilePath = "./file/trainer/";
    private TxtIO txtIO = new TxtIO();

    /**
     * 教练登录
     * @param userName  用户名，注：这里用户名是完整名字，传进来之前要先融合firstname+lastname
     * @param password   密码，注：这里不做空值等格式检测
     * @return  err=0 登录成功；err=1 用户名不存在；err=2 密码错误。
     */
    public int trainerLogin(String userName, String password){
        int err = 0;
        String logPath = trainerFilePath + userName + ".txt";
        File file = new File(logPath);
        if((!file.isFile()) || (!file.exists())){
            err = 1;
            return err;
        }
        ArrayList<String> lines = new ArrayList<String>();
        lines = txtIO.readTxt(logPath);
        if(!password.equals(lines.get(5))){
            err = 2;
            return err;
        }
        return err;
    }

    /**
     * 教练注册
     * @param trainer 教练的详细信息
     * @return err=0 注册成功；err=1 用户名重复；
     */
    public int trainerRegister(Trainer trainer){
        int err = 0;
        String regPath = trainerFilePath + trainer.getFirstName()+trainer.getLastName()+".txt";
        File file = new File(regPath);
        if(file.isFile() && file.exists()){
            err = 1;
            return err;
        }
        String trainerInfo = trainer.toString();
        txtIO.writeTxt(regPath, trainerInfo);
        return 0;
    }

    /**
     * 返回教练的详细信息
     * @param trainerName 教练名
     * @return 返回Trainer，null表示没有此教练信息
     */
    public Trainer showTrainerInfo(String trainerName){
        String trainInfoPath = trainerFilePath + trainerName+".txt";
        File file = new File(trainInfoPath);
        if((!file.isFile()) || (!file.exists())){
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        list = txtIO.readTxt(trainInfoPath);
        Trainer trainer= new Trainer(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
        return trainer;
    }

    /**
     * 修改教练的详细信息
     * @param trainerName 教练名
     * @param trainer 教练的详细信息
     * @return err = 0 修改成功；err = 1 修改失败；
     */
    public int editTrainerInfo(String trainerName, Trainer trainer){
        int err = 0;
        String trainerPath = trainerFilePath + trainerName + ".txt";
        File trainerFile = new File(trainerPath);
        if(trainerFile.exists() && trainerFile.isFile()){
            trainerFile.delete();
        }
        err = trainerRegister(trainer);

        return err;
    }

    /**
     * 获取所有教练名
     * @return TrainerList
     */
    public ArrayList<String> getAllTrainer() {
        File f = new File(trainerFilePath);
        if (!f.exists()) {
            System.out.println(trainerFilePath + " not exists");
            return null;
        }
        ArrayList<String> res = new ArrayList<>();
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            String[] strings = fs.getName().split("\\.");
            res.add(strings[0]);
        }
        return res;
    }
}
