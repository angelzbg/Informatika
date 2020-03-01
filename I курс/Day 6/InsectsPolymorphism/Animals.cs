using System;

namespace InsectsPolymorphism
{
    class Animal
    {
        public virtual void MakeSound()
        {
            Console.WriteLine("I am dumb.");
        }

        public void Run()
        {
            Console.WriteLine("I am running.");
        }
    }

    class Feline : Animal
    {
        public void Claw()
        {
            Console.WriteLine("Claw your eyes out.");
        }
    }

    class Cat : Feline
    {
        public override void MakeSound()
        {
            Console.WriteLine("Mweou");
        }
    }

    class Lion : Feline
    {
        public override void MakeSound()
        {
            Console.WriteLine("ROAR");
        }
    }

    class Canine : Animal
    {
        
    }

    class Dog : Canine
    {
        public override void MakeSound()
        {
            Console.WriteLine("Bark");
        }
    }

    class Wolf : Canine
    {
        public override void MakeSound()
        {
            Console.WriteLine("Howl");
        }
    }
}
