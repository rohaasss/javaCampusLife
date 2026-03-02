public class Assignment extends PlanItem {
    private String courseName;

    public Assignment(String title, String courseName, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean isUrgent() {
        return !completed && daysUntil <= 2;
    }

    @Override
    public String getCategory() {
        return "Assignment";
    }

    @Override
    public String toString() {
        return super.toString() + " course='" + courseName + "'";
    }
}
