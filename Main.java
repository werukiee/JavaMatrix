package Viper;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите размер матрицы(строк и столбцов): ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        Metod m1=new Metod(m,n);
        System.out.println("Введите матрицу: ");
        m1.print();
        System.out.println("Среднее ариф. непростых элементов: "+m1.Arif());
        System.out.print("Номера упорядоченных столбцов: ");m1.neupor();
        System.out.println();
        System.out.print("Номера строк с повт.элементами: ");m1.povtor();
        System.out.println();
        System.out.print("Спираль: ");
        m1.spiral();
    }
}
