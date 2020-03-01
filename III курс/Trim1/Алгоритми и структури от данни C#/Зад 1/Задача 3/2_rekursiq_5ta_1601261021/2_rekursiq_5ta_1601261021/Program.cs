using System;

namespace _2_rekursiq_5ta_1601261021
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());

            int number = -1;
            bool check = true;

            while(check)
            {
                check = false;
                number++;
                int[] a = new int[N]; //всички елементи са ми = 0
                int temp = number, counter = N;
                while (temp > 0)
                {
                    counter--;
                    if (temp == 1)
                    {
                        a[counter] = 1;
                        temp = 0;
                    }
                    else
                    {
                        if (temp % 2 == 0) a[counter] = 0;
                        else a[counter] = 1;
                        temp = temp / 2;
                    }
                }
                Console.WriteLine(string.Join(" ", a));
                for (int i = 0; i < N; i++) if (a[i] == 0) { check = true; break; }
            }

            Console.ReadKey();
        }
    }
}