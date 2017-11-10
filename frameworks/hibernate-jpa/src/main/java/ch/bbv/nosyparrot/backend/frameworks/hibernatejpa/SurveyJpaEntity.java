package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class SurveyJpaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
