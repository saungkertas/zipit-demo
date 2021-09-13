package zipit.demo.jetbrains;
import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //This is name and path of zip file to be created

        //Add files to be archived into zip file
        ArrayList<File> filesToAdd = new ArrayList<>();
        filesToAdd.add(new File(args[0]));

        //Initiate Zip Parameters which define various properties
        ZipParameters zipParameters= new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);

        ZipFile zipFile = new ZipFile("credential.zip", args[1].toCharArray());
        try {
            zipFile.addFiles(filesToAdd, zipParameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }

    }
}
