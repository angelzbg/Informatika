using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task4
{
    class Program
    {
        static int Fib(int n)
        {
            if (n <= 2)
            {
                return 1;
            }

            return Fib(n - 1) + Fib(n - 2);
        }

        static void Main(string[] args)
        {
            //Console.WriteLine(Fib(44));
            int[] fibNumbers = new int[50];
            fibNumbers[0] = 1;
            fibNumbers[1] = 1;
            for (int i = 2; i < fibNumbers.Length; i++)
            {
                fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
            }

            Console.WriteLine(fibNumbers[43]);
            Console.ReadLine();
        }
    }
}
