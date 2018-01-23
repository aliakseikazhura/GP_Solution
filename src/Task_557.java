import java.io.*;

public class Task_557 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT.txt"))
        ) {
            int[][] matrixA, result;
            String line[];
            String[] data = br.readLine().split("\\s+");
            int countMatrix = Integer.parseInt(data[0]);
            int size = Integer.parseInt(data[1]);
            String[] coordinates = br.readLine().split("\\s+");
            int coordinateI = Integer.parseInt(coordinates[0]);
            int coordinateJ = Integer.parseInt(coordinates[1]);
            int primeNumber = Integer.parseInt(br.readLine());
            br.readLine();
            matrixA = new int[size][size];
            result = new int[size][size];
            if (countMatrix >= 2) {
                for (int i = 0; i < size; i++) {
                    line = br.readLine().split("\\s+");
                    for (int j = 0; j < size; j++) {
                        result[i][j] = Integer.parseInt(line[j]);
                    }
                }
                for (int c = 1; c < countMatrix; c++) {
                    br.readLine();
                    for (int i = 0; i < size; i++) {
                        line = br.readLine().split("\\s+");
                        for (int j = 0; j < size; j++)
                            matrixA[i][j] = Integer.parseInt(line[j]);
                    }
                    result = multiplyMatrices(result, matrixA, primeNumber);
                }
                bw.write(String.valueOf(result[coordinateI - 1][coordinateJ - 1]));
            } else {
                for (int i = 0; i < size; i++) {
                    line = br.readLine().split("\\s+");
                    for (int j = 0; j < size; j++)
                        matrixA[i][j] = Integer.parseInt(line[j]);
                }
                bw.write(String.valueOf(matrixA[coordinateI - 1][coordinateJ - 1]));
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int primeNumber) {
        int size = matrixA.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                if (sum >= primeNumber && primeNumber > 0)
                    result[i][j] = sum % primeNumber;
                else
                    result[i][j] = sum;
            }
        }
        return result;
    }
}

