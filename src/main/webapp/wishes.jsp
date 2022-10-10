<%@ page import="java.util.List" %>
<%@ page import="com.gabit.dev.makeawish.models.Wish" %>
<%@ page import="java.util.LinkedList" %>
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
<body class="bg-dark position-relative" style="height: 100vh; min-height: 100vh; height: fit-content">
    <h1 class="text-light text-center fw-bolder pt-2">Make a wish<span style='font-size:30px;'>&#127776;</span></h1>
    <main class="mx-auto" style="width: 500px">
        <h2 class="text-light fs-3 fw-bolder text-center mt-5">Wishes' list</h2>
        <%
            List<Wish> wishes = (LinkedList<Wish>) session.getAttribute("wishes");
            int totalWishes = wishes.size();
            if (totalWishes > 0) {
                out.println("<div class=\"accordion accordion-flush\" id=\"accordionExample\">");
                for (int card = 1; card <= totalWishes; card++) {
                    out.println("<div class=\"accordion-item\">");
                        out.println("<h2 class=\"accordion-header\" id=\"heading" + card + " \">");
                            out.println("<button class=\"accordion-button collapsed fw-bolder fs-4 bg-light\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapse" + card + "\" aria-expanded=\"false\" aria-controls=\"collapse" + card + "\">");
                            out.println( wishes.get(card - 1).getTitle() + " by " + wishes.get(card - 1).getUsername());
                            out.println("</button>");
                        out.println("</h2>");
                        out.println("<div id=\"collapse" + card + "\" class=\"accordion-collapse collapse bg-info\" aria-labelledby=\"heading" + card + "\" data-bs-parent=\"#accordionExample\">");
                            out.println("<div class=\"accordion-body fst-italic fs-3\">");
                            out.println("<p class=\"text-center mb-0\">" + wishes.get(card - 1).getContent() + "</p>");
                            out.println("<p class=\"text-end text-secondary fs-6 mb-0\"> Score: " + wishes.get(card - 1).getScore() + "</p>");
                            out.println("</div>");
                            out.println("<div class=\"text-center d-flex justify-content-evenly pb-3\">");
                            out.println("<form method=\"get\" action=\"ServletDatabase\">");
                            out.println("<input type=\"hidden\" name=\"operation\" value=\"update\">");
                            out.println("<input type=\"hidden\" name=\"id\" value=" + wishes.get(card - 1).getId() + ">");
                            out.println("<input type=\"submit\" class=\"btn btn-success\" value=\"support &#128077;\">");
                            out.println("</form>");
                            out.println("<form  method=\"get\" action=\"ServletDatabase\">");
                            out.println("<input type=\"hidden\" name=\"operation\" value=\"delete\">");
                            out.println("<input type=\"hidden\" name=\"id\" value=" + wishes.get(card - 1).getId() + ">");
                            out.println("<input type=\"submit\" class=\"btn btn-danger\" value=\"delete &#9995;\">");
                            out.println("</form>");
                            out.println("</div>");
                        out.println("</div>");
                    out.println("</div>");
                }
                out.println("</div>");
            } else {
                out.println("<div class=\"alert alert-info text-center mx-auto my-3 role=\"alert\">");
                out.println("<p class=\"fw-bold py-3 mb-0\">There are no wishes added</p>");
                out.println("</div>");
            }
            out.println("<p class=\"text-center text-light mt-3\">You can <a href=\"index.jsp\" target=\"_self\" rel=\"noopener noreferrer\">Add a wish</a></p>");
        %>
    </main>
    <jsp:include page="copyright.jsp"></jsp:include>
</body>
</html>