
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;

public class roman {
   private static String USER = "admin";
    private static String PASS = "1234";

    public static void main(String[] args) {
        try {
 if (DataCreator.readData(Constants.DATA_FILE, Item.class).size() == 0) {
                List<Item> itemList = new ArrayList<>();
                itemList.add(new Item("ps4 slim", 100, 199));
                itemList.add(new Item("nintendo switch", 20, 279));
                itemList.add(new Item("xbox one s", 63, 189));
                itemList.add(new Item("cintas switch", 100, 59));
                itemList.add(new Item("cintas ps4", 20, 39));
                itemList.add(new Item("cintas de xbox one", 63, 40));
                itemList.add(new Item("joycons de nintendo switch", 63, 70));
                itemList.add(new Item("xbox one s", 100, 59));
                itemList.add(new Item("dualshock 4", 20, 59));
                itemList.add(new Item("nitendo switch pro controllers", 63, 79));
                DataCreator.saveDataToFile(Constants.DATA_FILE, itemList);
            }
 } catch (Exception ignored) {
            System.out.println("No pude escribir mi archivo de data");
        }

        staticFiles.location("/templates");
        get("/inicio", (req, res)
                -> {
          
           Map<String, Object> map = new HashMap<>();
        map.put("items", DataCreator.readData(Constants.DATA_FILE, Item.class));
             if (req.cookie("admin") == null ) {
            
                 res.redirect("/login");
            }

           
            map.put("pageTitle", "Timeline");
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
              response.cookie("/", "admin","1234", 3600, false, true);

                return "1";
            } else {
                return "0";
            }
        });

    }
}
