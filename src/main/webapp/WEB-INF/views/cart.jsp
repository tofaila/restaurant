<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Shop Homepage</title>

        <!-- Bootstrap core CSS -->
        <link href="resources/admin-template/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="resources/admin-template/cssnew/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/admin-template/css/animate.css">
        <link href="resources/img/logo.ico" rel="shortcut icon" />
        <script src="resources/admin-template/js/angular.js"></script>
        <script type="text/javascript">
           var cartproductlist = ${itemsincart};
            angular.module('organocartpackage', []).controller('CartController',
                    function ($scope) {
                        $scope.citems = cartproductlist;
                    });
        </script>
<!--        <style type="text/css">
            .table>thead {
                background-color: #8BC34A;
                color: #ffffff;
                font-style: italic;
                padding: 10px;
                text-align: center;
                vertical-align: middle;
            }

            .table>tfoot {
                background-color: #8BC34A;
                color: #ffffff;
                font-style: italic;
                padding: 10px;
                text-align: center;
            }

            .table-striped>tbody>tr:nth-of-type(even) {
                background-color: #dcedc8;
            }

            #removebtn {
                color: #ffffff;
                background-color: #e57373;
            }

            #removebtn:hover {
                color: #ffffff;
                background-color: #e53935;
            }

            #prodimage {
                width: 125px;
                height: 150px;
            }

            tr {
                margin: 10px;
                background-color: #9ccc65;
            }

            th {
                text-align: center;
                margin: 10px;
            }

            td {
                vertical-align: middle !important;
            }

            #jumbotrondiv {
                background-color: #dcedc8;
                width: 80%;
            }

            #quantity {
                text-align: center;
            }
            #quantity:FOCUS
            {
                outline: none;
                box-shadow:none;
            }
            #minusbutton, #plusbutton {
                padding: 9px;
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);
            }

            #checkoutbutton,#continuebutton {
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);
            }
            #checkoutbutton:HOVER,#continuebutton:HOVER {
                background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);
                color: #ffffff;
            }

        </style>-->

    </head>
    <body ng-app="organocartpackage" ng-controller="CartController">

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Dhaka restaurant</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <c:if test="${sessionScope.UserLoggedIn ==null}">
                            <li class="nav-item">
                                <a class="nav-link" href="login">Login</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.UserLoggedIn !=null}">
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout</a>
                            </li>
                            <li><a href="showcartpage" style="color: #9ccc65; font-size: 19px"> 
                                    <span class="glyphicon glyphicon-shopping-cart"></span> 
                                    <span class="badge">${sessionScope.grandquantity}</span>
                                </a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">

            <div class="row">
                <div class="col-lg-12">



                    <h3 style="text-align: center; color: #689f38"
                        style=" border-radius: 5px">Cart Page</h3>

                    <c:if test="${cartempty}">
                        <div class="jumbotron container h4 animated fadeInDown delay-05s" id="jumbotrondiv" align="center">
                            There are No items in the cart<br>
                            <br>
                            <br> 
                            <a href="buyproductpage" type="button" id="continuebutton"
                               class="btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                                Buy Products</a>
                        </div>
                    </c:if>
                    <c:if test="${!cartempty}">
                        <table class="table table-striped table-responsive animated fadeInDown delay-05s">
                            <thead>
                                <tr scope="row">
                                    <th style="width: 10%">Product</th>
                                    <th style="width: 10%">Product Name</th>
                                    <th style="width: 15%">Quantity</th>
                                    <th style="width: 7%">Total Price</th>
                                    <th style="width: 7%">Payable Amount</th>
                                    <th style="width: 10%"></th>
                                </tr>
                            </thead>

                            <tbody ng-repeat="items in citems">
                                <tr scope="row" style="margin: 10px">
                                    <td><img id="prodimage" src="resources/images/{{items.pid}}.jpg"
                                             class="img-rounded" width="100" height="100"></td>
                                    <td class="h4">{{items.pname}}</td>
                                    <td><div class="input-group">
                                            <span class="input-group-btn"> <a
                                                    href="editquantity?getpid={{items.pid}}&value=decrease"
                                                    id="minusbutton" type="button" class="btn"> <span
                                                        class="glyphicon glyphicon-minus"></span>
                                                </a>
                                            </span> <input type="text" id="quantity"
                                                           class="form-control input-number" value="{{items.qty}}"
                                                           readonly="readonly" onfocus="this.blur()"> <span class="input-group-btn">
                                                <a
                                                    href="editquantity?getpid={{items.pid}}&value=increase"
                                                    id="plusbutton" type="button" class="btn"> <span
                                                        class="glyphicon glyphicon-plus"></span>
                                                </a>
                                            </span>
                                        </div></td>
                                    <td>Tk.{{items.price}}</td>
                                    <td>Tk.{{items.total}}</td>
                                    <td><a href="removeproductitem?pid={{items.pid}}"
                                           id="removebtn" class="btn btn-outline-danger"> <span
                                                class="glyphicon glyphicon-remove"></span> Remove
                                        </a></td>
                                </tr>
                            </tbody>

                            <tfoot>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <div class="pull-left">
                                        <b>Grand Total</b>
                                    
                                </div>
                            </td>
                            <td><span class="pull-left">
                                    <b>Tk.${sessionScope.grandtotal}</b>
                                </span>
                            </td>
                            <td></td>
                            </tfoot>
                        </table>
                        <div class="pull-right" style="display: inline-block">
                            <a href="buyproductpage" type="button" id="continuebutton"
                               class="btn"><span
                                    class="glyphicon glyphicon-shopping-cart"></span> Continue shopping</a>
                            <a href="billaddresspage" class="btn" id="checkoutbutton"><span
                                    class="glyphicon glyphicon-tasks"></span> Proceed To Order </a>	
                        </div>
                    </c:if>
                </div>
                <!-- /.row -->

            </div>
        </div>
            <!-- /.container -->

            <!-- Footer -->
            <footer class="py-5 bg-dark">
                <div class="container">
                    <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
                </div>
                <!-- /.container -->
            </footer>

            <!-- Bootstrap core JavaScript -->
            <script src="resources/admin-template/jquery/jquery.min.js"></script>
            <script src="resources/admin-template/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>