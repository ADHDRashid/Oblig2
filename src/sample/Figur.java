package sample;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import javax.swing.*;
import java.util.List;

public abstract class Figur {

    ColorPicker colorPicker;
    private Shape shape ;
    private double x;
    private double y;
    double bredde, høyde;
    private int prevDragX;  // During drag  ging, these record the x and y coordinates of the
    private int prevDragY;


    public Figur() {

    }

    public Figur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Figur(double v, double v1, int i) {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    void endreStørrelse(int dx, int dy){
        bredde += dx;
        høyde += dy;
    }


    public abstract Shape getCreate();


}
