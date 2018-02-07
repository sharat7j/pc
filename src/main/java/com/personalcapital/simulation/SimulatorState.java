package com.personalcapital.simulation;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
public class SimulatorState {
	private NormalDistribution normalDistribution;
	private DescriptiveStatistics stats;

	public SimulatorState(double mean, double standardDeviation) {
		//init distribution for sampling
		//using default Randomizer
		this.normalDistribution = new NormalDistribution(mean, standardDeviation);
		
		//to store results and compute percentiles
		this.stats = new DescriptiveStatistics();
	}

	public void saveSimulationResult(double simResult) {
		this.stats.addValue(simResult);
	}

	public double nextSampleReturn() {			
		return this.normalDistribution.sample();
	}
	
	public double getPercentile(double n){
		return this.stats.getPercentile(n);
	}
}

