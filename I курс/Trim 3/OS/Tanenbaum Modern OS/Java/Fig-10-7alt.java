// Figure 10-7alt

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
        System.out.println("Unable to fork: IO error"); 
    } catch (SecurityException ex) {
        System.out.println("Unable to fork: Security Violation");   
    } catch (InterruptedException ex) {
        System.out.println("My wait was interrupted");  
    }
    
}
