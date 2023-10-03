import java.util.*;
import java.io.*;

class Packer {
    public static void main(String arg[]) {
        // Create a Scanner object to read user input
        Scanner sobj = new Scanner(System.in);
        boolean bRet;
        int PackCount = 0;

        // Display a welcome message
        System.out.println("------------------------------- File Packer-UnPacker -------------------------------");
        System.out.println("Packing Activity of the Application has Started");

        // Ask the user for the folder name containing the files to pack
        System.out.println("Enter the name of folder which contains the files that you want to pack: ");
        String FolderName = sobj.nextLine();

        // Create a File object for the specified folder
        File fobj = new File(FolderName);
        String Header = null;

        // Ask the user for the name of the packed file to create
        System.out.println("Enter the name of packed file that you want to create : ");
        String PackFile = sobj.nextLine();

        // Create a byte buffer to read and write data
        byte Buffer[] = new byte[1024];
        int iRet = 0;

        try {
            // Create a File object for the packed file
            File Packobj = new File(PackFile);
            bRet = Packobj.createNewFile();
            if (bRet == false) {
                System.out.println("Unable to create packed file");
                return;
            }

            System.out.println("Packed File gets successfully created in your current directory.");
            FileOutputStream outobj = new FileOutputStream(Packobj);

            // Check if the specified path is a directory
            bRet = fobj.isDirectory();
            if (bRet == true) {
                // List all files in the directory
                File list[] = fobj.listFiles();

                System.out.println(("Total number of files found in the directory are: " + list.length));
                for (int i = 0; i < list.length; i++) {
                    // Check if the file has a ".txt" extension
                    if ((list[i].getName()).endsWith(".txt")) {
                        // Create a header with file name and length, padding with spaces
                        Header = list[i].getName() + " " + list[i].length();
                        for (int j = Header.length(); j < 100; j++) {
                            Header = Header + " ";
                        }

                        byte bHeader[] = Header.getBytes();
                        outobj.write(bHeader, 0, bHeader.length);

                        FileInputStream inobj = new FileInputStream(list[i]);

                        // Loop to write the data
                        while ((iRet = inobj.read(Buffer)) != -1) {
                            outobj.write(Buffer, 0, iRet);
                        }
                        System.out.println("File Successfully packed with name: " + list[i].getName());
                        inobj.close();
                        PackCount++;
                    }
                }
                // Display packing summary
                System.out.println("---------------------- Packing Summary ----------------------");
                System.out.println("Total number of files scanned: " + list.length);
                System.out.println("Total number of files packed: " + PackCount);

                System.out.println("Thank you for using the Packer-UnPacker...");
            }
        } catch (Exception iobj) {
            System.out.println("Exception occured : " + iobj);
        }
    }
}