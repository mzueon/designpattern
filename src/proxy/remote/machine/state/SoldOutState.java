package proxy.remote.machine.state;

import proxy.remote.machine.Machine;

public class SoldOutState implements State{
    private static final long serialVersionUID = 2L;
    transient Machine machine;

    public SoldOutState(Machine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("동전을 넣을 수 없습니다. 현재 뽑기 기계 재고가 없습니다.");
    }

    public void ejectCoin() {
        System.out.println("동전을 넣지 않아서 반환할 동전이 없습니다.");
    }

    public void turnCrank() {
        System.out.println("손잡이를 돌렸지만 뽑기 기계에 재고가 없습니다.");
    }

    public void dispense() {
        System.out.println("아무것도 나오지 않았습니다.");
    }

    public void refill() {
        machine.setState(machine.getNoCoinState());
    }

    public String toString() {
        return "재고 없음";
    }
}
