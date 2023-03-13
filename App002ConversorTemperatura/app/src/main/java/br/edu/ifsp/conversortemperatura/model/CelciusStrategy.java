package br.edu.ifsp.conversortemperatura.model;

public class CelciusStrategy implements ConversorTemperatura {

    private static CelciusStrategy instance = null;

    private CelciusStrategy() {
    }

    public static CelciusStrategy getInstance() {
        if (instance == null) {
            instance = new CelciusStrategy();
        }
        return instance;
    }

    @Override
    public double getConvertion(double temperature) {
        return 1.8 * temperature + 32;
    }

    @Override
    public String getScale() {
        return "ºF";
    }
}