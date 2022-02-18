package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator <Object[]> loginValidData(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"lenastep@gmail.com", "12345nnnN"});
        list.add(new Object[]{"lenastep@gmail.com", "12345nnnN"});
        list.add(new Object[]{"lenastep@gmail.com", "12345nnnN"});

        return list.iterator();
    }



    @DataProvider
    public Iterator <Object[]> registrationValidData(){
        // ("Markus", "Strom", "markusstrom" + index + "@gmail.com", "Mstrom777%");

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Baby","Pups", "pups@tut.ru","Ppups888$"});

        return list.iterator();

    }


    @DataProvider
    public Iterator <Object[]> loginValidDataModel(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});

        return list.iterator();
    }



    @DataProvider
    public Iterator <Object[]> addCarSuccessDataModelCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/cars.csv")));
        String line = reader.readLine();

        while (line != null){
            String [] split = line.split(";");
            list.add(new Object[]{Car.builder()
                    .location(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .carClass(split[10])
                    .fuelConsumption(split[11])
                    .carRegNumber(split[12])
                    .price(split[13])
                    .distance(split[14])
                    .features(split[15])
                    .about(split[16])
                    .build()});

            line = reader.readLine();

        }
        return list.iterator();

    }


}





