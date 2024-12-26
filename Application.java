import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String question;
    private String[] options;
    private int correct_option;

    public Question(String question, String[] options, int correct_option) {
        this.question = question;
        this.options = options;
        this.correct_option = correct_option;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correct_option;
    }

}

public class Application {
    private ArrayList<Question> questions;
    private boolean timeover;

    public Application() {
        questions = new ArrayList<>();
    }

    private void loadQuestions(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String question = parts[0];
                String options[] = { parts[1], parts[2], parts[3], parts[4] };
                int correct_option = Integer.parseInt(parts[5]) - 1;

                questions.add(new Question(question, options, correct_option));

            }
        } catch (Exception e) {
            System.out.println("Error loading question");
        }
    }

    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No queestion is available");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("******Welcome to quiz******");
        System.out.println("---------------------------");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + " : " + q.getQuestion());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            timeover = false;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    timeover = true;
                    System.out.println("\n**  WARNING!! Time over, Next question will be displayed  **");
                }
            }, 30_000);

            int userAnswer = -1;
            if (!timeover) {
                try {
                    System.out.print("Enter your answer (1-4): ");
                    userAnswer = sc.nextInt() - 1;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    sc.next();
                }
            }

            timer.cancel();

            if (!timeover && userAnswer == q.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options[q.getCorrectOption()]);
            }
            System.out.println();
        }

        System.out.println("Quiz Over! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Application quiz = new Application();
        quiz.loadQuestions("Quizz.csv");
        quiz.startQuiz();
    }
}
