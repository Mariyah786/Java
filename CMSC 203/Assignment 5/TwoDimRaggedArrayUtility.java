package holidaybonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numRows = 0;
        while (scanner.hasNextLine()) {
            numRows++;
            scanner.nextLine();
        }
        scanner.close();

        double[][] array = new double[numRows][];
        scanner = new Scanner(file);
        int rowIndex = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.trim().split("\\s+");
            array[rowIndex] = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                array[rowIndex][i] = Double.parseDouble(tokens[i]);
            }
            rowIndex++;
        }
        scanner.close();
        return array;
    }

    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : array) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i]);
                if (i < row.length - 1) writer.print(" ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] array) {
        double total = 0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] array) {
        double total = getTotal(array);
        int count = 0;
        for (double[] row : array) {
            count += row.length;
        }
        return count == 0 ? 0 : total / count;
    }

    public static double getRowTotal(double[][] array, int rowIndex) {
        double total = 0;
        if (rowIndex >= 0 && rowIndex < array.length) {
            for (double value : array[rowIndex]) {
                total += value;
            }
        }
        return total;
    }

    public static double getColumnTotal(double[][] array, int columnIndex) {
        double total = 0;
        for (double[] row : array) {
            if (columnIndex >= 0 && columnIndex < row.length) {
                total += row[columnIndex];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length || array[rowIndex].length == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        double highest = array[rowIndex][0];
        for (double value : array[rowIndex]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length || array[rowIndex].length == 0) {
            return -1;
        }
        int highestIndex = 0;
        double highest = array[rowIndex][0];
        for (int i = 1; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > highest) {
                highest = array[rowIndex][i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    public static double getLowestInRow(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length || array[rowIndex].length == 0) {
            return Double.POSITIVE_INFINITY;
        }
        double lowest = array[rowIndex][0];
        for (double value : array[rowIndex]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length || array[rowIndex].length == 0) {
            return -1;
        }
        int lowestIndex = 0;
        double lowest = array[rowIndex][0];
        for (int i = 1; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] < lowest) {
                lowest = array[rowIndex][i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    public static double getHighestInColumn(double[][] array, int columnIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            if (columnIndex >= 0 && columnIndex < row.length) {
                if (row[columnIndex] > highest) {
                    highest = row[columnIndex];
                }
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] array, int columnIndex) {
        int highestIndex = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            if (columnIndex >= 0 && columnIndex < array[rowIndex].length) {
                if (array[rowIndex][columnIndex] > highest) {
                    highest = array[rowIndex][columnIndex];
                    highestIndex = rowIndex;
                }
            }
        }
        return highestIndex;
    }

    public static double getLowestInColumn(double[][] array, int columnIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            if (columnIndex >= 0 && columnIndex < row.length) {
                if (row[columnIndex] < lowest) {
                    lowest = row[columnIndex];
                }
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] array, int columnIndex) {
        int lowestIndex = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            if (columnIndex >= 0 && columnIndex < array[rowIndex].length) {
                if (array[rowIndex][columnIndex] < lowest) {
                    lowest = array[rowIndex][columnIndex];
                    lowestIndex = rowIndex;
                }
            }
        }
        return lowestIndex;
    }

    public static double getHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}
