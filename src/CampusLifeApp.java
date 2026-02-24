import java.util.ArrayList;

public class CampusLifeApp {
    public static void main(String[] args) {
        System.out.println("CREATING COURSES");
        Course backend = new Course("Backend", "mr.Talgat", 6);
        Course python = new Course("Python", "ms.Zhibek", 4);
        Course german = new Course("German", "ms.Erika", 3);

        System.out.println(backend);
        System.out.println(python);
        System.out.println(german);
        System.out.println();


        System.out.println("CREATING TASKS");
        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Connecting to Database", backend, 3, 2));
        tasks.add(new AssignmentTask("Working with numPy", python, 4, 1));
        tasks.add(new AssignmentTask("Topic 5: Family", german, 2, 0));
        tasks.add(new AssignmentTask("SciPy", python, 5, 4));
        tasks.add(new AssignmentTask("Essay", german, 3, 6));

        for (AssignmentTask task : tasks) {
            System.out.println(task);
        }
        System.out.println();


        System.out.println("CREATING STUDY SESSIONS");
        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(german, 90));
        sessions.add(new StudySession(python, 120));
        sessions.add(new StudySession(backend, 150));
        sessions.add(new StudySession(python, 45));
        sessions.add(new StudySession(german, 60));

        for (StudySession session : sessions) {
            System.out.println(session);
        }
        System.out.println();


        System.out.println("ALL TASKS");
        for (AssignmentTask task : tasks) {
            System.out.print(task);
            if (task.isUrgent()) {
                System.out.print("URGENT");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("COUNTING HOURS THAT LEFT");
        int totalHoursLeft = 0;
        for (AssignmentTask task : tasks) {
            if (!task.isCompleted()) {  // если задание не выполнено
                totalHoursLeft += task.getEstimatedHours();
            }
        }
        System.out.println("TOTAL HOURS: " + totalHoursLeft);
        System.out.println();

        System.out.println("TOTAL TIME ON EVERY COURSE");
        Course[] allCourses = {backend, python, german};

        for (Course course : allCourses) {
            double totalHours = 0;
            for (StudySession session : sessions) {
                if (session.getCourse() == course) {
                    totalHours += session.hours();
                }
            }
            System.out.println(course.getName() + ": " + totalHours + " hours");
        }
        System.out.println();


        System.out.println("DEMONSTRATING STATE CHANGE");
        System.out.println("Marking first task as completed");

        AssignmentTask firstTask = tasks.get(0);
        System.out.println("BEFORE: " + firstTask);
        firstTask.markCompleted();
        System.out.println("AFTER: " + firstTask);
        System.out.println("Urgent? " + (firstTask.isUrgent() ? "Yes" : "No"));
        System.out.println();

        totalHoursLeft = 0;
        for (AssignmentTask task : tasks) {
            if (!task.isCompleted()) {
                totalHoursLeft += task.getEstimatedHours();
            }
        }
        System.out.println("Remaining hours after completing task: " + totalHoursLeft);
        System.out.println();

        System.out.println("FINAL STATISTICS");
        System.out.println("Total tasks: " + tasks.size());

        int completed = 0;
        int urgent = 0;
        for (AssignmentTask task : tasks) {
            if (task.isCompleted()) completed++;
            if (task.isUrgent()) urgent++;
        }
        System.out.println("Completed: " + completed);
        System.out.println("Urgent remaining: " + urgent);

    }
}