using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task1
{
    class Program
    {
        static void Main(string[] args)
        {
            Random r = new Random();
            Console.BackgroundColor = ConsoleColor.White;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.Clear();
            // int rand = r.Next(1, 5);
            int[] numbers = new int[5];
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 5);
            }

            /*var n = numbers.Where(x => x == 5).Count();

            if (n > 0)
            {
                Console.WriteLine("Number exists");
            }
            else
            {
                Console.WriteLine("Number doesnt exists.");
            }*/

            Console.WriteLine("Input number:");
            int input = int.Parse(Console.ReadLine());

            bool check = false;
            for (int i = 0; i < numbers.Length; i++)
            {
                if (input == numbers[i])
                {
                    check = true;
                    Console.WriteLine("Number exists");
                    break;
                }
            }
            if (check == false)
            {
                Console.WriteLine("Number doesnt exists.");
            }


            Console.ReadLine();
        }
    }
}
