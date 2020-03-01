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
            Random r = new Random();
            int[] numbers = new int[5];
            int[] even = new int[5];
            int counter = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 5);
                if (numbers[i] % 2 == 0)
                {
                    even[counter] = numbers[i];
                    counter++;
                }
            }

            for (int i = 0; i < counter; i++)
            {
                Console.Write(even[i] + " ");
            }

            Console.ReadLine();
        }
    }
}
