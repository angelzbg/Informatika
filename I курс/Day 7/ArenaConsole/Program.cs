using ArenaEngine;
using System;

namespace ArenaConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            Knight knight = new Knight("Sir John")
            {
                Weapon = new Sword()
            };
            Assassin assassin = new Assassin("Sneaky Patrick")
            {
                Weapon = new Dagger()
            };

            Arena game = new Arena(knight, assassin);

            Console.WriteLine("Game starts!");
            while (!game.IsBattleOver)
            {
                Console.WriteLine("Fighting...");
                game.MakeRound();
            }
            Console.WriteLine("Winner is: " + game.Winner.Name);
            Console.ReadLine();
        }
    }
}
