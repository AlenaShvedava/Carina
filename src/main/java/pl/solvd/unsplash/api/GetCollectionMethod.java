package pl.solvd.unsplash.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;

@Endpoint(url = "${base_url}/search/collections", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/collections/_get/rs.schema")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCollectionMethod extends AbstractApiMethodV2 {
    public GetCollectionMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("query", "london");
        addParameter("client_id", getEnvArg("access_token"));
    }
}
