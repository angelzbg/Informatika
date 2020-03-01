//Figure 2-20a

while(true){                                // Repeat forever
    while(turn != 0){};                     // Loop until turn is 0
    critical_region();
    turn = 1;                               // Pass control
    non_critical_region();                                          
}
