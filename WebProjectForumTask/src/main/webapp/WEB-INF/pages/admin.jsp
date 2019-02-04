<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"><head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title class = "Pathname">Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="#">Start FOUR ROOM Admin</a>

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
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="/">Main page</a>
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
            </div>
        </li>
    </ul>

</nav>

<div id="wrapper">



    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item" id = commentsNavItem>
            <a class="nav-link" href="/admin/comments">
                <i class="fas fa-fw fa-comments"></i>
                <span>Comments</span></a>
        </li>
        <li class="nav-item" id = subjectsNavItem>
            <a class="nav-link" href="/admin/subjects">
                <i class="fas fa-fw fa-list"></i>
                <span>Subjects</span></a>
        </li>
        <li class="nav-item" id = usersNavItem>
            <a class="nav-link" href="/admin/users">
                <i class="fas fa-fw fa-users"></i>
                <span>Users</span></a>
        </li>
        <li class="nav-item" id = topicsNavItem>
            <a class="nav-link" href="/admin/topics">
                <i class="fas fa-fw fa-list"></i>
                <span>Topics</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item Pathname">
                </li>
            </ol>

            <!-- Comments DataTables Example -->

            <div id ="adminTables">
                <div id="displayCommentsTable" style="display: none">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-comments"></i>
                            Comments Data Table
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Comment</th>
                                        <th>Username</th>
                                        <th>Topic name</th>
                                        <th>Subject name</th>
                                        <th>Date</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody id="commentsBody"></tbody>
                                </table>
                                <button type="button" class = "btn btn-info addComments" data-toggle="modal" data-target="#addCommentsModal">Add new comment</button>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>
                <div id="displaySubjectsTable" style="display: none">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-list"></i>
                            Subjects Data Table
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Subject name</th>
                                        <th>Username</th>
                                        <th>Topic name</th>
                                        <th>Date</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody id="subjectsBody"></tbody>
                                </table>
                                <button type="button" class = "btn btn-info addSubjects" data-toggle="modal" data-target="#addSubjectsModal">Add new subject</button>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>
                <div id="displayUsersTable" style="display: none">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-users"></i>
                            Users Data Table
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Password</th>
                                        <th>Email</th>
                                        <th>First name</th>
                                        <th>Last name</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody id="usersBody"></tbody>
                                </table>
                                <button type="button" class = "btn btn-info addUsers" data-toggle="modal" data-target="#addUsersModal">Add new user</button>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>
                <div id="displayTopicsTable" style="display: none">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-list"></i>
                            Topics Data Table
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Topic name</th>
                                        <th colspan="2">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody id="topicsBody"></tbody>
                                </table>
                                <button type="button" class = "btn btn-info addTopics" data-toggle="modal" data-target="#addTopicsModal">Add new topic</button>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>
            </div>

    </div>

        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright © FOUR ROOM 2019</span>
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
                <a class="btn btn-primary" href="<c:url value="/logout" />">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Delete Comments-->
<div class="modal fade" id="deleteCommentsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete the comment?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Delete" below if you are ready to delete this comment.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" id="deleteCommentsModalButton" type="button" data-dismiss="modal">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Update Comments-->
<div class="modal fade" id="updateCommentsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update the comment</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/admin/comments">Update</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Add Comments-->
<div class="modal fade" id="addCommentsModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">Add the comment</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>
        <div class="modal-body">

        </div>
        <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <button class="btn btn-primary" id="addCommentsModalButton" type="button" data-dismiss="modal">Add</button>
        </div>
    </div>
</div>
</div>

<!-- Modal Delete Subjects-->
<div class="modal fade" id="deleteSubjectsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete the subject?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Delete" below if you are ready to delete this subject.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" id="deleteSubjectsModalButton" type="button" data-dismiss="modal">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Update Subjects-->
<div class="modal fade" id="updateSubjectsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update the subject?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/admin/subjects">Update</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Add Subjects-->
<div class="modal fade" id="addSubjectsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add the subject</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" id="addSubjectsModalButton" type="button" data-dismiss="modal">Add</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Delete Users-->
<div class="modal fade" id="deleteUsersModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete the user?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Delete" below if you are ready to delete this user.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" id="deleteUsersModalButton" type="button" data-dismiss="modal">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Update Users-->
<div class="modal fade" id="updateUsersModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update the user?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/admin/users">Update</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Add Users-->
<div class="modal fade" id="addUsersModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add the user</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" id="addUsersModalButton" type="button" data-dismiss="modal">Add</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Delete Topics-->
<div class="modal fade" id="deleteTopicsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete the topic?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Delete" below if you are ready to delete this topic.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" id="deleteTopicsModalButton" type="button" data-dismiss="modal">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Update Topics-->
<div class="modal fade" id="updateTopicsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update the topic?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/admin/topics">Update</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal Add Topics-->
<div class="modal fade" id="addTopicsModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add the topic</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" id="addTopicsModalButton" type="button" data-dismiss="modal">Add</a>
            </div>
        </div>
    </div>
