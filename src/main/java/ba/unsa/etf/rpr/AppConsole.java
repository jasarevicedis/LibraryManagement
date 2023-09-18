package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.business.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import ba.unsa.etf.rpr.exceptions.*;

public class AppConsole {
    private static final Option login = new Option("l","login",false,"Login - Enter your username and password!");
    private static final Option displayBooks = new Option("b","display-books",false,"Display all books");
    private static final Option addBook = new Option("a","add-book",false,"Add new book");


    private static final BookManager bookManager = new BookManager();

    /**
     * Prints all the options on the console
     * @param options - options to be printed
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar rpr.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    /**
     * Adds option objects to Options object
     * @return - Options object
     */
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(login);
        options.addOption(displayBooks);
        options.addOption(addBook);
        return options;
    }

    /**
     * The main method for executing the commands given by the user
     * @param args - eventual arguments of commands
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);
        if((cl.hasOption(login.getOpt()) || cl.hasOption(login.getLongOpt())) && cl.hasOption((login.getLongOpt()))){

            System.out.println("You have successfully registered");

        }
        else {
            printFormattedOptions(options);
            System.exit(-1);
        }
    }

}

