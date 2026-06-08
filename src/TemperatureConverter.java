import java.util.Scanner;

public class TemperatureConverter {


    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        }
        else if (unit.equalsIgnoreCase("F")) {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
        return temperature;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature or type \"stop\": ");
            String tempInput = scnr.next();

            if (tempInput.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                Scanner tempScanner = new Scanner(tempInput);

                if (!tempScanner.hasNextDouble()) {
                    System.out.println("Invalid temperature. Please enter a numeric value.");
                } else {
                    double temperature = tempScanner.nextDouble();

                    System.out.print("Enter unit (C or F): ");
                    String unit = scnr.next();

                    if (!(unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F"))) {
                        System.out.println("Invalid unit. Please enter C for Celsius or F for Fahrenheit.");
                    } else {
                        double converted = convertTemperature(temperature, unit);

                        if (unit.equalsIgnoreCase("C")) {
                            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, converted);
                        } else {
                            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, converted);
                        }
                    }
                }
            }
        }
    }
}