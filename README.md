# Morse Code Decoder
This application was written as a solution to the *Decode the Morse code* kata [published](https://www.codewars.com/kata/decode-the-morse-code) on the *Codewars* website.

This application will accept Morse code as a string, input by the user, and return the decoded Morse as a string in Latin script.

## Programming approach
This application was written in Java 21 using: 
* Object-oriented programming paradigm 
* Model–view–controller (MVC) design pattern
* Test-driven development methodology 

## Installation and Setup
### Prerequisites
* Java 21
* Access to command line interface / terminal

### Installation
1. Download `morse-decoder.jar` from the `/out/artifacts/morse_decoder_jar/` directory of this repository.
2. Move the downloaded file to another local directory on your device of your choosing.
3. Open your command line interface / terminal and navigate to the local location of `morse-decoder.jar`.
4. Run the application with the following command: 
> java -jar morse-decoder.jar

## Usage
Once you have run the application with the command above, you will be shown the following text:

> Welcome to the Morse Code Decoder!
> 
>Morse code letters must be separated by a SINGLE space and word by a TRIPLE space.
>
>Are you ready to decode morse code? [Y / N] and hit ENTER.

If you are ready to enter the Morse code message to decode, type `Y` and press the `ENTER` key. 
If not, type `N` and press the `ENTER` key.

If you selected to continue, you will be prompted to enter the Morse code message:

>Please enter the morse code you wish to decode and hit ENTER.

You can type the Morse code in manually, or you can copy and paste it into the terminal from another source.

### Morse code formatting
Please adhere to the following formatting when entering the Morse code:
* Morse code letters, e.g. `...` for the letter `S`, must be separated by a SINGLE space
* Morse code words, must be separated by a TRIPLE space
* Other than `.`, `-` or ` `, the Morse code entered must not include any other characters 

### Examples

#### Correct use

>Welcome to the Morse Code Decoder!
>
>Morse code letters must be separated by a SINGLE space and word by a TRIPLE space.
>
>Are you ready to decode morse code? [Y / N] and hit ENTER.
>
>Y
> 
>Please enter the morse code you wish to decode and hit ENTER.
>
>.... . -.--&nbsp;&nbsp;&nbsp;.--- ..- -.. .
> 
>Decoded morse code: HEY JUDE
> 
>Do you want to decode more morse code? [Y / N] and hit ENTER.
> 
>N
>
>Thank you for using the Morse Code Decoder. Goodbye.

#### Invalid characters
If the user enters any invalid characters, the returned decoded Morse will indicate the input was invalid.

>Welcome to the Morse Code Decoder!
>
>Morse code letters must be separated by a SINGLE space and word by a TRIPLE space.
>
>Are you ready to decode morse code? [Y / N] and hit ENTER.
>
>Y
>
>Please enter the morse code you wish to decode and hit ENTER.
>
> SOS
> 
> Decoded morse code: "SOS" is invalid morse code.
>
>Do you want to decode more morse code? [Y / N] and hit ENTER.
>
>N
>
>Thank you for using the Morse Code Decoder. Goodbye.


