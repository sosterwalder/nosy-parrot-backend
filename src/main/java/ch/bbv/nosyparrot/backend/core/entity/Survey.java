package ch.bbv.nosyparrot.backend.core.entity;


public class Survey {
    private String title;

    public Survey(String name) {
        this.title = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
