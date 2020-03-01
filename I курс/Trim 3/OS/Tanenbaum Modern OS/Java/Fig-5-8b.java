// Figure 5-8b

if (count ==0){
    unblock_user();                         // Code to wake up user process
} else {
    outDevice.load_data_register(p[i]);     // Output next character
    count = count - 1;                      
    i++;
}
outDevice.acknowledge_interrupt();          // Interrupt has been dealt with
return_from_interrupt();



