package quiz.application;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuizService extends Remote {
    String getQuestion(int index) throws RemoteException;
    String[] getOptions(int index) throws RemoteException;
    String getCorrectAnswer(int index) throws RemoteException;
    int getTotalQuestions() throws RemoteException;
}
