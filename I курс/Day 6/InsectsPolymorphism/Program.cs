using System;

namespace InsectsPolymorphism
{
    class Program
    {
        static void Main(string[] args)
        {
            Animal[] animals = new Animal[5]
            {
                new Dog(), new Cat(), new Lion(), new Wolf(), new Dog()
            };

            foreach (Animal animal in animals)
            {
                animal.MakeSound();
            }

            Console.ReadLine();
        }
    }
}
