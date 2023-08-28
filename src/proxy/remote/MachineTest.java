package proxy.remote;

import proxy.remote.machine.Machine;

public class MachineTest {
    public static void main(String[] args) {
        Machine machine = new Machine(10);
        System.out.println(machine);

        machine.insertCoin();
        machine.turnCrank();
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);

        machine.insertCoin();
        machine.turnCrank();
        machine.insertCoin();
        machine.turnCrank();

        System.out.println(machine);

    }


}
