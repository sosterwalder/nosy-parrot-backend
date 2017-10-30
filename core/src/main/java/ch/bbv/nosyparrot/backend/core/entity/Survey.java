package ch.bbv.nosyparrot.backend.core.entity;


public class Survey {
    private String id;
    private String title;

    public Survey(String id, String name) {
        this.id = id;
        this.title = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
