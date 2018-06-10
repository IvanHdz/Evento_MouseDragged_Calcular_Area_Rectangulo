
/**
 *
 * @author ViRuZ
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private int x1;
    private int ancho;
    private int y1;
    private int largo;

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent hace que vuelva a pintar el rectangulo
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(x1, y1, largo, ancho);
    }

    public void dibujar() {
        repaint();
    }

//*MÉTODOS set asginan Valores Y get Regresan Valores
    //Sirven para asignar nuevos valores cuando se dibujan varias veces.
    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
}
