import java.util.Scanner;

class App{


    //initialising Scanner sc
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //setting up a while loop
        while (true) {
            System.out.print("Enter (e) for encryption, (d) for decryption. Return to exit: ");
            String userChoice = sc.nextLine().toLowerCase();

            if (userChoice.isEmpty()) {
                return;
            }

            //error handling: making sure that the user cannot invalid input
            if (!userChoice.equals("e") && !userChoice.equals("d")) {
                System.out.println("Invalid choice. Please enter 'e' or 'd'.");
                continue;
            }

            System.out.print("Enter key (do not enter spaces): ");
            String key = sc.nextLine().toLowerCase();

            System.out.print("Enter message (do not enter spaces): ");
            String message = sc.nextLine().toLowerCase();

            if (userChoice.equals("e")) {

                //The method encrypt has access to the Strings message and key
                String encryptedMessage = encrypt(message, key);
                System.out.println("Encrypted message: " + encryptedMessage);
            } else {
                //Similarlly here with decrypt
                String decryptedMessage = decrypt(message, key);
                System.out.println("Decrypted message: " + decryptedMessage);
            }
        }
    }
    //setting up a method that handles the encryption

    //the method takes in the parameters: message and key.
    public static String encrypt(String message, String key) {

        //StringBuilder class Is used here to add the encrypted character onto the string by using the append method
        StringBuilder encryptedMessage = new StringBuilder();
        int shift = 0;


        //creating a for loop to go through every character in the message and apply the vigenere cipher

        //the i is the index value and it increases with the message length, initially the value of i is set to 0
        //but due to the 'i++', there is an increment in the value as the loop repeats
        for (int i = 0; i < message.length(); i++) {


            shift = key.charAt((i % key.length())) - 'z';
            char messageToChar = message.charAt(i);
            
            
            // changed z to a  
            if (Character.isLetter(messageToChar)) {
                messageToChar = (char) ((messageToChar - 'a' + shift) % 26 + 'a');
            }
            encryptedMessage.append(messageToChar);
        }
        return encryptedMessage.toString();
    }


    //setting up a method that handles the decryption
    public static String decrypt(String message, String key){
        StringBuilder decryptedMessage = new StringBuilder();
        int shift = 0;


		// changed z to a
        for(int i = 0; i<message.length();i++){
            shift = key.charAt((i)%key.length()) - 'a';
            char messageToChar = message.charAt(i);

            if (Character.isLetter(messageToChar)) {
                messageToChar = (char) ((messageToChar - 'a' - shift + 26) % 26 + 'a');
            }
            decryptedMessage.append(messageToChar);
        }
        return decryptedMessage.toString();

    }
}
