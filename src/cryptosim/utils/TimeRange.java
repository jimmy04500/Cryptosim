package cryptosim.utils;

public class TimeRange {
	private int startTime;
	private int finishTime;
	
	public TimeRange(int start, int finish) {
		startTime = start;
		finishTime = finish;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int getFinishTime() {
		return finishTime;
	}
}
