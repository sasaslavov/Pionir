<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${exception ne null}">
    <div class="error">${exception.message}</div>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <form:form method="POST" action="/njt/prijava/add/" modelAttribute="prijava">
            <fieldset>
                <legend>Prijavi se</legend>
                <table>
                    <div class="form-group">
                        <form:label path="takmicenje.takmicenjeId">Takmičenje</form:label>
                        <form:select class="form-control" path="takmicenje.takmicenjeId">                                          
                            <form:options items="${ta}" itemLabel="takmicenjeId" itemValue="takmicenjeId" />
                        </form:select>
                    </div>
                    <tr>
                        <td>Naziv</td>
                        <td>${takmicenje.naziv}</td>
                    </tr>
                    <tr>
                        <td>Datum Održavanja</td>
                        <td>${takmicenje.datumOdrzavanja}</td>
                    </tr>
                    <tr>
                        <td>Rok za prijave</td>
                        <td>${takmicenje.rokZaPrijave}</td>
                    </tr>
                    <tr>
                        <td>Tip</td>
                        <td>${takmicenje.tip}</td>
                    </tr>
                    <tr>
                        <td>Dozvoljen broj prijava</td>
                        <td>${takmicenje.dozvoljenBrojPrijava}</td>
                    </tr>
                    <tr>
                        <td>Broj prijava</td>
                        <td>${takmicenje.brojPrijava}</td>
                    </tr>
                    <tr>
                        <td>Disciplina</td>
                        <td>${takmicenje.disciplina}</td>
                    </tr>
                    <tr>
                        <td>Zemlja</td>
                        <td>${takmicenje.zemlja}</td>
                    </tr>

                    <div class="form-group">
                        <form:label path="plivac.plivacId">Plivac</form:label>
                        <form:select class="form-control" path="plivac.plivacId">                                          
                            <form:options items="${plivac}" itemLabel="plivacId" itemValue="plivacId" />
                        </form:select>
                    </div>



                    <tr><td colspan="2" align="center">
                            <button id="save">Save</button>
                        </td></tr>
                </table>
            </fieldset>
        </form:form>
    </body>
</html>