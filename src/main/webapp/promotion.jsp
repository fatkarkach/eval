<%@ page import="com.Dao.AdmincDao" %>
<%@ page import="com.model.Stock" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Dao.PromoDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Promotion" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="com.Dao.operationE" %>
<%@ page import="com.Dao.UserDao" %>
<%@ page import="com.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 30/10/2022
  Time: 12:51
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
  if((request.getSession(false).getAttribute("user")== null) )
  {

%>
<jsp:forward page="/index.jsp"></jsp:forward>
<%}%>
<body>
<div class="container mt-5 mb-1">
<%@include file="navadmic.jsp"%>
<%--button--%>
<div class="row">
  <div class="col text-start">
    <button type="button" class="btn btn-info mb-4 mt-4" data-toggle="modal" data-target="#addexampleModal">
      <i class="fa-solid fa-plus" style="color:white"></i>  Ajouter Une Promotion
    </button>
  </div>
  <div class="modal fade" id="addexampleModal" tabindex="-1" role="dialog" aria-labelledby="addexampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addexampleModalLabel">Ajouter une Promotion</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>

        <form  action="PromoServlet" method="post">
          <div class="modal-body">
            <select class="custom-select" name="categorie">
              <option value="multimédia">multimédia</option>
              <option value="Bio&Santé">Bio & Santé</option>
            </select>
            <br>
            <br>
            <%
              AdmincDao dao = new AdmincDao();
              List<Stock> list = dao.getAllStock();
              %>
            <select class="custom-select" name="produit">
              <%
                for(Stock v : list) {
              %>
              <option value="<%=v.getProduit()%>"><%=v.getProduit()%></option>

              <%
                }
              %>
            </select>
            <br>
            <br>
            <input class="form-control" type="number" placeholder="Entrez Promotion" name="promo"> <br>
            <input class="form-control" type="number" placeholder="Entrez nombre de jour" name="dateExpiration">

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">fermer</button>
            <button type="submit" class="btn btn-primary">Ajouter</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%--tableau--%>
  <div class="card-body table-responsive fixTableHead px-0 pt-0">
    <table class="table">
      <thead class="bg-info">
    <tr>
      <th scope="col" class="text-center px-5">Catégorie</th>
      <th class="text-center px-5">Produit</th>
      <th class="text-center px-5">promotion</th>
      <th class="text-center px-5">point-fidilités</th>
      <th class="text-center px-5">Application</th>
      <th class="text-center px-5">date Expiration</th>
    </tr>
    </thead>
   <%
      operationE op = new operationE();
      op.start();
    %>
    <%
      PromoDao promoDao=new PromoDao();
      List<Stock> stocks = promoDao.getAllStockPromo();
      UserDao userDao=new UserDao();
      AdmincDao admincDao=new AdmincDao();
      int id_user=userDao.id;
      Users users=admincDao.getuser(id_user);
      for(Stock stock: stocks){
        for(Promotion promotion: stock.getPromotionsByIdStock()){
          if(promotion.getUsersByIdUsers().equals(users) &&  stock.getUsersByIdUsers().equals(users)){
    %>
      <tbody style=" background-color: aliceblue">
    <tr>
      <td class="text-center" style="background-color: aliceblue"><%=stock.getCategorie()%></td>
      <td class="text-center" style="background-color: aliceblue"><%=stock.getProduit()%></td>
      <td class="text-center" style="background-color: aliceblue"><%=promotion.getPromo()%>%</td>
      <td class="text-center" style="background-color: aliceblue"><%=promotion.getPoints()%>points</td>
      <td class="text-center" style="background-color: aliceblue"><%=promotion.getDisponible()%></td>
      <td class="text-center" style="background-color: aliceblue"><%=promotion.getDateExpiration()%></td>
  </tbody>
    <%
      }
    %>
    <%
      }}
    %>
  </table>
</div>
</div>
</body>
</html>
