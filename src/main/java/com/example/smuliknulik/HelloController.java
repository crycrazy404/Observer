package com.example.smuliknulik;

import Obs.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML

    public TextField dindon, timer, clock, coll, repeat;
    public Label mess;

    public Canvas canvas;

    public Button start, stop, clean, stCount, spCount, stColl, spColl, stClock, spClock;

    Subject subject = new Subject();
    ComponentText ct;

    Signal sl;
    ComponentClock ck;
    GraphicsContext gr;

    @FXML

    public void initialize() {
        gr = canvas.getGraphicsContext2D();
        addObs();
        dindon.setEditable(false);
        dindon.setText("Прошло _ с");
        Clock clock = new Clock();
        Paint p = Color.KHAKI;
        clock.draw(gr, p, 190, 190, 95, 95, 105);
        start.setOnAction(actionEvent -> start());
        stop.setOnAction(actionEvent -> stop());
        clean.setOnAction(actionEvent -> clean());
        stCount.setOnAction(actionEvent -> startCount());
        spCount.setOnAction(actionEvent -> stopCount());
        stColl.setOnAction(actionEvent -> startColl());
        spColl.setOnAction(actionEvent -> stopColl());
        stClock.setOnAction(actionEvent -> startClock());
        spClock.setOnAction(actionEvent -> stopClock());
    }

    public void start() {
        mess.setText("Таймер активен");
        subject.start(Integer.parseInt(timer.getText()), Integer.parseInt(repeat.getText()));
    }

    public void startCount() {
        ct.onComp();
    }

    public void stopCount() {
        ct.offComp();
    }

    public void startColl() {
        sl.onComp(Integer.parseInt(coll.getText()));
    }

    public void stopColl() {
        sl.offComp();
    }

    public void startClock() {
        ck.onComp(Integer.parseInt(clock.getText()));
    }

    public void stopClock() {
        ck.offComp();
    }

    public void stop() {
        mess.setText("Таймер остановлен");
        subject.stop();
    }

    public void clean() {
        mess.setText("Таймер неактивен");
        timer.setText("");
        repeat.setText("");
        coll.setText("");
        clock.setText("");
        delObs();
        addObs();
        subject.clean();
    }

    public void addObs() {
        ct = new ComponentText(subject, dindon);
        sl = new Signal(subject);
        ck = new ComponentClock(subject, gr);
    }

    public void delObs() {
        ct.delComo(subject);
        sl.delComo(subject);
        ck.delComo(subject);
    }
}

