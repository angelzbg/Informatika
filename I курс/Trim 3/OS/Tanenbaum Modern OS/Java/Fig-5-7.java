// Figure 5-7

Buffer buf, p;
PrinterDevice outDevice;

p.copy_from_user(buf,count);                // P is the kernel buffer
for(i=0; i<count; i++){                     // Loop on every character
    while(!outDevice.ready());              // Loop until ready
    outDevice.load_data_register(p[i]);     // Output one character
}
return_to_user();


