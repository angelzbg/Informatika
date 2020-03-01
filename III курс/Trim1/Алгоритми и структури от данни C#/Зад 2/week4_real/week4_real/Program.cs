using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace week4_real
{
    class Program
    {
        private class Point
        {
            public int X { get; set; }
            public int Y { get; set; }

            public Point(int x, int y)
            {
                X = x;
                Y = y;
            }
        }
        private class Rect
        {
            public Point Point1 { get; set; }
            public Point Point2 { get; set; }
            public int Space { get; }

            public int groupIndex { get; set; }

            public Rect(string[] numbers)
            {
                Point1 = new Point(int.Parse(numbers[0]), int.Parse(numbers[1]));
                Point2 = new Point(int.Parse(numbers[2]), int.Parse(numbers[3]));

                Space = (Point2.X - Point1.X) * (Point2.Y - Point1.Y);

                groupIndex = -1;
            }
        }

        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;

            Console.Write("Брой правоъгълници = ");
            int N = 0;
            while (N <= 0) int.TryParse(Console.ReadLine(), out N);

            Rect[] rectangles = new Rect[N];

            for (int i = 0; i < N; i++)
            {
                string[] coords = Console.ReadLine().Split(new char[] { ' ' });

                rectangles[i] = new Rect(coords);
            }

            for (int i = 0; i < N; i++) Console.WriteLine("Лице на фигура[" + (i + 1) + "] = " + rectangles[i].Space + " кв. м");

            int groupIndexer = -1;
            for (int i = 0; i < N; i++)
            {
                if (rectangles[i].groupIndex < 0)//-1 не е в група значи започваме да обхождаме масива
                {
                    for (int j = 0; j < N; j++)
                    {
                        if (i == j) continue; //не искаме да проверяваме една и съща фигура

                        if (rectangles[j].Point1.X == rectangles[i].Point2.X) //ако j е отдясно на i
                        {
                            if (rectangles[i].Point1.Y == rectangles[j].Point1.Y || rectangles[i].Point2.Y == rectangles[j].Point2.Y)
                            {
                                if (rectangles[j].groupIndex > -1) // допирната фигура вече има група(област)
                                {
                                    rectangles[i].groupIndex = rectangles[j].groupIndex;
                                }
                                else //и двете фигури нямат група(област)
                                {
                                    groupIndexer++;
                                    rectangles[i].groupIndex = groupIndexer;
                                    rectangles[j].groupIndex = groupIndexer;
                                }
                                break;
                            }
                        }
                        else if (rectangles[j].Point2.X == rectangles[i].Point1.X) //ако j е отляво на i
                        {
                            if (rectangles[j].Point1.Y == rectangles[i].Point1.Y || rectangles[j].Point2.Y == rectangles[i].Point2.Y)
                            {
                                if (rectangles[j].groupIndex > -1) // допирната фигура вече има група(област)
                                {
                                    rectangles[i].groupIndex = rectangles[j].groupIndex;
                                }
                                else //и двете фигури нямат група(област)
                                {
                                    groupIndexer++;
                                    rectangles[i].groupIndex = groupIndexer;
                                    rectangles[j].groupIndex = groupIndexer;
                                }
                                break;
                            }
                        }
                        else if (rectangles[j].Point1.Y == rectangles[i].Point2.Y) //ако j е над i
                        {
                            if (rectangles[i].Point2.X > rectangles[j].Point1.X && rectangles[j].Point2.X > rectangles[i].Point1.X)
                            {
                                if (rectangles[j].groupIndex > -1) // допирната фигура вече има група(област)
                                {
                                    rectangles[i].groupIndex = rectangles[j].groupIndex;
                                }
                                else //и двете фигури нямат група(област)
                                {
                                    groupIndexer++;
                                    rectangles[i].groupIndex = groupIndexer;
                                    rectangles[j].groupIndex = groupIndexer;
                                }
                                break;
                            }
                        }
                        else if (rectangles[j].Point2.Y == rectangles[i].Point1.Y) //ако j е под i
                        {
                            if (rectangles[j].Point2.X > rectangles[i].Point1.X && rectangles[i].Point2.X > rectangles[j].Point1.X)
                            {
                                if (rectangles[j].groupIndex > -1) // допирната фигура вече има група(област)
                                {
                                    rectangles[i].groupIndex = rectangles[j].groupIndex;
                                }
                                else //и двете фигури нямат група(област)
                                {
                                    groupIndexer++;
                                    rectangles[i].groupIndex = groupIndexer;
                                    rectangles[j].groupIndex = groupIndexer;
                                }
                                break;
                            }
                        }
                    }
                }

                if (rectangles[i].groupIndex < 0) //ако  все още няма индекс на група, значи тази фигура трябва да образува сама група:
                {
                    rectangles[i].groupIndex = ++groupIndexer;
                }
            }

            int groupCount = groupIndexer + 1;
            int[] areaSpaces = new int[groupCount];

            string[] oblastiTestList = new string[groupCount];

            for (int i = 0; i < N; i++)
            {
                areaSpaces[rectangles[i].groupIndex] += rectangles[i].Space;
                oblastiTestList[rectangles[i].groupIndex] += " " + (i+1);
            }

            int sumAllAreas = 0, largestArea = 0, largestAreaNumber = 0;
            Console.WriteLine("\n--- Списък с всички области [" + groupCount + "] ---");
            for (int i = 0; i < groupCount; i++)
            {
                sumAllAreas += areaSpaces[i];
                if (areaSpaces[i] > largestArea)
                {
                    largestArea = areaSpaces[i];
                    largestAreaNumber = i + 1;
                }
                Console.WriteLine("Област #" + (i + 1) + " - " + areaSpaces[i] + " кв. м" + ", образувана от фигури: " + oblastiTestList[i]);
            }
            Console.Write("\n");

            Console.WriteLine("Сумата на лицата на всички области = " + sumAllAreas + " кв. м.");
            Console.WriteLine("Най-голямата област е #" + largestAreaNumber + " с площ " + largestArea + " кв. м.");

            Console.ReadKey();
        }
    }
}