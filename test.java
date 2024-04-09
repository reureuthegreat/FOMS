import java.util.Scanner;

public class test{
    public test() {
        int num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("The number you entered is " + number);
        sc.close();
    }
}