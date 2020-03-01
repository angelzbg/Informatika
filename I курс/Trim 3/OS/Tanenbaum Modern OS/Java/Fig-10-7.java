// Figure 10-7

String command;
String parameters[];
int status;

while(true){                                    // Repeat forever
    type_prompt();                              // Display prompt on screen
    command = read_command();                   // Read input from the terminal
    parameters = read_parameters();
    
    pid = UnixAPI.fork()                        // Fork off a child process
    
    if(pid < 0) {                       
        System.out.println("Unable to fork");   // Error condition
        continue;                               // Repeat the loop
    }
    
    if(pid != 0) {                      
        // Parent code
        status = UnixAPI.waitpid(-1, 0);        // Parent waits for child
    } else {
        // Child code
        UnixAPI.execcv(command, parameters, 0)  // Child does the work
    }
}



//Notes:
//  The above code has no chance of working as Java does not support a
//      Unix style fork. Assuming that it did, this would be the way to do it.  
//  true is predefined in Java


