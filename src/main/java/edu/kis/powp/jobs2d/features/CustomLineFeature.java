package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.RadioMenuOptionGroup;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.CustomLine;

import javax.swing.JCheckBoxMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLineFeature {

    private static CustomLine customLine;

    public static void setupCustomLine(Application application) {
        customLine = new CustomLine();
        Job2dDriver customLineDriver = new LineDrawerAdapter(DrawerFeature.getDrawerController(), customLine, "Custom line");
        DriverFeature.addDriver("Custom line", customLineDriver);
        initializeMenu(application);
    }

    private static void initializeMenu(Application app) {
        app.addComponentMenu(CustomLine.class, "Line Settings");

        RadioMenuOptionGroup colorGroup = new RadioMenuOptionGroup();
        Map<String, Color> colors = new LinkedHashMap<>();
        colors.put("Color: Black", Color.BLACK);
        colors.put("Color: Red", Color.RED);
        colors.put("Color: Green", Color.GREEN);
        colors.put("Color: Blue", Color.BLUE);

        colors.forEach((label, color) -> {
            createRadioItem(app, label, colorGroup, e -> customLine.setColor(color));
        });

        RadioMenuOptionGroup thicknessGroup = new RadioMenuOptionGroup();
        float[] thicknesses = {1.0f, 3.0f, 5.0f, 7.0f};

        for (float thickness : thicknesses) {
            String label = "Thickness: " + thickness;
            createRadioItem(app, label, thicknessGroup, e -> customLine.setThickness(thickness));
        }

        app.addComponentMenuElementWithCheckBox(CustomLine.class, "Dotted",
                e -> {
                    customLine.setDotted(!customLine.isDotted());
                    DriverFeature.updateDriverInfo();
                },
                false
        );
    }

    private static void createRadioItem(Application app, String label, RadioMenuOptionGroup group, ActionListener action) {
        app.addComponentMenuElementWithCheckBox(CustomLine.class, label, event -> {
            action.actionPerformed(event);
            group.notifyItemSelected((JCheckBoxMenuItem) event.getSource());
            DriverFeature.updateDriverInfo();
        }, false);
    }


}