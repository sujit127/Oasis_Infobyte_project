import java.util.*;

class OnlineExamination {

    static Scanner sc = new Scanner(System.in);

    static String username = "admin";
    static String password = "1234";

    static String name = "Student";
    static int score = 0;

    public static void main(String[] args) {

        if (login()) {
            int choice;
            do {
                System.out.println("\n===== ONLINE EXAMINATION SYSTEM =====");
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        updatePassword();
                        break;
                    case 3:
                        startExam();
                        break;
                    case 4:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 4);
        }
    }

    // Login Function
    static boolean login() {
        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }

    // Update Profile
    static void updateProfile() {
        System.out.print("Enter new name: ");
        name = sc.next();
        System.out.println("Profile Updated Successfully!");
    }

    // Update Password
    static void updatePassword() {
        System.out.print("Enter old password: ");
        String oldPass = sc.next();

        if (oldPass.equals(password)) {
            System.out.print("Enter new password: ");
            password = sc.next();
            System.out.println("Password Updated Successfully!");
        } else {
            System.out.println("Wrong old password!");
        }
    }

    // Start Exam
    static void startExam() {
        score = 0;

        System.out.println("\n===== EXAM STARTED =====");
        System.out.println("You have 30 seconds to complete the exam.\n");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Auto submitting...");
                showResult();
                System.exit(0);
            }
        }, 30000); // 30 seconds

        String[] questions = {
                "1. Java is a _?",
                "2. Which keyword is used to inherit a class?",
                "3. Which method is entry point of Java?"
        };

        String[][] options = {
                {"1) Language", "2) OS", "3) Browser", "4) Device"},
                {"1) this", "2) super", "3) extends", "4) implements"},
                {"1) start()", "2) main()", "3) run()", "4) init()"}
        };

        int[] answers = {1, 3, 2};

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }
            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (ans == answers[i]) {
                score++;
            }
        }

        timer.cancel();
        showResult();
    }

    // Show Result
    static void showResult() {
        System.out.println("\n===== RESULT =====");
        System.out.println("Candidate: " + name);
        System.out.println("Score: " + score + "/3");
    }

    // Logout
    static void logout() {
        System.out.println("Logged out successfully!");
        System.out.println("Session Closed.");
    }
}