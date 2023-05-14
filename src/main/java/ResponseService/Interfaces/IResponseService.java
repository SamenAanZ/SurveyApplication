package ResponseService.Interfaces;

import java.util.Map;

public interface IResponseService {
    boolean createResponse(String surveyId, Map<String, String> answers);
}
