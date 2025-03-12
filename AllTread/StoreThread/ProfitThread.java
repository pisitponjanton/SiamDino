package AllTread.StoreThread;

import AllMom.MomShore;

public class ProfitThread extends Thread {
    private boolean running;
    private MomShore m;

    public ProfitThread(MomShore m) {
        this.m = m;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                setRunning();
                m.setMoney_Profit(m.getProfit());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void setRunning() {
        try {
            while (running) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void running() {
        this.running = false;
        notify();
    }

    public void stopping() {
        this.running = true;
    }
}
