// Figure 10-4


Runtime me = Runtime.getRuntime();          // Get my runtime object

try {
    child = me.exec(commandAndParams);  // Execute the command in a new process
    status = child.waitFor();           // Wait for the child to complete
} catch (IOException ex) {
    handle_error();                     // Handle any error
    
}
