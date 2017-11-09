package ch.bbv.nosyparrot.backend.frameworks.springjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class SurveyJpaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    protected SurveyJpaEntity() {}

    public SurveyJpaEntity(String title) {
        this.title = title;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }
}
