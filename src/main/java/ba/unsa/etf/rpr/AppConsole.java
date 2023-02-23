package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.*;

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

            Exam exam = new Exam();

            exam.setUser(user);
            exam.setCourse(course);

            try {
                exam.setExamTime(parseDate(cl.getArgList().get(1)));
            } catch (ParseException e) {
                System.out.println("Date format incorrect. Must be dd/MM/yyyy. Please try again.");

                System.exit(1);
            }

            exam.setAnswerSheet(cl.getArgList().get(2));

            DaoFactory.examDao().add(exam);

            System.out.println("Exam successfully added to the database.");

        } else if (cl.hasOption(getExams.getOpt()) || cl.hasOption(getExams.getLongOpt())) {
            ExamManager examManager = new ExamManager();

            examManager.getAll().forEach(q -> System.out.println(q.getAnswerSheet() + "\n"));

        } else if (cl.hasOption(addCourse.getOpt()) || cl.hasOption(addCourse.getLongOpt())) {
            CourseManager courseManager = new CourseManager();

            if (cl.getArgList().size() != 2) {
                System.out.println("Course addition must have two arguments: the name of the course and the name of the professor. Please try again.");

                System.exit(1);
            }

            try {
                courseManager.createCourse(cl.getArgList().get(0), cl.getArgList().get(1));
            } catch (DBHandleException e) {
                System.out.println("Course with the same name already exists. Please try again.");

                System.exit(1);
            }

            System.out.println("Course successfully added to the database.");

        } else {
            printFormattedOptions(options);

            System.exit(-1);
        }
    }
}

