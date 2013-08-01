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
    private AListItem selectedItem;

    private ArrayList<ModelUpdatedListener> listeners;
    
    public AListModel() {
        insets = new Insets(6, 8, 2, 8);
        items = new ArrayList<>();
        
        listeners = new ArrayList<>();
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
        for (AListItem aListItem : items) {
            if (selectedItem.equals(this.selectedItem)) {
                this.selectedItem = selectedItem;
            }
        }
        fireModelUpdatedListeners();
    }

    public AListItem getSelectedItem() {
        return selectedItem;
    }

    public void setItems(ArrayList<AListItem> items) {
        this.items = items;
        fireModelUpdatedListeners();
    }
    
    public void addModelUpdatedListener(ModelUpdatedListener listener) {
        this.listeners.add(listener);
    }
    
    public void removeModelUpdatedListener(ModelUpdatedListener listener) {
        this.listeners.remove(listener);
    }
    
    private void fireModelUpdatedListeners() {
        for (ModelUpdatedListener listener : listeners) {
            listener.modelUpdated();
        }
    }
    
    public static abstract class ModelUpdatedListener {

        public void modelUpdated() {
        }
    }
    
}
