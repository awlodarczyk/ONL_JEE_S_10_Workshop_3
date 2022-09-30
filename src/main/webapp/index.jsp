<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 15/06/2021
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/fragment/header.jsp" %>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Utwórz użytkownika</h1>
</div>
<div class="row">
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div class="row">
                    <form action="<c:url value="/user/mock"/>" method="post">
                        <button class="d-none d-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-database fa-sm text-white-50"></i> Utworz tabele i użytkowników</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <a href="<c:url value="/user/list"/>" class="d-none d-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Zobacz użytkowników</a>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <a href="<c:url value="/user/create"/>" class="d-none d-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-address-card fa-sm text-white-50"></i> Dodaj użytkownika</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="/fragment/footer.jsp" %>