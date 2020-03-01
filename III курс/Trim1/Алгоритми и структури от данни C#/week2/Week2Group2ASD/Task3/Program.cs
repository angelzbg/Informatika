using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    class Program
    {
        static void Print(int n)
        {
            if (n <= 0)
            {
                return;
            }
            Console.WriteLine(n);
            Print(n - 1);
        }

        static void Main(string[] args)
        {
            //Без цикъл изведете числата от едно до 10
            Print(10);
            Console.ReadLine();
        }
    }
}
