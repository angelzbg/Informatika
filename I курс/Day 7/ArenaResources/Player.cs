using System;

namespace ArenaGame
{
    class Player
    {
        public string Name { get; private set; }

        static protected Random rand = new Random();

        public int Strength { get; protected set; }

        public int Health { get; protected set; }

        public bool IsAlive { get { return Health > 0; } }
        
        public virtual int Attack()
        {
            int coef = rand.Next(70, 110);
            return (Strength * coef) / 100;
        }

        public virtual void TakeDamage(int damage)
        {
            Health = Health - damage;
            if (Health < 0) Health = 0;
        }

        public Player (string name)
        {
            Strength = 100;
            Health = 1000;
            Name = name;
        }
    }
}
