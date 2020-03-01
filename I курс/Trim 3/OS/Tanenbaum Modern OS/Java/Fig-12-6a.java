// Figure 12-6a

static final int BYTE_SIZE = 8;             // A byte contains 8 bits


static int bit_count(byte data){                

    int i,  count = 0;                      // Count the bits in a byte
    
    for(i=0; i<BYTE_SIZE; i++)              // Loop over the bits in a byte
        if( ((byte >> i) & 1) != 0)         // If this bit is a 1, add to count
            count++;
    
    return count;                           // Return the sum
}


