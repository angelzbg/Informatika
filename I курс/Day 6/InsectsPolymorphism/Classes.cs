using System;

namespace InsectsPolymorphism
{
    class Insect
    {
        public void AnnoyHuman()
        {
            Console.WriteLine("Bzzzzz");
        }

        public void Crawl()
        {
            Console.WriteLine("Crawling around.");
        }
    }

    class Winged : Insect
    {
        public void Fly()
        {
            Console.WriteLine("I fly!");
        }
    }

    class Butterfly : Winged
    {

    }

    class Moth : Winged
    {
        public void EatCloth ()
        {
            Console.WriteLine("Bit a hole in your favourite blouse.");
        }
    }

    class Cockroach : Insect
    {
        public void ScareHumans ()
        {
            Console.WriteLine("Bwahahaha");
        }
    }
}
