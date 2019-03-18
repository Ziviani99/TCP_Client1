/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/**
 *
 * @author zivia
 */
public class TCP_Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        Locale.setDefault(Locale.US);
        // TODO code application logic here
        // Connect to the server process running at host
	Socket s = new Socket("127.0.0.1", 9001);
	
    	// The next 2 lines create a output stream we can
	// write to.  (To write TO SERVER)
	OutputStream os= s.getOutputStream();
	DataOutputStream serverWriter = new DataOutputStream(os);
		
	// The next 2 lines create a buffer reader that
	// reads from the standard input. (to read stream FROM SERVER)
	InputStreamReader isrServer = new InputStreamReader(s.getInputStream());
	BufferedReader serverReader = new BufferedReader(isrServer);
                
                
        //create buffer reader to read input from user. 
	//Read the user input to string 'sentence'
        
        //linhas adicionadas
        System.out.println("Se você quiser que o servidor calcule seu IMC digite 1 e depois sua altura e peso.");
        System.out.println("Ex.: 1 1,86 84");
        //
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence;  
        sentence = inFromUser.readLine();

        
               
        // Send a user input to server
        serverWriter.writeBytes(sentence +"\n");
		
	// Server should convert to upper case and reply.
	// Read server's reply below and output to screen.
        String response = serverReader.readLine();
	System.out.println(response);
        s.close();
    }
    
}
