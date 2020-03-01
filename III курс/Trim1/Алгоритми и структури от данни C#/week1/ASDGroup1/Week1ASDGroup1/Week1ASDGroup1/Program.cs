using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week1ASDGroup1
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 5;
            double b = 5.5;
            float c = 5.5f;
            decimal d = 5.5m;
            char symbol = 's';
            string name = "Gosho";


            int[] arvariabler = new int[] { 1, 2, 3, 4, 5 };
            var variable = new int[5];
            bool check = true;

            if (check)
            {
                Console.WriteLine("Hello !");
            }

            int[] array = new int[5];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = 1;
            }

            Console.ReadLine();

        }
    }
}
