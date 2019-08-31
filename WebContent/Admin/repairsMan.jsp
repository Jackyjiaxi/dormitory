<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>维修工调配</title>
<link href="../css/adminframe.css" rel="stylesheet">
<script>
var  highlightcolor='#c1ebff';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  			<tr><td height="30" background="../images/tab_05.gif">
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      			<tr>
        			<td width="12" height="30"><img src="../images/tab_03.gif" width="12" height="30" /></td>
        			<td>
        				<label>维修工信息【请选定维修工】</label>
        			</td>
        			<td width="16"><img src="../images/tab_07.gif" width="16" height="30" /></td>
      			</tr>
    			</table>
    		</td></tr>
    			
  			<tr><td>
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      			<tr>
      				<td width="8" background="../images/tab_12.gif">&nbsp;</td>
        			<td>
        			<form name="tab" method="post" action="#">
        				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          				<tr>
            				<th width="10%" height="22" background="../images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2">维修人ID</span></div></th>
            				<th width="20%" height="22" background="../images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2">维修人</span></div></th>
            				<th width="20%" height="22" background="../images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2">维修人电话</span></div></th>
            				<th width="40%" height="22" background="../images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2">维修方向</span></div></th>
            				<th width="10%" height="22" background="../images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2">操作</span></div></th>
          				</tr>
          				<!-- 此处增添记录 -->
          				<%=session.getAttribute("query") %> 
    					</table>
    				</form>
    				</td>
  				</tr>
				</table>
</body>
</html>