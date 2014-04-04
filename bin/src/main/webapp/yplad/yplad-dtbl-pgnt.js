/**
 * Busca las palabras redirect, success o error
 * 
 * @param messages
 * @return true si existe algun error
 */
function hasAsyncDtblErrors(messages) {
  try {
    clearExceptionDiv();
    if (messages.redirect) {
      return true;
    }
    if (messages.success != undefined) {
      if (messages.success == false || messages.success == 'false') {
        return true;
      }
    }
    if (messages.error != undefined) {
      if (messages.error == true || messages.error == 'true') {
        return true;
      }
    }
    return false;
  } catch (e) {
    alert("hasAsyncDtblErrors: " + e.description);
  }
}

/**
 * Si existe redirect, notificara el valor recibido en message.error Si
 * messages.success es false, publicara el error en el elemento exceptiondiv
 * 
 * @param messages
 * @return
 */
function manageAsyncDtblErrors(messages) {
  try {
    if (messages.redirect) {
      alert(messages.error);
      window.location = YPLAD.ctx + messages.redirect;
      return;
    }
    if (messages.success != undefined) {
      if (messages.success == false && messages.exception) {
        publishExceptionDiv(traducirError(messages.exception));
      }
      return;
    }
  } catch (e) {
    alert("manageAsyncDtblErrors: " + e.description);
  }
}

/**
 * Regresa un paginator, containers es el id del div, rowsPerPage es el numero
 * de renglones de la tabla.
 */
function getPladPaginator(containers, rowsPerPage) {
  return new YPLAD.widget.Paginator( {
    containers : containers,
    rowsPerPage : rowsPerPage,
    containerClass : "plad-paginator",
    template : "{FirstPageLink} {PreviousPageLink} <span class='plad-pgntor'>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
    firstPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/first_on.gif' class='plad-pgntor-img' alt='Primera' />",
    firstPageLinkClass : "yui-pg-first",
    lastPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/last_on.gif' class='plad-pgntor-img' alt='Ultima' />",
    lastPageLinkClass : "yui-pg-last",
    previousPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/prev_on.gif' class='plad-pgntor-img' alt='Anterior' />",
    previousPageLinkClass : "yui-pg-previous",
    nextPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/next_on.gif' class='plad-pgntor-img' alt='Siguiente' />",
    nextPageLinkClass : "yui-pg-next",
    pageReportTemplate : "Pag. {currentPage} de {totalPages}"
  });
}

/**
 * Regresa un paginator, containers es el id del div, rowsPerPage es el numero
 * de renglones de la tabla.
 */
function getPladPaginatorWithSearch(containers, rowsPerPage, idSearch) {
  return new YPLAD.widget.Paginator(
      {
        containers : containers,
        rowsPerPage : rowsPerPage,
        containerClass : "plad-paginator",
        template : "<a href='#' onclick='return false;' id='"
            + idSearch
            + "'><img src='"
            + YPLAD.ctx
            + "/yplad/images/icon_search.gif' height='15' style='vertical-align:top' alt='Busqueda' /></a> {FirstPageLink} {PreviousPageLink} <span class='plad-pgntor'>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
        firstPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/first_on.gif' class='plad-pgntor-img' alt='Primera' />",
        firstPageLinkClass : "yui-pg-first",
        lastPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/last_on.gif' class='plad-pgntor-img' alt='Ultima' />",
        lastPageLinkClass : "yui-pg-last",
        previousPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/prev_on.gif' class='plad-pgntor-img' alt='Anterior' />",
        previousPageLinkClass : "yui-pg-previous",
        nextPageLinkLabel : "<img src='" + YPLAD.ctx + "/yplad/images/next_on.gif' class='plad-pgntor-img' alt='Siguiente' />",
        nextPageLinkClass : "yui-pg-next",
        pageReportTemplate : "Pag. {currentPage} de {totalPages}"
      });
}

YPLAD.Dtbl = function() {
};

YPLAD.Dtbl.detalleFmt = function(cell, row, col, data) {
  cell.innerHTML = '<input type="image" src="' + YPLAD.ctx + '/yplad/images/edit.gif" value="Detalle" size="21,21" border="0" alt="Detalle" onClick="return false;" />';
  cell.style.textAlign = 'center';
};

