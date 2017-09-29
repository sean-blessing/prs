$().ready(function() {

	$.get("http://prs.gregorydoud.net/Users/List").done(function(data) {
		console.log(data);
		allUsers = data;
		var htmlForContent = buildListOfUsers();
		$("content").html(htmlForContent);
	});
});

var allUsers = [];

var users = [
	{ ID: 0, UserName: 'gpdoud', Password: 'password', 
		FirstName: 'Greg', LastName: 'Doud',
		Email: 'gdoud@maxtrain.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true },
	{ ID: 1, UserName: 'kimn', Password: 'password', 
		FirstName: 'Kim', LastName: 'Nguyen',
		Email: 'kim@gmail.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true },
	{ ID: 1, UserName: 'longn', Password: 'password', 
		FirstName: 'Long', LastName: 'Nguyen',
		Email: 'long@gmail.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true },
	{ ID: 1, UserName: 'eric', Password: 'password', 
		FirstName: 'Eric', LastName: 'Nguyen',
		Email: 'eric@gmail.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true },
	{ ID: 1, UserName: 'elisha', Password: 'password', 
		FirstName: 'Elisha', LastName: 'Nguyen',
		Email: 'elisha@gmail.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true },
	{ ID: 1, UserName: 'phuc', Password: 'password', 
		FirstName: 'Phuc', LastName: 'Nguyen',
		Email: 'phuk@gmail.com', Phone: '513-555-1212',
		IsAdmin: true, IsReviewer: true }
];

function getUsers() {
	return allUsers;
}

function buildListOfUsers() {
	var users = getUsers();
	var usersHTML = "<table>";
	usersHTML += "<tr>"
			+ "<th>ID</th>"
			+ "<th>User Name</th>"
			+ "<th>Password</th>"
			+ "<th>First Name</th>"
			+ "<th>Last Name</th>"
			+ "<th>Email</th>"
			+ "<th>Phone</th>"
			+ "<th>IsAdmin</th>"
			+ "<th>IsReviewer</th>"
			+ "</tr>";

	for(var idx = 0; idx < users.length; idx++) {
		var user = users[idx];
		var tr = "<tr>";
		tr += "<td>" + user.ID + "</td>";
		tr += "<td>" + user.UserName + "</td>";
		tr += "<td>" + user.Password + "</td>";
		tr += "<td>" + user.FirstName + "</td>";
		tr += "<td>" + user.LastName + "</td>";
		tr += "<td>" + user.Email + "</td>";
		tr += "<td>" + user.Phone + "</td>";
		tr += "<td>" + user.IsAdmin + "</td>";
		tr += "<td>" + user.IsReviewer + "</td>";
		tr += "</tr>";
		usersHTML += tr;
	}

	usersHTML += "</table>";
	return usersHTML;
}