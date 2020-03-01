// Figure 12-6b

// Macro to add up the bits in a byte and return the sum
#define bit_count(b) ((b&1) + ((b>>1)&1) + ((b>>2)&1) + ((b>>3)&1) + ((b>>4)&1) 
                            + ((b>>5)&1) + ((b>>6)&1) + ((b>>7)&1)) 



// For this to work you would have to run the C preprocessor on the java file
