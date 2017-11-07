package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class SurveyJpaEntity {
    @Id
    private long id;
    private String title;

    protected SurveyJpaEntity() {}

    public SurveyJpaEntity(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
