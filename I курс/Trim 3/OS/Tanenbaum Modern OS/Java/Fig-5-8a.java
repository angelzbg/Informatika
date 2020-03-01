// Figure 5-8a

Buffer buf, p;
PrinterDevice outDevice;

p.copy_from_user(buf,count);                // P is the kernel buffer
outDevice.enable_interrupts();              // Enable interrupts for the devic
while(!outDevice.ready());                  // Loop until ready
outDevice.load_data_register(p[0]);         // Output the first character
scheduler();                                // Do other work


