package sample;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangell extends Figur {

    private Rectangle recta;
    private double musx;
    private  double musy;
    private boolean drar = false;
    private boolean setForan = true;

    //Rectangle r;


    public boolean isSetForan() {
        return setForan;
    }

    public Rectangell() {

    }

    public Rectangell(double x,double y,double width,double height) {
        recta = new Rectangle(x,y,width,height);
        setX(x);
        setY(y);



    }
    @Override
    public Shape getCreate(){
        recta.setCursor(Cursor.HAND);
        recta.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
            if (ev.getButton() == MouseButton.PRIMARY) {
                recta.setX(ev.getX());
                recta.setY(ev.getY());
            } else if (ev.getButton() == MouseButton.SECONDARY) {
                recta.setWidth(ev.getX());
                recta.setHeight(ev.getY());
            }
        });
        recta.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
            if(isSetForan()){
                recta.toFront();
            }
        });

        return recta;
    }




}
