package components;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import toolkit.BToolkit;

/**
 *
 * @author alexisvincent
 */
public class BMenuBar extends JComponent {

    private static Image imgClose, imgCloseMouseOver, imgMinimize, imgMinimizeMouseOver;
    private BMenuButton close, minimize;
    private Point ptOnFrame;
    private GridBagConstraints gc;
    private static JFrame frame;

    static {
        //init images
        imgClose = BToolkit.getImage("close");
        imgCloseMouseOver = BToolkit.getImage("closeMouseOver");
        imgMinimize = BToolkit.getImage("minimize");
        imgMinimizeMouseOver = BToolkit.getImage("minimizeMouseOver");
    }
    
    public BMenuBar() {

        
        //init buttons
        close = new BMenuButton(imgClose, imgCloseMouseOver);
        minimize = new BMenuButton(imgMinimize, imgMinimizeMouseOver);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ptOnFrame = e.getPoint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                try {
                    BMenuBar.frame.setLocation(e.getXOnScreen() - ptOnFrame.x, e.getYOnScreen() - ptOnFrame.y);
                } catch (NullPointerException ex) {
                    System.out.println("You have not set a mainframe for BMenuButton... \nPlease set the mainframe with BMenuButton.setMainFrame(yourFrame)");
                }
            }
        });

        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                close.setMouseOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                close.setMouseOver(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });


        minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BMenuBar.frame.setState(Frame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimize.setMouseOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimize.setMouseOver(false);
            }
        });

        this.setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(7, 10, 5, 2);
        this.add(close, gc);

        gc.gridx++;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = new Insets(7, 3, 5, 5);
        this.add(minimize, gc);
        }

    public static void setMainFrame(JFrame frame) {
        BMenuBar.frame = frame;
    }
}
