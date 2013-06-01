package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import toolkit.BToolkit;

/**
 *
 * @author alexisvincent
 */
public class BFooter extends JComponent {

    private static Image imgHome, imgHomeMouseOver;
    private BMenuButton home;
    private GridBagConstraints gc;
    private static JComponent homeScreen;

    static {
        //init images
        imgHome = BToolkit.getImage("close");
        imgHomeMouseOver = BToolkit.getImage("closeMouseOver");
    }

    public BFooter() {


        //init buttons
        home = new BMenuButton(imgHome, imgHomeMouseOver);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setMouseOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setMouseOver(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                BFooter.this.goHome();
            }
        });

        this.setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = new Insets(5, 10, 7, 2);
        this.add(home, gc);

    }
    
    public static void setHomeScreen(JComponent homeScreen) {
        BFooter.homeScreen = homeScreen;
    }
    
    public void goHome() {
        homeScreen.setVisible(true);
    }
}
