using System;

namespace Inheritance
{
    class Program
    {
        static void Main(string[] args)
        {
            One objOne = new One();
            Two objTwo = new Two();

            objOne.Value = 10;
            objOne.DoSomething();

            Console.WriteLine();

            objTwo.Value = 20;
            objTwo.DoSomething();
            objTwo.DoSomethingElse();



            Console.ReadLine();
        }
    }
}
