function showWait() {
  YPLAD.WaitPnl.show();
}
function hideWait() {
  YPLAD.WaitPnl.hide();
}

function waitInit() {
  YPLAD.WaitPnl = new YPLAD.widget.Panel("waitpnl", {
    width : "120px",
    height : "120px",
    fixedcenter : true,
    close : false,
    draggable : false,
    zindex : 5,
    modal : true,
    visible : false
  });
  var kw = new YPLAD.util.KeyListener(document, {
    keys : 27
  }, {
    fn : YPLAD.WaitPnl.hide,
    scope : YPLAD.WaitPnl,
    correctScope : true
  });
  kw.enable();
  YPLAD.WaitPnl.setHeader("Cargando...");
  YPLAD.WaitPnl.setBody('<img src="' + YPLAD.ctx + '/images/loader.gif"  align="middle"  />');
  YPLAD.WaitPnl.render(document.body);
}

YPLAD.util.Event.onDOMReady(waitInit);

YPLAD.showWait = showWait;

YPLAD.hideWait = hideWait;