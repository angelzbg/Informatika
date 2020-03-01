// Figure 10-4

pid = UnixAPIfork();        // Fork via Unix, if success pid>0 in parent
if(pid < 0) {                               
    handle_error();         // Fork failed (e.g. memory or some table is full)
} else if (pid >0) {
                            // Parent code
} else {
                            // Child code
}



//Notes:
//  The above code has no chance of working as Java does not support a
//      Unix style fork. Assuming that it did, this would be the way to do it.  


