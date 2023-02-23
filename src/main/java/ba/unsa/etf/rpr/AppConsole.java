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

    private static final Option addBook = new Option("b", "add-book", false, "Adding book to the database");
    private static final Option addMember = new Option("m", "add-member", false, "Adding member to the database");
    private static final Option getBooks = new Option("getB", "get-books", false, "Printing all books from the database");
    private static final Option getMembers = new Option("getM", "get-members", false, "Printing all members from the database");

    private static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);

        helpFormatter.printUsage(printWriter, 150, "java -jar RPRprojekat.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);

        printWriter.close();
    }
    static Date today = new Date();
    private static Options addOptions() {
        Options options = new Options();

        options.addOption(addBook);
        options.addOption(addMember);
        options.addOption(getBooks);
        options.addOption(getMembers);

        return options;
    }
    public static void main(String[] args) throws Exception {

        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);

        if (cl.hasOption(addBook.getOpt()) || cl.hasOption(addBook.getLongOpt())) {
            Book book = null;

            if (cl.getArgList().size() != 3) {
                System.out.println("Must have three arguments: the book title, publish year and author name.");
            }

            try {
                book = DaoFactory.bookDao().searchByTitle(cl.getArgList().get(0));
            } catch (DBException e) {
                System.out.println("Course not defined. Please try again.");

                System.exit(1);
            }





        } else if (cl.hasOption(addMember.getOpt()) || cl.hasOption(addMember.getLongOpt())) {
            MemberManager memberManager = new MemberManager();

            if (cl.getArgList().size() != 2) {
                System.out.println("Member addition must have two arguments: the first and the last name. Please try again.");

                System.exit(1);
            }

            try {
                memberManager.createMember(cl.getArgList().get(0), cl.getArgList().get(1), today);
            } catch (DBException e) {
                System.out.println("Member with the same name already exists. Please try again.");

                System.exit(1);
            }

            System.out.println("Member successfully added to the database.");

        } else {
            printFormattedOptions(options);

            System.exit(-1);
        }
    }
}

