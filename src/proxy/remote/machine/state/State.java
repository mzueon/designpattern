package proxy.remote.machine.state;

import java.io.Serializable;

public interface State extends Serializable {
    public void insertCoin();
    public void ejectCoin();
    public void turnCrank();
    public void dispense();

    public void refill();
}
