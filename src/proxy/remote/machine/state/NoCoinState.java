package proxy.remote.machine.state;

import proxy.remote.machine.Machine;

public class NoCoinState implements State{
    private static final long serialVersionUID = 2L;
    transient Machine machine;

    public NoCoinState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("동전을 넣었습니다");
        machine.setState(machine.getHasCoinState());
    }


    @Override
    public void ejectCoin() {
        System.out.println("동전을 넣지 않았습니다");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌렸지만 동전이 없는 채로 돌렸습니다");
    }

    @Override
    public void dispense() {
        System.out.println("돈부터 내셈");
    }

    @Override
    public void refill() {}

    @Override
    public String toString() {
        return "동전 기다리는 중 ...";
    }
}
