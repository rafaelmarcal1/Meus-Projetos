package br.edu.ifsp.conversortemperatura.model;

public class FarhenheitToKelvinStrategy implements ConversorTemperatura{

    private static FarhenheitToKelvinStrategy instance = null;

    private FarhenheitToKelvinStrategy(){}

    public static FarhenheitToKelvinStrategy getInstance(){
        if (instance == null){
            instance = new FarhenheitToKelvinStrategy();
        }
        return instance;
    }

    @Override
    public double getConvertion(double temperature) {
        return CelciusStrategy.getInstance().getConvertion(temperature) + 273.15;
    }

    @Override
    public String getScale() {
        return "K";
    }
}