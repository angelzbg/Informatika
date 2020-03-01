using System;

namespace ShapesNonVirt
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
                if (shp is Circle)
                {
                    Circle c = shp as Circle;
                    total = total + c.GetArea();
                }
                else
                {
                    if (shp is Rectangle)
                    {
                        Rectangle r = shp as Rectangle;
                        total = total + r.GetArea();
                    }
                    else
                    {
                        if (shp is Square)
                        {
                            Square s = shp as Square;
                            total = total + s.GetArea();
                        }
                    }
                }
            }
            Console.WriteLine("Total area is: " + total);
            Console.ReadLine();
        }
    }
}
