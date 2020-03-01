// Figure 12-5a

#include "config"

static void init() {

#if(CPU == PENTIUM)
    // Pentium initialization goes here
#endif

#if(CPU == ULTRASPARC)
    // UltraSPARC initialization goes here
#endif

}

// This code requires that you run the C/C++ preprocessor first and it must be
// inside the class.  It would be unlikely that such code would ever be written // though.
