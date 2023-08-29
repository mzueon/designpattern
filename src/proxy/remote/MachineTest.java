package proxy.remote;

import proxy.remote.machine.Machine;
import proxy.remote.machine.MachineMonitor;

public class MachineTest {
    public static void main(String[] args) {
        Machine machine = new Machine("8th floor",10);
        MachineMonitor monitor = new MachineMonitor(machine);
        monitor.report();
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

        monitor.report();
    }


}
