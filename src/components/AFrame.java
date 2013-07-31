package components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author alexisvincent
 */
public class AFrame extends JFrame {

    private JLayeredPane layeredPane;
    private static final GridBagConstraints gridbagConstraints;
    private AComponent defaultLayer;
    private AComponent paletteLayer;

    public AFrame() {
        this("Default");
    }

    static {
        //Setup Layor Constraints
        gridbagConstraints = new GridBagConstraints();
        gridbagConstraints.gridx = 0;
        gridbagConstraints.gridy = 0;
        gridbagConstraints.gridwidth = 1;
        gridbagConstraints.gridheight = 1;
        gridbagConstraints.fill = GridBagConstraints.BOTH;
        gridbagConstraints.anchor = GridBagConstraints.CENTER;
        gridbagConstraints.weightx = 1;
        gridbagConstraints.weighty = 1;
    }

    public AFrame(String title) {
        super(title);

        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(0, 0, 0, 0));

        layeredPane = new JLayeredPane() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }

            @Override
            public void doLayout() {
                defaultLayer.setSize(layeredPane.getSize());
                paletteLayer.setSize(layeredPane.getSize());
            }
        };

        this.add(layeredPane, gridbagConstraints);

        //begin adding layers
        defaultLayer = new AComponent();
        defaultLayer.setLayout(new GridBagLayout());
        layeredPane.add(defaultLayer, JLayeredPane.DEFAULT_LAYER);

        paletteLayer = new AComponent();
        paletteLayer.setLayout(new GridBagLayout());
        layeredPane.add(paletteLayer, JLayeredPane.PALETTE_LAYER);
    }

    @Override
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void addPaneltoDefaultLayer(AComponent panel) {
        addPanelToComponent(panel, defaultLayer);
    }

    public void addPaneltoPaletteLayer(AComponent panel) {
        addPanelToComponent(panel, paletteLayer);
    }

    public static void addPanelToComponent(final AComponent panel, final AComponent parentComponent) {
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                //check all components on this frame (or rather it's content pane)
                for (int i = 0; i < parentComponent.getComponentCount(); i++) {
                    //we only want to hide all OTHER components except the component we set to visible
                    if (!e.getComponent().equals(parentComponent.getComponent(i))) {
                        parentComponent.getComponent(i).setVisible(false);
                    }
                }
            }
        });
        parentComponent.add(panel, gridbagConstraints);
    }
}
