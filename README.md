# Quiz_Application-using-Java
**Problem Description**

  This project is a Java-based quiz application that allows users to answer multiple-choice questions with a time limit for each question. The questions are loaded from an external CSV file, making the quiz customizable. Each question has four options, and users must select the correct one within 30 seconds. If the user fails to respond in the given time, the program automatically moves to the next question and displays a "Time over!" message. At the end of the quiz, the user's score is displayed.

**Imported Modules**
1. java.io.BufferedReader: For reading the CSV file containing questions.
2. java.io.FileReader: For accessing the external file.
3. java.util.ArrayList: For storing the list of questions in memory.
4. java.util.Scanner: For user input.
5. java.util.Timer: For managing the 30-second countdown for each question.
6. java.util.TimerTask: For defining the task to execute when the timer expires.

**Input type**
1. Question file: A CSV file containing questions and their options in the following format "Question,Option1,Option2,Option3,Option4,CorrectOptionIndex"
2. User Input: An integer value (1 to 4) to select the correct option.

**Output type**
1. Displays the question, options, and a prompt for the user to enter their choice.
2. Shows the result ("Correct!" or "Wrong!") for each question.
3. Displays a "Time over!" message if the user fails to respond within 30 seconds.
4. Outputs the final score at the end of the quiz.

**Constraints**
1. Time Limit: Each question must be answered within 30 seconds. If the user fails to answer, the program skips to the next question.
2. Input Validation: Only integers between 1 and 4 are accepted as valid inputs. Invalid inputs are handled gracefully.
3. File Format: The questions file must follow the specified CSV format for proper loading of questions.
4. No Skipping Questions: The user cannot skip a question except when the timer expires.
Question Count:
5. At least one question must be provided in the CSV file for the quiz to run.

**Features of the project**

1. Timer Functionality: Automatically enforces a 30-second time limit for each question.
Displays "Time over!" and moves to the next question if the user fails to respond.
2. Dynamic Question Loading: Questions and answers are loaded dynamically from a CSV file, allowing easy customization.
3. Error Handling: Handles invalid user inputs and file-loading errors.
4. Interactive Feedback: Provides feedback after each question (correct or wrong) and displays the correct answer if the user is incorrect.
5. Final Scoring: Calculates and displays the total score at the end of the quiz.
