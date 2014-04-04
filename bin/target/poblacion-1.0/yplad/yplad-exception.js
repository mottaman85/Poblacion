function showException(exception) {
  try {
    YPLAD.ExceptionPnl.setBody("<p>" + exception + "</p>");
    YPLAD.ExceptionPnl.show();
  } catch (e) {
    alert("showException:" + e.description);
  }
}

function exceptionInit() {
  YPLAD.ExceptionPnl = new YPLAD.widget.Panel("exceptioncontainer", {
    width : "40em",
    fixedcenter : true,
    close : true,
    draggable : false,
    zindex : 6,
    modal : true,
    constraintoviewport : true,
    monitorresize : true,
    visible : false
  });
  var kw = new YPLAD.util.KeyListener(document, {
    keys : 27
  }, {
    fn : YPLAD.ExceptionPnl.hide,
    scope : YPLAD.ExceptionPnl,
    correctScope : true
  });
  kw.enable();
  YPLAD.ExceptionPnl.setHeader("Error");
  YPLAD.ExceptionPnl.render(document.body);
}

YPLAD.util.Event.onDOMReady(exceptionInit);