//I denne filen så er det en abstract figur klasse
//som oppretter en slag mal for hver figur og linje
package sample;
import javafx.scene.shape.Shape;

public abstract class Figur {
    private Shape shape ;
    private double x;
    private double y;
    double bredde, høyde;
    private int prevDragX;  //lagrer en logg på forrige musklikk basert på X aksen
    private int prevDragY;  //lagrer en logg på forrige musklikk basert på Y aksen

    //Default Figur uten parameter variabler
    public Figur() { }

    public Figur(double v, double v1, int i) {}

    //Default figur konstruktør som inneholder x og y verdier
    //Disse variablene vil være nyttig for circle, rectangle og linje
    //slik at de kan hente x og y ved hjelp av metoder (getX(), getY())
    public Figur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Getter metode for x variabel
    public double getX() {
        return x;
    }

    //Setter metode for x variabel
    public void setX(double x) {
        this.x = x;
    }

    //Getter metode for y variabel
    public double getY() {
        return y;
    }

    //Setter metode for y variabel
    public void setY(double y) {
        this.y = y;
    }

    //Opprettelse av andre figurer med forskjellige størrelse
    void endreStørrelse(int dx, int dy){
        bredde += dx;
        høyde += dy;
    }

    //Abstract metode for opprettelse/henting av ferdig spesifisert figur
    public abstract Shape getCreate();

}
