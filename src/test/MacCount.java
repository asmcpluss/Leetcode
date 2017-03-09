package test;

import java.util.ArrayList;
import java.util.Calendar;

public class MacCount {
	private Calendar capture_time;
	private int numberOfMacs;
	private ArrayList<String> macs;
	public Calendar getCapture_time() {
		return capture_time;
	}
	public void setCapture_time(Calendar capture_time) {
		this.capture_time = capture_time;
	}
	public int getNumberOfMacs() {
		return numberOfMacs;
	}
	public void setNumberOfMacs(int numberOfMacs) {
		this.numberOfMacs = numberOfMacs;
	}
	public ArrayList<String> getMacs() {
		return macs;
	}
	public void setMacs(ArrayList<String> macs) {
		this.macs = macs;
	}
	
}
