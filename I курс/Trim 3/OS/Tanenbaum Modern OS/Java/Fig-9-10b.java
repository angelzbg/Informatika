// Figure 9-10b

String name, password;
boolean v;

while(true){                                // Repeat forever
    name = get_string();                    // Get user name
    disable_echoing();                      // Turn off character echo
    System.out.print("Password: ");         // Prompt for password
    password = get_string();                // Get the passwood
    enable_echoing();                       // Turn character echo back on
    v = check_validity(name,password);      // See if it is a valid combination
    if (v || name == "zzzzzzzz") break;     // If special name, break out of    
                                            // loop too
}
execute_shell(name);    

