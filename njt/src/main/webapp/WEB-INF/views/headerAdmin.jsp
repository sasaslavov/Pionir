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
        <div class="container-fluid" style="background-color: black;">
            <div class="navbar-header">
                <a class="navbar-brand" href="/njt/admin/">Plivačka-takmičenja</a>
            </div>
            <div class="navbar-collapse collapse" >
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="/njt/admin/plivaciAll" class="glyphicon glyphicon-user"> Plivači </a></li>                
                    <li><a href="/njt/admin/takmicenjeAll" class="glyphicon glyphicon-asterisk"> Takmičenja </a></li>
                    <li><a href="/njt/admin/prijavaAll" class="glyphicon glyphicon-pencil"> Prijave </a></li>
                    <li><a href="/njt/admin/rezultatAll" class="glyphicon glyphicon-baby-formula"> Rezultati </a></li>
                    <li><a href="/njt/admin/registration" class="glyphicon glyphicon-registration-mark"> Register </a></li>
                    <li><a onclick="document.forms['logoutForm'].submit()" class="glyphicon glyphicon-log-out">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>