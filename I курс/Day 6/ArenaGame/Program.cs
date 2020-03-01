using System;

namespace ArenaGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Player p1 = new Assassin("Ivan The Shadow");
            Player p2 = new Knight("Sir Dragan");

            Arena arena = new Arena(p1, p2);
            arena.Battle();
            Console.WriteLine("Winner is: " + arena.Winner.Name);
            Console.ReadLine();
        }
    }
}