YPLAD.Dtbl.eliminarFmt = function(cell, row, col, data) {
  cell.innerHTML = '<input type="image" src="' + YPLAD.ctx + '/yplad/images/trash.gif" value="Eliminar" size="21,21" border="0" alt="Eliminar" onClick="return false;" />';
  cell.style.textAlign = 'center';
};

YPLAD.Dtbl.DerechaFmt = function(cell, row, col, data) {
  cell.innerHTML = '<div align="right">' + data + '</div>';
};

YPLAD.Dtbl.idFmt = function(cell, row, col, data) {
  if (row.getData('nuevo') == true) {
    cell.innerHTML = '*';
  } else {
    cell.innerHTML = data;
  }
};

YPLAD.util.Event.onDOMReady(function() {
  YPLAD.Dtbl.textEditor = new YPLAD.widget.TextboxCellEditor( {
    disableBtns : true
  });
  YPLAD.Dtbl.numberEditor = new YPLAD.widget.TextboxCellEditor( {
    validator : YPLAD.widget.DataTable.validateNumber,
    disableBtns : true
  });

})

YPLAD.Dtbl.prototype = {
  myDataTable : null,
  myDataSource : null,
  paginator : null,
  responseSchema : null,
  _EDITOR : false,
  _ROW_MOUSE : false,
  _ROW_SELECT : false,  
  _URL : null,
  _ERROR : '<font color="red">Error de Sistema.</font>',
  _EMPTY : 'No existen registros.',
  _LOADING : '<div style="color: blue;vertical-align:middle;"><img src="' + YPLAD.ctx + '/images/wait_icon.gif" align="middle"/>&nbsp;Cargando...</div>',
  _DBTL_CONTAINER : null,
  _PGNT_CONTAINTER : null,
  _PGTN_RECORDS : 5,
  _PGNT_TOTAL_CONTAINTER : null,
  _PGNT_ID_SEARCH : null,
  _FIELDS : [ "id", "nuevo", "modificado", "eliminado", "error", "rechazado", "confirmado", "aportacion", "retiro","arrtEspecial"],
  _COLUMNS_DEFS : [ {
    key : "id",
    label : "DEFAULT"
  } ],
  setDtblContainer : function(container) {
    this._DBTL_CONTAINER = container;
  },
  setPgntContainer : function(container) {
    this._PGNT_CONTAINTER = container;
  },
  setPgntTotalContainer : function(container) {
    this._PGNT_TOTAL_CONTAINTER = container;
  },
  setPgntIdSearch : function(container) {
    this._PGNT_ID_SEARCH = container;
  },  
  setPgntRecords : function(records) {
    this._PGTN_RECORDS = records;
  },
  setUrl : function(url) {
    this._URL = url;
  },
  setColumnsDefs : function(columnsDefs) {
    this._COLUMNS_DEFS = columnsDefs;
  },
  setFields : function(fields) {
    this._FIELDS = fields;
  },
  setEditor : function(flag) {
    this._EDITOR = flag;
  },
  setRowMouse : function(flag) {
    this._ROW_MOUSE = flag;
  },
  setRowSelect : function(flag) {
    this._ROW_SELECT = flag;
  },   
  setEmpty : function(text) {
    this._EMPTY = text;
  },
  construct : function() {
    if (!this._URL) {
      alert("Url is undefined");
      return;
    }
    if (!this._DBTL_CONTAINER) {
      alert("DtblContainer is undefined");
      return;
    }
    if (!this._PGNT_CONTAINTER) {
      alert("PgntContainer is undefined");
      return;
    }
    if (!this._PGNT_TOTAL_CONTAINTER) {
      alert("PgntTotalContainer is undefined");
      return;
    }

    this.responseSchema = {
      resultsList : "ResultSet.Result",
      fields : this._FIELDS
    };

    this.myDataSource = new YPLAD.util.DataSource(this._URL);
    this.myDataSource.connXhrMode = "queueRequests";
    this.myDataSource.connMethodPost = true;
    this.myDataSource.responseType = YPLAD.util.DataSource.TYPE_JSON;
    this.myDataSource.responseSchema = this.responseSchema;
    this.myDataSource.maxCacheEntries = 1;

    this.myDataSource.doBeforeParseData = function(oRequest, oFullResponse, oCallback) {
      try {
        if (hasAsyncDtblErrors(oFullResponse) == true) {
          manageAsyncDtblErrors(oFullResponse);
          return {};
        }
      } catch (e) {
        alert("doBeforeParseData: " + e.description);
      }
      return oFullResponse;
    };

    if (this._PGNT_ID_SEARCH == null) {
      this.paginator = getPladPaginator(this._PGNT_CONTAINTER, this._PGTN_RECORDS);
    } else {
      this.paginator = getPladPaginatorWithSearch(this._PGNT_CONTAINTER, this._PGTN_RECORDS, this._PGNT_ID_SEARCH);
    }    

    this.paginator.subscribe('totalRecordsChange', function(e) {
      this.setTotalRecords(e.newValue);
    }, this, true);

    var myRowFormatter = function(elTr, oRecord) {
      if (oRecord.getData('modificado') == true) {
        YPLAD.util.Dom.addClass(elTr, "modificado");
      }
      if (oRecord.getData('eliminado') == true) {
        YPLAD.util.Dom.addClass(elTr, "eliminado");
      }
      if (oRecord.getData('nuevo') == true) {
        YPLAD.util.Dom.addClass(elTr, "nuevo");
      }
      if (oRecord.getData('error') == true) {
        YPLAD.util.Dom.addClass(elTr, "fontrojo");
      }if (oRecord.getData('confirmado') == true) {
        YPLAD.util.Dom.addClass(elTr, "confirmado");
      }if (oRecord.getData('rechazado') == true) {
        YPLAD.util.Dom.addClass(elTr, "rechazado");
      }if (oRecord.getData('aportacion') == true) {
    	YPLAD.util.Dom.addClass(elTr, "aportacion");
      }if (oRecord.getData('retiro') == true) {
	  YPLAD.util.Dom.addClass(elTr, "retiro");
      }if (oRecord.getData('arrtEspecial') == true) {
	  YPLAD.util.Dom.addClass(elTr, "arrtEspecial");
      }
      
      else {
        YPLAD.util.Dom.removeClass(elTr, "fontrojo");
      }

      return true;
    };

    this.oConfigs = {
      paginator : this.paginator,
      MSG_EMPTY : this._EMPTY,
      MSG_LOADING : this._LOADING,
      MSG_ERROR : this._ERROR,
      initialLoad : false,
      formatRow : myRowFormatter
    };
    try {
      this.myDataTable = new YPLAD.widget.DataTable(this._DBTL_CONTAINER, this._COLUMNS_DEFS, this.myDataSource, this.oConfigs);

      if (this._EDITOR) {
        var highlightEditableCell = function(oArgs) {
          var elCell = oArgs.target;
          if (YPLAD.util.Dom.hasClass(elCell, "yui-dt-editable")) {
            this.highlightCell(elCell);
          }
        };
        this.myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
        this.myDataTable.subscribe("cellMouseoutEvent", this.myDataTable.onEventUnhighlightCell);
        this.myDataTable.subscribe("cellClickEvent", this.myDataTable.onEventShowCellEditor);

        /**
         * Asignara el field modificado a true, en el evento de guardar con un
         * editor de columna
         */
        this.myDataTable.subscribe("editorSaveEvent", function(oArgs) {
          var oRecord = oArgs.editor.getRecord();
          if (oArgs.newData != oArgs.oldData) {
            YPLAD.logplad('field modificado ahora es true..');
            oRecord.setData("modificado", true);
          }
          this.render();
        });

      }
      
      /**
       * Activa el evento de mouse over sobre cada renglon del datatable
       */
      if (this._ROW_MOUSE) {
        this.myDataTable.subscribe("rowMouseoverEvent", this.myDataTable.onEventHighlightRow); 
        this.myDataTable.subscribe("rowMouseoutEvent", this.myDataTable.onEventUnhighlightRow); 
      }
      
      /**
       * Activa el evento al seleccionar el renglon del datatable
       */
      if (this._ROW_SELECT) {
        this.myDataTable.subscribe("rowClickEvent", this.myDataTable.onEventSelectRow);
      }      

    } catch (e) {
      alert("construct: " + e.description);
    }
  },
  setTotalRecords : function(total) {
    var container = document.getElementById(this._PGNT_TOTAL_CONTAINTER);
    if (container) {
      container.innerHTML = total;
    }
  },
  success : function(sRequest, oResponse, oPayload) {
    var dtbl = this.myDataTable;
    dtbl.onDataReturnInitializeTable(sRequest, oResponse, oPayload);
    var pag = dtbl.get('paginator');
    if (pag) {
      pag.set('totalRecords', oResponse.results.length);
    }
  },
  failure : function(sRequest, oResponse, oPayload) {
    var dtbl = this.myDataTable;
    dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
    dtbl.showTableMessage(this._ERROR + " <br/> " + parseErrorMsg(oResponse), "errorMessage");
    var pag = dtbl.get('paginator');
    if (pag) {
      pag.set('totalRecords', 0);
    }
  },
  update : function() {
    try {
      var dtbl = this.myDataTable;
      dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
      dtbl.showTableMessage(this._LOADING);
      var pag = dtbl.get('paginator');
      if (pag) {
        pag.set('totalRecords', 0);
      }
      var postdata = "";
      postdata += "ddd=" + new Date().getTime();
      postdata += this.getPostData();

      var callback2 = {
        success : this.success,
        failure : this.failure,
        scope : this
      };
      this.myDataSource.sendRequest(postdata, callback2);
    } catch (x) {
      alert("update:" + x.description);
    }
  },
  getPostData : function() {
    return "";
  },
  isChanged : function() {
    try {
      var dtbl = this.myDataTable;
      var nRecordsLength = dtbl.getRecordSet().getLength();
      var record;
      for (i = 0; i < nRecordsLength; i++) {
        record = dtbl.getRecordSet().getRecord(i);
        if (record.getData("nuevo") == true || record.getData("modificado") == true || record.getData("eliminado") == true) {
          return true;
        }
      }
      return false;
    } catch (x) {
      alert("isChanged: " + x.description);
    }
  },
  clear : function() {
    try {
      var dtbl = this.myDataTable;
      dtbl.unselectAllRows();
      dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
      var pag = dtbl.get('paginator');
      if (pag) {
        pag.set('totalRecords', 0);
      }
    } catch (x) {
      alert("clear: " + x.description);
    }
  },
  getJsonRecords : function() {
    try {
      var dtbl = this.myDataTable;
      var recordSet = dtbl.getRecordSet();
      var arrayTemp = [];
      for (i = 0; i < recordSet.getLength(); i++) {
        var record = recordSet.getRecord(i);
        arrayTemp.push(record.getData());
      }
      return YPLAD.lang.JSON.stringify(arrayTemp);
    } catch (x) {
      alert("getJsonRecords: " + x.description);
    }
  },
  size : function(record) {
    try {
      var dtbl = this.myDataTable;
      return dtbl.getRecordSet().getLength();
    } catch (x) {
      alert("size: " + x.description);
    }
  }

}

