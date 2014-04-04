<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRUEBA</title>
<script src="http://yui.yahooapis.com/3.14.1/build/yui/yui-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.14.1/build/cssbase/cssbase-min.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.14.1/build/cssbase-context/cssbase-context-min.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.14.1/build/cssgrids/cssgrids-min.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.14.1/build/cssfonts/cssfonts-context-min.css">
<script type="text/javascript">
</script>
</head>
<body class="yui3-skin-sam yui3-cssfonts" id="yahoo-com">	
<script>

a = function(){
	console.log("Click en el boton");
}

	YUI().use('datatable', function (Y) {

		var table = new Y.DataTable({
	    	columns: ["id", "name", "price"],
	    	data: [],
	    	sortable: true
		}).render('#example');
});

	
	YUI().use('button-plugin', function(Y){
	    
	    var button = new Y.Plugin.Button.createNode("#container", {
	        type : 'checkbox'
	    }).on("click", a);
	    
	});
</script>
	<div id="example" class="yui3-tabview">

	</div>
<div>
	<div class="yui3-cssfonts"><h1>Lorem Ipsum</h1></div>
	<div><h1>Lorem Ipsum</h1></div>
</div>

<div id="container">
    <button class='yui3-button'>One</button>
    <button class='yui3-button'>Two</button>
	<button class='yui3-button'>Three</button>
</div>        
	<button id="testButton">Odddne</button>
</body>  

</html>