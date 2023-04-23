package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;


public class mod8_4 {
    private mod8_3 request;
    private int milesOnVehicle;
    private int price;
    private int numberOfSeats;
    private int numberOfDoors;
    private String[] options;
    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(mod8_4 customer) throws Exception {
        return objectMapper.writeValueAsString(customer);
    }

    public static mod8_4 fromJSON(String input) throws Exception {
        return objectMapper.readValue(input, mod8_4.class);
    }

    protected mod8_4() {
    }

    public mod8_4(mod8_3 request, int milesOnVehicle, int price, int numberOfSeats, int numberOfDoors, String[] options) {
        this.request = request;
        this.milesOnVehicle = 20000;
        this.price = 40000;
        this.numberOfSeats = 5;
        this.numberOfDoors = 4;
        this.options = options;
    }

    @Override
    public String toString() {
        String output = request.toString() + "\nMiles On Vehicle: " + milesOnVehicle + "\nPrice: " + price + "\nSeats: " + numberOfSeats + "\nDoors: " + numberOfDoors;
        return output;
    }

    public mod8_3 getRequest() {
        return request;
    }

    public void setRequest(mod8_3 request) {
        this.request = request;
    }

    public int getMilesOnVehicle() {
        return milesOnVehicle;
    }

    public void setMilesOnVehicle(int milesOnVehicle) {
        this.milesOnVehicle = milesOnVehicle;
    }

    public int getPrice() {
        return price;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}