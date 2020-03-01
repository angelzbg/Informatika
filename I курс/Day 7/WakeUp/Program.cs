using System;

namespace WakeUp
{
    class Base
    {
        public virtual void M() { Console.WriteLine("Base.M"); }

        public Base() { M(); }
    }

    class Derived : Base
    {
        int data;
        public override void M() { Console.WriteLine("Derived.M : " + data); }
        
        public Derived() { data = 10; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Base b = new Base();
            Derived d = new Derived();
            Console.ReadLine();

            //DO NOT use virtual methods inside your constructors,
            //because you virtual method may execute with uninitialized data.
        }
    }
}
