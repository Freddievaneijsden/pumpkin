package com.example.pumpkin.model;

import com.example.pumpkin.Pumpkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.Random;

public class Model {
    private int score = 0;
    private StringProperty scoring = new SimpleStringProperty();
    Image noSmash;
    Image smash;

    ObjectProperty<Image> firstPumpkin;
    ObjectProperty<Image> secondPumpkin;
    ObjectProperty<Image> thirdPumpkin;

    public Model() {
        URL noSmashUrl = getClass().getResource("/com/example/pumpkin/images/pumpkin_blank.png");
        if (noSmashUrl == null) {
            throw new RuntimeException("Image not found: /com/example/pumpkin/images/pumpkin_blank.png");
        }
        noSmash = new Image(noSmashUrl.toExternalForm());
//        noSmash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin_blank.png").toExternalForm());
//        smash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin1.png").toExternalForm());
        firstPumpkin = new SimpleObjectProperty<>(noSmash);
        secondPumpkin = new SimpleObjectProperty<>(noSmash);
        thirdPumpkin = new SimpleObjectProperty<>(noSmash);
    }

    public String getScoring() {
        return scoring.get();
    }

    public StringProperty scoringProperty() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring.set(scoring);
    }

    public Image getFirstPumpkin() {
        return firstPumpkin.get();
    }

    public ObjectProperty<Image> firstPumpkinProperty() {
        return firstPumpkin;
    }

    public void setFirstPumpkin(Image firstPumpkin) {
        this.firstPumpkin.set(firstPumpkin);
    }

    public Image getSecondPumpkin() {
        return secondPumpkin.get();
    }

    public ObjectProperty<Image> secondPumpkinProperty() {
        return secondPumpkin;
    }

    public void setSecondPumpkin(Image secondPumpkin) {
        this.secondPumpkin.set(secondPumpkin);
    }

    public Image getThirdPumpkin() {
        return thirdPumpkin.get();
    }

    public ObjectProperty<Image> thirdPumpkinProperty() {
        return thirdPumpkin;
    }

    public void setThirdPumpkin(Image thirdPumpkin) {
        this.thirdPumpkin.set(thirdPumpkin);
    }

    public void randomlyChangeOnePumpkin() {
        Random random = new Random();
        int randomPumpkin = random.nextInt(4);
        if (randomPumpkin == 1) {
            setFirstPumpkin(smash);
        }
        else if (randomPumpkin == 2) {
            setSecondPumpkin(smash);
        }
        else if (randomPumpkin == 3) {
            setThirdPumpkin(smash);
        }
    }

    public void pumkinSmached(Pumpkin pumpkin) {
        //Check if we can smack this pumpkin
        //Increase score
        if (pumpkin == Pumpkin.FIRST && getFirstPumpkin() == smash) {
            setFirstPumpkin(noSmash);
            score ++;
        }
        else if ( pumpkin == Pumpkin.SECOND && getSecondPumpkin() == smash ) {
            setSecondPumpkin(noSmash);
            score ++;
        }
        else if ( pumpkin  == Pumpkin.THIRD && getThirdPumpkin() == smash ) {
            setThirdPumpkin(noSmash);
            score ++;
        }

        setScoring(score + " poäng");

    }
}
