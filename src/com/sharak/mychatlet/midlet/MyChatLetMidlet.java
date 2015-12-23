/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharak.mychatlet.midlet;

import com.sharak.mychatlet.midlet.threads.ThreadClient;

import java.io.*;

import javax.microedition.io.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Fede
 */
public class MyChatLetMidlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    
    String hostString, portString, nickString, passString;
    InputStream is;
    OutputStream os;
    SocketConnection sc;
    
    ThreadClient client;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private Command exitCommand;
    private Command itemCommand;
    private Command backCommand;
    private Command logoutCommand;
    private Command exitCommand1;
    private Command createMessageCommand;
    private Command okCommand;
    private Command backCommand1;
    private Command cleanScreenCommand;
    private Command backToServerAccessCommand;
    private Command exitCommand2;
    private Command okToLoginCommand;
    private Command backToServerAccessCommand1;
    private Command backToPreviousDisplayCommand;
    private Command okToChatCommand;
    private Form chatForm;
    private TextBox messageTextBox;
    private Form serverAccessForm;
    private TextField hostTextField;
    private TextField portTextField;
    private Alert errorAlert;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The MyChatLetMidlet constructor.
     */
    public MyChatLetMidlet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    /**
     * Switches a display to previous displayable of the current displayable.
     * The <code>display</code> instance is obtain from the
     * <code>getDisplay</code> method.
     */
    private void switchToPreviousDisplayable() {
        Displayable __currentDisplayable = getDisplay().getCurrent();
        if (__currentDisplayable != null) {
            Displayable __nextDisplayable = (Displayable) __previousDisplayables.get(__currentDisplayable);
            if (__nextDisplayable != null) {
                switchDisplayable(null, __nextDisplayable);
            }
        }
    }
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize

    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
    
        switchDisplayable(null, getServerAccessForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        Displayable __currentDisplayable = display.getCurrent();
        if (__currentDisplayable != null && nextDisplayable != null) {
            __previousDisplayables.put(nextDisplayable, __currentDisplayable);
        }
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
if (displayable == chatForm) {//GEN-BEGIN:|7-commandAction|1|60-preAction
            if (command == cleanScreenCommand) {//GEN-END:|7-commandAction|1|60-preAction
    chatForm.deleteAll();
//GEN-LINE:|7-commandAction|2|60-postAction
 // write post-action user code here
} else if (command == createMessageCommand) {//GEN-LINE:|7-commandAction|3|42-preAction

                switchDisplayable(null, getMessageTextBox());//GEN-LINE:|7-commandAction|4|42-postAction

            } else if (command == logoutCommand) {//GEN-LINE:|7-commandAction|5|40-preAction
    try {
        os.write("/E".getBytes());
        os.write("\r\n".getBytes());
        detenerChat();
        chatForm.append(new StringItem("Te has desconectado del servidor",""));
        switchDisplayable(null, getServerAccessForm());//GEN-LINE:|7-commandAction|6|40-postAction
    } 
    catch (Exception ex) {
    }
    }//GEN-BEGIN:|7-commandAction|7|75-preAction
} else if (displayable == errorAlert) {
    if (command == backToPreviousDisplayCommand) {//GEN-END:|7-commandAction|7|75-preAction

        switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|8|75-postAction

    }//GEN-BEGIN:|7-commandAction|9|53-preAction
} else if (displayable == messageTextBox) {
    if (command == backCommand1) {//GEN-END:|7-commandAction|9|53-preAction
    
        switchDisplayable(null, getChatForm());//GEN-LINE:|7-commandAction|10|53-postAction

    } else if (command == okCommand) {//GEN-LINE:|7-commandAction|11|55-preAction
    chatForm.append(new StringItem(messageTextBox.getString().trim(),""));
    try {
        os.write(messageTextBox.getString().trim().getBytes());
        os.write("\r\n".getBytes());
        switchDisplayable(null, getChatForm());//GEN-LINE:|7-commandAction|12|55-postAction
        messageTextBox.setString("");
    }
    catch (Exception ex) {
        switchDisplayable (null, getErrorAlert());
        errorAlert.setString(ex.getMessage());
    }
    }//GEN-BEGIN:|7-commandAction|13|66-preAction
} else if (displayable == serverAccessForm) {
    if (command == exitCommand2) {//GEN-END:|7-commandAction|13|66-preAction

        exitMIDlet();//GEN-LINE:|7-commandAction|14|66-postAction

    } else if (command == okToLoginCommand) {//GEN-LINE:|7-commandAction|15|68-preAction
    try{
        // conexion al servidor del chat
        hostString = hostTextField.getString().trim();
        portString = portTextField.getString().trim();
        sc = (SocketConnection)Connector.open("socket://"+hostString+":"+portString);
        // prepara los streams
        is = sc.openInputStream();
        os = sc.openOutputStream();
        switchDisplayable(null, getChatForm());//GEN-LINE:|7-commandAction|16|68-postAction
        recibirMensajesChat();
    } catch(Exception ex){
        switchDisplayable (null, getErrorAlert());
        errorAlert.setString(ex.getMessage());
    }
            }//GEN-BEGIN:|7-commandAction|17|7-postCommandAction
        }//GEN-END:|7-commandAction|17|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|18|
//</editor-fold>//GEN-END:|7-commandAction|18|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: chatForm ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of chatForm component.
     *
     * @return the initialized component instance
     */
    public Form getChatForm() {
        if (chatForm == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
chatForm = new Form("CHAT", new Item[]{});//GEN-BEGIN:|14-getter|1|14-postInit
            chatForm.addCommand(getLogoutCommand());
            chatForm.addCommand(getCreateMessageCommand());
            chatForm.addCommand(getCleanScreenCommand());
            chatForm.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return chatForm;
    }
//</editor-fold>//GEN-END:|14-getter|2|









//<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of itemCommand component.
     *
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
itemCommand = new Command("Item", Command.ITEM, 0);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return itemCommand;
    }
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
//GEN-END:|34-getter|0|34-preInit
 // write pre-init user code here
backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|34-getter|1|34-postInit
 // write post-init user code here
}//GEN-BEGIN:|34-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|34-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|37-getter|0|37-preInit
 // write pre-init user code here
