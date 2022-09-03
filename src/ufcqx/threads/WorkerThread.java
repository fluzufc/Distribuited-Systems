package src.ufcqx.threads;

public class WorkerThread extends Thread{
    
    private int id;
    private int in;
    private double out;

    public WorkerThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        this.work();
    }
    
    private void work() {
        System.out.println("Worker " + this.id + " it's working");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + this.id + " it's done working");

        this.out = this.in*3.14;
    }

    public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public double getOut() {
		return out;
	}

	public void setOut(double out) {
		this.out = out;
	}

}
