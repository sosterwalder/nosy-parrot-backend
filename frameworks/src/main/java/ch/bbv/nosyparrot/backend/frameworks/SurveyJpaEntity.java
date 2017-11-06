package ch.bbv.nosyparrot.backend.frameworks;

import ch.bbv.nosyparrot.backend.frameworks.security.entity.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class SurveyJpaEntity {
    @Id
    private long id;
    private String title;
    @ManyToOne
    private User user;

    protected SurveyJpaEntity() {}

    public SurveyJpaEntity(long id, String title, User user) {
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
