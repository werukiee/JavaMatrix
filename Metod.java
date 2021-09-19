package Viper;

import java.util.Scanner;

public class Metod {
    Scanner sc=new Scanner(System.in);
    int[][] mass;
    int n; int m;
    Metod(int m,int n)
    {
        this.n=n;
        this.m=m;
        mass=new int[m][n];
    }

    void print() //ВВОД МАТРИЦЫ РАНДОМНО
    {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                mass[i][j] = (int) (Math.random() * 10) + 1;
                System.out.print(mass[i][j]+" ");
            }
            System.out.println();
        }
    }

    void printt() //ВВОД МАТРИЦЫ С КЛАВИАТУРЫ И ВЫВОД НА ЭКРАН
    {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                mass[i][j] = sc.nextInt();;
            }
            System.out.println();
        }
        System.out.println("Матрица: ");
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mass[i][j]+" ");
            }
            System.out.println();
        }
    }

    boolean neprost(int a) //2ФУНКЦИЯ НА ПРОВЕРКУ НЕПРОСТОГО ЧИСЛА
    {
        int kol=0;
        for(int i=1;i<=a;i++)
            if(a%i==0)
                kol++;
        if(kol>2)
            return true;
        else
            return false;
    }

    void neupor() //ФУНКЦИЯ НА ПРОВЕРКУ НЕПРОСТОГО ЧИСЛА
    {
        int num=0; int kol=0;
        for(int i=0;i<n;i++)
        {
            kol=0; num++; //ТУТ СЧИТАЮ НОМЕРА СТОЛБЦОВ
            for(int j=0;j<n-1;j++){
                if(mass[j][i]>mass[j+1][i]) { //СЧЕТЧИК НЕУПОДРЯЧЕННЫХ ЭЛЕМЕНТОВ
                    kol++;
                }
            }
            if(kol==0)
                System.out.print(num+" ");

        }
    }

    void povtor() //ФУНКЦИЯ НА НЕУПОРЯД ЭЛЕМЕНТЫ В СТОЛБЦАХ
    {
        int num=0; int kol=0;
        for(int i=0;i<n;i++) {
            kol = 0; num++; //ТУТ СЧИТАЮ НОМЕРА СТРОК
            for (int j = 0; j < n-1; j++)
                if (mass[i][j] == mass[i][j+1]) //СЧЕТЧИК ПОВТОРЯЮЩИХСЯ В КАЖДОЙ СТРОКЕ
                    kol++;
            if(kol>0)
                System.out.print(num+ " ");
        }
    }

    double Arif() //СРЕДНЕЕ АРИФ НЕПРОСТЫХ
    {
        double sum=0; double kol=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(neprost(mass[i][j])) //ФУНКЦИЯ НА ПРОВЕРКУ НЕПРОСТОГО ЧИСЛА
                {
                    sum += mass[i][j]; kol++;
                }
        if(sum>0)
            return sum/kol;
        else
            return sum;
    }
    void spiral()
    {
        int i, j, k = 1, c = 0, b;
        b = m * n;
        do                                                      // до тех пор пока k != b(макс. елем.) заполняем матрицу
        {                                                       //
            for (j = c; j < n - c; j++)                         // алгоритм словами я передать не могу
            {                                                   // но смысл его в том что матрица заполняется
                if (k > b)                                      // по 4 стенкам(соответственно 4 форами)
                    break;                                      //
                System.out.print(mass[c][j]+" ");                               // * * * * *
            }                                                   // * * * * *   <---- "типо" матрица 4х5
                                                                // * * * * *
            for(i=c+1;i<m-c;i++)                                // * * * * *
            {                                                   //
                if(k > b)                                       // 1 2 3 4 5   <---- первая стенка
                    break;                                      // * * * * *
                System.out.print(mass[i][n - c - 1]+" ");       // * * * * *
            }                                                   // * * * * *
            //
            for(j = n - c - 2; j >= c; j--)                     // 1 2 3 4 5
            {                                                   // * * * * 6
                if(k > b)                                       // * * * * 7
                    break;                                      // * * * * 8
                System.out.print(mass[m - c - 1][j]+" ");                       //         ^
            }                                                   //         '-------- вторая стенка
            //
            for(i = m - c - 2; i > c; i--)                      //
            {                                                   // 1  2  3  4  5                                1  2  3  4  5
                if(k > b)                                       // *  *  *  *  6                                14 *  *  *  6
                    break;                                      // *  *  *  *  7                                13 *  *  *  7
                System.out.print(mass[i][c]+" ");               // 12 11 10 9  8     <---- третья стенка        12 11 10 9  8
            }                                                   //                                              ^
            //                                                                                                  '------- четвертая стенка
            c++;                                                // счетчик количества("толщины") стенок
        }
        while(k <= m * n);                                      // ну и на следующих кругах заполняем оставшиеся "места"
        // if-ы нужны для того чтобы не случилась перезапись
        // верхней стенки -> нижней
        // и левой -> правой

    }
}

