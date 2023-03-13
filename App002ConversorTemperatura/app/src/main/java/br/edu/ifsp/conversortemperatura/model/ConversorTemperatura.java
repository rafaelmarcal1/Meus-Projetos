package br.edu.ifsp.conversortemperatura.model;

public interface ConversorTemperatura {

    public abstract double getConvertion(double temperature);

    String getScale();
}
