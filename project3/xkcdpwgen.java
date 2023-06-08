 // Represents importing relevant java libraries to make the generation
// of this program possible
import java.util.*;
import java.io.*;
import java.security.SecureRandom;

// Represents the creation of a program that aims to 
// develop a program called 'xkcdpwgen' that can 
// generate secure, memorable passwords using the 
// XKDC method

public class xkcdpwgen {
    
    
    // Represents the constants initialized for this class and program
    // in the process of password generation
    
    // Represents the numbers used in this program in password generation
    private static final String DIGITS_USED = "0123456789";
    
    // Represents the symbols that can be used in the password
    private static final String UNIQUE_SYMBOLS = "~!@#$%^&*.:;";
    
    // Represents the file with all of the possible words
    private static final String word_List = "words.txt";
    
    // Represents the initialization of the main method, to take in the 
    // number of words, capslocks, numbers, and symbols, in the process
    // of the password generation process
    public static void main(String[] args){
        
        // Represents initializing the number of words, 
        // symbols, numbers and capslock cases
        
        // Represents initializing the number of unique symbols to 0
        int unique_symbols = 0;
        
        // Represents initializing the number of words by default to 0
        int words = 4;
        
        // Represents initializing the number of capslock cases to 0
        int caps = 0;
        
        // Represents initializing the number of numbers to 0
        int numbers = 0;
        
        // Represents prompting the user to enter command line 
        // arguments in the process of enhancing the password
        // generation process
        for (int i = 0; i < args.length; i+=2){
            
            // Represents the value in integer form in the duration
            // of looping
            int int_val = Integer.parseInt(args[i+1]);
            
            // Represents the string at hand
            String string_at_hand = args[i];
            
            // Represents going over each of the case of the command line
            // interface argument 
            switch(string_at_hand){
                
                // In case the value given is a capslock, the int_val
                // is assigned to caps, allowing the user to enter
                // the number of such characters in the password 
                // generation process 
                case "-c":
                    
                    // assigning the value to the caps
                    caps = int_val;
                    break;
                
                // In case the value given is a words, the int_val
                // is assigned to words, allowing the user to enter
                // the number of such characters in the password 
                // generation process 
                case "-w":
                    
                    // assigning the value to the words
                    words = int_val;
                    break;
                
                // In case the value given is a symbols, the int_val
                // is assigned to symbols, allowing the user to enter
                // the number of such characters in the password 
                // generation process 
                case "-s":
                    
                    // assigning the value to the symbols
                    unique_symbols = int_val;
                    break;
                
                
                // In case the value given is a numbers, the int_val
                // is assigned to numbers, allowing the user to enter
                // the number of such characters in the password 
                // generation process 
                case "-n":
                    
                    // assigning the value to the numbers
                    numbers = int_val;
                    break;
                
                default:
                    System.exit(1);
            }
        }
        
        // Represents the helper function that generates the password
        String passwordGenerated = generation_password(unique_symbols, words, caps, numbers);
    
        // Represents initializing the list of words
        List<String> wordsContained = goOverWordList(word_List);
        
        // Represents printing the password for the user that is 
        // generated
        System.out.println(String.join("", passwordGenerated));
    }

    public static String generation_password(int words, int caps, int numbers, int unique_symbols) {
        
        SecureRandom random = new SecureRandom();
        
        // Represents a new string builder object to build the password
        StringBuilder PASSWORD_GENERATED = new StringBuilder();
        
        // Represents laoding the word list
        List<String> wordsContained = goOverWordList(word_List);
    
        // Represents the loop that goes over all of the words to 
        // take out random words from the word list
        for (int i = 0; i < words; i++) {
            
            // Represents iterating through the words and getting the
            // random words from the list
            String wordRandomlyCaptured = wordsContained.get(random.nextInt(wordsContained.size()));

            // Based on the XKCD method of password generation, 
            // if the 'i' is less than number of capslock cases, 
            // makes it capitalized
            if (i < caps) {
                
                wordRandomlyCaptured = wordRandomlyCaptured.substring(0, 1).toUpperCase() + wordRandomlyCaptured.substring(1);
                
            }
            
            PASSWORD_GENERATED.append(wordRandomlyCaptured);
        }
        
        // Represents going over the iterations and interting random elements
        // for password generation
        for (int i = 0; i < numbers; i++) {
            PASSWORD_GENERATED.insert(random.nextInt(PASSWORD_GENERATED.length() + 1), random.nextInt(10));
        }
        
        // Represents going over and adding random unique symbols to our
        // password generation process
        for (int i = 0; i < unique_symbols; i++) {
            
            PASSWORD_GENERATED.insert(random.nextInt(PASSWORD_GENERATED.length() + 1), UNIQUE_SYMBOLS.charAt(random.nextInt(UNIQUE_SYMBOLS.length())));
        }

        return PASSWORD_GENERATED.toString();
    }
    
    public static List<String> goOverWordList(String givenWordFile) {
        List<String> words = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(givenWordFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading word list: " + e.getMessage());
            System.exit(1);
        }
        
        return words;
    }
}
