package ch.bbv.nosyparrot.backend.usecases.core.entity;

import java.util.List;

public interface SurveyEntityGateway {
    List<Survey> findByUser(long userId);
}
