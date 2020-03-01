using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task6
{
    class Program
    {
        static string Reverse(string start, string reversed)
        {
            if (start.Length == 0)
            {
                return reversed;
            }

            reversed = reversed + start[start.Length - 1];
            start = start.Substring(0, start.Length - 1);

            return Reverse(start, reversed);
        }

        static string Reverse(string start)
        {
            return Reverse(start, "");
        }

        static void Main(string[] args)
        {
            Console.WriteLine(Reverse("Hello"));
            Console.ReadLine();
        }
    }
}
