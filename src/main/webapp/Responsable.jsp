<%@ page import="com.Dao.PromoDao" %>
<%@ page import="com.model.Stock" %>
<%@ page import="com.model.Promotion" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Dao.UserDao" %>
<%@ page import="com.Dao.AdmincDao" %>
<%@ page import="com.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 31/10/2022
  Time: 15:40
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
    if((request.getSession(false).getAttribute("responsable")== null) )
    {

%>
<jsp:forward page="/index.jsp"></jsp:forward>
<%}%>
<body>
<div class="container mt-5 mb-1">
    <%@include file="navresp.jsp"%>
        <div class="card-body table-responsive fixTableHead px-0 pt-0">
            <table class="table">
                <thead class="bg-info">
        <tr>
            <th scope="col" class="text-center px-5">Catégorie</th>
            <th class="text-center px-5">Produit</th>
            <th class="text-center px-5">promotion</th>
            <th class="text-center px-5">Application</th>
        </tr>
        </thead>
        <tbody>
        <tbody>
        <%
            PromoDao promoDao=new PromoDao();
            List<Stock> stocks = promoDao.getAllStockPromo();
            UserDao userDao=new UserDao();
            int id_ur=userDao.id_ur;
            AdmincDao admincDao=new AdmincDao();
            Users users=admincDao.getuser(id_ur);
            for(Stock stock: stocks){
                for(Promotion promotion: stock.getPromotionsByIdStock()){
                    if(promotion.getDisponible().equals("Non") && promotion.getUsersByIdUsers().equals(users) &&  stock.getUsersByIdUsers().equals(users)){
        %>

        <tr>
            <td><%=stock.getCategorie()%></td>
            <td><%=stock.getProduit()%></td>
            <td><%=promotion.getPromo()%></td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#exampleModal<%=promotion.getIdPromo()%>">
                    Vérification
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal<%=promotion.getIdPromo()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header text-center">
                                <h5 class="modal-title"  id="exampleModalLabel">Vérification</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form method="post" action="VerController">
                            <div class="modal-body">
                                <h5 class="text-danger">Quantité de produit : <%=stock.getQuantites()%></h5>
                                <input type="hidden" value="<%=stock.getProduit()%>" name="produit">
                                <br>
                                    <div class="input-group mb-3">
                                        <select class="custom-select" id="inputGroupSelect02" name="disponible">
                                            <option selected>Appliquer la promotion</option>
                                            <option value="1">Oui</option>
                                            <option value="2">Non</option>
                                        </select>
                                        <input type="hidden" value="<%=promotion.getPromo()%>" name="promo">
                                        <input type="hidden" value="<%=promotion.getPoints()%>" name="points">
                                        <input type="hidden" value="<%=promotion.getDateExpiration()%>" name="date">

                                    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
                                <input type="hidden" name="idpromo" value="<%=promotion.getIdPromo()%>">
                                <button type="submit" class="btn btn-primary">Appliquer</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </td>
        </tbody>
        <%
            }}
        %>
        <%
            }
        %>
    </table>
</div>
</div>
</body>
</html>
