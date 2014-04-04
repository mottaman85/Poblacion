<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/yui/build/reset-fonts-grids/reset-fonts-grids.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/yui/build/fonts/fonts-min.css"></link>
<!--CSS CONTROLS-->
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/container.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/button.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/autocomplete.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/tabview.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/calendar.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/logger.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/slider.css" />

<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/element/element-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/utilities/utilities.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/datasource/datasource-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/autocomplete/autocomplete-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/container/container-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/button/button-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/paginator/paginator-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/datatable/datatable-debug.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/json/json-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/resize/resize-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/layout/layout-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/tabview/tabview-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/logger/logger-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/yuitest/yuitest-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/calendar/calendar-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/uploader/uploader-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/animation/animation-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/slider/slider-min.js"></script>
<!--CHARTS -->
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/swf/swf-min.js"></script>
<script type="text/javascript" src="${ctx}/${yuiversion}/yui/build/charts/charts-min.js"></script>


<script type="text/javascript">
var YPLAD = YAHOO;
YPLAD.namespace("dtblFn");
YPLAD.ctx = '${ctx}';
YPLAD.version = '1.0';


/**
 * Log para la categoria de plad.
 */
YPLAD.logplad = function(message) {
  YPLAD.log(message, 'pladcategory');
};

</script>

<!--PLAD -->
<link rel="stylesheet" type="text/css" href="${ctx}/yplad/yplad-domain.css?version=${version}"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/yplad/yplad-dtbl-pgnt.css?version=${version}"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/yplad/yplad-exception.css?version=${version}"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/${yuiversion}/${skins}/datatable.css"></link>
<script type="text/javascript" src="${ctx}/yplad/yplad-wait.js?version=${version}"></script> 
<script type="text/javascript" src="${ctx}/yplad/yplad-exception.js?version=${version}"></script>
<script type="text/javascript" src="${ctx}/yplad/yplad-message.js?version=${version}"></script> 
<script type="text/javascript" src="${ctx}/yplad/yplad-dtbl-pgnt.js?version=${version}"></script> 
<script type="text/javascript" src="${ctx}/yplad/yplad-scroll-dtbl-pgnt.js?version=${version}"></script> 
<script type="text/javascript" src="${ctx}/yplad/yplad-utils.js?version=${version}"></script> 
<script type="text/javascript" src="${ctx}/yplad/yplad-async.js?version=${version}"></script>
<script type="text/javascript" src="${ctx}/yplad/utils-plad-reg/utilsPladReg.js?version=${version}"></script>
<script type="text/javascript" src="${ctx}/yplad/utils-plad-reg/jquery.js?version=${version}"></script>  