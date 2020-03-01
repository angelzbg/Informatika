// Figure 2-11a

Buffer buf;
Page page;

while(true){                                // Repeat forever
    buf = get_next_request();               // Get the request
    handoff_work(buf);                      // Pass off the work
}
