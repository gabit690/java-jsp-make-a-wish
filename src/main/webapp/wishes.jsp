<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <title>JSP - Web application</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</head>
<body class="bg-dark position-relative" style="height: 100vh">
    <h1 class="text-light text-center fw-bolder pt-2">Make a wish<span style='font-size:30px;'>&#127776;</span></h1>
    <main class="mx-auto" style="width: 500px">
        <h2 class="text-light fs-3 fw-bolder text-center mt-5">Wishes' list</h2>
        <%

            boolean show = true;

            if (show) {
                String[] numbers = {"0", "1", "2", "3", "4", "5"};
                out.println("<div class=\"accordion accordion-flush\" id=\"accordionExample\">");
                for (int card = 1; card <= numbers.length; card++) {
                    out.println("<div class=\"accordion-item\">");
                    out.println("<h2 class=\"accordion-header\" id=\"heading" + card + " \">");
                    out.println("<button class=\"accordion-button collapsed fw-bolder fs-4 bg-light\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapse" + card + "\" aria-expanded=\"false\" aria-controls=\"collapse" + card + "\">");
                    out.println(card);
                    out.println("</button>");
                    out.println("</h2>");
                    out.println("<div id=\"collapse" + card + "\" class=\"accordion-collapse collapse\" aria-labelledby=\"heading" + card + "\" data-bs-parent=\"#accordionExample\">");
                    out.println("<div class=\"accordion-body text-center\">");
                    out.println(card);
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                }
                out.println("</div>");
            } else {
                out.println("<div class=\"alert alert-info text-center mx-auto my-3 role=\"alert\">");
                out.println("<p>There are no wishes added</p>");
                out.println("<p class=\"text-center \">You can <a href=\"index.jsp\" target=\"_self\" rel=\"noopener noreferrer\">add a wish</a></p>");
                out.println("</div>");
            }



        %>
    </main>
    <jsp:include page="copyright.jsp"></jsp:include>
</body>
</html>