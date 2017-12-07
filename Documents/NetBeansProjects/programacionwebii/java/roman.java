
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;

public class roman {

    private static String USER = "admin";
    private static String PASS = "1234";

    public static void main(String[] args) {
        staticFiles.location("/templates");
        get("/inicio", (req, res)
                -> {
            Map<String, Object> map = new HashMap<>();
            //map.put("pageTitle", "Timeline");
            return new ModelAndView(map, "templates/index.html");

        }, new VelocityTemplateEngine());

        get("/login", (req, res)
                -> {

            Map<String, Object> map = new HashMap<>();
            //map.put("pageTitle", "Timeline");

            return new ModelAndView(map, "templates/login.html");
        }, new VelocityTemplateEngine());

        get("/check/login", (request, response)
                -> {
            String user = request.queryParams("user");
            String pass = request.queryParams("pass");
            if (user.equals(USER) && pass.equals(PASS)) {
                // salvo el cookie de session
                return "1";
            } else {
                return "0";
            }
        });

    }
}
