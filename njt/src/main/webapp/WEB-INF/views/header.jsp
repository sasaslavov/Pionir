<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
        body{
            background-color: lightblue;
            text-align: center;
            font: message-box;
            margin: auto;
        }
        .list-group-item {
            background-color: lightblue;
            border-color: black;
        }
</style>
<div class="col-sm-12">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid" style="background-color: black">
            <div class="navbar-header">
                <a class="navbar-brand" href="/njt/">Plivačka-takmičenja</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="/njt/plivac/all" class="glyphicon glyphicon-user"> Plivači </a></li>                
                    <li><a href="/njt/takmicenje/all" class="glyphicon glyphicon-asterisk"> Takmičenja </a></li>
                    <li><a href="/njt/prijava/all" class="glyphicon glyphicon-pencil"> Prijave </a></li>
                    <li><a href="/njt/rezultati/all" class="glyphicon glyphicon-apple"> Rezultati </a></li>
                    <li><a href="/njt/prijava/mojePrijave" class="glyphicon glyphicon-user"> Moje Prijave</a></li>
                    <li><a href="/njt/rezultati/mojiRezultati" class="glyphicon glyphicon-baby-formula"> Moji Rezultati </a></li>
                    <li><a  class="glyphicon glyphicon-log-out" onclick="document.forms['logoutForm'].submit()">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>