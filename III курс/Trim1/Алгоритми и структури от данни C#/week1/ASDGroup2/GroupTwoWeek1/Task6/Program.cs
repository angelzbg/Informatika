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
            int N = 5;//int.Parse(Console.ReadLine());
            int K = 3;// int.Parse(Console.ReadLine());
            if (K >= N)
            {
                throw new Exception(" K >= N Error");
            }
            int[] numbers = new int[N];// { 4, 8, 7, 7, 5 };
            Random r = new Random();
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = r.Next(1, 10);
            }
            //4,8,7,7,5
            int bestSum = 0;
            int bestIndex = 0;

            for (int i = 0; i <= numbers.Length - K; i++)
            {
                int tmpSum = 0;
                for (int j = i; j < i + K; j++)
                {
                    tmpSum += numbers[j];
                }
                if (tmpSum >= bestSum)
                {
                    bestSum = tmpSum;
                    bestIndex = i;
                }
            }

            Console.ReadLine();
        }
    }
}
