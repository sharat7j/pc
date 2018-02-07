package personalcapital;
import org.junit.Test;

import com.personalcapital.simulation.MonteCarloSimulator;
import com.personalcapital.simulation.Portfolio;
public class TestSimulator {
	@Test
	public void testSimulation(){
		Portfolio aggressive = new Portfolio("Aggressive", new Double(100000), new Double(0.094324), new Double(0.15675));
		Portfolio conservative = new Portfolio("Conservative", new Double(100000), new Double(0.06189), new Double(0.063438));
		Portfolio[] portfolios=new Portfolio[2];
		portfolios[0]=aggressive;
		portfolios[1]=conservative;
		MonteCarloSimulator simulator = new MonteCarloSimulator(portfolios);
		simulator.simulate();
		
		System.out.println(aggressive);
		System.out.println(conservative);
	}
}
