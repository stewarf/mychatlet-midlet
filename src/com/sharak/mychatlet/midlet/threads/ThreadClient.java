package com.sharak.mychatlet.midlet.threads;

import java.io.InputStream;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

public class ThreadClient extends Thread {
    
    InputStream entrada;
    Form form;
    
    public ThreadClient(InputStream is, Form form){
        this.entrada = is;
        this.form=form;
    }
    
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
    
    public void run(){
        
        try {
            String txt = "";
            StringBuffer sb = new StringBuffer();
            
            int c = 0;
            while ((c = entrada.read()) != -1) {
                if(c != '\n'){
                    sb.append((char)c);
                } else {
                    txt=sb.toString();
                    form.append(new StringItem(txt.toString(),""));
                    sb = new StringBuffer();
                }
            }
        } catch(Exception ex){ }
        
    }
    
}
