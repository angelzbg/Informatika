using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task5
{
    class Program
    {
        static int Factorial(int N)
        {
            if (N <= 1)
            {
                return 1;
            }
            return N * Factorial(N - 1);
        }
        static void Main(string[] args)
        {
            Console.WriteLine(Factorial(5));
            Console.ReadLine();
        }
    }
}
