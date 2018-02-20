import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


            // The name of the file to open.
            String fileNameRead = "rawText.txt";
            String spzOutputFile="spz.txt";
            String RCoutFile="rc.txt";
            String MACoutFile="mac.txt";

            // This will reference one line at a time
            String line = null;

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader(fileNameRead);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);
            //SPZ
                FileWriter fileWriter =
                        new FileWriter(spzOutputFile);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriterSPZ =
                        new BufferedWriter(fileWriter);
            //RC
                FileWriter fileWriterRC =
                        new FileWriter(RCoutFile);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriterRC =
                        new BufferedWriter(fileWriterRC);
            //MAC
                FileWriter fileWriterMAC =
                        new FileWriter(MACoutFile);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriterMAC =
                        new BufferedWriter(fileWriterMAC);

                String patternSPZ="[A-Z]{2}[0-9]{3}[A-Z]{2}";
                String patternRC="[0-9]{2}[0|1|2|5|6]{1}[1-9]{1}(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/?([0-9]{3,4})";
                String patternMAC="([0-9A-F]{2}[:-]){5}([0-9A-F]{2})";

                while ((line = bufferedReader.readLine()) != null) {

                    String[] result=line.split(" ");

                    for (String swap:result) {

                    //SPZ
                        Pattern spz=Pattern.compile(patternSPZ);
                        Matcher matcherSPZ=spz.matcher(swap);
                    //RC
                        Pattern rc=Pattern.compile(patternRC);
                        Matcher matcherRC=rc.matcher(swap);
                    //MAC
                        Pattern mac=Pattern.compile(patternMAC);
                        Matcher matcherMAC=mac.matcher(swap);

                        if (matcherSPZ.matches()) {

                            System.out.println(swap);

                            bufferedWriterSPZ.write(swap);
                            bufferedWriterSPZ.newLine();

                        }

                        if (matcherRC.matches()) {

                            System.out.println(swap);
                            System.out.println();

                            bufferedWriterRC.write(swap);
                            bufferedWriterRC.newLine();

                        }

                        if (matcherMAC.matches()) {

                            System.out.println(swap);
                            System.out.println();

                            bufferedWriterMAC.write(swap);
                            bufferedWriterMAC.newLine();

                        }


                    }



                }

                // Always close files.
                bufferedReader.close();

                bufferedWriterSPZ.close();
                bufferedWriterRC.close();
                bufferedWriterMAC.close();

                //exeptions
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileNameRead + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileNameRead + "'");
                System.out.println(
                        "Error writing to file '"
                                + spzOutputFile + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }

/*
        // The name of the file to open.
        String fileNameWrite = "write.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileNameWrite);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileNameWrite + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
*/


    }

}
