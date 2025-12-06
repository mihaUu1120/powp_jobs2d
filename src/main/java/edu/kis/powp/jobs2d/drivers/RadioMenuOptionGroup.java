package edu.kis.powp.jobs2d.drivers;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RadioMenuOptionGroup {
    private final List<JCheckBoxMenuItem> items = new ArrayList<>();

    public void notifyItemSelected(JCheckBoxMenuItem selectedItem) {
        if (!items.contains(selectedItem)) {
            items.add(selectedItem);
        }

        for (JCheckBoxMenuItem item : items) {
            boolean isSelected = (item == selectedItem);
            item.setState(isSelected);
            item.setEnabled(!isSelected);
        }
    }
}
