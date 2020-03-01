using System;

namespace Shapes
{
    class Program
    {
        static void Main(string[] args)
        {
            Shape[] shapes = new Shape[]
            {
                new Rectangle() { Width = 10, Height = 5 },
                new Circle() { Radius = 10 },
                new Square() { Side = 5 }
            };

            double total = 0;
            foreach (Shape shp in shapes)
            {
                total = total + shp.GetArea();
            }

            Console.WriteLine("Total area is: " + total);
            Console.ReadLine();
        }
    }
}
