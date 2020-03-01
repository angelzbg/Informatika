using System;
using System.Collections.Generic;
using System.Linq;

namespace _2_dopulnitelna_1601261021
{
    class Program
    {
        static private string[] commands;
        static private List<int> numbers = new List<int>();
        static private List<int> orderedNumbers = new List<int>();
        static void Main(string[] args)
        {
            int C = 0;
            while (C <= 0) int.TryParse(Console.ReadLine(), out C);

            commands = new string[C];
            for (int i = 0; i < C; i++)
            {
                commands[i] = Console.ReadLine();
                int num1 = int.Parse(commands[i][0].ToString()), num2 = int.Parse(commands[i][commands[i].Length-1].ToString());

                bool check1 = false, check2 = false;

                foreach(int num in numbers)
                {
                    if (num == num1) check1 = true;
                    if (num == num2) check2 = true;
                }

                if (!check1) numbers.Add(num1);
                if (!check2) numbers.Add(num2);
            }

            orderedNumbers.Add(numbers[0]);

            /* Максимален тест
             * 9510263487
             11 команди
             1 after 5
             8 before 7
             3 before 4
             0 after 1
             6 before 3
             6 after 2
             4 after 3
             8 after 4
             2 after 0
             9 before 5
             3 after 6
             */

            int counter = 0;
            while(orderedNumbers.Count < numbers.Count)
            {
                for (int i = 0; i < numbers.Count(); i++)
                {
                    FindMyPlace(numbers[i]);
                }
                Console.WriteLine("Attempt (" + ++counter + "): " + string.Join("", orderedNumbers));
            }

            Console.WriteLine(string.Join("", orderedNumbers));

            Console.ReadKey();
        }

        static void FindMyPlace(int number)
        {
            foreach (string str in commands)
            {
                if (str.Contains(number + ""))
                {
                    int num1 = int.Parse(str[0].ToString()), num2 = int.Parse(str[str.Length - 1].ToString());

                    bool check1 = false, check2 = false;
                    foreach(int n in orderedNumbers)
                    {
                        if (number == n) return;
                        if (n == num1) check1 = true;
                        if (n == num2) check2 = true;
                    }

                    if (number == num1 && check2)//ляво
                    {
                        int index = orderedNumbers.IndexOf(num2);
                        if (str.Contains("after")) // лявото число трябва да е след дясното
                        {
                            orderedNumbers.Insert(index + 1, number);
                        }
                        else //before лявото число трябва да е след преди дясното
                        {
                            orderedNumbers.Insert(index, number);
                        }
                    }
                    else if(number == num2 && check1)//дясно
                    {
                        int index = orderedNumbers.IndexOf(num1);
                        if (str.Contains("after")) // дясното число трябва да е преди лявото
                        {
                            orderedNumbers.Insert(index, number);
                        }
                        else //before дясното трябва да е след лявото
                        {
                            orderedNumbers.Insert(index + 1, number);
                        }
                    }
                }
            }
        }
    }
}