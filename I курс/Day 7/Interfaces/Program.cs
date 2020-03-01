using System;

namespace Interfaces
{
    class Program
    {
        static void Main(string[] args)
        {
            LivingBeing[] beings = new LivingBeing[]
            {
                new Cow(), new WoodPecker(), new Rose(), new FlyTrap()
            };

            foreach (var b in beings)
            {
                if (b is Animal)
                {
                    Animal a = b as Animal;
                    a.MakeSound();
                }
                if (b is Plant)
                {
                    Plant p = b as Plant;
                    p.Blossom();
                }
                if (b is IBugEater)
                {
                    IBugEater be = b as IBugEater;
                    be.EatBugs();
                }
            }

            Console.ReadLine();
        }
    }
}
