<%-- 
    Document   : addproduct
    Created on : Nov 25, 2018, 5:18:28 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Add Product</title>
        <link href="resources/admin-template/img/logo.ico" rel="shortcut icon" />
        <!-- Bootstrap core CSS-->
        <link href="resources/admin-template/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/admin-template/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/admin-template/datatables/dataTablesbootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/admin-template/cssnew/sb-admin.css" rel="stylesheet">
        <script src="resources/admin-template/js/angular.js"></script>

        <script>
            

            var tableinfoall = ${tableinfoList};
            var searchonetype = ${s};
            
            angular.module('abc', []).controller('SearchController',
                    function ($scope) {
                        $scope.rt = tableinfoall;
                        $scope.sro = searchonetype;
                        console.log($scope.rt);
                        console.log($scope.sro);
                        //                        console.log( $scope.rtList);
                    });
        </script>
        
        
        
        
    </head>

    <body id="page-top" ng-app="abc" ng-controller="SearchController" >
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="${pageContext.request.contextPath}"><img src="resources/admin-template/image/Logo.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li> 
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About us</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/accomodation">Accomodation</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Admin Login</a></li>
                            <li class="nav-item"><a class="nav-link" href="gallery.html">Gallery</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
                                    <li class="nav-item"><a class="nav-link" href="blog-single.html">Blog Details</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item"><a class="nav-link" href="elements.html">Elemests</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                            <li class="nav-item"><a class="btn theme_btn button_hover login" href="#">Customer Login</a></li>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>

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
                        <span>Pages</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">Settings:</h6>
                        <a class="dropdown-item" href="showingcategorypage">Add Facility</a>
                        <a class="dropdown-item" href="roombookinginfo">Room Booking</a>
                        <a class="dropdown-item" href="customerinfo">Customer Information</a>
                        <a class="dropdown-item" href="paymentinfo">Payment</a>
                        <a class="dropdown-item" href="showingroomtypepage">Add Room Type</a>
                        <a class="dropdown-item" href="roomcategory">Add Room Category</a>
                        <a class="dropdown-item" href="room">Add Room</a>
                        <div class="dropdown-divider"></div>
                        <h6 class="dropdown-header">Other Pages:</h6>
                        <a class="dropdown-item" href="#">View Orders</a>
                        <a class="dropdown-item" href="#">Manage User</a>
                        <a class="dropdown-item" href="reportView" target="_blank">Product Report</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="charts.html">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Charts</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tables.html">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>


            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Table Booking</li>
                    </ol>
                    <!-- end panel heading -->
                    <div class="panel-body">





                        <!--                        Start-->





                        <div class="formcontainer ">


                            <center><h1>Booking Table</h1></center>





                           

                           
<!--                                <form action="processBasicyear" method="post">-->
                                <form action="roomsearch" >
                            
                                     <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-group">

                                        <select class="form-control" ng-model="s" ng-options="x.tableno as x.tableno for x in rt " required="true">
                                            <option value="">-- Table Type --</option>
                                        </select>
                                        <div class="form-label-group">
                                            <input type="hidden" value="{{s}}" name="tableno"> <br>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            
<!--                             <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-group">

                                        <select class="form-control" ng-model="c" ng-options="x.catid as x.catid for x in rt" required="true">
                                            <option value="">-- Room Category --</option>
                                        </select>
                                        <div class="form-label-group">
                                            <input type="hidden" value="{{c}}" name="catid"> <br>

                                        </div>
                                    </div>
                                </div>
                            </div>-->
                                    
                                    
                                    
                                    <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                             <input type="text" class="form-control"  name="startdate" placeholder="End Date" required="true" id="date" ></input>
                                            
                                                <label for="date">Start Date</label>
                                            </div>
                                        </div>
                                    </div>
                                    <!--                                                End Date-->

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="form-label-group">
                                            <input type="text" class="form-control"  name="enddate" placeholder="End Date" required="true" id="date1" ></input>
                                                <label for="date1">End Date</label>
                                            </div>
                                        </div>
                                    </div>






                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-fw btn-block" value="Search">
                                   
                                </div>
                            </form>

                        </div>










                        <!--                        End-->
                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <c:if test="${check}">
                            <div class="card-header">
                                <i class="fas fa-table"></i>
                                Table  List</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Table Image</th>
                                                <th>Table ID</th>
                                                <th>Table No </th>
                                              
                                                <th>Total Seat</th>
                                                
                                              
                                                <th>Edit/Remove</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                 <th>Table Image</th>
                                                <th>Table ID</th>
                                                <th>Table No</th>
                                              
                                                <th>Total Seat</th>
                                                
                                                
                                               
                                                <th>Edit/Remove</th>

                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr ng-repeat="Cat in sro">
                                                        <td><img class="img-responsive" style="width:180px ;height:200px;border-radius: 0;" src="resources/admin-template/imgr/{{Cat.roomid}}.jpg" /></td>
                                            <td>{{Cat.tableid}}</td>
                                             <td>{{Cat.tableno}}</td>
                                            <td>{{Cat.totalseat}}</td>
                                         
                                           
                                         
                                            <td><a href="roomprofilelink?getsid={{Cat.tableid}}"><button id="editbuttons" type="submit" class="btn btn-info">room details</button></a></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                            </c:if>
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

            <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="startdate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
            </script>


            <script>
                        $(document).ready(function () {
                            var date_input = $('input[name="enddate"]'); //our date input has the name "date"
                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                            date_input.datepicker({
                                format: 'yyyy/mm/dd',
                                container: container,
                                todayHighlight: true,
                                autoclose: true,
                            })
                        })
            </script>

            <!--     Form code begins 
                <form method="post">
                  <div class="form-group">  Date input 
                    <label class="control-label" for="date">Date</label>
                    <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
                  </div>
                 </form>-->
        </div>
    </body>
</html>
