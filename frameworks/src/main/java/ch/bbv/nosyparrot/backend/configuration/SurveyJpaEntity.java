package ch.bbv.nosyparrot.backend.configuration;

import ch.bbv.nosyparrot.backend.configuration.security.entity.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class SurveyJpaEntity {
    @Id
    private String id;
    private String title;
    @ManyToOne
    private User user;

    protected SurveyJpaEntity() {}

    public SurveyJpaEntity(String id, String title, User user) {
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
