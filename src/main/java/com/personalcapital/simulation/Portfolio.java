package com.personalcapital.simulation;

public class Portfolio {

	private String portfoliaName;
	private Double initialInvestment;
	private Double mean;
	private Double standardDeviation;
	
	private Double bestCase10Percent;
	private Double worstCase10Percent;
	private Double median;
	public Portfolio(String portfoliaName, Double initialInvestment, Double mean, Double standardDeviation) {
		super();
		this.portfoliaName = portfoliaName;
		this.initialInvestment = initialInvestment;
		this.mean = mean;
		this.standardDeviation = standardDeviation;
	}
	public String getPortfoliaName() {
		return portfoliaName;
	}
	public void setPortfoliaName(String portfoliaName) {
		this.portfoliaName = portfoliaName;
	}
	public Double getInitialInvestment() {
		return initialInvestment;
	}
	public void setInitialInvestment(Double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}
	public Double getMean() {
		return mean;
	}
	public void setMean(Double mean) {
		this.mean = mean;
	}
	public Double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public Double getBestCase10Percent() {
		return bestCase10Percent;
	}
	public void setBestCase10Percent(Double bestCase10Percent) {
		this.bestCase10Percent = bestCase10Percent;
	}
	public Double getWorstCase10Percent() {
		return worstCase10Percent;
	}
	public void setWorstCase10Percent(Double worstCase10Percent) {
		this.worstCase10Percent = worstCase10Percent;
	}
	public Double getMedian() {
		return median;
	}
	public void setMedian(Double median) {
		this.median = median;
	}
	
	@Override
	public String toString() {
		return "Portfolio [name=" + portfoliaName + ", initialInvestment="
				+ initialInvestment + ", return=" + mean + ", risk="
				+ standardDeviation + ", Median=" + median
				+ ", 10% Best=" + bestCase10Percent
				+ ", 10% Worst=" + worstCase10Percent + "]";
	}
	
}
