package cn.brickie;

import cn.brickie.config.IntgTestBase;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@DatabaseSetup(value = "classpath:/integration/person.yml")
@DatabaseTearDown
public class PersonControllerTest extends IntgTestBase {

    @Test
    public void person_all_query() {
        given().get("/person")
                .then()
                .log()
                .all()
                .statusCode(SC_OK)
                .body("$",hasSize(5))
                .body("[0].name", equalTo("小明"));
    }
}
