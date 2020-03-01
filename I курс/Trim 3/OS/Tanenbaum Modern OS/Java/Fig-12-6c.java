// Figure 12-6c

// Macro to look up the bit count in a table
static int bits[] = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2,  
                      3, 2, 3, 3, 4, 2, 3, ...}; 
#define bit_count(b) bits[b]



// For this to work you would have to run the C preprocessor on the java file
// and in addition this code would need to be inside the class.
