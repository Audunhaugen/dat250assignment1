package dat250exp1;

import io.javalin.Javalin;

public class App {

    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    private static final double INCH_TO_METER = 0.0254;
    private static final double FOOT_TO_METER = 0.3048;
    private static final double MILE_TO_METER = 1609.344;

    public static void main(String[] args) {
        startWebServer();
    }

    /**
     * Starts the Javalin web server and defines routes.
     */
    public static void startWebServer() {
        Javalin app = Javalin.create().start(9000);
        defineRoutes(app);
    }

    /**
     * Defines the web application routes.
     *
     * @param app The Javalin application instance.
     */
    public static void defineRoutes(Javalin app) {
        app.get("/", ctx -> {
            ctx.html(WEBPAGE);
        });

        app.post("/convert", ctx -> {
            double value = Double.parseDouble(ctx.formParam("value"));
            String fromUnit = ctx.formParam("sunit");
            String toUnit = ctx.formParam("tunit");
            double result = convertUnits(value, fromUnit, toUnit);
            ctx.result(Double.toString(result));
        });
    }

    /**
     * Converts units from one unit to another.
     *
     * @param value    The value to convert.
     * @param fromUnit The source unit.
     * @param toUnit   The target unit.
     * @return The converted value.
     */
    public static double convertUnits(double value, String fromUnit, String toUnit) {
        double inMeters = value;
        if (fromUnit.equals("in")) {
            inMeters *= INCH_TO_METER;
        } else if (fromUnit.equals("ft")) {
            inMeters *= FOOT_TO_METER;
        } else if (fromUnit.equals("mi")) {
            inMeters *= MILE_TO_METER;
        }

        double result = inMeters;
        if (toUnit.equals("in")) {
            result /= INCH_TO_METER;
        } else if (toUnit.equals("ft")) {
            result /= FOOT_TO_METER;
        } else if (toUnit.equals("mi")) {
            result /= MILE_TO_METER;
        }
        return result;
    }
}
