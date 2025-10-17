import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import javax.crypto.*;



public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int choice = 0;

    public static void main(String[] args) {

        //idSystem();
        encrypt(getFile(), idSystem());


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
    
    static void encrypt(Path filePath,int idSystem){
        
        String encryptedFilesPath = idSystem + "test.txt";
        System.out.println("filename: " + encryptedFilesPath);
        Path file = Paths.get(encryptedFilesPath);



        System.out.println("Encrypting file...");
        try{
            FileWriter writer = new FileWriter(idSystem + "test.txt", true);


            System.out.println("1");
            byte[] fileData = Files.readAllBytes(filePath);
            System.out.println("2");
            KeyGenerator genKey = KeyGenerator.getInstance("AES");
            System.out.println("3");
            genKey.init(128);
            SecretKey key = genKey.generateKey();
            System.out.println("4");
            Cipher encrypt = Cipher.getInstance("AES");
            encrypt.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("5");
            byte[] encryptedFile = encrypt.doFinal(fileData);
            System.out.println("6");




            Files.write(file, encryptedFile);
            System.out.println("7");
            System.out.println("File encrypted successfully!");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        

        

    }

    static Path getFile(){
        String filePath = "README.md";
        System.out.print("Enter the file path: ");
        filePath = scanner.nextLine();
        Path file = Paths.get(filePath);
        
        return file;
    }

    static int idSystem(){
        String line;
        int count = 0;

        try {
            String idFilePath = "id.txt";
            

            FileReader reader = new FileReader(idFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.printf("ID: %06d\n", count);
                count++;

            }
            
            bufferedReader.close();

            FileWriter write = new FileWriter(idFilePath, true);
            write.write(count + "\n");
            write.close();

        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
        return count + 1;
    }

    static void test(){
        try {
            Path file = Paths.get("README.md");
            if(Files.exists(file)){
                System.out.println("exist");
            }
            else System.out.println("does not exist");
            
        } catch (Exception e) {
            System.out.println("error");
        }
    }


}
