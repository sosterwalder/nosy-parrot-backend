package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class SurveyJpaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
