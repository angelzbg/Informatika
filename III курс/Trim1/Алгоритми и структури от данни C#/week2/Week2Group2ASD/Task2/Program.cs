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
            int[] numbers = new int[] { 10, 20, 30, 40, 0 };
            int N = 333;

            if (N > numbers[numbers.Length - 2])
            {
                numbers[numbers.Length - 1] = N;
            }
            else
            {
                for (int i = 0; i < numbers.Length; i++)
                {
                    if (numbers[i] > N)
                    {
                        for (int j = numbers.Length - 1; j > i; j--)
                        {
                            numbers[j] = numbers[j - 1];
                        }
                        numbers[i] = N;
                        break;
                    }
                }
            }

            Console.WriteLine(String.Join(",", numbers));
            Console.ReadLine();
        }
    }
}
