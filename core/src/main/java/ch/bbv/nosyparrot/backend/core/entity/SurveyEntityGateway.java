package ch.bbv.nosyparrot.backend.core.entity;

import java.util.List;

public interface SurveyEntityGateway {
    List<Survey> getAll();
    List<Survey> create(String title);
}