exitCommand1 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|37-getter|1|37-postInit
 // write post-init user code here
}//GEN-BEGIN:|37-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|37-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: logoutCommand ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initialized instance of logoutCommand component.
     *
     * @return the initialized component instance
     */
    public Command getLogoutCommand() {
        if (logoutCommand == null) {
//GEN-END:|39-getter|0|39-preInit
 // write pre-init user code here
logoutCommand = new Command("Cerrar", Command.ITEM, 0);//GEN-LINE:|39-getter|1|39-postInit
 // write post-init user code here
}//GEN-BEGIN:|39-getter|2|
        return logoutCommand;
    }
//</editor-fold>//GEN-END:|39-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: createMessageCommand ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initialized instance of createMessageCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCreateMessageCommand() {
        if (createMessageCommand == null) {
//GEN-END:|41-getter|0|41-preInit
 // write pre-init user code here
createMessageCommand = new Command("Crear Msj.", Command.ITEM, 0);//GEN-LINE:|41-getter|1|41-postInit
 // write post-init user code here
}//GEN-BEGIN:|41-getter|2|
        return createMessageCommand;
    }
//</editor-fold>//GEN-END:|41-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {
//GEN-END:|52-getter|0|52-preInit
 // write pre-init user code here
backCommand1 = new Command("Regresar", Command.BACK, 0);//GEN-LINE:|52-getter|1|52-postInit
 // write post-init user code here
}//GEN-BEGIN:|52-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|52-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|54-getter|0|54-preInit
 // write pre-init user code here
