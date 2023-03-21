package pl.solvd.unsplash.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.PathParam;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.apache.commons.digester.annotations.rules.SetProperty;

import javax.ws.rs.QueryParam;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;

@Endpoint(url = "${base_url}/collections/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/collections/_getById/rs.schema")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCollectionByIdMethod extends AbstractApiMethodV2 {
    public GetCollectionByIdMethod() {
        replaceUrlPlaceholder("base_url", getEnvArg("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(5));
        addParameter("query", "london");
        addParameter("client_id", getEnvArg("access_token"));
    }
}
