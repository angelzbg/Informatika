// Figure 2-21

// Static variables are shared between all instances of a class

static final int N = 2;                     // Number of processes

static int turn;                            // Whose turn is it
static boolean interested[] 
        = new boolean[2];                   // Who is interested

static void init(){                         // Initialize interested array
    for(int i=0; i<N; i++)
        interested[i] = false;              // To be all false



static void enter_region(int process){      // Process is 0 or 1
    int other;
    
    other = 1 - process;                    // Number of the other process
    interested[process] = true;             // Show that you are interested
    turn = process;                         // Set flag;
    while(turn == process) && interested[other]);   // Busy wait
}

static void leave_region(itn process){      // Process: who is leaving
    interested[process] = false;
}                   

