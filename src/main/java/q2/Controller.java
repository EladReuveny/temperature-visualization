package q2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This class allows connecting and integrating between the SceneBuilder App to the Java code.
 */
public class Controller {
    @FXML
    private Canvas canvas;

    //Creating a TemperatureData's object to use its services.
    private TemperatureData temperatures = new TemperatureData();
    int[][] temperaturesArr = temperatures.createTemperatures();

    @FXML
    /*
      A method whose called while clicking the Next button, and draws the graph represented
     by columns which represent temperatures of a year, for each year.
     */
    public void drawGraph() {
        // Clear the canvas.
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        // Get information about the temperatures.
        int[] years = temperatures.getYears();
        int currentYearIndex = temperatures.getCurrentYearIndex();
        int year = years[currentYearIndex];
        int minTemp = temperatures.getMinTemperature();
        int maxTemp = temperatures.getMaxTemperature();
        double avgTemp = temperatures.getAverageTemperature();

        // Set up some constants for drawing the columns.
        int columnWidth = 50;
        int columnHeight = 400;
        int x = 300;
        int y = 500;

        // Set up the graphics context for drawing the columns.
        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        // Draw columns for each month
        for (int j = 0; j < temperaturesArr[0].length; j++) {
            int temp = temperaturesArr[currentYearIndex][j];
            int columnX = x + j * columnWidth;
            int columnY = y - (temp - minTemp) * columnHeight / (maxTemp - minTemp);
            int columnHeightAdjusted = columnHeight * temp / (maxTemp - minTemp);

            Color columnColor = Color.LIGHTGRAY;
            //Checking if current temperature is the min/max, and painting its column with blue/red, respectively.
            if (temp == maxTemp)
                columnColor = Color.RED;
            else if (temp == minTemp)
                columnColor = Color.BLUE;
            gc.setFill(columnColor);
            gc.fillRect(columnX, columnY, columnWidth, columnHeightAdjusted);
            gc.strokeRect(columnX, columnY, columnWidth, columnHeightAdjusted);

            // Draw temperature value on top of column
            gc.strokeText(String.valueOf(temp), columnX + columnWidth / 2, columnY - 5);

            /*// Draw month number centered under column
            String month = String.valueOf(j + 1);
            double monthWidth = new Font("Arial", 12).getSize() * month.length() * 0.6;
            double monthX = columnX + columnWidth / 2 - monthWidth / 2;
            gc.strokeText(String.valueOf(j + 1), monthX, y + 20);*/
            gc.strokeText(String.valueOf(j + 1), columnX + columnWidth / 2, y + 20);
        }

        // Draw the graph title and current year's average temperature.
        gc.setFont(Font.font("Arial", 16));
        gc.strokeText(temperatures.title + year + " is: " + avgTemp, 400, 50);

        //Advance to the next year circularly.
        temperatures.setCurrentYearIndex((currentYearIndex + 1) % years.length);
    }
}