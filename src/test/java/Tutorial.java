public class Tutorial {

    private String title;
    private String description;
    private boolean published;

    public Tutorial(String title, String description, boolean published) {

        this.title = title;
        this.description = description;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublished() {
        return published;
    }
}
