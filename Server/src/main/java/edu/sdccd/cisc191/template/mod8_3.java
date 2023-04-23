package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;


public class mod8_3 {
    private int year;
    private String make = "BMW";
    private String model = "328i";

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(mod8_3 customer) throws Exception {
        return objectMapper.writeValueAsString(customer);
    }
    public static mod8_3 fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, mod8_3.class);
    }
    protected mod8_3() {}
    public mod8_3(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }
    @Override
    public String toString() {
        String output = "Vehicle Year: " + year + "\nMaker: " + make + "\nModel: "
                + model;
        return output;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}