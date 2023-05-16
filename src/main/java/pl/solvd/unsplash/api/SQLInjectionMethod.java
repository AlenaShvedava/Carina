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
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class SQLInjectionMethod extends AbstractApiMethodV2 {
    public SQLInjectionMethod() {
        replaceUrlPlaceholder("base_url", getEnvArg("api_url"));
        addParameter("client_id", getEnvArg("access_token"));
        addParameter("<img src","x onerror=\"&#x61;lert(1)\">");
        addParameter("query", "london");
    }
}
