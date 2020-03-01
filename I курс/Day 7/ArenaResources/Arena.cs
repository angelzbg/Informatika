using System;

namespace ArenaGame
{
    class Arena
    {
        Player player1;
        Player player2;

        public Player Winner
        {
            get
            {
                if (IsBattleOver)
                {
                    if (player1.IsAlive) return player1;
                    else return player2;
                }
                else return null;
            }
        }

        public void MakeRound()
        {
            if (IsBattleOver) { throw new Exception ("Battle is over!"); }

            int p1Damage = player1.Attack();
            player2.TakeDamage(p1Damage);
            Console.WriteLine("Player 1 hits for: " + p1Damage);

            if (player2.IsAlive)
            {
                int p2Damage = player2.Attack();
                player1.TakeDamage(p2Damage);
                Console.WriteLine("Player 2 hits for: " + p2Damage);
            }
        }

        public bool IsBattleOver
        {
            get { return player1.Health <= 0 || player2.Health <= 0; }
        }

        public void Battle()
        {
            while (!IsBattleOver)
            {
                MakeRound();
            }
        }

        public Arena (Player p1, Player p2)
        {
            player1 = p1;
            player2 = p2;
        }
    }
}
