package br.edu.ifsp.conversortemperatura.model;

public class CelsiusToKelvinStrategy implements ConversorTemperatura{

    private static CelsiusToKelvinStrategy instance = null;

    private CelsiusToKelvinStrategy(){}

    public static CelsiusToKelvinStrategy getInstance(){
        if (instance == null){
            instance = new CelsiusToKelvinStrategy();
        }
        return instance;
    }

    @Override
    public double getConvertion(double temperature){
        return temperature + 273.15;
    }

    @Override
    public String getScale(){
        return "K";
    }
}
