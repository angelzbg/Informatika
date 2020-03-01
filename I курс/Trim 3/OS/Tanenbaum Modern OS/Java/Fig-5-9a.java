// Figure 5-9a

Buffer buf, p;
PrinterDevice outDevice;

p.copy_from_user(buf,count);                
outDevice.set_up_DMA_controller(p);          
scheduler();

