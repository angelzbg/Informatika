using System;

namespace Insects
{
    class Program
    {
        static void FlyOrWalk (Insect insect)
        {
            if (insect is Winged)
            {
                Winged winged = insect as Winged;
                winged = (Winged)insect; //Same as above (well, almost).
                winged.Fly();
            }
            else
            {
                insect.Crawl();
            }
        }
        static void Main(string[] args)
        {
            Cockroach roach = new Cockroach();
            Moth moth = new Moth();
            Butterfly butterfly = new Butterfly();

            Console.WriteLine("Cockroach: ");
            roach.ScareHumans();
            roach.AnnoyHuman();
            Console.WriteLine();

            Console.WriteLine("Moth");
            moth.AnnoyHuman();
            moth.Fly();
            moth.EatCloth();
            Console.WriteLine();

            Console.WriteLine("Butterfly");
            butterfly.AnnoyHuman();
            butterfly.Fly();
            Console.WriteLine();

            Insect someInsect;
            someInsect = moth;

            Winged wingedInsect = moth;
            //Winged anotherFlyingPest = roach; Roach doesn't inherit from Winged

            bool mothIsInsect = moth is Insect;
            Console.WriteLine("moth is an insect: " + mothIsInsect);

            bool roachIsWinged = roach is Winged;
            Console.WriteLine("cockroach is winged insect: " + roachIsWinged);

            Insect justaBug = new Insect();
            //moth = justaBug; //Moth is an insect, but insect is not a moth.

            Console.ReadLine();
        }
    }
}
