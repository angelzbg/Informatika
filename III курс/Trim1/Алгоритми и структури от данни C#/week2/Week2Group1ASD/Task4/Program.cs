using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task4
{
    class Program
    {
        static string Reverse(string stringToReverse)
        {
            return Reverse(stringToReverse, "");
        }
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
        static void Main(string[] args)
        {
            string helloReversed = Reverse("Hello");
            Console.WriteLine(helloReversed);
            Console.ReadLine();
        }
    }
}
