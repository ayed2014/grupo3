package arboles;

import java.io.*;

/**
 * Created by Fran on 06/04/14.
 */
public class Io {

    public ArBin loadArbin(){
        try{
        FileInputStream fs=new FileInputStream("Arbin.ser");
            ObjectInputStream os=new ObjectInputStream(fs);
                ArBin binTree=(ArBin)os.readObject();
                return binTree;
            }catch (IOException E){}
         catch (ClassNotFoundException E){}
        return null;
    }

    public void saveArbin(ArBin binTree){
        try{
        FileOutputStream fs=new FileOutputStream("Arbin.ser");
        ObjectOutputStream os=new ObjectOutputStream(fs);
        os.writeObject(binTree);
        os.close();
        }catch (FileNotFoundException E){}
        catch (IOException E){}
    }
}
