using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task6
{
    class Program
    {
        static void Main(string[] args)
        {
            //Да се напише програма, която чете 
            //от конзолата две цели числа N и K 
            //(K<N), и масив от N елемента.
            //Да се намерят тези K поредни елемента, 
            //които имат максимална сума.
            //N=5 K=2
            //1,2,3,4,5
            int N = int.Parse(Console.ReadLine());
            int K = int.Parse(Console.ReadLine());
            Random r = new Random();
            int[] numbers = new int[N];
            int bestSum = 0;
            int bestStart = 0;

            if (K >= N)
            {
                throw new Exception("!(K < N) == true");
            }

            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 10);
            }

            for (int i = 0; i < numbers.Length - K + 1; i++)
            {
                int tmpSum = 0;
                for (int j = i; j < i + K; j++)
                {
                    tmpSum += numbers[j];
                }
                if (tmpSum > bestSum)
                {
                    bestSum = tmpSum;
                    bestStart = i;
                }
            }

            Console.ReadLine();
        }
    }
}
