package org.geektimes.projects.user.management;

import org.geektimes.projects.user.domain.Computer;

public class ComputerManager implements ComputerManagerMBean {
    private final Computer computer;

    public ComputerManager(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String getDisk() {
        return computer.getDisk();
    }

    @Override
    public void setDisk(String disk) {
        computer.setDisk(disk);
    }

    @Override
    public String getKeyboard() {
        return computer.getKeyboard();
    }

    @Override
    public void setKeyboard(String keyboard) {
        computer.setKeyboard(keyboard);
    }

    @Override
    public String getMouse() {
        return computer.getMouse();
    }

    @Override
    public void setMouse(String mouse) {
        computer.setMouse(mouse);
    }

    @Override
    public String getHost() {
        return computer.getHost();
    }

    @Override
    public void setHost(String host) {
        computer.setHost(host);
    }

    @Override
    public String getMonitor() {
        return computer.getMonitor();
    }

    @Override
    public void setMonitor(String monitor) {
        computer.setMonitor(monitor);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
