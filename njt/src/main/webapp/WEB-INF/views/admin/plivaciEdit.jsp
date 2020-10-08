<%--
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "/resources/js/bootstrap.js" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"  crossorigin="anonymous">

        <script   src="https://code.jquery.com/jquery-3.2.1.min.js"     crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
      $( function() {
      $( "#datumRodjenja" ).datepicker();
      } ); 
      </script>
        
        <!--<link rel="stylesheet" type="text/css" href="../../resources/styles/index2.css">-->
        <title>Plivač</title>
    </head>
    <body>
        <%@include file = "../headerAdmin.jsp" %>
        <br><br><br><br><br><br>

        <div class="col-6 col-md-1"></div>
        <div class="col-6 col-md-10">
            <div class="list-group" align="center">
                <div class="list-group-item">
                    <b><font size="4"><a href="/njt/admin/plivaciAll">Plivač</a> / Unos </font></b>
                </div>
            </div>
            <br><br>
            <script>
                function validateForm() {
                    var x = document.getElementById("imePlivaca").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Ime plivaca morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("prezimePlivaca").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Prezime plivaca morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("datumRodjenja").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Datum rodjenja morate da popunite");
                        return false;
                    }
                    var x = document.getElementById("brojLicence").value;
                    console.log(x);
                    if (x == "" || x == null) {
                        alert("Broj licence morate da popunite");
                        return false;
                    }
                }
            </script>
            <div class="container-fluid">
                <form:form action="/njt/admin/editS/${plivac.plivacId}" onsubmit="return validateForm()" method="post" modelAttribute="plivac">
                    <div class="form-group">
                        <form:label path="plivacId">ID</form:label>
                        <form:input path="plivacId" class="form-control" id="takmicenjeId" disabled="true" />
                    </div>
                    <div class="form-group">
                        <form:label path="imePlivaca">Ime plivača</form:label>
                        <form:input path="imePlivaca" class="form-control" id="imePlivaca" />
                    </div>  
                    <div class="form-group">
                        <form:label path="prezimePlivaca">Prezime plivača</form:label>
                        <form:input path="prezimePlivaca" class="form-control" id="prezimePlivaca" />
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="datumRodjenja">Datum Rođenja</form:label>
                        <fmt:formatDate value="${plivac.datumRodjenja}" var="formattedDate" type="date" pattern="yyyy/MM/dd" />                                           
                        <form:input path="datumRodjenja" class="form-control" id="datumRodjenja" value="${formattedDate}"/>
                    </div>  
                    <div class="form-group">
                        <form:label path="brojLicence">Broj licence</form:label>
                        <form:input path="brojLicence" class="form-control" id="brojLicence" />
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="status">Status</form:label>
                        <form:select class="form-control" path="status">                                          
                            <form:options items="${status}" itemLabel="naziv" itemValue="naziv" />
                        </form:select>
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="zemlja.zemljaId">Zemlja</form:label>
                        <form:select class="form-control" path="zemlja.zemljaId">                                          
                            <form:options items="${zemlja}" itemLabel="naziv" itemValue="zemljaId" />
                        </form:select>
                    </div>
                    <br>
                    <div class="form-group">
                        <form:label path="pol">Pol</form:label>
                        <form:select class="form-control" path="pol">                                          
                            <form:options items="${pol}" itemLabel="naziv" itemValue="naziv" />
                        </form:select>
                    </div>

                    <div class='text-right'>
                        <button type="submit" class="btn btn-dark"><span class="fa fa-fw fa-check-square"></span></button>
                        <a href="/njt/admin/plivaciAll" class="btn btn-dark"><span class="fa fa-fw fa-remove"></span></a>
                    </div>

                </form:form>
            </div>         
        </div>
        <div class="col-6 col-md-1"></div>
    </body> 
</html>
