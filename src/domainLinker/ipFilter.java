/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainLinker;

/**
 *
 * @author Omage Micheal
 */
public class ipFilter {
    ipFilter(String IpAddrs){
        
    };

    ipFilter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String sf(String p){
        String ip = "";
        for(int x = 0; x < p.length(); x ++){           
            String y = String.valueOf( p.charAt(x) );
            if(" ".equals(y)){
                    
            }
            else{
               ip += y; 
            }

        }
        return ip;
    }
}
