//Figure 2-20b

while(true){                                // Repeat forever
    while(turn != 1){};                     // Loop until turn is 1
    critical_region();
    turn = 0;                               // Pass control
    non_critical_region();                                          
}

