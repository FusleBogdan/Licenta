package quiz.application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class QuizServiceImpl extends UnicastRemoteObject implements QuizService {
    private static final long serialVersionUID = 1L;

    private String[][] questions = {
        {"Which is used to find and fix bugs in the Java programs.?", "JVM", "JDB", "JDK", "JRE"},
        {"What is the return type of the hashCode() method in the Object class?", "int", "Object", "long", "void"},
        {"Which package contains the Random class?", "java.util package", "java.lang package", "java.awt package", "java.io package"},
        {"An interface with no fields or methods is known as?", "Runnable Interface", "Abstract Interface", "Marker Interface", "CharSequence Interface"},
        {"In which memory a String is stored, when we create a string using new operator?", "Stack", "String memory", "Random storage space", "Heap memory"},
        {"Which of the following is a marker interface?", "Runnable interface", "Remote interface", "Readable interface", "Result interface"},
        {"Which keyword is used for accessing the features of a package?", "import", "package", "extends", "export"},
        {"In java, jar stands for?", "Java Archive Runner", "Java Archive", "Java Application Resource", "Java Application Runner"},
        {"Which of the following is a mutable class in java?", "java.lang.StringBuilder", "java.lang.Short", "java.lang.Byte", "java.lang.String"},
        {"Which of the following option leads to the portability and security of Java?", "Bytecode is executed by JVM", "The applet makes the Java code secure and portable", "Use of exception handling", "Dynamic binding between objects"},
    };

    private String[] answers = {
        "JDB",
        "int",
        "java.util package",
        "Marker Interface",
        "Heap memory",
        "Remote interface",
        "import",
        "Java Archive",
        "java.lang.StringBuilder",
        "Bytecode is executed by JVM"
    };

    protected QuizServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getQuestion(int index) throws RemoteException {
        return questions[index][0];
    }

    @Override
    public String[] getOptions(int index) throws RemoteException {
        return new String[] {questions[index][1], questions[index][2], questions[index][3], questions[index][4]};
    }

    @Override
    public String getCorrectAnswer(int index) throws RemoteException {
        return answers[index];
    }

    @Override
    public int getTotalQuestions() throws RemoteException {
        return questions.length;
    }
    
    public class QuizServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            QuizServiceImpl quizService = new QuizServiceImpl();
            QuizService stub = (QuizService) UnicastRemoteObject.exportObject(quizService, 0);

            // Start the RMI registry and bind the remote object
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("QuizService", stub);

            System.out.println("QuizServer is running...");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
}
