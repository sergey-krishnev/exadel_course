 $(document).ready(function () {
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/","");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    var idNav = "#" + pathname + "NavItem";
    $(idNav).addClass("active");
    $(".Pathname").text(Pathname);

     $('#adminTables').html('<div id="' + pathname + 'Table"></div>');

    var commentsDTO_data = '';
    var subjectsDTO_data = '';
    var usersDTO_data = '';
    var topicsDTO_data = '';

     $.getJSON("http://localhost:8080/comments", function (data) {
         commentsDTO_data +='<div class="card mb-3">';
         commentsDTO_data +='<div class="card-header">';
         commentsDTO_data +='<i class="fas fa-comments"></i>';
         commentsDTO_data +=' Comments Data Table</div>';
         commentsDTO_data +='<div class="card-body">';
         commentsDTO_data +='<div class="table-responsive">';
         commentsDTO_data +='<table class="table table-bordered table-hover" width="100%" cellspacing="0">';
         commentsDTO_data +='<thead>';
         commentsDTO_data +='<tr>';
         commentsDTO_data +='<th>Comment</th>';
         commentsDTO_data +='<th>Username</th>';
         commentsDTO_data +='<th>Topic name</th>';
         commentsDTO_data +='<th>Subject name</th>';
         commentsDTO_data +='<th>Date</th>';
         commentsDTO_data +='<th colspan="2">Action</th>';
         commentsDTO_data +='</tr>';
         commentsDTO_data +='</thead>';
         commentsDTO_data +='<tfoot>';
         commentsDTO_data +='<tr>';
         commentsDTO_data +='<th>Comment</th>';
         commentsDTO_data +='<th>Username</th>';
         commentsDTO_data +='<th>Topic name</th>';
         commentsDTO_data +='<th>Subject name</th>';
         commentsDTO_data +='<th>Date</th>';
         commentsDTO_data +='<th colspan="2">Action</th>';
         commentsDTO_data +='</tr>';
         commentsDTO_data +='</tfoot>';
         $.each(data, function (key, value) {
             commentsDTO_data +='<tr>';
             commentsDTO_data +='<td>' + value.message + '</td>';
             commentsDTO_data +='<td>' + value.userName + '</td>';
             commentsDTO_data +='<td>' + value.topicName + '</td>';
             commentsDTO_data +='<td>' + value.subjectName + '</td>';
             commentsDTO_data +='<td>' + value.date + '</td>';
             commentsDTO_data += '<td><button type="button" class = "btn btn-primary updateComment" id ="' + value.id + '">Update</button></td>';
             commentsDTO_data += '<td><button type="button" class = "btn btn-danger deleteComment" id ="' + value.id + '">Delete</button></td>';
             commentsDTO_data +='</tr>';
         });
         commentsDTO_data +='</table>';
         commentsDTO_data +='</div>';
         commentsDTO_data +='</div>';
         commentsDTO_data +='<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>';
         commentsDTO_data +='</div>';
         $('#commentsTable').html(commentsDTO_data)
     });

     $.getJSON("http://localhost:8080/topics/subjects", function (data) {
         subjectsDTO_data +='<div class="card mb-3">';
         subjectsDTO_data +='<div class="card-header">';
         subjectsDTO_data +='<i class="fas fa-list"></i>';
         subjectsDTO_data +=' Subjects Data Table</div>';
         subjectsDTO_data +='<div class="card-body">';
         subjectsDTO_data +='<div class="table-responsive">';
         subjectsDTO_data +='<table class="table table-bordered table-hover" width="100%" cellspacing="0">';
         subjectsDTO_data +='<thead>';
         subjectsDTO_data +='<tr>';
         subjectsDTO_data +='<th>Subject name</th>';
         subjectsDTO_data +='<th>Username</th>';
         subjectsDTO_data +='<th>Topic name</th>';
         subjectsDTO_data +='<th>Date</th>';
         subjectsDTO_data +='<th colspan="2">Action</th>';
         subjectsDTO_data +='</tr>';
         subjectsDTO_data +='</thead>';
         subjectsDTO_data +='<tfoot>';
         subjectsDTO_data +='<tr>';
         subjectsDTO_data +='<th>Subject name</th>';
         subjectsDTO_data +='<th>Username</th>';
         subjectsDTO_data +='<th>Topic name</th>';
         subjectsDTO_data +='<th>Date</th>';
         subjectsDTO_data +='<th colspan="2">Action</th>';
         subjectsDTO_data +='</tr>';
         subjectsDTO_data +='</tfoot>';
         $.each(data, function (key, value) {
             subjectsDTO_data +='<tr>';
             subjectsDTO_data +='<td>' + value.subjectName + '</td>';
             subjectsDTO_data +='<td>' + value.userName + '</td>';
             subjectsDTO_data +='<td>' + value.topicName + '</td>';
             subjectsDTO_data +='<td>' + value.date + '</td>';
             subjectsDTO_data += '<td><button type="button" class = "btn btn-primary updateSubject" id ="' + value.id + '">Update</button></td>';
             subjectsDTO_data += '<td><button type="button" class = "btn btn-danger deleteSubject" id ="' + value.id + '">Delete</button></td>';
             subjectsDTO_data +='</tr>';
         });
         subjectsDTO_data +='</table>';
         subjectsDTO_data +='</div>';
         subjectsDTO_data +='</div>';
         subjectsDTO_data +='<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>';
         subjectsDTO_data +='</div>';
         $('#subjectsTable').html(subjectsDTO_data)
     });

     $.getJSON("http://localhost:8080/users", function (data) {
         usersDTO_data +='<div class="card mb-3">';
         usersDTO_data +='<div class="card-header">';
         usersDTO_data +='<i class="fas fa-users"></i>';
         usersDTO_data +=' Users Data Table</div>';
         usersDTO_data +='<div class="card-body">';
         usersDTO_data +='<div class="table-responsive">';
         usersDTO_data +='<table class="table table-bordered table-hover" width="100%" cellspacing="0">';
         usersDTO_data +='<thead>';
         usersDTO_data +='<tr>';
         usersDTO_data +='<th>Username</th>';
         usersDTO_data +='<th>Password</th>';
         usersDTO_data +='<th>Email</th>';
         usersDTO_data +='<th>First name</th>';
         usersDTO_data +='<th>Last name</th>';
         usersDTO_data +='<th colspan="2">Action</th>';
         usersDTO_data +='</tr>';
         usersDTO_data +='</thead>';
         usersDTO_data +='<tfoot>';
         usersDTO_data +='<tr>';
         usersDTO_data +='<th>Username</th>';
         usersDTO_data +='<th>Password</th>';
         usersDTO_data +='<th>Email</th>';
         usersDTO_data +='<th>First name</th>';
         usersDTO_data +='<th>Last name</th>';
         usersDTO_data +='<th colspan="2">Action</th>';
         usersDTO_data +='</tr>';
         usersDTO_data +='</tfoot>';
         $.each(data, function (key, value) {
             usersDTO_data +='<tr>';
             usersDTO_data +='<td>' + value.userName + '</td>';
             usersDTO_data +='<td>' + value.password + '</td>';
             usersDTO_data +='<td>' + value.email + '</td>';
             usersDTO_data +='<td>' + value.firstName + '</td>';
             usersDTO_data +='<td>' + value.lastName + '</td>';
             usersDTO_data += '<td><button type="button" class = "btn btn-primary updateUser" id ="' + value.id + '">Update</button></td>';
             usersDTO_data += '<td><button type="button" class = "btn btn-danger deleteUser" id ="' + value.id + '">Delete</button></td>';
             usersDTO_data +='</tr>';
         });
         usersDTO_data +='</table>';
         usersDTO_data +='</div>';
         usersDTO_data +='</div>';
         usersDTO_data +='<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>';
         usersDTO_data +='</div>';
         $('#usersTable').html(usersDTO_data)
     });

     $.getJSON("http://localhost:8080/topics", function (data) {
         topicsDTO_data +='<div class="card mb-3">';
         topicsDTO_data +='<div class="card-header">';
         topicsDTO_data +='<i class="fas fa-list"></i>';
         topicsDTO_data +=' Topics Data Table</div>';
         topicsDTO_data +='<div class="card-body">';
         topicsDTO_data +='<div class="table-responsive">';
         topicsDTO_data +='<table class="table table-bordered table-hover" width="100%" cellspacing="0">';
         topicsDTO_data +='<thead>';
         topicsDTO_data +='<tr>';
         topicsDTO_data +='<th>Topic name</th>';
         topicsDTO_data +='<th colspan="2">Action</th>';
         topicsDTO_data +='</tr>';
         topicsDTO_data +='</thead>';
         topicsDTO_data +='<tfoot>';
         topicsDTO_data +='<tr>';
         topicsDTO_data +='<th>Topic name</th>';
         topicsDTO_data +='<th colspan="2">Action</th>';
         topicsDTO_data +='</tr>';
         topicsDTO_data +='</tfoot>';
         $.each(data, function (key, value) {
            topicsDTO_data +='<tr>';
            topicsDTO_data +='<td>' + value.topicName + '</td>';
            topicsDTO_data += '<td><button type="button" class = "btn btn-primary updateTopic" id ="' + value.id + '">Update</button></td>';
            topicsDTO_data += '<td><button type="button" class = "btn btn-danger deleteTopic" id ="' + value.id + '">Delete</button></td>';
            topicsDTO_data +='</tr>';
         });
         topicsDTO_data +='</table>';
         topicsDTO_data +='</div>';
         topicsDTO_data +='</div>';
         topicsDTO_data +='<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>';
         topicsDTO_data +='</div>';
         $('#topicsTable').html(topicsDTO_data)
     });


 });