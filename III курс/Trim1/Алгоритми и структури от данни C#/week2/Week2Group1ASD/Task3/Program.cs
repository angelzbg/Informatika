using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    class Program
    {
        static void PrintNumbers(int x)
        {
            if (x < 1)
            {
                return;
            }
            Console.WriteLine(x);
            PrintNumbers(x - 1);
        }

        static void Main(string[] args)
        {
            PrintNumbers(10);
            Console.ReadLine();
        }
    }
}
