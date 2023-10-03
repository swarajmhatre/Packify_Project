import java.util.*;
import java.io.*;

class Unpacker {
    public static void main(String arg[]) {
        // Create a Scanner object to read user input
        Scanner sobj = new Scanner(System.in);
        byte Header[] = new byte[100];
        int iRet = 0;
        String HeaderStr;
        String Tokens[];
        int iCount = 0;

        // Display a welcome message
        System.out.println("----------- Packer Unpacker ----------- ");
        System.out.println("Unpacking Activity of the application is started...");

        // Ask the user for the name of the packed file to unpack
        System.out.println("Enter the file name which contains the packed data : ");
        String PackFile = sobj.nextLine();

        try {
            // Create a File object for the packed file
            File Packobj = new File(PackFile);
            FileInputStream inobj = new FileInputStream(Packobj);

            while ((iRet = inobj.read(Header, 0, 100)) > 0) {
                HeaderStr = new String(Header);
                System.out.println(HeaderStr);

                // Split the header to extract file name and size
                Tokens = HeaderStr.split(" ");

                // Create a new File object for the extracted file
                File newfileobj = new File(Tokens[0]);
                newfileobj.createNewFile();

                FileOutputStream outobj = new FileOutputStream(newfileobj);
                int FileSize = Integer.parseInt(Tokens[1]);
                byte Buffer[] = new byte[FileSize];

                // Read and write the file data
                inobj.read(Buffer, 0, FileSize);
                outobj.write(Buffer, 0, FileSize);

                System.out.println("File Successfully extracted with Name: " + Tokens[0]);
                iCount++;
            }
            // Display unpacking summary
            System.out.println("---------------------- Unpacking Summary ----------------------");
            System.out.println("Total number of files extracted: " + iCount);
            System.out.println("Thank you for using Packer-UnPacker...");
        } catch (Exception obj) {
            System.out.println("Exception occured : " + obj);
        }
    }
}