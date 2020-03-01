using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week2Group1ASD
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
             Имаме масива A - Трябва да направим така, че стойностите му да се разменят отгледално.
Пример :
Вход: {1,7,9,15,17} Изход {17,15,9,7,1} -> Като данните в масива също трябва да са запазени
по този начин
Вход: {4, 11,5,9,21} -> 21,9,5,11,4
             
             */
            int[] numbers = new int[] { 5, 7, 9, 15, 21 };
            for (int i = 0; i < numbers.Length / 2; i++)
            {
                int tmp = numbers[i];
                numbers[i] = numbers[numbers.Length - i - 1];
                numbers[numbers.Length - i - 1] = tmp;
            }

            Console.ReadLine();
        }
    }
}
