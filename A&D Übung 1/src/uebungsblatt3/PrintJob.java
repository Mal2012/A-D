package uebungsblatt3;

public class PrintJob {
	public String dateiname;
	public int dateigroeße;

	public PrintJob(String dateiname, int dateigroeße) {
		super();
		this.dateiname = dateiname;
		this.dateigroeße = dateigroeße;
	}

	@Override
	public String toString() {
		return "PrintJob [dateiname=" + dateiname + ", dateigroeße="
				+ dateigroeße + "]";
	}
}
