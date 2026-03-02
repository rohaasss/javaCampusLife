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

        //new home assignment


        ArrayList<PlanItem> planItems = new ArrayList<>();
        planItems.add(new Assignment("Lab 10: REST API", "Backend", 2, 4));
        planItems.add(new Assignment("Homework 5: Loops", "Python", 5, 3));
        planItems.add(new ExamPreparation("Final Exam", "German", 3, 8));
        planItems.add(new ExamPreparation("Midterm", "Backend", 1, 6));
        planItems.add(new ClubEvent("Hackathon", "Room 205", 2, 10));
        planItems.add(new ClubEvent("German Film Club", "Konya hall", 4, 2));

        System.out.println();
        System.out.println("NEW VERSION-PlanItem Hierarchy");
        System.out.println();
        System.out.println("ALL PLAN ITEMS");
        for (PlanItem item : planItems) {
            System.out.println(item);
        }
        System.out.println();

        System.out.println("URGENT ITEMS");
        for (PlanItem item : planItems) {
            if (item.isUrgent()) {
                System.out.println(item.getCategory() + ": " + item.getTitle() + " (URGENT!)");
            }
        }
        System.out.println();

        int remaining = 0;
        for (PlanItem item : planItems) {
            if (!item.isCompleted()) {
                remaining += item.getEstimatedHours();
            }
        }
        System.out.println("Total remaining hours: " + remaining);
        System.out.println();

        PlanItem mostUrgent = null;
        int min = Integer.MAX_VALUE;
        for (PlanItem item : planItems) {
            if (!item.isCompleted() && item.getDaysUntil() < min) {
                min = item.getDaysUntil();
                mostUrgent = item;
            }
        }
        if (mostUrgent != null) {
            System.out.println("Most urgent: " + mostUrgent.getTitle() + " (" + mostUrgent.getCategory() + ") in " + min + " days");
        }
        System.out.println();

        System.out.println("MARKING FIRST PLAN ITEM AS COMPLETED");
        PlanItem first = planItems.get(0);
        System.out.println("BEFORE: " + first);
        first.markCompleted();
        System.out.println("AFTER: " + first);
        System.out.println("Urgent now? " + first.isUrgent());
    }

}