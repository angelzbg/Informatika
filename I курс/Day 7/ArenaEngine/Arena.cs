using System;

namespace ArenaEngine
{
    public class Arena
    {
        Figher player1;
        Figher player2;

        public Figher Winner
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

            if (player2.IsAlive)
            {
                int p2Damage = player2.Attack();
                player1.TakeDamage(p2Damage);
            }
        }

        public bool IsBattleOver
        {
            get { return player1.Health <= 0 || player2.Health <= 0; }
        }

        public Arena (Figher p1, Figher p2)
        {
            player1 = p1;
            player2 = p2;
        }
    }
}
