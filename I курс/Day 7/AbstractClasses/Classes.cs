using System;

namespace AbstractClasses
{
    abstract class Shape
    {
        public double X { get; private set; }
        public double Y { get; private set; }

        public void Move(int newX, int newY)
        {
            X = newX; Y = newY;
        }
        public abstract double GetArea();
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

    abstract class Triangle : Shape
    {

    }

    class RightTriangle : Triangle
    {
        public double SideA { get; set; }

        public double SideB { get; set; }

        public double SideC {
            get
            {
                return Math.Sqrt(SideA * SideA + SideB * SideB);
            }
        }
        public override double GetArea()
        {
            return SideA * SideB / 2;
        }
    }

    class AnyTriangle : Triangle
    {
        public double Side { get; set; }

        public double Height { get; set; }

        public override double GetArea()
        {
            return Side * Height / 2;
        }
    }
}
