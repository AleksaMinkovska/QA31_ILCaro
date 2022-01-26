package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Car {

    String location;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String carClass;
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distance;
    String features;
    String about;

}
