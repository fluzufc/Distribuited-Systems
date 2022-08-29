package src.ufcqx.threads;

public class WorkerThread extends Thread{
    
    private int id;
    private int in;
    private int out;

    public WorkerThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        this.work();
    }
    
    public void work() {
        System.out.println("Worker " + this.id + " it's working");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + this.id + " it's done working");

        this.out = this.in*10;
    }

    public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

}
