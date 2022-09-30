<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 15/06/2021
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/fragment/header.jsp" %>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Utwórz użytkownika</h1>
</div>
<div class="row">
    <div class="col-xl-12 col-md-12 mb-2">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div>
                    <form class="row no-gutters align-items-center" method="post">
                        <div class="col-xl-12 col-md-12 mb-2">
                            <div class="form-group">
                                <label for="username">Nazwa</label>
                                <input name="username" type="text" class="form-control" id="username"
                                       placeholder="Nazwa użytkownika">
                            </div>
                        </div>
                        <div class="col-xl-12 col-md-12 mb-2">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input name="email" type="email" class="form-control" id="email"
                                       placeholder="Email użytkownika">
                            </div>
                        </div>
                        <div class="col-xl-12 col-md-12 mb-2">
                            <div class="form-group">
                                <label for="password">Hasło</label>
                                <input name="password" type="password" class="form-control" id="password"
                                       placeholder="Hasło użytkownika">
                            </div>
                        </div>
                        <div class="col-xl-12 col-md-12 mb-2">
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                    class="fas fa-address-card fa-sm text-white-50"></i> Dodaj użytkownika
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/fragment/footer.jsp" %>