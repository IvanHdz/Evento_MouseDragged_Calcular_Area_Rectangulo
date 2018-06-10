
/**
 *
 * @author ViRuZ
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DibujoRectangulo extends JFrame {

    private Container contenedor;
    private JLabel etiqueta;
    private int x1;
    private int ancho;
    private int y1;
    private int largo;
    private int area;
    private Panel miPanel;

    public DibujoRectangulo() {
        super("Viruz Blog: Dibujar Rectángulo");
        //getContentPane es el panel principal del frame
        contenedor = getContentPane();
        etiqueta = new JLabel("Área");
        miPanel = new Panel();
        setSize(500, 500);
        miPanel.setBackground(Color.white);

        //agregamos la etiqueta y el panel 
        contenedor.add(etiqueta, BorderLayout.SOUTH);
        contenedor.add(miPanel, BorderLayout.CENTER);

        addEventos();
    }

    private void addEventos() {
        //mousePressed maneja el evento cuando se oprime el botón del ratón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                ancho = 1;
                largo = 1;

                //indica atu puntero donde empieza a dibujar posicion X y Y
                miPanel.setX1(x1 - 2);
                miPanel.setY1(y1 - 27);
                miPanel.setAncho(ancho);
                miPanel.setLargo(largo);

                etiqueta.setText("Área: ");
                miPanel.dibujar();
            }
        });

      //mouseReleased maneja el evento cuando se suelta el botón del ratón
        //depues de haber arrastrado.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evento) {
                largo = evento.getX() - x1;
                ancho = evento.getY() - y1;

                miPanel.setAncho(ancho);
                miPanel.setLargo(largo);

                miPanel.dibujar();
            }
        });

      //mouseDragged maneja el evento cuando el usuario arrastra el ratón con el 
        //botón oprimido.
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                largo = e.getX() - x1;
                ancho = e.getY() - y1;
                area = largo * ancho;

                miPanel.setAncho(ancho);
                miPanel.setLargo(largo);

                if (ancho < 0 || largo < 0) {
                    etiqueta.setText("Área: ");
                } else {
                    etiqueta.setText("Área: " + String.valueOf(area));
                }

                miPanel.dibujar();
            }
        });
    }
}
