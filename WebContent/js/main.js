$().ready(function() {

	$("nav").append(
		"<ul>"
			+"<li title='PRS'><a href='index.html'>PRS</a></li>"
			+"<li title='Home page'><a href='index.html'>Home</a></li>"
			+"<li title='Users'><a href='user-list.html'>Users</a></li>"
			+"<li title='Products'><a href='products?action=list'>Products</a></li>"
		+"</ul>"
	);

}); // end ready