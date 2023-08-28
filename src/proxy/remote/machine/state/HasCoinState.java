package proxy.remote.machine.state;

import proxy.remote.machine.Machine;

public class HasCoinState implements State {
    private static final long serialVersionUID = 2L;
    transient Machine machine;

    public HasCoinState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("다른 동전을 투입할 수 없습니다");
    }

    @Override
    public void ejectCoin() {
        System.out.println("동전 반환");
        machine.setState(this);
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌렸습니다");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("아무것도 나오지 않았습니다");
    }

    @Override
    public void refill() {

    }

    @Override
    public String toString() {
        return "손잡이를 돌리기를 기다리는 중";
    }
}
