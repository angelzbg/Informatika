using System;

namespace ArenaEngine
{
    public abstract class Figher
    {
        public string Name { get; private set; }

        public Weapon Weapon { get; set; }

        static protected Random rand = new Random();

        public int Strength { get; protected set; }

        public int Health { get; protected set; }

        public bool IsAlive { get { return Health > 0; } }
        
        public virtual int Attack()
        {
            int coef = rand.Next(70, 110);
            int damage = (Strength * coef) / 100;
            if (Weapon != null) damage = damage + Weapon.Damage;
            return damage;
        }

        public virtual void TakeDamage(int damage)
        {
            Health = Health - damage;
            if (Health < 0) Health = 0;
        }

        public Figher (string name)
        {
            Strength = 100;
            Health = 1000;
            Name = name;
        }
    }
}
