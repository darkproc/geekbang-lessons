package org.geektimes.projects.user.management;

import org.geektimes.projects.user.domain.Computer;

public interface ComputerManagerMBean {
    public String getDisk() ;
    public void setDisk(String disk) ;

    public String getKeyboard() ;
    public void setKeyboard(String keyboard) ;

    public String getMouse();

    public void setMouse(String mouse) ;

    public String getHost() ;

    public void setHost(String host);

    public String getMonitor();
    public void setMonitor(String monitor);
    Computer getComputer();
}
