<%@ page import="com.model.Centre" %>
<%@ page import="com.Dao.centreDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Dao.AdminDao" %>
<%@ page import="com.model.Responsable" %>
<%@ page import="com.Dao.PromoDao" %>
<%@ page import="com.model.Stock" %>
<%@ page import="com.model.Promotion" %><%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 13/11/2022
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Promotion</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css.css" type="text/css"/>
    <script src="https://kit.fontawesome.com/5c1b47c11d.js" crossorigin="anonymous"></script>
</head>
<% //In case, if Admin session is not set, redirect to Login page
    if((request.getSession(false).getAttribute("admin")== null) )
    {

%>
<jsp:forward page="/index.jsp"></jsp:forward>
<%}%>
<body>
<div class="container mt-5 mb-1">
    <%@include file="navadmine.jsp"%>
    <div class="row justify-content-center">
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card mt-5">
                <div class="card-content">
                    <div class="card-body bg-info">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <%--<i class="icon-pencil primary font-large-2 float-left"></i>--%>
                                    <i class="fa-solid fa-house-user"></i>
                            </div>
                            <div class="media-body text-right">
                                <%
                                    centreDao dao = new centreDao();
                                    List<Centre> list = dao.getAllcentre();%>
                                <h3><%=list.size()%></h3>
                                <span>Centres</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card mt-5">
                <div class="card-content">
                    <div class="card-body bg-light">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa-solid fa-user-group"></i>
                                <%--<i class="icon-speech warning font-large-2 float-left"></i>--%>
                            </div>
                            <div class="media-body text-right">
                                <%
                                    AdminDao adminDao=new AdminDao();
                                    List<Responsable> listR = adminDao.getAllresp();
                                    %>
                                <h3><%=listR.size()%></h3>
                                <span>Responsable</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card mt-5">
                <div class="card-content">
                    <div class="card-body bg-success">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa-solid fa-tag"></i>
                            <%--    <i class="icon-graph success font-large-2 float-left"></i>--%>
                            </div>
                            <div class="media-body text-right">
                                <%
                                    PromoDao promoDao=new PromoDao();
                                    List<Promotion> listP = promoDao.getAllPromo();

                                %>
                                <h3><%=listP.size()%></h3>
                                <span>Promotions</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
