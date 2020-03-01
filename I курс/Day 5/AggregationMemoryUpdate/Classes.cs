using System;

namespace AggregationMemoryUpdate
{
    class CarAllInOne
    {
        public string Brand { get; set; }
        public string Model { get; set; }

        //Gearbox
        int currentGear;
        void ShiftUp() { currentGear++; }
        void ShiftDown() { currentGear--; }

        //Engine
        int revsPerMinute;
        void TurnOn() { revsPerMinute = 700; }

        void TurnOff() { revsPerMinute = 0; }

        void StepOnIt() { revsPerMinute += 300; }

        void GoEasy() { revsPerMinute -= 300; }

        //
        public void Start()
        {
            TurnOn();
            ShiftUp();
            StepOnIt();
        }

        public void Accelerate()
        {
            StepOnIt();
            ShiftUp();
        }

    }
}
