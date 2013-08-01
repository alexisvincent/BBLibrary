package components;

import java.awt.Insets;
import java.util.ArrayList;

/**
 *
 * @author alexisvincent
 */
public class AListModel {

    private Insets insets;
    private ArrayList<AListItem> items;
    private ArrayList<ModelUpdatedListener> modelUpdatedListeners;
    private ArrayList<SelectionListener> selectionListeners;

    public AListModel() {
        insets = new Insets(6, 8, 2, 8);
        items = new ArrayList<>();
        modelUpdatedListeners = new ArrayList<>();
        selectionListeners = new ArrayList<>();
    }

    public Insets getInsets() {
        return insets;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
        fireModelUpdatedListeners();
    }

    public ArrayList<AListItem> getItems() {
        return items;
    }

    public void setSelectedItem(AListItem selectedItem) {
        for (AListItem aListItem : getItems()) {
            if (selectedItem.equals(aListItem)) {
                aListItem.setSelected(true);
            } else {
                aListItem.setSelected(false);
            }
        }
        fireSelectionListeners();
    }

    public AListItem getSelectedItem() {
        for (AListItem aListItem : getItems()) {
            if (aListItem.isSelected()) {
                return aListItem;
            }
        }
        return null;
    }

    public void setItems(ArrayList<AListItem> items) {
        this.items = items;
        for (final AListItem i : items) {
            i.addSelectionListener(new SelectionListener() {
                @Override
                public void itemSelected(AListItem item) {
                    for (AListItem j : getItems()) {
                        if (!j.equals(i)) {
                            j.setSelected(false);
                        }
                    }
                    fireSelectionListeners();
                }
            });

            i.addFocusListener(new FocusListener() {
                @Override
                public void itemFocused(AListItem item) {
                    for (AListItem j : getItems()) {
                        if (!j.equals(i)) {
                            j.setFocus(false);
                        }
                    }
                }
            });
        }
        fireModelUpdatedListeners();
    }

    public void addModelUpdatedListener(ModelUpdatedListener listener) {
        this.modelUpdatedListeners.add(listener);
    }

    public void removeModelUpdatedListener(ModelUpdatedListener listener) {
        this.modelUpdatedListeners.remove(listener);
    }

    private void fireModelUpdatedListeners() {
        for (ModelUpdatedListener listener : modelUpdatedListeners) {
            listener.modelUpdated();
        }
    }

    public void addSelectionListener(SelectionListener listener) {
        this.selectionListeners.add(listener);
    }

    public void removeModelUpdatedListener(SelectionListener listener) {
        this.selectionListeners.remove(listener);
    }

    private void fireSelectionListeners() {
        for (SelectionListener listener : selectionListeners) {
            listener.itemSelected(getSelectedItem());
        }
    }

    public static abstract class ModelUpdatedListener {

        public void modelUpdated() {
        }
    }

    public abstract class SelectionListener {

        public void itemSelected(AListItem item) {
        }
    }

    public abstract class FocusListener {

        public void itemFocused(AListItem item) {
        }
    }
}
