// Figure 12-5a


static void foo() {
    int x;
    ...
    
#ifdef DEBUG
    System.out.println("In subroutine foo, x is " + x);
#endif
    
    ...
}

// This code requires that you run the C/C++ preprocessor first and it must be
// inside the class.  
