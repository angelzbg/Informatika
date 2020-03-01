using System;

namespace AggregationMemoryUpdate
{
    class Car
    {
        public string Brand { get; set; }
        public string Model { get; set; }

        public Engine Engine { get; set; }

        public Gearbox Gearbox { get; set; }

        public void Start()
        {
            Engine.TurnOn();
            Engine.StepOnIt();
            Gearbox.ShiftUp();
        }

        public void Accelerate()
        {
            Engine.StepOnIt();
            Gearbox.ShiftUp();
        }

        public void Slowdown()
        {
            Engine.GoEasy();
            Gearbox.ShiftDown();
        }
    }
}
