package _JDBC_.Gun2;

public class _03_Printf {
    public static void main(String[] args) {
        //virgulden onceki bolum formati,   virgulden sonraki bolum satirlari temsil eder

        int a = 2324;
        double pi = 3.1412343;
        String isim = "ayser burak";
        char basharf = 'b';

        System.out.printf("%5d",a); // a yi 5 hane icinde ondalik sistemde goster

        System.out.println();

        System.out.printf("%-5d",a); // a yi 5 hane icinde ondalik sistemde goster

        System.out.println();

        System.out.printf("%-5d @f",a,pi);

        System.out.println();

        System.out.printf("%-5d %6.2f",a,pi);
        //               6 hane kullan noktadan sonra 2 hane kullan

        System.out.println();

        System.out.printf("%-5d %6.2f %20s \n",a,pi,isim);

        System.out.println();

        System.out.printf("%-6.1f",pi);
        System.out.println();
        System.out.printf("%6.1f",pi);

    }
}
