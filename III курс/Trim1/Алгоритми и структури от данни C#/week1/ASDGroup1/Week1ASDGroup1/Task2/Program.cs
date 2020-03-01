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
            Random r = new Random();
            int[] numbers = new int[3];
            int sum = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 5);
                //sum = sum + numbers[i];
                sum += numbers[i];
            }
            //numbers.Sum();

            Console.WriteLine(sum);
            Console.ReadLine();
        }
    }
}
