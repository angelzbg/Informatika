using System;

namespace Inheritance
{
    class One 
    {
        public int Value { get; set; }
        public void DoSomething()
        {
            Console.WriteLine("One: " + Value);
        }
    }

    class Two : One
    {
        public void DoSomethingElse ()
        {
            Console.WriteLine("Two does something else.");
        }
    } 
}
