// Figure 1-19

String command;
String parameters[];
int status;

    while(true{                             // Repeat forever
    type_prompt();                          // Display prompt on screen
    command = read_command();               // Read input from the terminal
    parameters = read_parameters();
    
    if(UnixAPI.fork() != 0) {                   // Fork via Unix
        // Parent code
        status = UnixAPI.waitpid(-1, 0);        // Wait on process, status is 
                                                //returned
    } else {
        // Child code
        UnixAPI.execcv(command, parameters, 0)  // Execute the command
    }
}



//Notes:
//  The above code has no chance of working as Java does not support a
//      Unix style fork. Assuming that it did, this would be the way to do it.  
//  true is predefined in Java


