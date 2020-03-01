using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week2Group2ASD
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = new int[] { 1, 2, 3, 4, 5, 6 };
            for (int i = 0; i < numbers.Length / 2; i++)
            {
                int tmp = numbers[i];
                numbers[i] = numbers[numbers.Length - 1 - i];
                numbers[numbers.Length - 1 - i] = tmp;
            }

            Console.WriteLine(String.Join(" ", numbers));
        }
    }
}
