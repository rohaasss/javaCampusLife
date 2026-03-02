public class ExamPreparation extends PlanItem {
    private String subject;

    public ExamPreparation(String title, String subject, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean isUrgent() {
        return !completed && daysUntil <= 5;
    }

    @Override
    public String getCategory() {
        return "ExamPreparation";
    }

    @Override
    public String toString() {
        return super.toString() + " subject='" + subject + "'";
    }
}
