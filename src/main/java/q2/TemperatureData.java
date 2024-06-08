package q2;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This class represents the data about the temperatures of each year. It provides services and tools
 to control each year's data.
 */
public class TemperatureData {
    // Initializing instance variables.
    private final int NUMBER_OF_YEARS = 5;
    private final int NUMBER_OF_MONTHS = 12;
    private int[][]temperatures = new int[NUMBER_OF_YEARS][NUMBER_OF_MONTHS];
    private final int[] years = {2017, 2018, 2019, 2020, 2021};
    private int currentYearIndex = 0;
    public final String title = "Average Temperature For Year ";

    /**
     * This method creates a two - dimensional array of a random temperatures values and returns it.
     * @return A two - dimensional array of a random temperatures values.
     */
    public int[][] createTemperatures() {
        Random rnd = new Random();
        for(int i = 0; i < temperatures.length; i++)
            for (int j = 0; j < temperatures[0].length; j++)
                temperatures[i][j] = rnd.nextInt(1, 45);
        return temperatures;
    }

    /**
     * This method returns the current year.
     * @return  The current year.
     */
    public int[] getYears() {
        return this.years;
    }

    /**
     * This method return the current year index.
     * @return The current year index.
     */
    public int getCurrentYearIndex() {
        return this.currentYearIndex;
    }

    /**
     * This method finds and returns the minimum temperature of the current year.
     * @return The minimum temperature of the current year.
     */
    public int getMinTemperature() {
        int min = temperatures[currentYearIndex][0];
        for (int j = 1; j < temperatures[0].length; j++) {
            if (temperatures[currentYearIndex][j] < min)
                min = temperatures[currentYearIndex][j];
        }
        return min;
    }

    /**
     * This method finds and returns the maximum temperature of the current year.
     * @return The maximum temperature of the current year.
     */
    public int getMaxTemperature() {
        int max = temperatures[currentYearIndex][0];
        for (int j = 1; j < temperatures[0].length; j++) {
            if (temperatures[currentYearIndex][j] > max)
                max = temperatures[currentYearIndex][j];
        }
        return max;
    }

    /**
     * This method finds and returns the average temperature of the current year.
     * @return The average temperature of the current year.
     */
    public double getAverageTemperature() {
        double sum = 0;
        for(int j = 0; j < temperatures[0].length; j++) {
            sum += temperatures[currentYearIndex][j];
        }
        sum /= temperatures[0].length;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedSum= df.format(sum);
        return Double.valueOf(formattedSum);
    }

    /**
     * This method initializes the current year index to a particular parameter.
     * @param x A parameter to change current year index's value to.
     */
    public void setCurrentYearIndex(int x) {
        this.currentYearIndex = x;
    }
}