</div>

<!-- Templates -->
    <script id="commentsTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td>\${message}</td>
            <td>\${userName}</td>
            <td>\${topicName}</td>
            <td>\${subjectName}</td>
            <td>\${date}</td>
            <td><button type="button" class = "btn btn-primary updateComments" id ="\${id}" data-toggle="modal" data-target="#updateCommentsModal">Update</button></td>
            <td><button type="button" class = "btn btn-danger deleteComments" id ="\${id}" data-toggle="modal" data-target="#deleteCommentsModal">Delete</button></td>
        </tr>
    </script>

    <script id="commentsUpdateTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td><input type="text" value="\${message}"/></td>
            <td><select id = "usersSelectUpdate"></select></td>
            <td><select id = "topicsSelectUpdate"></select></td>
            <td><select id = "subjectsSelectUpdate"></select></td>
            <td><input type="text" value="\${date}"/></td>
            <td><button type="button" class = "btn btn-primary okComments" id ="\${id}">OK</button></td>
            <td><button type="button" class = "btn btn-danger cancelComments" id ="\${id}">Cancel</button></td>
        </tr>
    </script>

    <script id="subjectsTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td>\${subjectName}</td>
            <td>\${userName}</td>
            <td>\${topicName}</td>
            <td>\${date}</td>
            <td><button type="button" class = "btn btn-primary updateSubjects" id ="\${id}" data-toggle="modal" data-target="#updateSubjectsModal">Update</button></td>
            <td><button type="button" class = "btn btn-danger deleteSubjects" id ="\${id}" data-toggle="modal" data-target="#deleteSubjectsModal">Delete</button></td>
        </tr>
    </script>

    <script id="subjectsUpdateTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td><input type="text" value="\${subjectName}"/></td>
            <td><select id = "usersSelectUpdate"></select></td>
            <td><select id = "topicsSelectUpdate"/></select></td>
            <td><input type="text" value="\${date}"/></td>
            <td><button type="button" class = "btn btn-primary okSubjects" id ="\${id}">OK</button></td>
            <td><button type="button" class = "btn btn-danger cancelSubjects" id ="\${id}">Cancel</button></td>
        </tr>
    </script>

    <script id="usersTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td>\${userName}</td>
            <td>\${password}</td>
            <td>\${email}</td>
            <td>\${firstName}</td>
            <td>\${lastName}</td>
            <td><button type="button" class = "btn btn-primary updateUsers" id ="\${id}" data-toggle="modal" data-target="#updateUsersModal">Update</button></td>
            <td><button type="button" class = "btn btn-danger deleteUsers" id ="\${id}" data-toggle="modal" data-target="#deleteUsersModal">Delete</button></td>
        </tr>
    </script>

    <script id="usersUpdateTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td><input type="text" value="\${userName}"/></td>
            <td><input type="text" value="\${password}"/></td>
            <td><input type="text" value="\${email}"/></td>
            <td><input type="text" value="\${firstName}"/></td>
            <td><input type="text" value="\${lastName}"/></td>
            <td><button type="button" class = "btn btn-primary okUsers" id ="\${id}">OK</button></td>
            <td><button type="button" class = "btn btn-danger cancelUsers" id ="\${id}">Cancel</button></td>
        </tr>
    </script>

    <script id="topicsTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td>\${topicName}</td>
            <td><button type="button" class = "btn btn-primary updateTopics" id ="\${id}" data-toggle="modal" data-target="#updateTopicsModal">Update</button></td>
            <td><button type="button" class = "btn btn-danger deleteTopics" id ="\${id}" data-toggle="modal" data-target="#deleteTopicsModal">Delete</button></td>
        </tr>
    </script>

    <script id="topicsUpdateTemplate" type="text/x-jQuery-tmpl">
        <tr id ="column\${id}">
            <td><input type="text" value="\${topicName}"/></td>
            <td><button type="button" class = "btn btn-primary okTopics" id ="\${id}">OK</button></td>
            <td><button type="button" class = "btn btn-danger cancelTopics" id ="\${id}">Cancel</button></td>
        </tr>
    </script>

    <script id="topicsSelectTemplate" type="text/x-jQuery-tmpl">
        <option value="\${topicName}">\${topicName}</option>
    </script>

    <script id="subjectsSelectTemplate" type="text/x-jQuery-tmpl">
        <option value="\${subjectName}">\${subjectName}</option>
    </script>

    <script id="usersSelectTemplate" type="text/x-jQuery-tmpl">
        <option value="\${userName}">\${userName}</option>
    </script>



<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script>
<script src="scripts/adminPasteData.js"></script>
<script src="scripts/deleteData.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>




</body></html>