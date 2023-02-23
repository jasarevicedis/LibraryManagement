package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;

public class AppConsole {
    private static final Option addBook = new Option("b", "add-book", false, "Adding book to the database");
    private static final Option addMember = new Option("m", "add-member", false, "Adding member to the database");
    private static final Option getBooks = new Option("getB", "get-books", false, "Printing all books from the database");
    private static final Option getMembers = new Option("getM", "get-members", false, "Printing all members from the database");


    private static Options addOptions() {
        Options options = new Options();

        options.addOption(addBook);
        options.addOption(addMember);
        options.addOption(getBooks);
        options.addOption(getMembers);

        return options;
    }
}

