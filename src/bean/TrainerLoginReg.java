package bean;

import io.TxtIO;

import java.io.File;
import java.util.ArrayList;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-4-23
 */
public class TrainerLoginReg {
    private String trainerFilePath = "./file/trainer/";
    private TxtIO txtIO = new TxtIO();

    /**
     * 教练登录
     * @param userName  用户名，注：这里用户名是完整名字，传进来之前要先融合firstname+lastname
     * @param password   密码，注：这里不做空值等格式检测
     * @return  err=0 登录成功；err=1 用户名不存在；err=2 密码错误。
     */
    private int trainerLogin(String userName, String password){
            int err = 0;
            String logPath = trainerFilePath + userName + ".txt";
            File file = new File(logPath);
            if((!file.isFile()) || (!file.exists())){
                err = 1;
                return err;
             }
            ArrayList<String> lines = new ArrayList<String>();
            lines = txtIO.readTxt(logPath);
            if(lines.get(4) != password){
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
    private int trainerRegister(Trainer trainer){
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
}
