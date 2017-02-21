import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ChatClient {
    
    private JTextArea output;
    private JScrollPane textPane;
    private JTextField input;
    private JButton sendButton;
    private JButton quitButton;
    private JFrame frame;
    private JComboBox usernames;
    private JDialog aboutDialog;
    private Socket connection = null;
    private BufferedReader serverIn = null;
    private PrintStream serverOut = null;
    
    public ChatClient() {
        output = new JTextArea(10,50);
        textPane = new JScrollPane(output, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        input = new JTextField(50);
        sendButton = new JButton("Send");
        quitButton = new JButton("Quit");
        usernames = new JComboBox();
        usernames.addItem("Jane Doe");
        usernames.addItem("1337dud3");
        usernames.addItem("Java Geek");
    }
    
    public void launchFrame() {
        frame = new JFrame("Chat Room");
        
        // Use the Border Layout for the frame
        frame.setLayout(new BorderLayout());
        
        frame.add(textPane, BorderLayout.WEST);
        frame.add(input, BorderLayout.SOUTH);
        
        // Create the button panel
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(sendButton);
        p1.add(quitButton);
        p1.add(usernames);
        
        // Add the button panel to the center
        frame.add(p1, BorderLayout.CENTER);
        
        // Create menu bar and File menu
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(quitMenuItem);
        mb.add(file);
        frame.setJMenuBar(mb);
        
        // Add Help menu to menu bar
        JMenu help = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new AboutHandler());
        help.add(aboutMenuItem);
        mb.add(help);
        
        // Attach listener to the appropriate components
        sendButton.addActionListener(new SendHandler());
        input.addActionListener(new SendHandler());
        frame.addWindowListener(new CloseHandler());
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frame.pack();
        frame.setVisible(true);
        doConnect();
    }
    
    private class SendHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = input.getText();
            output.append(usernames.getSelectedItem() + ": " + text + "\n");
            serverOut.print(text);
            input.setText("");
            //output.setCaretPosition(output.getDocument().getLength()-1);
        }
    }
    
    private class CloseHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    private class AboutHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Create the aboutDialog when it is requested
            if ( aboutDialog == null ) {
                aboutDialog = new AboutDialog(frame, "About", true);
            }
            aboutDialog.setVisible(true);
        }
    }
    
    private class AboutDialog extends JDialog implements ActionListener  {
        public AboutDialog(Frame parent, String title, boolean modal) {
            super(parent,title,modal);
            add(new JLabel("The ChatClient is a neat tool that allows you to talk " +
                    "to other ChatClients via a ChatServer"),BorderLayout.NORTH);
            JButton b = new JButton("OK");
            add(b,BorderLayout.SOUTH);
            b.addActionListener(this);
            pack();
        }
        // Hide the dialog box when the OK button is pushed
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
    
    private void doConnect() {
        //initialise server IP and port information
        String serverIP = System.getProperty("serverIP", "127.0.0.1");
        String serverPort = System.getProperty("serverPort", "2000");
        
        try {
            connection = new Socket(serverIP, Integer.parseInt(serverPort));
            
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            serverIn = new BufferedReader(isr);
            
            serverOut = new PrintStream(connection.getOutputStream());
            Thread t = new Thread(new RemoteReader());
            t.start();
        }
        
        catch (Exception e) {
            System.err.println("Unable to connect to server!");
            e.printStackTrace();
        } // END of try-catch block
             
    }// END of doConnect method
    
    private class RemoteReader implements Runnable {
        public void run() {
            try {
                while ( true ) {
                    String nextLine = serverIn.readLine();
                    output.append(nextLine + "\n");
                    output.setCaretPosition(output.getDocument().getLength()-1);
                }
            } 
            catch (Exception e) {
                System.err.println("Error while reading from server.");
                e.printStackTrace();
            }
        } // END of run method
} // END of RemoteReader nested class
    
    public static void main(String[] args) {
        ChatClient c = new ChatClient();
        c.launchFrame();
    }
}
