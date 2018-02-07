package com.personalcapital.simulation;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
public class MonteCarloSimulator {
	private final int numberOfSimulations=100;
	private final int predictionPeriod=20;
	private final double inflationRate=0.035;
	private Portfolio[] portfolios;
	private HashMap<Portfolio,SimulatorState> portfolioStates;
	public  MonteCarloSimulator(Portfolio[] portfolios) {
		this.portfolios=portfolios;
		portfolioStates=new HashMap<Portfolio,SimulatorState>();
		
		for(Portfolio portfolio:portfolios) {
			SimulatorState simulatedState=new SimulatorState(portfolio.getMean(),portfolio.getStandardDeviation());
			portfolioStates.put(portfolio, simulatedState);
		}
	}
	
public void simulate() {
		
	for (int i = 0; i < numberOfSimulations; i++) {
		for (Portfolio portfolio : portfolios) {
			double simulatorResult=portfolio.getInitialInvestment();//starting value
			for(int j=0;j<predictionPeriod;j++) {
				double rate = portfolioStates.get(portfolio).nextSampleReturn();
				
				//end of year gain
				simulatorResult = (1+rate)*simulatorResult;
				
				//for inflation
				simulatorResult = (1-inflationRate)*simulatorResult;
				
			}
			portfolioStates.get(portfolio).saveSimulationResult(simulatorResult);
		}
	}
	
	for (Portfolio portfolio : portfolios) {
		SimulatorState simulatorstate=portfolioStates.get(portfolio);
		portfolio.setMedian(simulatorstate.getPercentile(50));
		portfolio.setBestCase10Percent(simulatorstate.getPercentile(90));
		portfolio.setWorstCase10Percent(simulatorstate.getPercentile(10));
	}
	
	}
}
