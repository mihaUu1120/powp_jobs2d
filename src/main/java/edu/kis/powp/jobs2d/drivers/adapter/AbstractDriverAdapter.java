package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class AbstractDriverAdapter extends AbstractDriver {

    public AbstractDriverAdapter(int x, int y) {
        super(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.operateTo(x,y);
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Figure Jane";
    }
}
