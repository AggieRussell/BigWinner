package predictor.spi;

import java.util.ArrayList;

public interface Predictor {
	public ArrayList<ArrayList<String>> getPrediction(int year, int week, String algorithm);
}