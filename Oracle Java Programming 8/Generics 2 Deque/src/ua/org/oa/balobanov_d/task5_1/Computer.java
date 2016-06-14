package ua.org.oa.balobanov_d.task5_1;

public class Computer implements Comparable<Computer>{

	private int processorFrequency;
	private String videoCard;
	private String ssdCapacity;
	
	
	
	public Computer(int processorFrequency, String videoCard, String ssdCapacity) {
		this.processorFrequency = processorFrequency;
		this.videoCard = videoCard;
		this.ssdCapacity = ssdCapacity;
	}



	public int getProcessorFrequency() {
		return processorFrequency;
	}



	public void setProcessorFrequency(int processorFrequency) {
		this.processorFrequency = processorFrequency;
	}



	public String getVideoCard() {
		return videoCard;
	}



	public void setVideoCard(String videoCard) {
		this.videoCard = videoCard;
	}



	public String getSsdCapacity() {
		return ssdCapacity;
	}



	public void setSsdCapacity(String ssdCapacity) {
		this.ssdCapacity = ssdCapacity;
	}


	

	@Override
	public String toString() {
		return "Processor Frequency " + processorFrequency + ". Video Card " + videoCard + ". SSD Capacity " + ssdCapacity;
	}



	// Сортировка по частоте процессора
	@Override
	public int compareTo(Computer arg) {
		return processorFrequency - arg.processorFrequency;
	}

}
