package predictor;

import predictor.spi.Predictor;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.ArrayList;

public class PredictionService {
    private static PredictionService service;
    private ServiceLoader<Predictor> loader;

    private PredictionService() {
        loader = ServiceLoader.load(Predictor.class);
    }

    public static synchronized PredictionService getInstance() {
        if (service == null) {
            service = new PredictionService();
        }
        return service;
    }
	
    public ArrayList<ArrayList<String>> getPrediction(int year, int week, String algorithm) {
        ArrayList<ArrayList<String>> predictions = null;

		// Traverses through available services
        try {
            Iterator<Predictor> predictors = loader.iterator();
			// Keep traversing until there are no more algorithms or a result is given
            while (predictions == null && predictors.hasNext()) {
				Predictor p = predictors.next();
				predictions = p.getPrediction(year,week,algorithm);
            }
			// Nothing was found, return empty list. Avoids nullptr errors.
			if (predictions == null){
				predictions = new ArrayList<ArrayList<String>>();
				ArrayList<String> nullList = new ArrayList<String>();
					nullList.add("null");
				predictions.add(nullList);
				predictions.add(nullList);
				predictions.add(nullList);
			}
		}
		// ServiceProvider Error
		catch (ServiceConfigurationError serviceError) {
            predictions = null;
            serviceError.printStackTrace();
        }
        return predictions;
    }
}