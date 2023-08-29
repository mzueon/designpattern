package proxy.remote.machine;

import proxy.remote.machine.state.*;

public class Machine {
    private static final long serialVersionUID = 2L;
    State state;
    State hasCoinState;
    State noCoinState;
    State soldOutState;
    State soldState;
    int count = 0;
    String location;

    public Machine(String location, int stock) {
        hasCoinState = new HasCoinState(this);
        noCoinState = new NoCoinState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);

        this.count = stock;
        this.location = location;

        if (stock > 0){
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }



    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("상품이 슬롯에서 나오는 중...");
        if (count > 0) {
            count = count - 1;
        }
    }

    public State getState() {
        return state;
    }

    public String getLocation() {
        return location;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\n재고 수: " + count + " 개");

        result.append("\n");
        result.append("뽑기 기계 : " + state + "\n");
        return result.toString();
    }
}
