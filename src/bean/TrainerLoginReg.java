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
