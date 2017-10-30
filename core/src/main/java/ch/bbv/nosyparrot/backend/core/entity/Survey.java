package ch.bbv.nosyparrot.backend.core.entity;


public class Survey {
    private String id;
    private String title;
    private User user;

    public Survey(String id, String name, User user) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
