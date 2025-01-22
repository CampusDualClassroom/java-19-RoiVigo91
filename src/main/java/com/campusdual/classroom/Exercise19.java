package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        return getTridimensionalString(intArrayTri, flatTridimensionalArray(intArrayTri));
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int cols = intArrayTri[0][0].length;
        int[][] flattened = new int[rows][cols];

        for (int d = 0; d < intArrayTri.length; d++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    flattened[i][j] += intArrayTri[d][i][j];
                }
            }
        }
        return flattened;

    }



    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            builder.append(getUnidimensionalString(intArrayBi[i])).append("\n");
        }
        return builder.toString().trim();
    }


    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            builder.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();

    }


    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i < columns; i++) {
            array[i] = i + 1;
        }
        return array;

    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = value++;
            }
        }
        return array;

    }


    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] array = new int[depth][rows][columns];
        int value = 1;
        for (int d = 0; d < depth; d++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[d][i][j] = value++;
                }
            }
        }
        return array;

    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
