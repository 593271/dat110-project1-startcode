package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import no.hvl.dat110.TODO;

public class RPCUtils {
    
    public static byte[] encapsulate(byte rpcid, byte[] payload) {

        byte[] rpcmsg = null;
        
        rpcmsg = new byte[payload.length + 1];

        rpcmsg[0] = rpcid;

        for (int i = 0; i < payload.length; i++) {

            rpcmsg[i+1] = payload[i];
        }

        // TODO - START

        // Encapsulate the rpcid and payload in a byte array according to the RPC
        // message syntax



        // TODO - END

        return rpcmsg;
    }

    public static byte[] decapsulate(byte[] rpcmsg) {

        byte[] payload = null;
        
        payload = new byte[rpcmsg.length-1];


        for(int i =0; i <rpcmsg.length-1; i++) {
            payload[i] = rpcmsg[i+1];
        }

        // Decapsulate the rpcid and payload in a byte array according to the RPC
        // message syntax

        return payload;

    }
    
    public static byte[] marshallString(String str) {
        
        byte[] encoded = null;
        
        // TODO - START 
        encoded = str.getBytes();
        
        
        // TODO - END
        
        return encoded;
    }
    
    public static String unmarshallString(byte[] data) {
        
        String decoded = null; 
        
        decoded = new String(data);
        
    
        
        // TODO - END
        
        return decoded;
    }
    
    public static byte[] marshallVoid() {
        
        byte[] encoded = null;
        
        // TODO - START 
        
        encoded = new byte[0];
                
        // TODO - END
        
        return encoded;
        
    }
    
    public static void unmarshallVoid(byte[] data) {
        
        // TODO
        
       
        
    }
    
    public static byte[] marshallBoolean(boolean b) {
        
        byte[] encoded = new byte[1];
                
        if (b) {
            encoded[0] = 1;
        } else
        {
            encoded[0] = 0;
        }
        
        return encoded;
    }
    
    public static boolean unmarshallBoolean(byte[] data) {
        
        return (data[0] > 0);
        
    }
    
    public static byte[] marshallInteger(int x) {
        
        byte[] encoded = null;
        
        // TODO - START 
        
        BigInteger bigInt = BigInteger.valueOf(x);
        encoded = bigInt.toByteArray();
        // TODO - END
        
        return encoded;
    }
    
    
    public static int unmarshallInteger(byte[] data) {
        
        int decoded = 0;
        // TODO - START 
        decoded = new BigInteger((data)).intValue();
        // TODO - END
        
        return decoded;
        
    }
    
}