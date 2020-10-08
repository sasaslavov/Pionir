<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" type="text/css" href="/njt/resources/styles/index2.css">-->
        <title>JSP view all Rezultati!</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br>
        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
            <form:form method="post" action="/njt/admin/addR/${takmicenje.takmicenjeId}" modelAttribute="rezultatForma">
                <table class="table table-condensed table-align" id="myTable">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Id Plivača</th>
                            <th>Ime</th>
                            <th>Prezime</th>
                            <th>Prvi rezultat</th>
                            <th>Drugi rezultat</th>
                            <th>Pozicija</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${rezultatForma.rezultati}" var="rezultat" varStatus="status"> 
                            <tr>
                                <td align="center">${status.count} </td>
                                <td><input name="rezultati[${status.index}].plivac.plivacId" value="${rezultat.plivac.plivacId}" disabled/> </td>
                                <td><input name="rezultati[${status.index}].plivac.imePlivaca" value="${rezultat.plivac.imePlivaca}" disabled/> </td>
                                <td><input name="rezultati[${status.index}].plivac.prezimePlivaca" value="${rezultat.plivac.prezimePlivaca}" disabled/> </td>
                                <td><input name="rezultati[${status.index}].prviRezultat" value="${rezultat.prviRezultat}" /></td>
                                <td><input name="rezultati[${status.index}].drugiRezultat" value="${rezultat.drugiRezultat}" /></td>
                                <td><input name="rezultati[${status.index}].pozicija" value="${rezultat.pozicija}" /></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <input type="submit" value="Save"/>
        </form:form>
    </body>
</html>
