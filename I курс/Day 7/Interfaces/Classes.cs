using System;

namespace Interfaces
{
    abstract class LivingBeing
    {
    }

    abstract class Animal : LivingBeing
    {
        public void Move() { Console.WriteLine("I move!"); }

        public abstract void MakeSound();
    }

    class WoodPecker : Animal, IBugEater
    {
        public override void MakeSound()
        {
            Console.WriteLine("Knock-knock");
        }

        public void EatBugs()
        {
            Console.WriteLine("I eat bugs!");
        }
    }

    class Cow : Animal
    {
        public override void MakeSound()
        {
            Console.WriteLine("Moooo");
        }
    }

    abstract class Plant : LivingBeing
    {
        public void Blossom() { Console.WriteLine("I make blossoms!" ); }
    }

    class FlyTrap : Plant, IBugEater 
    {
        public void EatBugs()
        {
            Console.WriteLine("I eat bugs, too!");
        }
    }

    class Rose : Plant
    {

    }
}
