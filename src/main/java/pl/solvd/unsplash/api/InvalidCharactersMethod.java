package pl.solvd.unsplash.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;

@Endpoint(url = "${base_url}/search/photos", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/rs.schema")
@SuccessfulHttpStatus(status = HttpResponseStatusType.BAD_REQUEST_400)
public class InvalidCharactersMethod extends AbstractApiMethodV2 {
    public InvalidCharactersMethod() {
        replaceUrlPlaceholder("base_url", getEnvArg("api_url"));
        addParameter("query", "O0=#<scr>'--");
        addParameter("client_id", getEnvArg("access_token"));
    }
}
