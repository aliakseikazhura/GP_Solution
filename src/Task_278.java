import java.io.*;

public class Task_278 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT.txt"))
        ) {
            int i = 0;
            String s = br.readLine();
            String t = br.readLine();
            if (s.length() > t.length())
                bw.write("NO");
            else {
                for (int j = 0; j < t.length(); j++) {
                    if (i >= s.length())
                        break;

                    if (s.charAt(i) == t.charAt(j))
                        i++;
                }
                if (s.length() == i && i != 0)
                    bw.write("YES");
                else
                    bw.write("NO");
            }
        }
    }
}
