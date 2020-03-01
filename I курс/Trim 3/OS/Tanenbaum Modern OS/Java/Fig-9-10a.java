// Figure 9-10a

String name, password;
boolean v;

while(true){                                // Repeat forever
    name = get_string();                    // Get user name
    disable_echoing();                      // Turn off character echo
    System.out.print("Password: ");         // Prompt for password
    password = get_string();                // Get the passwood
    enable_echoing();                       // Turn character echo back on
    v = check_validity(name,password);      // See if it is a valid combination
    if (v) break;                           // If it is valid, break out of             
                                            // loop
}
execute_shell(name);    
    

