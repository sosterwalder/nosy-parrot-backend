package ch.bbv.nosyparrot.backend.core.entity;


public class Survey {
    private long id;
    private String title;
    private User user;

    public Survey(long id, String name) {
        this.id = id;
        this.title = name;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
