using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task2
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
             Напишете програма, в която въвеждаме масив в нарастващ ред. След което
въвеждаме стойност.
Нека тази стойност да бъде поставена точно там където е необходимо.
Пример:
Вход:
1, 3,5,7,9
4
Изход:
1, 3, 4,5,7,9
             */

            int[] numbers = new int[] { 10, 20, 30, 40, 50, 0 };
            int num = 25;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] > num)
                {
                    for (int j = numbers.Length - 1; j > i; j--)
                    {
                        numbers[j] = numbers[j - 1];
                    }
                    numbers[i] = num;
                    break;
                }
            }
            Console.WriteLine(String.Join(" ", numbers));
            Console.ReadLine();
        }
    }
}
