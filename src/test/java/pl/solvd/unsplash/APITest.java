package pl.solvd.unsplash;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.zebrunner.carina.utils.R;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.remote.Response;
import org.testng.Assert;
import pl.solvd.unsplash.api.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import java.io.InputStream;

public class APITest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C1", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/1")
    public void testGetPhotos() {
        GetPhotoMethod getPhotoMethod = new GetPhotoMethod();
        getPhotoMethod.callAPIExpectSuccess();
        getPhotoMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C2", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/2")
    public void testGetCollection() {
        GetCollectionMethod getCollectionMethod = new GetCollectionMethod();
        getCollectionMethod.callAPIExpectSuccess();
        getCollectionMethod.validateResponseAgainstSchema("api/collections/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C3", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/3")
    public void testGetCollectionById() {
        GetCollectionByIdMethod getCollectionByIdMethod = new GetCollectionByIdMethod();
        getCollectionByIdMethod.callAPIExpectSuccess();
        getCollectionByIdMethod.validateResponseAgainstSchema("api/collections/_getById/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C4", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/4")
    public void testGetPhotosFromCollection() {
        GetPhotosFromCollectionMethod getPhotosFromCollectionMethod = new GetPhotosFromCollectionMethod();
        getPhotosFromCollectionMethod.callAPIExpectSuccess();
        getPhotosFromCollectionMethod.validateResponseAgainstSchema("api/photos/_getFromCollection/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C5", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/5")
    public void testHTTP() {
        CheckHTTPMethod checkHTTPMethod = new CheckHTTPMethod();
        checkHTTPMethod.callAPIExpectSuccess();
        checkHTTPMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C37", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/37")
    public void testInvalidCharactersMethod() {
        InvalidCharactersMethod invalidCharactersMethod = new InvalidCharactersMethod();
        invalidCharactersMethod.callAPIExpectSuccess();
        invalidCharactersMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C38",locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/38")
    public void testSQLInjection() {
        SQLInjectionMethod sqlInjectionMethod = new SQLInjectionMethod();
        sqlInjectionMethod.callAPIExpectSuccess();
        sqlInjectionMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C13", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/13")
    public void testPerPageUpperLimit() {
        GetPerPageUpperLimitMethod getPerPageUpperLimitMethod = new GetPerPageUpperLimitMethod();
        getPerPageUpperLimitMethod.callAPIExpectSuccess();
        getPerPageUpperLimitMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C15", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/15")
    public void testPageUpperLimit() {
        GetPageUpperLimitMethod getPageUpperLimitMethod = new GetPageUpperLimitMethod();
        getPageUpperLimitMethod.callAPIExpectSuccess();
        getPageUpperLimitMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestRailCases(testCasesId = "C9", locale = "https://shvedavaalena.testrail.io/index.php?/cases/view/9")
    public void testCyrillicQuery() {
        GetPhotosByCyrillicQueryMethod getPhotosByCyrillicQueryMethod = new GetPhotosByCyrillicQueryMethod();
        getPhotosByCyrillicQueryMethod.callAPIExpectSuccess();
        getPhotosByCyrillicQueryMethod.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }
}
