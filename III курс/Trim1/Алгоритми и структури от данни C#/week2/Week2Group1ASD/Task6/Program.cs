using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Task6
{
    class Program
    {
        static int Fac(int n)
        {
            if (n <= 1)
            {
                return 1;
            }

            return n * Fac(n - 1);
        }

        static void Main(string[] args)
        {
            BigInteger b = new BigInteger();
            int N = int.Parse(Console.ReadLine());
            Console.WriteLine(Fac(N));
            Console.ReadLine();
        }
    }
}
