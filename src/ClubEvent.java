public class ClubEvent extends PlanItem {
    private String location;

    public ClubEvent(String title, String location, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean isUrgent() {
        return !completed && daysUntil <= 1;
    }

    @Override
    public String getCategory() {
        return "ClubEvent";
    }

    @Override
    public String toString() {
        return super.toString() + " location='" + location + "'";
    }
}