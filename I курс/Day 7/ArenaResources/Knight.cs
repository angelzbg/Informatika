using System;

namespace ArenaGame
{
    class Knight : Player
    {
        public override void TakeDamage(int damage)
        {
            int coef = rand.Next(60, 90);
            damage = (damage * coef) / 100;
            base.TakeDamage(damage);
        }

        public Knight (string name) : base (name)
        {

        }
    }
}
