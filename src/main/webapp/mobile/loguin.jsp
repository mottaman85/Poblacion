<%@ include file="/taglibs.jsp"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://demos.jquerymobile.com/1.4.2/css/themes/default/jquery.mobile-1.4.2.min.css">
	<link rel="stylesheet" href="http://demos.jquerymobile.com/1.4.2/_assets/css/jqm-demos.css">
	<script src="http://demos.jquerymobile.com/1.4.2/js/jquery.js"></script>
	<script src="http://demos.jquerymobile.com/1.4.2/_assets/js/index.js"></script>
	<script src="http://demos.jquerymobile.com/1.4.2/js/jquery.mobile-1.4.2.min.js"></script>

</head>
<body>

<!-- Start of first page: #one -->
<div data-role="page" id="one">

	<div data-role="header">
		<h1>Login</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content" >
	<%=request.getHeader("User-Agent") %>
		<h3>Ingrese sus datos de acceso</h3>

		<input type="text" placeholder="Usuario">
		<input type="text" placeholder="Password">
		<input type="submit" value="Ingresar">
		
		<p><a href="#two" class="ui-btn ui-shadow ui-corner-all">Muestra Roles</a></p>
	</div><!-- /content -->

	<div data-role="footer" data-theme="a">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page one -->

<!-- Start of second page: #two -->
<div data-role="page" id="two" data-theme="a">

	<div data-role="header">
		<h1>Roles</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>Roles</h2>
		
		<ul data-role="listview" data-filter="true" data-filter-placeholder="Search fruits..." data-inset="true">
    <s:iterator value="roles">
    	<li><a href="#"><s:property value="label"/> </a></li>
    </s:iterator>
	</ul>

	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->

<!-- Start of third page: #popup -->
<div data-role="page" id="popup">

	<div data-role="header" data-theme="b">
		<h1>Dialog</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>Popup</h2>
		<p>I have an id of "popup" on my page container and only look like a dialog because the link to me had a <code>data-rel="dialog"</code> attribute which gives me this inset look and a <code>data-transition="pop"</code> attribute to change the transition to pop. Without this, I'd be styled as a normal page.</p>
		<p><a href="#one" data-rel="back" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-icon-back ui-btn-icon-left">Back to page "one"</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page popup -->


</body>
</html>