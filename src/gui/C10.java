package gui;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;

public class C10 extends TRMain {


    public C10(String name, String userid) {
        super(name);
        final JFXPanel VFXPanel = new JFXPanel();
        File video_source = new File("./test.mp4");
        Media m = new Media(video_source.toURI().toString());
        MediaPlayer player = new MediaPlayer(m);
        player.setAutoPlay(true);
        MediaView viewer = new MediaView(player);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        javafx.geometry.Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        viewer.setX((screen.getWidth() - centerPanel.getWidth()) / 2);
        viewer.setY((screen.getHeight() - centerPanel.getHeight()) / 2);
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);
        root.getChildren().add(viewer);
        VFXPanel.setScene(scene);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(VFXPanel, BorderLayout.CENTER);
        prebutton.setVisible(true);
        prebutton.setText("play");
        prebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.play();
            }
        });
        nextbutton.setVisible(true);
        nextbutton.setText("pause");
        nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.pause();
            }
        });


        newbutton.setVisible(true);
        newbutton.setText("Back");
        newbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.stop();
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C5("Course Video",userid);
            }
        });

    }
}
