using System;


namespace ArenaEngine
{
    public abstract class Weapon
    {
        public abstract int Damage { get; }
    }

    public class Dagger : Weapon
    {
        public override int Damage
        {
            get
            {
                return 50;
            }
        }
    }

    public class Sword : Weapon
    {
        public override int Damage
        {
            get
            {
                return 80;
            }
        }
    }
}
