package components;

import components.AListModel.ModelUpdatedListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.plaf.ScrollBarUI;

/**
 *
 * @author alexisvincent
 */
public class AList extends AComponent {

    private AListModel model;
    private JScrollPane scrollPane;
    private AComponent itemsPane;
    private GridBagConstraints gc;

    public AList() {
        this(new AListModel());
    }

    public AList(AListModel model) {
        setModel(model);

        itemsPane = new AComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new Color(10, 10, 10, 200));
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        };
        itemsPane.setLayout(new GridBagLayout());
        scrollPane = new JScrollPane(itemsPane) {

            @Override
            public void paint(Graphics g) {
                paintChildren(g);
            }
            
        };
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI() {
        });
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI() {
        });

        this.setDefaultGridbagConstraints();

        this.setLayout(new GridBagLayout());
        this.add(scrollPane, gc);

        this.buildItemsPane();

        getModel().addModelUpdatedListener(new ModelUpdatedListener() {
            @Override
            public void modelUpdated() {
                buildItemsPane();
            }
        });

    }

    private void setDefaultGridbagConstraints() {
        //Setup Layor Constraints
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 1;
        gc.weighty = 1;
    }

    private void buildItemsPane() {
        itemsPane.removeAll();

        this.setDefaultGridbagConstraints();
        gc.insets = getInsets();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        gc.weighty = 0;

        for (AListItem aListItem : getItems()) {
            itemsPane.add(aListItem, gc);
            gc.gridy++;
        }
        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
    }

    public ArrayList<AListItem> getItems() {
        return getModel().getItems();
    }

    public void setItems(ArrayList<AListItem> items) {
        getModel().setItems(items);
    }

    public AListModel getModel() {
        return model;
    }

    public void setModel(AListModel model) {
        this.model = model;
    }

    public void setInsets(Insets insets) {
        getModel().setInsets(insets);
    }

    public void setSelectedItem(AListItem item) {
        getModel().setSelectedItem(item);
    }

    public AListItem getSelectedItem() {
        return getModel().getSelectedItem();
    }

    @Override
    public Insets getInsets() {
        return getModel().getInsets();
    }
}
