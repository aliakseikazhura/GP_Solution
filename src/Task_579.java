import java.io.*;

public class Task_579 {
    public static void main(String[] args) throws IOException {
        int sumPositive = 0, sumNegative = 0, countPositive = 0, countNegative = 0;
        try (
                BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT.txt"))
        ) {
            int g = Integer.parseInt(br.readLine());
            int[] array = new int[g];
            String[] inputArray = br.readLine().split("\\s+");
            for (int i = 0; i < g; i++) {
                array[i] = Integer.parseInt(inputArray[i]);
            }
            for (int i = 0; i < g; i++) {
                if (array[i] > 0) {
                    sumPositive += array[i];
                    countPositive++;
                } else {
                    if (array[i] < 0) {
                        sumNegative += array[i];
                        countNegative++;
                    }
                }
            }
            if (Math.abs(sumPositive) >= Math.abs(sumNegative)) {
                bw.write(countPositive + "\r\n");
                for (int i = 0; i < g; i++) {
                    if (array[i] > 0)
                        bw.write(i + 1 + " ");
                }
            } else {
                if (Math.abs(sumPositive) < Math.abs(sumNegative)) {
                    bw.write(countNegative + "\r\n");
                    for (int i = 0; i < g; i++) {
                        if (array[i] < 0)
                            bw.write(i + 1 + " ");
                    }
                } else {
                    bw.write(0 + "\r\n");
                }
            }

        }
    }
}
