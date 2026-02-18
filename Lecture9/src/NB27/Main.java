package NB27;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Car[] cars = new Car[20];
        int counter = 0;

        BufferedReader br = new BufferedReader(new FileReader("src/NB27/carList.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());

                String[] splitLine = line.split(" ");

                cars[counter] = new Car(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
                counter++;
                line = br.readLine();
            }
            String everything = sb.toString();
        } finally {
            br.close();
        }

        System.out.println(Arrays.toString(cars));

        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = 0; j < cars.length; j++) {
            }

        }
    }
}