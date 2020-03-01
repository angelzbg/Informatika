// Figure 12-1b

public class Responder implements ActionListener {

    // Method that responds when events are posted by an
    // object x that has notified Java via addActionListener
    // that an instance of Responder may be interested in x's events
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        
        if (action == "event 1") {
            // Code for event 1
        } else if (action == "event 2") {
            // Code for event 2
        } else if (action == "event 3") {
            // Code for event 3
        } else {
            // Code for all other events
        }
    }
        
        
        
    public Responder(){
    // Code to construct/initialize the Responder class
    }
    
}


