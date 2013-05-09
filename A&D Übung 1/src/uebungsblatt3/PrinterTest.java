package uebungsblatt3;

public class PrinterTest {

	public static void main(String[] args) {
		Printer p = new Printer();
		PrintJob pj1 = new PrintJob("PrintJob 1", 1);
		PrintJob pj2 = new PrintJob("PrintJob 2", 2);
		PrintJob pj3 = new PrintJob("PrintJob 3", 3);
		p.addPrintJob(pj2);
		p.addPrintJob(pj1);
		p.addPrintJob(pj3);
		p.execute();
		p.execute();
		p.execute();
	}
}
