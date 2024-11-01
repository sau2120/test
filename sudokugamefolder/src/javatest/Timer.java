package javatest;

public class Timer {

	private long startTime;
	private long endTime;
	
	public void start() {
		startTime = System.currentTimeMillis(); //시작 시간
	}
	
	public long stop() {
		return endTime = System.currentTimeMillis(); //끝낸 시간
	}
	
	public long getTimeTaken() {
		return (endTime-startTime)/1000; //끝내는데 걸린 시간
	}
	
}
