// Figure 12-4

final int PROC_TABLE_SIZE 200;              // Maximum number of processes
SystemProcess p, proc_table[];
boolean found = false;

for(i=0; i<PROC_TABLE_SIZE; i++){           // Loop over processes
    p = proc_table[i];
    if (p == null) continue;                // Skip empty slots in table
    if (p.get_pid() == pid){                // Found it
         found = true;
         break;                             // Break out of the loop
    }
}


