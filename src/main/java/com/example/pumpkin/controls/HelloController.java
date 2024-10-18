package com.example.pumpkin.controls;

import com.example.pumpkin.Pumpkin;
import com.example.pumpkin.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class HelloController {

    public ImageView image1;

    //Will run after the controller object is created
    //and the fields are initialized
    public void initialize () {
        startRandomEvent();
    }

    private void startRandomEvent () {
        Timeline timeLine = new Timeline(   //tid som går
                new KeyFrame(
                        Duration.millis(Math.random() * 3000),
                        (ActionEvent event) -> {model.randomlyChangeOnePumpkin();
                        startRandomEvent();}
                )
        );
        timeLine.play();
    }

    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void image1Clicked(MouseEvent mouseEvent) {
        model.pumkinSmached(Pumpkin.FIRST);
    }

    public void image2Clicked(MouseEvent mouseEvent) {
        model.pumkinSmached(Pumpkin.SECOND);
    }

    public void image3Clicked(MouseEvent mouseEvent) {
        model.pumkinSmached(Pumpkin.THIRD);
    }
}