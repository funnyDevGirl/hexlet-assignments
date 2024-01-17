package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    //возвращает JSON представление объекта (в виде строки)
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json =  mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    //возвращает объект класса Car с соответствующими свойствами
    public static Car unserialize(String json) {

        ObjectMapper mapper = new ObjectMapper();
        Car car;
        try {
            car = mapper.readValue(json, Car.class);
            //return mapper.readValue(json, Car.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    // END
}
