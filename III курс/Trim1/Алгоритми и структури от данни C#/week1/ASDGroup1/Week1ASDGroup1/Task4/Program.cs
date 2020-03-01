using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task4
{
    class Programa
    {
        static void Main(string[] args)
        {
            //Премахане на елемент от масив.
            int[] numbers = new int[] { 1, 5, 7, 9, 11, 15, 9 };
            int search = 9;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] == search)
                {
                    for (int j = i; j < numbers.Length - 1; j++)
                    {
                        numbers[j] = numbers[j + 1];
                    }

                    numbers[numbers.Length - 1] = 0;
                }
            }

            Console.WriteLine(String.Join(" ", numbers));

            Console.ReadLine();
        }
    }
}
