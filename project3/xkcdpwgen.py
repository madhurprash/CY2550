#!/usr/bin/env python3

## Represents importing the random python library to generate random variables
## that we need in the process of the password generation process
import random
import argparse

## Represents the creation of a program that aims to 
## develop a program called 'xkcdpwgen' that can 
## generate secure, memorable passwords using the 
## XKDC method

## Represents the constants initialized for this class and program
## in the process of password generation

## Represents the f/ile with all of the possible words
word_List = "words.txt"
    
## Represents the numbers used in this program in password generation
DIGITS_USED = "0123456789"
    
## Represents the symbols that can be used in the password
UNIQUE_SYMBOLS = "~!@#$%^&*.:;"
    
## Represents the initialization of the main method, to take in the 
## number of words, capslocks, numbers, and symbols, in the process
## of the password generation process
def main():
        
    ## Represents initializing the number of words, 
    ## symbols, numbers and capslock cases

    ## Represents using a parser to generate the password
    parser_toUse = argparse.ArgumentParser()

    ## Represents parsing the argument for the words to generate the password below
    parser_toUse.add_argument("-w", "--words", type=int, default=4, help="number of words in the generated password")

    ## Represents parsing the argument for the caps to generate the password below
    parser_toUse.add_argument("-c", "--caps", type=int, default=0, help="number of words with capitalized first letters")

    ## Represents parsing the argument for the numbers to generate the password below
    parser_toUse.add_argument("-n", "--numbers", type=int, default=0, help="number of random digits in the password")

    ## Represents parsing the argument for the unique symbols to generate the password below
    parser_toUse.add_argument("-s", "--symbols", type=int, default=0, help="number of random symbols in the password")

    ## represents parsing the arguments
    args = parser_toUse.parse_args()

    ## Represents initializing the number of unique symbols to 0
    unique_symbols = args.symbols
        
    ## Represents initializing the number of words by default to 0
    words = args.words
        
    ## Represents initializing the number of capslock cases to 0
    caps = args.caps
        
    ## Represents initializing the number of numbers to 0
    numbers = args.numbers
    
    passwordGenerated = generation_password(unique_symbols, words, caps, numbers)
    print(passwordGenerated)

def generation_password(unique_symbols, words, caps, numbers):
        
    ## SecureRandom random = new SecureRandom();
        
    ## Represents a new string builder object to build the password
    PASSWORD_GENERATED = []
    
    ## Represents laoding the word list
    wordsContained = goOverWordList(word_List)

    ## Represents randomly shuffling all of the words for the sake of password generation
    random.shuffle(wordsContained)
    
    ## Represents the loop that goes over all of the words to 
    ## take out random words from the word list
    for i in range(words):
            
        ## Represents iterating through the words and getting the
        ## random words from the list
        wordRandomlyCaptured = wordsContained[i]

        ## Based on the XKCD method of password generation, 
        ## if the 'i' is less than number of capslock cases, 
        ## makes it capitalized
        if i < min(caps, words) :
                
            wordRandomlyCaptured = wordRandomlyCaptured[0].upper() + wordRandomlyCaptured[1:]
                
        
            
        PASSWORD_GENERATED.append(wordRandomlyCaptured)
    
        
    ## Represents going over the iterations and interting random elements
    ## for password generation
    for _ in range(numbers):
        PASSWORD_GENERATED.append(random.choice(DIGITS_USED))
    
        
    ## Represents going over and adding random unique symbols to our
    ## password generation process
    for _ in range(unique_symbols):
            
        PASSWORD_GENERATED.append(random.choice(UNIQUE_SYMBOLS))
    

    return ''.join(PASSWORD_GENERATED)

    
def goOverWordList(givenWordFile):
    words = []

    ## Represents reading the given wordfile, and then through each
    ## line, stripping and appending to our words to return the words
    with open(givenWordFile, 'r') as file:
        for line in file:
            words.append(line.strip())
    
        
    
    return words


## Represents calling the main function from the script to be able to create the output of this code efficiently
if __name__ == "__main__":

    ## Represents calling the main function on the script
    main()

    
