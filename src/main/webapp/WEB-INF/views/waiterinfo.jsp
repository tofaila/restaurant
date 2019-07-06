
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Add Waiterinfo</title>
        <link href="resources/admin-template/img/logo.ico" rel="shortcut icon" />
        <!-- Bootstrap core CSS-->
        <link href="resources/admin-template/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/admin-template/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/admin-template/datatables/dataTablesbootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/admin-template/cssnew/sb-admin.css" rel="stylesheet">
        <script src="js/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  
        <script>
            var wa = ${waiterinfolist};
            console.log(wa);
            angular.module('myapp', []).controller('WaiterinfoController',
                    function ($scope) {
                        $scope.waiterinfoAngularObject = wa;
                    });
        </script>

    </head>
    <body id="page-top" ng-app="myapp" ng-controller="WaiterinfoController">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin">Dhaka restaurant/a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <span class="badge badge-danger">9+</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-envelope fa-fw"></i>
                        <span class="badge badge-danger">7</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Hello ${sessionScope.UserLoggedIn}</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>">Home</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="admin">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
               <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Tables</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showtablepage">Add Table</a>
                       <a class="dropdown-item" href="showtablepage"> Table List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Customers</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                       <a class="dropdown-item" href="showcustomerinfo"> Customer List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Waiters</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                       <a class="dropdown-item" href="showwaiterinfo"> Waiter List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Products</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showproductpage">Add Product</a>
                       <a class="dropdown-item" href="showproductpage"> Product List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Orders</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showcustomerorder">Add CustomerOrder</a>
                       <a class="dropdown-item" href="showcustomerorder"> CustomerOrder List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Bookings</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showbookinginfo">Add Booking</a>
                       <a class="dropdown-item" href="showbookinginfo"> Booking List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Orderdetails</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showorderdetails">Add Orderdetails</a>
                       <a class="dropdown-item" href="showorderdetails"> Orderdetails List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Payments</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                       <a class="dropdown-item" href="showpaymentpage">Add Payment</a>
                       <a class="dropdown-item" href="showpaymentpage"> Payment List</a>
<!--                        <a class="dropdown-item" href="showcustomerinfo">Add Customer</a>
                        <a class="dropdown-item" href="showproductpage">Add Product</a>
                        <a class="dropdown-item" href="showwaiterinfo">Add Waiter</a>
                        <a class="dropdown-item" href="showbookinginfo">Add Booking</a>-->
                        <div class="dropdown-divider"></div>
<!--                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Order details</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>-->
                    </div>
                </li>
<!--                <li class="nav-item">
                    <a class="nav-link" href="charts.html">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Charts</span></a>
                </li>-->
<!--                <li class="nav-item">
                    <a class="nav-link" href="tables.html">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>-->
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Add Waiterinfo</li>
                    </ol>

                    <div class="panel-body">
                        <div class="formcontainer">
                            <c:if test="${check}">
                                <form:form name="addwaiterinfoform" commandName="newWaiterinfoObject" action="addingwaiterinfo" method="post">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Waiter  Id" type="text" path="waiterid" required="true" id="waiterid"></form:input>
                                                <label for="waiterid">Waiter Id</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Waiter Name" type="text" path="waitername" required="true" id="waitername"></form:input>
                                                <label for="waitername">Waiter Name</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input type="text" class="form-control" placeholder="Address" path="address" required="true" id="address"></form:input>
                                                <label for="address">Address</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input type="text" class="form-control" placeholder="Phone" path="phone" required="true" id="phone"></form:input>
                                                <label for="phone">Phone</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input type="text" class="form-control" placeholder="Email Id" path="emailid" required="true" id="emailid"></form:input>
                                                <label for="emailid">Email Id</label>
                                        </div>
                                    </div>
                                   
                                    <form:button id="editbuttons" type="submit" name="Addingwaiterinfo" class="btn btn-success">Add Waiter</form:button>
                                    <form:button id="removebuttons" type="reset" class="btn btn-danger">Reset Details</form:button>
                                    <a href="showwaiterinfo"><button id="show" type="button" class="btn">Cancel</button></a> 
                                </form:form>
                            </c:if>

                            <c:if test="${!check}">
                                <form:form name="addwaiterinfoform" commandName="newWaiterinfoObject" action="addingwaiterinfo" method="post">
                                    <div class="form-group">
                                       <div class="form-label-group">
                                           <form:input class="form-control" Placeholder="Waiter Id" type="text" path="waiterid" required="true" id="waiterid" readonly="true"></form:input>
                                                <label for="waiterid">Waiter Id</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Waiter Name" type="text" path="waitername" required="true" id="waitername"></form:input>
                                                <label for="waitername">Waiter Name</label>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Address" type="text" path="address" required="true" id="address"></form:input>
                                                <label for="address">Address</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Phone " type="text" path="phone" required="true" id="phone"></form:input>
                                                <label for="phone">Phone</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <form:input class="form-control" Placeholder="Email Id" type="text" path="emailid" required="true" id="emailid"></form:input>
                                                <label for="emailid">Email Id</label>
                                        </div>
                                    </div>
                                  
                                    <form:button id="editbuttons" type="submit" name="EditingWaiterinfo"
                                                 class="btn btn-success">Edit Waiter</form:button>
                                    <form:button id="removebuttons" type="reset" class="btn btn-danger">Reset Details</form:button>
                                     <a href="showwaiterinfo"><button id="show" type="button" class="btn">Cancel</button></a> 
                                </form:form>
                            </c:if>
                        </div>
                    </div>


                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Waiterinfo List</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Waiter Id</th>
                                            <th>Waiter Name</th>
                                            
                                            <th>Address</th>
                                            <th>Phone</th>
                                            <th>Email Id</th>
                                            
                                           
                                        </tr>
                                    </thead>
<!--                                    <tfoot>
                                        <tr>
                                            <th>Table Id</th>
                                            <th>Table NO</th>
                                            <th>Total Seat</th>
                                          
                                        </tr>
                                    </tfoot>-->
                                    <tbody>
                                        <tr ng-repeat="x in waiterinfoAngularObject">
                                            <td>{{x.waiterid}}</td>
                                            <td>{{x.waitername}}</td>
                                           
                                            <td>{{x.address}}</td>
                                            <td>{{x.phone}}</td>
                                            <td>{{x.emailid}}</td>
                                           
                                            <td><a href="editingwaiterinfobutton?getwaiterid={{x.waiterid}}"><button id="editbuttons" type="submit" class="btn">Edit</button></a> <a href="removingwaiterinfo/{{x.waiterid}}"><button  id="removebuttons" type="button" class="btn btn-danger">Remove</button></a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2018</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
            <script src="resources/admin-template/jquery/jquery.min.js"></script>
            <script src="resources/admin-template/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="resources/admin-template/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="resources/admin-template/chart/Chartmin.js"></script>
            <script src="resources/admin-template/datatables/jquerydataTables.js"></script>
            <script src="resources/admin-template/datatables/dataTablesbootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="resources/admin-template/jsnew/sb-adminmin.js"></script>

            <!-- Demo scripts for this page-->
            <script src="resources/admin-template/jsnew/demo/datatablesdemo.js"></script>
            <script src="resources/admin-template/jsnew/demo/chartareademo.js"></script>


            <!--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>-->

            <!-- Include Date Range Picker -->
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    </body>
</html>
