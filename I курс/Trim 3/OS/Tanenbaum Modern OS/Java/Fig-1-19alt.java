// Figure 1-19

String commandAndParams[];
Process child;
int status;

Runtime me = Runtime.getRuntime();          // Get my runtime object

while(true){                                // Repeat forever
    type_prompt();                          // Display prompt on screen
    commandAndParams = read_command();      // Read input from the terminal
    
    try {
        child = me.exec(commandAndParams);  // Execute the command in a new 
                                            // process
        status = child.waitFor();           // Wait for the child to complete
    } catch (IOException ex) {
        // do nothing on error
    }
    
}
