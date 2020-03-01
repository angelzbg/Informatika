using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task4
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = new int[] { 1, 6, 12, 6, 15 };
            int search = 6;
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
