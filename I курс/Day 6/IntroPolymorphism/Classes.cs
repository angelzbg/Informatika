using System;

namespace IntroPolymorphism
{
    class BaseClass
    {
        public void DoSomething()
        {
            Console.WriteLine("Base class here.");
        }

        public virtual void DoSomethingVirtual()
        {
            Console.WriteLine("Virtual: Base class here.");
        }
    }

    class DerivedClass : BaseClass
    {
        public void DoSomething()
        {
            Console.WriteLine("DERIVED class here.");
        }

        public override void DoSomethingVirtual()
        {
            Console.WriteLine("Override: DERIVED here.");
        }
    }
}
