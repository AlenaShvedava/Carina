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
public class CheckHTTPMethod extends AbstractApiMethodV2 {
    public CheckHTTPMethod() {
        replaceUrlPlaceholder("base_url", getEnvArg("STAG.api_url"));
        addParameter("query", "london");
        addParameter("client_id", getEnvArg("access_token"));
    }
}
