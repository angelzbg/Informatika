using System;

namespace IntroPolymorphism
{
    class Program
    {
        static void Main(string[] args)
        {
            BaseClass objBase = new BaseClass();
            DerivedClass objDerived = new DerivedClass();
            BaseClass objBaseTwo = objDerived;

            objBase.DoSomething();
            objDerived.DoSomething();
            objBaseTwo.DoSomething();

            Console.WriteLine();

            objBase.DoSomethingVirtual();
            objDerived.DoSomethingVirtual();
            objBaseTwo.DoSomethingVirtual();

            Console.ReadLine();
        }
    }
}
