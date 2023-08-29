package proxy.remote.machine;

public class MachineMonitor {
    Machine machine;

    public MachineMonitor(Machine machine) {
        this.machine = machine;
    }

    public void report(){
        System.out.println("뽑기 기계의 위치 : " + machine.getLocation());
        System.out.println("현재 재고 수 : " + machine.getCount());
        System.out.println("현재 상태 : " + machine.getState());
    }
}
