//Figure 5-46

// What a Java program might look like if there was a XWindowsAPI that
// allowed java to interface with X Windows

import XWindowsAPI.*;

public class XWindowsApplication  extends XWindowsApplication {

    public static void main(String args[]) {
    
        Display disp;                           // Server identifier
        Window win;                             // Window identifier
        GC gc;                                  // Graphic context identifier
        XEvent event;                           // Storage for one event
        int running = 1;
        
        disp = new Display ("display_name");    // Connect to the X server
        win = new Window(disp, ...);            // Allocate memory for the new 
                                                // window
        disp.XSetStandardProperties(....);      // Announces window to window 
                                                // manager
        gc = new GC(disp, win, 0, 0);           // Create graphic control
        disp.XselectInput(win, XWindowsAPI.BUTTONPRESSMASK | 
                               XWindowsAPI.KEYPRESSMASK |
                               XWindowsAPI.EXPOSUREMASK );
        disp.XMapRaised(win);                   // Display window; send Expose 
                                                // event
        
        while (running) {
            event = disp.XNextEvent();          // Get next event
            switch(event.type){
                case XWindowsAPI.EXPOSE:        ...; break; // Repaint window
                case XWindowsAPI.BUTTONPRESS:   ...; break; // Repaint window
                case XWindowsAPI.KEYPRESS:      ...; break; // Repaint window
            }
        }
        
        disp.XFreeGC(gc);                       // Release the graphic context
        disp.XDestroyWindow(win);               // Let go of the window
        disp.XCloseDisplay();                   // Tear down the network 
                                                // connection
        
    }
                
        
}
                                
