import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Task_670 {
    public static boolean ostChs(int x) {
        List<Integer> list = new ArrayList<>();
        int p = 0;
        while (x != 0) {
            p = x % 10;
            if (list.contains(p)) {
                return false;
            } else {
                list.add(p);
            }
            x = x / 10;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt();
        int number = 0, i = 1;
        for (; number < g; i++) {
            if (ostChs(i))
                number++;
        }
        System.out.println(i - 1);
    }
}
