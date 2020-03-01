using System;

namespace AbstractClasses
{
    class Program
    {
        static void Main(string[] args)
        {
            //Shape shp = new Shape(); //Shape is abstract.
            //Shape triangle = new Triangle(); //Triangle is abstract, too.
            Shape rt = new RightTriangle() { SideA = 10, SideB = 5 };

            Shape[] shapes = new Shape[]
            {
                new Rectangle() { Width = 10, Height = 5 },
                new Circle() { Radius = 10 },
                new Square() { Side = 5 },
                new RightTriangle() { SideA = 8, SideB = 15 },
                rt,
                new AnyTriangle() { Side = 6, Height = 3 }
            };

            //Count how many triangles we have.
            int triangles = 0;
            foreach (var shp in shapes)
            {
                if (shp is Triangle) triangles = triangles + 1;
            }
        }
    }
}
