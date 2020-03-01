using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task5
{
    class Program
    {
        static void Main(string[] args)
        {
            bool[] numbers = new bool[201];
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = true;
            }

            for (int i = 2; i < numbers.Length; i++)
            {
                if (numbers[i] == true)
                {
                    for (int j = i * 2; j < numbers.Length; j += i)
                    {
                        numbers[j] = false;
                    }
                }
            }

            for (int i = 2; i < numbers.Length; i++)
            {
                if (numbers[i])
                {
                    Console.WriteLine(i);
                }
            }

            Console.ReadLine();
        }
    }
}
