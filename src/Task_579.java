import java.io.*;

public class Task_579 {
    public static void main(String[] args) throws IOException {
        int sumPol = 0, sumOtr = 0, countPol = 0, countOtr = 0, countZero = 0;
        try (
                BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT.txt"))
        ) {
            int g = Integer.parseInt(br.readLine());
            int[] mas = new int[g];
            String[] inputArray = br.readLine().split("\\s+");
            for (int i = 0; i < g; i++) {
                mas[i] = Integer.parseInt(inputArray[i]);
            }
            for (int i = 0; i < g; i++) {
                if (mas[i] > 0) {
                    sumPol += mas[i];
                    countPol++;
                }
                if (mas[i] < 0) {
                    sumOtr += mas[i];
                    countOtr++;
                }
                if (mas[i] == 0)
                    countZero++;
            }
            if (countZero == g) {
                bw.write(0 + "\r\n");
            }
            if (Math.abs(sumPol) > Math.abs(sumOtr)) {
                bw.write(countPol + "\r\n");
                System.out.println(countPol);
                for (int i = 0; i < g; i++) {
                    if (mas[i] > 0)
                        bw.write(i + 1 + " ");
                }
            }
            if (Math.abs(sumPol) < Math.abs(sumOtr)) {
                bw.write(countOtr + "\r\n");
                for (int i = 0; i < g; i++) {
                    if (mas[i] < 0)
                        bw.write(i + 1 + " ");
                }
            }
        }

    }
}
