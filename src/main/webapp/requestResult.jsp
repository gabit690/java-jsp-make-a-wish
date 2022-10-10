<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@page import="com.gabit.dev.makeawish.models.OperationResult" %>


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
    <main>
        <%
            String colorMessage = null;

            OperationResult operationType = (OperationResult) session.getAttribute("operationType");
            String operationMessage = (String) session.getAttribute("operationMessage");

            switch (operationType) {
                case CREATED:
                    colorMessage = "success";
                    break;
                case UPDATED:
                    colorMessage = "info";
                    break;
                case DELETED:
                    colorMessage = "danger";
                    break;
                default:
                    break;
            }
        %>
        <div class="alert alert-<%= colorMessage %> text-center w-50 mx-auto my-5" role="alert">
            <h4 class="alert-heading">Well done!</h4>
            <p class="mb-0"><%= operationMessage %></p>
        </div>
        <p class="text-center text-light">You can <a href="ServletDatabase" target="_self" rel="noopener noreferrer">go to the wishes' list</a> or <a href="index.jsp" target="_self" rel="noopener noreferrer">add another wish</a></p>
    </main>
    <jsp:include page="copyright.jsp"></jsp:include>
</body>
</html>