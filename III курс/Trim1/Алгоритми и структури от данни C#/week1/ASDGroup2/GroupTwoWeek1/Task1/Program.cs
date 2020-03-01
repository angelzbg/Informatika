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
            //Дали числото съществува в масив.
            int[] numbers = new int[] { 1, 5, 7, 9, 15 };
            int input = int.Parse(Console.ReadLine());
            bool check = false;
            for (int i = 0; i < numbers.Length; i++)
            {
                if (input == numbers[i])
                {
                    check = true;
                    Console.WriteLine("Number exists!");
                    break;
                }
            }

            if (check == false)
            {
                Console.WriteLine("Number doesnt exist!");
            }

        }
    }
}
