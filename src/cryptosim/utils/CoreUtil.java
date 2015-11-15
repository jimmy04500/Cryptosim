package cryptosim.utils;

import cryptosim.operations.Operation;

public class CoreUtil {
	private Core[] cores;
	
	public CoreUtil(int numCores) {
		cores = new Core[numCores];
		for (int i = 0; i < numCores; i++) {
			cores[i] = new Core();
		}
	}
	
	public int scheduleOperation(int currentTime, Operation operation) {
		int nextAvailable = getNextLowestEndTime();
		int startTime = currentTime > nextAvailable? currentTime : nextAvailable;
		
		Core core = getAvailableCore(startTime);
		core.append(operation, startTime);
		
		return startTime;
	}
	
	public void clearPreviousOps(int time) {
		for (Core core : cores) {
			core.clear(time);
		}
	}
	
	
	public Core getAvailableCore() {
		for (Core core : cores) {
			if (core.isEmpty()) return core;
		}
		return null;
	}
	
	public Core getAvailableCore(int time) {
		for (Core core : cores) {
			if (core.availableTime() <= time) return core;
		}
		return null;
	}
	
	// Precondition: all cores are busy
	// Return: start time of the operation
	public int insertAtNextLowest(Operation op) {
		Core lowestCore = cores[0];
		for (int i = 1; i < cores.length; i++) {
			if (cores[i].availableTime() < lowestCore.availableTime())
				lowestCore = cores[i];
		}
		return lowestCore.append(op);
	}
	
	public int getNextLowestAvailable() {
		int lowest = cores[0].availableTime();
		for (int i = 1; i < cores.length; i++) {
			int temp = cores[i].availableTime();
			if (!cores[i].isEmpty() && temp < lowest)
				lowest = cores[i].availableTime();
		}
		return lowest;
	}
	
	public int getNextLowestEndTime() {
		int lowest = cores[0].availableTime();
		for (int i = 1; i < cores.length; i++) {
			int temp = cores[i].availableTime();
			if (temp < lowest)
				lowest = cores[i].availableTime();
		}
		return lowest;
	}
	
	public void print() {
		for (int i = 0; i < cores.length; i++) {
			System.out.println("Core " + (i + 1));
			cores[i].print();
		}
	}
}