okCommand = new Command("Enviar", Command.OK, 0);//GEN-LINE:|54-getter|1|54-postInit
 // write post-init user code here
}//GEN-BEGIN:|54-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|54-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: messageTextBox ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initialized instance of messageTextBox component.
     *
     * @return the initialized component instance
     */
    public TextBox getMessageTextBox() {
        if (messageTextBox == null) {
//GEN-END:|51-getter|0|51-preInit
 // write pre-init user code here
messageTextBox = new TextBox("Crear Mensaje Nuevo", null, 500, TextField.ANY | TextField.SENSITIVE | TextField.NON_PREDICTIVE | TextField.INITIAL_CAPS_WORD);//GEN-BEGIN:|51-getter|1|51-postInit
            messageTextBox.addCommand(getBackCommand1());
            messageTextBox.addCommand(getOkCommand());
            messageTextBox.setCommandListener(this);//GEN-END:|51-getter|1|51-postInit
 // write post-init user code here
}//GEN-BEGIN:|51-getter|2|
        return messageTextBox;
    }
//</editor-fold>//GEN-END:|51-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cleanScreenCommand ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initialized instance of cleanScreenCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCleanScreenCommand() {
        if (cleanScreenCommand == null) {
//GEN-END:|59-getter|0|59-preInit
 // write pre-init user code here
cleanScreenCommand = new Command("Limpiar Pantalla", Command.ITEM, 0);//GEN-LINE:|59-getter|1|59-postInit
 // write post-init user code here
}//GEN-BEGIN:|59-getter|2|
        return cleanScreenCommand;
    }
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToServerAccessCommand ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initialized instance of backToServerAccessCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackToServerAccessCommand() {
        if (backToServerAccessCommand == null) {
//GEN-END:|62-getter|0|62-preInit
 // write pre-init user code here
backToServerAccessCommand = new Command("Regresar", Command.BACK, 0);//GEN-LINE:|62-getter|1|62-postInit
 // write post-init user code here
}//GEN-BEGIN:|62-getter|2|
        return backToServerAccessCommand;
    }
//</editor-fold>//GEN-END:|62-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: serverAccessForm ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initialized instance of serverAccessForm component.
     *
     * @return the initialized component instance
     */
    public Form getServerAccessForm() {
        if (serverAccessForm == null) {
//GEN-END:|61-getter|0|61-preInit
 // write pre-init user code here
serverAccessForm = new Form("Conectar a Servidor CHAT", new Item[]{getHostTextField(), getPortTextField()});//GEN-BEGIN:|61-getter|1|61-postInit
            serverAccessForm.addCommand(getExitCommand2());
            serverAccessForm.addCommand(getOkToLoginCommand());
            serverAccessForm.setCommandListener(this);//GEN-END:|61-getter|1|61-postInit
 // write post-init user code here
}//GEN-BEGIN:|61-getter|2|
        return serverAccessForm;
    }
//</editor-fold>//GEN-END:|61-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initialized instance of exitCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {
//GEN-END:|65-getter|0|65-preInit
 // write pre-init user code here
exitCommand2 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|65-getter|1|65-postInit
 // write post-init user code here
}//GEN-BEGIN:|65-getter|2|
        return exitCommand2;
    }
//</editor-fold>//GEN-END:|65-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okToLoginCommand ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initialized instance of okToLoginCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkToLoginCommand() {
        if (okToLoginCommand == null) {
//GEN-END:|67-getter|0|67-preInit
 // write pre-init user code here
okToLoginCommand = new Command("Conectar", Command.OK, 0);//GEN-LINE:|67-getter|1|67-postInit
 // write post-init user code here
}//GEN-BEGIN:|67-getter|2|
        return okToLoginCommand;
    }
