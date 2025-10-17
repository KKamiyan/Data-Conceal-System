import java.util.Scanner;
import java.nio.file.*;
import javax.crypto.*;



public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int choice = 0;

    public static void main(String[] args) {

        encrypt(getFile());


        /*System.out.println("Data Conceal System");

        System.out.println("(1)Decrypt/Read file");
        System.out.println("(2)Encrypt/Hide file");
        System.out.println("(0)Exit");
        System.out.print(": ");
        choice = scanner.nextInt();

        switch(choice){
            case 1 -> System.out.println("test");
        }
        */
        scanner.close();


    }

    static void decrypt(){

    }
    
    static void encrypt(Path filePath){
        
        String encryptedFilesPath = "Data-Conceal-System\\Encrypted-Files";
        Path file = Paths.get(encryptedFilesPath);

        if(!Files.exists(file)){
            System.out.println("DOEsnt exist");
        }

        System.out.println("Encrypting file...");
        try{
            System.out.println("1");
            byte[] fileData = Files.readAllBytes(filePath);
            System.out.println("2");
            KeyGenerator genKey = KeyGenerator.getInstance("AES");
            System.out.println("3");
            genKey.init(128);
            SecretKey key = genKey.generateKey();

            Cipher encrypt = Cipher.getInstance("AES");
            encrypt.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedFile = encrypt.doFinal(fileData);

            Files.write(file, encryptedFile);
            System.out.println("File encrypted successfully!");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        

        

    }

    static Path getFile(){
        String filePath = "";
        System.out.print("Enter the file path: ");
        //filePath = scanner.nextLine();
        Path file = Paths.get(filePath);
        
        return file;
    }




}
