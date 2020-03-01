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
            int[] numbers = new int[5];
            Random r = new Random();
            int sum = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 10);
                //sum = sum + numbers[i];
                sum += numbers[i];
            }

            Console.WriteLine(sum);
            Console.ReadLine();
        }
    }
}
