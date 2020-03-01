//Figure 11-32

    inhandle = Win2000Api.createFile("data",
                                     Win2000Api.GENERIC_READ,
                                     0, null,
                                     Win2000Api.OPEN_EXISTING,
                                     0, null);      

    outhandle = Win2000Api.createFile("newf",
                                     Win2000Api.GENERIC_WRITE,
                                     0, null,
                                     Win2000Api.CREATE_ALWAYS,
                                     Win2000Api.FILE_ATTRIBUTE_NORMAL, null);
    
    do {
        status = inhandle.ReadFile(buffer, BUF_SIZE, null);
        if(status.s >0 && status.count > 0)
            outhandle.WriteFile(buffer, status.count, null);
    } while (status.s >0 && status.count > 0)
    
    // Close the files
    inhandle.closeHandle();
    outhandle.closeHandle();
                
