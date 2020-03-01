// Figure 2-11b

while(true){                                // Repeat forever
    buf = wait_for_work();                  // Wait to do some work 
    page = look_for_page_in_cache(buf);     // See if the page is available
    if(page == null){
        page = read_page_from_disk(buf);    // Get the page from disk
    return_page(page);                      // Provide the page
}


