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
            //Генериране на прости числа.
            bool[] primes = new bool[201];
            for (int i = 0; i < primes.Length; i++)
            {
                primes[i] = true;
            }

            for (int i = 2; i < primes.Length; i++)
            {
                if (primes[i] == true)
                {
                    for (int j = i * 2; j < primes.Length; j += i)
                    {
                        primes[j] = false;
                    }
                }
            }

            for (int i = 2; i < primes.Length; i++)
            {
                if (primes[i] == true)
                {
                    Console.WriteLine(i);
                }
            }

            Console.ReadLine();
        }
    }
}
