using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = new int[] { 1, 6, 12, 9, 15 };
            int[] even = new int[numbers.Length];
            int counter = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] % 2 == 0)
                {
                    even[counter] = numbers[i];
                    counter++;
                }
            }

            for (int i = 0; i < counter; i++)
            {
                Console.WriteLine(even[i]);
            }

            Console.ReadLine();
        }
    }
}
