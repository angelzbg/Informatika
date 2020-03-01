using System;
using System.Collections.Generic;

namespace _2_3ta_1601261021
{
    class Program
    {
        static void Main(string[] args)
        {
            medians();
            Console.ReadKey();
        }

        static void medians()
        {
            int N = 0;
            while (N <= 0) int.TryParse(Console.ReadLine(), out N);

            string[] lines = new string[N];

            int numberCount = 0;
            for (int i = 0; i < N; i++)
            {
                lines[i] = Console.ReadLine();
                if (lines[i].Contains("A")) numberCount++;
            }

            double[] numbers = new double[numberCount];

            int temp1 = 0;
            for (int i = 0; i < N; i++)
                if (lines[i].Contains("A"))
                    numbers[temp1++] = double.Parse(lines[i].Replace("A ", "").Replace(".", ","));
            temp1 = 0;

            for (int i = 0; i < N; i++)
            {
                if (lines[i].Contains("G"))
                {
                    double[] tempArray1 = new double[temp1];
                    for (int j = 0; j < temp1; j++) tempArray1[j] = numbers[j];

                    for (int j = 0; j < temp1; j++)
                    {
                        for (int k = 0; k < temp1 - 1; k++)
                        {
                            if (tempArray1[k] > tempArray1[k + 1])
                            {
                                double temp = tempArray1[k];
                                tempArray1[k] = tempArray1[k + 1];
                                tempArray1[k + 1] = temp;
                            }
                        }
                    }

                    if (temp1 % 2 == 0) Console.WriteLine((tempArray1[temp1/2 - 1] + tempArray1[temp1/2])/2);
                    else Console.WriteLine(tempArray1[temp1/2]);
                }
                else temp1++;
            }
        }
    }
}