using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task5
{
    class Program
    {
        static int Fib(int n)
        {
            if (n <= 1)
            {
                return 1;
            }

            return Fib(n - 1) + Fib(n - 2);
        }

        static void Main(string[] args)
        {
            //Console.WriteLine(Fib(45));
            
            int[] array = new int[45];
            array[0] = 1;
            array[1] = 1;
            for (int i = 2; i < array.Length; i++)
            {
                array[i] = array[i - 1] + array[i - 2];
            }


            Console.ReadLine();
        }
    }
}
