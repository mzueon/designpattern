package proxy.remote.machine.state;

import proxy.remote.machine.Machine;

public class SoldState implements State {
    private static final long serialVersionUID = 2L;
    transient Machine machine;

    public SoldState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("상품 꺼내는 중... 기다리세요");
    }

    @Override
    public void ejectCoin() {
        System.out.println("이미 손잡이를 돌렸기 때문에 동전을 반환할 수 없습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 두 번 돌려도 상품이 하나 더 나오지는 않습니다");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoCoinState());
        } else {
            System.out.println("재고 없음");
            machine.setState(machine.getSoldOutState());
        }
    }

    @Override
    public void refill() {

    }

    @Override
    public String toString() {
        return "상품 꺼내는 중";
    }
}