/**
 * Dynamic Datatable - La paginacion se realiza con la base de datos
 */

YPLAD.DtblDyn = function() {
};

YPLAD.DtblDyn.prototype = {
  myDataTable : null,
  myDataSource : null,
  paginator : null,
  responseSchema : null,
  _EDITOR : false,
  _ROW_MOUSE : false,
  _ROW_SELECT : false,
  _EDITOR : false,
  _URL : null,
  _ERROR : '<font color="red">Error de Sistema.</font>',
  _EMPTY : 'No existen registros.',
  _LOADING : '<div style="color: blue;vertical-align:middle;"><img src="' + YPLAD.ctx + '/images/wait_icon.gif" align="middle"/>&nbsp;Cargando...</div>',
  _DBTL_CONTAINER : null,
  _PGNT_CONTAINTER : null,
  _PGTN_RECORDS : 5,
  _PGNT_TOTAL_CONTAINTER : null,
  _FIELDS : [ "id", "nuevo", "modificado", "eliminado", "error", "aportacion", "retiro", "arrtEspecial" ],
  _COLUMNS_DEFS : [ {
    key : "id",
    label : "DEFAULT"
  } ],
  setDtblContainer : function(container) {
    this._DBTL_CONTAINER = container;
  },
  setPgntContainer : function(container) {
    this._PGNT_CONTAINTER = container;
  },
  setPgntTotalContainer : function(container) {
    this._PGNT_TOTAL_CONTAINTER = container;
  },
  setPgntIdSearch : function(container) {
    this._PGNT_ID_SEARCH = container;
  },    
  setPgntRecords : function(records) {
    this._PGTN_RECORDS = records;
  },
  setUrl : function(url) {
    this._URL = url;
  },
  setColumnsDefs : function(columnsDefs) {
    this._COLUMNS_DEFS = columnsDefs;
  },
  setFields : function(fields) {
    this._FIELDS = fields;
  },
  setEditor : function(flag) {
    this._EDITOR = flag;
  },
  setRowMouse : function(flag) {
    this._ROW_MOUSE = flag;
  },
  setRowSelect : function(flag) {
    this._ROW_SELECT = flag;
  },  
  setEmpty : function(text) {
    this._EMPTY = text;
  },
  construct : function() {
    if (!this._URL) {
      alert("Url is undefined");
      return;
    }
    if (!this._DBTL_CONTAINER) {
      alert("DtblContainer is undefined");
      return;
    }
    if (!this._PGNT_CONTAINTER) {
      alert("PgntContainer is undefined");
      return;
    }
    if (!this._PGNT_TOTAL_CONTAINTER) {
      alert("PgntTotalContainer is undefined");
      return;
    }

    this.responseSchema = {
      resultsList : "ResultSet.Result",
      fields : this._FIELDS,
      metaFields : {
        totalRecords : "totalRecords"
      }
    };

    this.myDataSource = new YPLAD.util.DataSource(this._URL);
    this.myDataSource.connXhrMode = "queueRequests";
    this.myDataSource.connMethodPost = true;
    this.myDataSource.responseType = YPLAD.util.DataSource.TYPE_JSON;
    this.myDataSource.responseSchema = this.responseSchema;
    this.myDataSource.maxCacheEntries = 1;

    this.myDataSource.doBeforeParseData = function(oRequest, oFullResponse, oCallback) {
      try {
        if (hasAsyncDtblErrors(oFullResponse) == true) {
          manageAsyncDtblErrors(oFullResponse);
          return {};
        }
      } catch (e) {
        alert("doBeforeParseData: " + e.description);
      }
      return oFullResponse;
    };

    if (this._PGNT_ID_SEARCH == null) {
      this.paginator = getPladPaginator(this._PGNT_CONTAINTER, this._PGTN_RECORDS);
    } else {
      this.paginator = getPladPaginatorWithSearch(this._PGNT_CONTAINTER, this._PGTN_RECORDS, this._PGNT_ID_SEARCH);
    }      

    this.paginator.subscribe('totalRecordsChange', function(e) {
      this.setTotalRecords(e.newValue);
    }, this, true);

    var myRowFormatter = function(elTr, oRecord) {
      if (oRecord.getData('modificado') == true) {
        YPLAD.util.Dom.addClass(elTr, "modificado");
      }
      if (oRecord.getData('eliminado') == true) {
        YPLAD.util.Dom.addClass(elTr, "eliminado");
      }
      if (oRecord.getData('nuevo') == true) {
        YPLAD.util.Dom.addClass(elTr, "nuevo");
      }
      if (oRecord.getData('error') == true) {
        YPLAD.util.Dom.addClass(elTr, "fontrojo");
      } 
      if (oRecord.getData('aportacion') == true) {
    	  YPLAD.util.Dom.addClass(elTr, "aportacion");
      } 
      if (oRecord.getData('retiro') == true) {
    	  YPLAD.util.Dom.addClass(elTr, "retiro");
      } 
      if (oRecord.getData('arrtEspecial') == true) {
    	  YPLAD.util.Dom.addClass(elTr, "arrtEspecial");
      }
      
      else {
        YPLAD.util.Dom.removeClass(elTr, "fontrojo");
      }

      return true;
    };

    this.oConfigs = {
      paginator : this.paginator,
      MSG_EMPTY : this._EMPTY,
      MSG_LOADING : this._LOADING,
      MSG_ERROR : this._ERROR,
      initialLoad : false,
      dynamicData : true,
      formatRow : myRowFormatter
    };
    try {
      this.myDataTable = new YPLAD.widget.DataTable(this._DBTL_CONTAINER, this._COLUMNS_DEFS, this.myDataSource, this.oConfigs);

      if (this._EDITOR) {
        var highlightEditableCell = function(oArgs) {
          var elCell = oArgs.target;
          if (YPLAD.util.Dom.hasClass(elCell, "yui-dt-editable")) {
            this.highlightCell(elCell);
          }
        };
        this.myDataTable.subscribe("cellMouseoverEvent", highlightEditableCell);
        this.myDataTable.subscribe("cellMouseoutEvent", this.myDataTable.onEventUnhighlightCell);
        this.myDataTable.subscribe("cellClickEvent", this.myDataTable.onEventShowCellEditor);

        /**
         * Asignara el field modificado a true, en el evento de guardar con un
         * editor de columna
         */
        this.myDataTable.subscribe("editorSaveEvent", function(oArgs) {
          var oRecord = oArgs.editor.getRecord();
          if (oArgs.newData != oArgs.oldData) {
            YPLAD.logplad('field modificado ahora es true..');
            oRecord.setData("modificado", true);
          }
          this.render();
        });

      }
      
      /**
       * Activa el evento de mouse over sobre cada renglon del datatable
       */
      if (this._ROW_MOUSE) {
        this.myDataTable.subscribe("rowMouseoverEvent", this.myDataTable.onEventHighlightRow); 
        this.myDataTable.subscribe("rowMouseoutEvent", this.myDataTable.onEventUnhighlightRow); 
      }
      
      /**
       * Activa el evento al seleccionar el renglon del datatable
       */
      if (this._ROW_SELECT) {
        this.myDataTable.subscribe("rowClickEvent", this.myDataTable.onEventSelectRow);
      }
      

    } catch (e) {
      alert("construct: " + e.description);
    }
  },
  setTotalRecords : function(total) {
    var container = document.getElementById(this._PGNT_TOTAL_CONTAINTER);
    if (container) {
      container.innerHTML = total;
    }
  },
  success : function(sRequest, oResponse, oPayload) {
    var dtbl = this.myDataTable;
    dtbl.onDataReturnInitializeTable(sRequest, oResponse, oPayload);
    var pag = dtbl.get('paginator');
    if (pag) {
      pag.set('totalRecords', oResponse.meta.totalRecords);
    }
  },
  failure : function(sRequest, oResponse, oPayload) {
    var dtbl = this.myDataTable;
    dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
    dtbl.showTableMessage(this._ERROR + " <br/> " + parseErrorMsg(oResponse), "errorMessage");
    var pag = dtbl.get('paginator');
    if (pag) {
      pag.set('totalRecords', 0);
    }
  },
  update : function() {
    try {
      var dtbl = this.myDataTable;
      dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
      dtbl.showTableMessage(this._LOADING);
      var pag = dtbl.get('paginator');
      if (pag) {
        pag.set('totalRecords', 0);
      }
      var postdata = "";
      postdata += "ddd=" + new Date().getTime();
      postdata += this.getPostData();

      var callback2 = {
        success : this.success,
        failure : this.failure,
        scope : this
      };
      this.myDataSource.sendRequest(postdata, callback2);
    } catch (x) {
      alert("update:" + x.description);
    }
  },
  getPostData : function() {
    return "";
  },
  isChanged : function() {
    try {
      var dtbl = this.myDataTable;
      var nRecordsLength = dtbl.getRecordSet().getLength();
      var record;
      for (i = 0; i < nRecordsLength; i++) {
        record = dtbl.getRecordSet().getRecord(i);
        if (record) {
          if (record.getData("nuevo") == true) {
            return true;
          }
          if (record.getData("modificado") == true) {
            return true;
          }
          if (record.getData("eliminado") == true) {
            return true;
          }
        }
      }
      return false;
    } catch (x) {
      	("isChanged: " + x.description);
    }
  },
  clear : function() {
    try {
      var dtbl = this.myDataTable;
      dtbl.unselectAllRows();
      dtbl.deleteRows(dtbl.getRecordSet().getLength() - 1, -1 * dtbl.getRecordSet().getLength());
      var pag = dtbl.get('paginator');
      if (pag) {
        pag.set('totalRecords', 0);
      }
    } catch (x) {
      alert("clear: " + x.description);
    }
  },
  getJsonRecords : function() {
    try {
      var dtbl = this.myDataTable;
      var recordSet = dtbl.getRecordSet();
      var arrayTemp = [];
      YPLAD.logplad("Longitud del recordset: " + recordSet.getLength());
      for (i = 0; i < recordSet.getLength(); i++) {
        var record = recordSet.getRecord(i);
        if (record) {
          arrayTemp.push(record.getData());
        }
      }
      return YPLAD.lang.JSON.stringify(arrayTemp);
    } catch (x) {
      alert("getJsonRecords: " + x.description);
    }
  },
  /**
   * Este metodo no regresa el total de registros mostrados en la pantalla.
   */
  size : function(record) {
    try {
      var dtbl = this.myDataTable;
      return dtbl.getRecordSet().getLength();
    } catch (x) {
      alert("size: " + x.description);
    }
  }
};

/**
 * *****************************************************************************
 * 
 */
