package test;

import bean.Trainer;
import controller.TrianerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrianerControllerTest {
    TrianerController trianerController = new TrianerController();
    @Test
    void trainerLogin() {
        trianerController.trainerLogin("tt","111");
    }

    @Test
    void trainerRegister() {
        String firstName = "yf0";
        String lastName = "zhao";
        String Gender = "female";
        String age = "18";
        String speciaity = "swimming";
        String password = "123";
        Trainer trainer = new Trainer(firstName,lastName,Gender,age,speciaity,password);
        trianerController.trainerRegister(trainer);
    }

    @Test
    void showTrainerInfo() {
        trianerController.showTrainerInfo("tt");
    }

    @Test
    void editTrainerInfo() {
        String firstName = "yf0";
        String lastName = "zhao";
        String Gender = "female";
        String age = "18";
        String speciaity = "swimming";
        String password = "123";
        Trainer trainer = new Trainer(firstName,lastName,Gender,age,speciaity,password);
        trianerController.editTrainerInfo("tt",trainer);
    }
}