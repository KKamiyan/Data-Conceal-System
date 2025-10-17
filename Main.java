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
        
        String encryptedFilesPath = idSystem + "test.aes";
        System.out.println(filePath + " to: " + encryptedFilesPath);
        Path file = Paths.get(encryptedFilesPath);



        System.out.println("Encrypting file...");
        try{
            FileWriter writer = new FileWriter(idSystem + "test.aes", true);


            System.out.println("10%");
            byte[] fileData = Files.readAllBytes(filePath);
            System.out.println("20%");
            KeyGenerator genKey = KeyGenerator.getInstance("AES");
            System.out.println("30%");
            genKey.init(128);
            SecretKey key = genKey.generateKey();
            System.out.println("40%");
            Cipher encrypt = Cipher.getInstance("AES");
            encrypt.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("50%");
            byte[] encryptedFile = encrypt.doFinal(fileData);
            System.out.println("60%");




            Files.write(file, encryptedFile);
            System.out.println("70%\n...\n100%");
            System.out.println("File encrypted successfully!");
            System.out.println("Encrypted file path: " + file.toAbsolutePath().toString());
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }

        

        

    }

    static Path getFile(){
        String filePath = "README.md";
        System.out.print("Enter the file path ");

        do {
            System.out.print(": ");
            filePath = scanner.nextLine();
        } while (filePath.isEmpty());
        
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
                
                count++;

            }
            System.out.printf("Conversion ID: %06d\n", count);
            
            bufferedReader.close();

            FileWriter write = new FileWriter(idFilePath, true);
            write.write(count + "\n");
            write.close();

        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
        return count;
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
