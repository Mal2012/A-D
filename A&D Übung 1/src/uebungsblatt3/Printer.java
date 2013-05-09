package uebungsblatt3;

public class Printer {
	QueueAr que = new QueueAr();

	public void addPrintJob(PrintJob p) {
		que.enqueue(p);
	}

	public void execute() {
		System.out.println(que.dequeue());
	}
}
