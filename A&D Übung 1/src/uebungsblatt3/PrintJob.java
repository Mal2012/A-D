package uebungsblatt3;

public class PrintJob {
	public String dateiname;
	public int dateigroe�e;

	public PrintJob(String dateiname, int dateigroe�e) {
		super();
		this.dateiname = dateiname;
		this.dateigroe�e = dateigroe�e;
	}

	@Override
	public String toString() {
		return "PrintJob [dateiname=" + dateiname + ", dateigroe�e="
				+ dateigroe�e + "]";
	}
}
