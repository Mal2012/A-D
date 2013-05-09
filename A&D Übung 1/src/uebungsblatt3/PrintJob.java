package uebungsblatt3;

public class PrintJob {
	public String dateiname;
	public int dateigroeﬂe;

	public PrintJob(String dateiname, int dateigroeﬂe) {
		super();
		this.dateiname = dateiname;
		this.dateigroeﬂe = dateigroeﬂe;
	}

	@Override
	public String toString() {
		return "PrintJob [dateiname=" + dateiname + ", dateigroeﬂe="
				+ dateigroeﬂe + "]";
	}
}
