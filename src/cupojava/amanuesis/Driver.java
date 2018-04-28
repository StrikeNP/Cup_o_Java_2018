package cupojava.amanuesis;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([\"'])(?:(?=(\\\\?))\\2.)*?\\1");
        try(Scanner input = new Scanner(System.in)) {
            String inputString = input.nextLine();
            int commands = 0;

            String currentCommand = "";
            String undoInput = "";
            String redoInput = "";
            while(commands < 1000 && !currentCommand.equals("$Read it to me")) {
                currentCommand = input.nextLine();
                if(currentCommand.equals("$Undo")) {
                    redoInput = undoInput;
                    inputString = undoInput;
                } else if(currentCommand.equals("$Redo")) {
                    inputString = redoInput;
                } else if(currentCommand.startsWith("$Change all")) {
                    Matcher m = p.matcher(currentCommand);
                    String firstArgument = m.group(0);
                    String secondArgument = m.group(1);
                    undoInput = inputString;
                    inputString = inputString.replace(firstArgument, secondArgument);
                } else if(currentCommand.startsWith("$Change the")) {
                    String[] splitArray = currentCommand.split(" ");
                    int wordToChange = -1;
                    if(!splitArray[2].equals("last")) {
                        wordToChange = Integer.parseInt(String.valueOf(splitArray[2].charAt(0)));
                    } else {
                        wordToChange = splitArray.length - 1;
                    }
                    Matcher m = p.matcher(currentCommand);
                    String newWord = m.group(1);
                    splitArray[wordToChange] = newWord;
                    undoInput = inputString;
                    inputString = "";
                    for(String str : splitArray) {
                        inputString += str;
                        inputString += " ";
                    }
                } else if(currentCommand.startsWith("$Delete")) {
                    String[] splitArray = currentCommand.split(" ");
                    if(splitArray[splitArray.length - 1].equals("word")) {
                        int numberToChange = -1;
                        if(splitArray[2].equals("last")) {
                            numberToChange = splitArray.length - 1;
                        } else {
                            numberToChange = Integer.parseInt(String.valueOf(splitArray[2].charAt(0)));
                        }
                        splitArray[numberToChange] = null;
                        undoInput = inputString;
                        inputString = "";
                        for(int i = 0; i < splitArray.length; i++) {
                            if(splitArray[numberToChange] != null) {
                                inputString += splitArray[i];
                                inputString += " ";
                            }
                        }
                    } else if(splitArray[splitArray.length - 1].equals("character")) {
                        int numberToChange = -1;
                        if(splitArray[2].equals("last")) {
                            numberToChange = splitArray.length - 1;
                        } else {
                            numberToChange = Integer.parseInt(String.valueOf(splitArray[2].charAt(0)));
                        }
                        undoInput = inputString;
                        for(int i = 0; i < undoInput.length(); i++) {
                            if(numberToChange != i - 1) {
                                inputString += undoInput.charAt(i);
                            }
                        }
                    } else {
                        int numberToChange = -1;
                        if(splitArray[2].equals("last")) {
                            numberToChange = splitArray.length - 1;
                        } else {
                            numberToChange = Integer.parseInt(String.valueOf(splitArray[2].charAt(0)));
                        }
                        undoInput = inputString;
                        inputString = "";
                        for(int i = 0; i < splitArray.length; i++) {
                            if(i != numberToChange - 1) {
                                inputString += splitArray[i];
                                inputString += " ";
                            }
                        }
                    }
                } else if(currentCommand.startsWith("$Go to the")) {

                }

                commands++;
            }
        }
    }
}
