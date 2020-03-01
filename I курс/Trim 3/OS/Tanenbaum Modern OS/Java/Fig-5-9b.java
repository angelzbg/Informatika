// Figure 5-9b

outDevice.acknowledge_interrupt();          // Interrupt has been dealt with
unblock_user();                             // Code to wake up user process
return_from_interrupt();


