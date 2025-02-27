import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        //считываем с консоли размер массива n на m
        out.println("Введите размер массива");
        int n = in.nextInt();//считываем n
        int m = in.nextInt();//считываем m
        int[][] a = new int[n][m];//создаём массив a

        // Заполнение массива
        out.println("Введите элементы массива");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        out.println("Введите число k");
        int k = in.nextInt();//считываем число k
        out.println("Изначальный массив");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(a[i][j] + " ");
            }
            out.println();
        }

        //2.Сортирует элементы каждой строки по возрастанию остатков от деления на K.
        // Если остатки равны, сортирует элементы по убыванию.
        //сортируем каждую строчку
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                for (int l = j + 1; l < m; l++) {//создаём дополнительный цикл для сортировки
                    //создаём переменные для остатков при делении на k
                    int rem1 = a[i][j] % k;
                    int rem2 = a[i][l] % k;
                    //сравниваем остатки
                    if (rem1 > rem2 || (rem1 == rem2 && a[i][j] < a[i][l])) {
                        //меняем местами,если условие выполняется
                        int temp = a[i][j];
                        a[i][j] = a[i][l];
                        a[i][l] = temp;
                    }
                }
            }
        }
        //вывод результата
        out.println("Отсортированный массив");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(a[i][j] + " ");
            }
            out.println();
        }
        //3.Находит произведение максимальных элементов каждой строки, а также их индексы в строках.
        int pr = 1;//создаём переменную pr,которую будем использовать для подсчёта произведения
        out.println("Индексы максимальных элементов");
        for (int i = 0; i < n; i++) {
            int maxi = 0;//создаём переменную maxi,в которой будет находится индекс максимального элемента
            for (int j = 0; j < m; j++) {//ищет максимальный элемент
                if (a[i][maxi] < a[i][j]){
                    maxi = j;
                }
            }
            out.print("[" + i + "]"+"["+maxi +"]"+ " ");//выводит индексы максимальных элементов
            pr *= a[i][maxi];//находим произведение максимальных элементов
        }
        out.println();
        out.println("Произведение максимальных элементов");
        out.println(pr);//выводим произведение максимальных элементов
        // 4. Выводим элементы массива в транспонированном виде
        out.println("Элементы массива в транспонированном виде:");
        // Для транспонирования мы меняем местами i и j
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out.print(a[j][i] + " ");
            }
            out.println();
        }

        out.print("Массив,после удаления элементов кратных k");
        out.println(" ");
        //5. Удаляет из массива все элементы, которые являются кратными числу K,
        // выводит получившийся массив массивов, а также количество удалённых элементов.
        int count = 0;//создаём переменную для подсчёта суммы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] % k != 0){//проверяем условие,что элемент массива не делится на k,если условие выполняется,увеличиваем сумму и выводим элемент массива
                    count++;
                    out.print(a[i][j] + " ");
                }
            }
            out.println();
        }
        int c = (m*n)-count;
        out.println("Количество элементов кратных k");
        out.print(c);//выводим сумму элементов кратных k
    }
}
