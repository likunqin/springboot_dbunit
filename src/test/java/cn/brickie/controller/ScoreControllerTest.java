package cn.brickie.controller;

import cn.brickie.config.IntgTestBase;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = {
        "classpath:/integration/course.yml",
        "classpath:/integration/score.yml",
        "classpath:/integration/student.yml"
})
@DatabaseTearDown(type = DatabaseOperation.DELETE, value = {
        "classpath:/integration/course.yml",
        "classpath:/integration/score.yml",
        "classpath:/integration/student.yml"
})
public class ScoreControllerTest extends IntgTestBase {

    @Test
    public void person_all_query() {
        given().get("/score")
                .then()
                .log()
                .all()
                .statusCode(SC_OK)
                .body("$", hasSize(12))
                .body("[0].student.name", equalTo("小红"))
                .body("[0].course.name", equalTo("语文"))
                .body("[0].score", equalTo(68.0F));
    }
}
