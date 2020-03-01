using System;

namespace AggregationMemoryUpdate
{
    class Engine
    {
        public int RevsPerMinute { get; private set; }
        public void TurnOn() { RevsPerMinute = 700; }

        public void TurnOff() { RevsPerMinute = 0; }

        public void StepOnIt() { RevsPerMinute += 300; }

        public void GoEasy() { RevsPerMinute -= 300; }
    }
}
