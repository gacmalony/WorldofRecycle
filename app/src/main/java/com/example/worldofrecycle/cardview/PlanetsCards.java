package com.example.worldofrecycle.cardview;

public class PlanetsCards {

    private String planetName2;
    private int distance2;
    private int gravity2;
    private int diameter2;

    public String getPlanetName2() {
        return planetName2;
    }

    public int getDistance2() {
        return distance2;
    }

    public int getGravity2() {
        return gravity2;
    }

    public int getDiameter2() {
        return diameter2;
    }

    public PlanetsCards(String planetName2, int distance2, int gravity2, int diameter2) {
        this.planetName2 = planetName2;
        this.distance2 = distance2;
        this.gravity2 = gravity2;
        this.diameter2 = diameter2;
    }
}
