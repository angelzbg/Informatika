using System;

namespace ArenaEngine
{
    public class Assassin : Figher
    {
        public override int Attack()
        {
            int baseDamage = base.Attack();
            bool critical = rand.Next(10) < 4;
            if (critical) baseDamage = baseDamage * 3;
            return baseDamage;
        }

        public Assassin (string name) : base (name)
        {

        }
    }
}
