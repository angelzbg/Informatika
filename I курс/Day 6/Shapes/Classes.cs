using System;

namespace Shapes
{
    class Shape
    {
        public virtual double GetArea() { return 0; }
    }

    class Rectangle : Shape
    {
        public double Width { get; set; }
        public double Height { get; set; }

        public override double GetArea()
        {
            return Width * Height;
        }
    }

    class Circle : Shape
    {
        public double Radius { get; set; }
        public override double GetArea()
        {
            return 3.14 * Radius * Radius;
        }
    }

    class Square : Shape
    {
        public double Side { get; set; }

        public override double GetArea()
        {
            return Side * Side;
        }
    }
}
