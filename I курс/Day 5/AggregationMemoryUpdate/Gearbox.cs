using System;

namespace AggregationMemoryUpdate
{
    class Gearbox
    {
        public int CurrentGear { get; private set; }
        public void ShiftUp() { CurrentGear++; }
        public void ShiftDown() { CurrentGear--; }
    }
}
