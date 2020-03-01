//Figure 5-41

// What a Java program might look like if there was a WindowsAPI that
// allowed java to interface with windows

import WindowsAPI.*;

public class WindowsApplication  extends WindowsApplication {

    public int WinMain (HINSTANCE h, HINSTANCE hprev, 
                        String szCmd, int iCmdShow){
    
        WNDCLASS wndclass;              // Class object for this window
        MSG msg;                        // Incomming messages are stored here
        HWND hwnd;                      // Handle to the window object
        
        // Initialize wndclass
        wndclass = new WNDCLASS(this,               // Tells who is responsible
                "Program name",                     // Text for the title bar
                WindowsAPI.LoadIcon(null, WindowsAPI.IDI_APPLICATION),  
                WindowsAPI.LoadCursor(null, WindowsAPI.IDC_ARROW));     
                
        WindowsAPI.RegisterClass(wndclass);         // Tell Windows about 
                                                    // wndclass
        hwnd = WindowsAPI.CreateWindow(....);       // Allocate storage for the 
                                                    // window
        WindowsAPI.ShowWindow(hwnd,iCmdShow);       // Display the window on 
                                                    // the screen
        WindowsAPI.UpdateWindow(hwnd);              // Tell the window to paint 
                                                    // itself
        
        while(msg = WindowsAPI.GetMessage(null, 0, 0)) {    // Get message from 
                                                            // queue
            TranslateMessage(msg);                  // Translate the message
            DispatchMessage(msg);                   // Dispatch the message
        }
        return (msg.wParam);
    }
    
    public long WndProc(HWND hwnd, UINT message, UINT wParam, long IParam){
        // Declarations go here
        
        switch(message) {
            case WindowsAPI.WM_CREATE:  ....; return;   // Create window
            case WindowsAPI.WM_PAINT:   ....; return;   // Repaint contents of 
                                                        // window
            case WindowsAPI.WM_DESTROY: ....; return;   // Destroy window
        }
        return(DefWindowProc(hwnd,message,wParam,IParam);   // Default
    }
}
                                