//</editor-fold>//GEN-END:|67-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: hostTextField ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initialized instance of hostTextField component.
     *
     * @return the initialized component instance
     */
    public TextField getHostTextField() {
        if (hostTextField == null) {
//GEN-END:|70-getter|0|70-preInit
 // write pre-init user code here
hostTextField = new TextField("Host", null, 32, TextField.ANY | TextField.SENSITIVE);//GEN-LINE:|70-getter|1|70-postInit
 // write post-init user code here
}//GEN-BEGIN:|70-getter|2|
        return hostTextField;
    }
//</editor-fold>//GEN-END:|70-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: portTextField ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initialized instance of portTextField component.
     *
     * @return the initialized component instance
     */
    public TextField getPortTextField() {
        if (portTextField == null) {
//GEN-END:|71-getter|0|71-preInit
 // write pre-init user code here
portTextField = new TextField("Puerto", null, 32, TextField.NUMERIC);//GEN-LINE:|71-getter|1|71-postInit
 // write post-init user code here
}//GEN-BEGIN:|71-getter|2|
        return portTextField;
    }
//</editor-fold>//GEN-END:|71-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToPreviousDisplayCommand ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initialized instance of backToPreviousDisplayCommand
     * component.
     *
     * @return the initialized component instance
     */
    public Command getBackToPreviousDisplayCommand() {
        if (backToPreviousDisplayCommand == null) {
//GEN-END:|74-getter|0|74-preInit
 // write pre-init user code here
backToPreviousDisplayCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|74-getter|1|74-postInit
 // write post-init user code here
}//GEN-BEGIN:|74-getter|2|
        return backToPreviousDisplayCommand;
    }
//</editor-fold>//GEN-END:|74-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: errorAlert ">//GEN-BEGIN:|73-getter|0|73-preInit
    /**
     * Returns an initialized instance of errorAlert component.
     *
     * @return the initialized component instance
     */
    public Alert getErrorAlert() {
        if (errorAlert == null) {
//GEN-END:|73-getter|0|73-preInit
 // write pre-init user code here
errorAlert = new Alert("Error", null, null, AlertType.ERROR);//GEN-BEGIN:|73-getter|1|73-postInit
            errorAlert.addCommand(getBackToPreviousDisplayCommand());
            errorAlert.setCommandListener(this);
            errorAlert.setTimeout(Alert.FOREVER);//GEN-END:|73-getter|1|73-postInit
 // write post-init user code here
}//GEN-BEGIN:|73-getter|2|
        return errorAlert;
    }
//</editor-fold>//GEN-END:|73-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backToServerAccessCommand1 ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initialized instance of backToServerAccessCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackToServerAccessCommand1() {
        if (backToServerAccessCommand1 == null) {
//GEN-END:|79-getter|0|79-preInit
 // write pre-init user code here
backToServerAccessCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|79-getter|1|79-postInit
 // write post-init user code here
}//GEN-BEGIN:|79-getter|2|
        return backToServerAccessCommand1;
    }
//</editor-fold>//GEN-END:|79-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okToChatCommand ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initialized instance of okToChatCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkToChatCommand() {
        if (okToChatCommand == null) {
//GEN-END:|81-getter|0|81-preInit
 // write pre-init user code here
okToChatCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|81-getter|1|81-postInit
 // write post-init user code here
}//GEN-BEGIN:|81-getter|2|
        return okToChatCommand;
    }
//</editor-fold>//GEN-END:|81-getter|2|







    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }
    
    // metodo para preparar e iniciar el hilo que recibira los mensajes del chat
    private void recibirMensajesChat(){
        try {
            // crea la instancia y arranca el hilo
            // la razon de hacerlo asi es para que el InputStream bloquee el hilo
            // y lo maneje independientemente del MIDlet principal
            client = new ThreadClient(is,chatForm);
            client.start();
            
        } catch(Exception ex){
            switchDisplayable (null, getErrorAlert());
            errorAlert.setString(ex.getMessage());
        }
    }
    
    private void detenerChat(){
        if(is != null) {
            try {
                is.close();
            }
            catch(IOException io){}
        }
        //System.exit(-1);
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}
