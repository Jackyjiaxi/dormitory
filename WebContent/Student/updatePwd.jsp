<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>�޸�����</title>
<link href="../css/studentframe.css" rel="stylesheet">
<script>
	var he=document.body.clientHeight-105
	document.write("<div id=tt style=height:"+he+";overflow:hidden>")
</script>
<script>
function showsubmenu(sid)
{
	whichEl = eval("submenu" + sid);
	imgmenu = eval("imgmenu" + sid);
	if (whichEl.style.display == "none")
	{
		eval("submenu" + sid + ".style.display=\"\";");
		imgmenu.background="../images/main_47.gif";
	}else
	{
		eval("submenu" + sid + ".style.display=\"none\";");
		imgmenu.background="../images/main_48.gif";
	}
}
</script>
</head>
<body>
<%String username=session.getAttribute("username").toString(); %>
<div id="container">
    <div id="header">
    	<h1><b>ѧ���������ϵͳ---ѧ����</b></h1>
    </div>
    <div id="guide">
    	<label for="userlabel">��ǰ�û���<%=username %></label> 	
    </div>
    <div id=main>
    	<div id="leftbar">
    		<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
 				<tr>
    					<td valign="top">
    						<table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      							<tr><td>
        							<table width="100%" border="0" cellspacing="0" cellpadding="0">
          									<tr>
            									<td height="23" background="../images/main_47.gif" id="imgmenu1" class="menu_title" 
            									       onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" 
            									       onMouseOut="this.className='menu_title';" style="cursor:hand">
            										<table width="100%" border="0" cellspacing="0" cellpadding="0">
              										<tr>
                										<td width="18%">&nbsp;</td>
                										<td width="82%" class="STYLE1">ϵͳ����</td>
              										</tr>
            										</table>
            									</td>
          									</tr>
          									<tr><td background="../images/main_51.gif" id="submenu1">
			 										<div class="sec_menu" >  
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td>
               													 	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  													<tr>
                    													<td width="16%" height="25">
                    														<div align="center">
                    															<img src="../images/left.gif" width="10" height="10" />
                    														</div>
                    													</td>
                    													<td width="84%" height="23">
                    														<table width="95%" border="0" cellspacing="0" cellpadding="0">
                        														<tr>
                          															<td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                          																<span class="STYLE3"><a href="updateStudent.jsp">�༭������Ϣ</a></span>
                          															</td>
                        														</tr>
                   														 	</table>
                   														 </td>
                  													</tr>
                  													<tr>
                    													<td height="23">
                    														<div align="center">
                    															<img src="../images/left.gif" width="10" height="10" />
                    														</div>
                    													</td>
                    													<td height="23">
                    														<table width="95%" border="0" cellspacing="0" cellpadding="0">
                        													<tr>
                          														<td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                          															<span class="STYLE3"><a href="updatePwd.jsp">�����޸�</a></span>
                          														</td>
                        													</tr>
                    														</table>
                    													</td>
                  													</tr>
                                                        			</table>
                                                 				</td></tr>
                                                            <tr>
                                                             	<td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
              												 </tr>
                                                         </table>
                                                     </div>
                                                 </td></tr>      
                                        </table>
                                </td></tr>
                                <tr><td>
                                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          									<tr>
            									<td height="23" background="../images/main_47.gif" id="imgmenu2" class="menu_title" 
            									       onMouseOver="this.className='menu_title2';" onClick="showsubmenu(2)" 
            									       onMouseOut="this.className='menu_title';" style="cursor:hand">
            										<table width="100%" border="0" cellspacing="0" cellpadding="0">
              										<tr>
                										<td width="18%">&nbsp;</td>
                										<td width="82%" class="STYLE1">��ѯ����</td>
              										</tr>
            										</table>
            									</td>
          									</tr>
          									<tr><td background="../images/main_51.gif" id="submenu2">
			 										<div class="sec_menu" >  
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td>
               													 	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  													<tr>
                    													<td width="16%" height="25">
                    														<div align="center">
                    															<img src="../images/left.gif" width="10" height="10" />
                    														</div>
                    													</td>
                    													<td width="84%" height="23">
                    														<table width="95%" border="0" cellspacing="0" cellpadding="0">
                        														<tr>
                          															<td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                          																<span class="STYLE3"><a href="../SQueryStuServlet">�����ۺ���Ϣ</a></span>
                          															</td>
                        														</tr>
                   														 	</table>
                   														 </td>
                  													</tr>
                  													<tr>
                    													<td height="23">
                    														<div align="center">
                    															<img src="../images/left.gif" width="10" height="10" />
                    														</div>
                    													</td>
                    													<td height="23">
                    														<table width="95%" border="0" cellspacing="0" cellpadding="0">
                        													<tr>
                          														<td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                          															<span class="STYLE3"><a href="../SQueryallHelServlet">�������Ȳ�ѯ</a></span>
                          														</td>
                        													</tr>
                    														</table>
                    													</td>
                  													</tr>
                                                        			</table>
                                                 				</td></tr>
                                                            <tr>
                                                             	<td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
              												 </tr>
                                                         </table>
                                                     </div>
                                                 </td></tr>      
                                        </table>
                                </td></tr>
                                <tr><td>
                                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          									<tr>
            									<td height="23" background="../images/main_47.gif" id="imgmenu6" class="menu_title" 
            									       onMouseOver="this.className='menu_title2';" onClick="showsubmenu(6)" 
            									       onMouseOut="this.className='menu_title';" style="cursor:hand">
            										<table width="100%" border="0" cellspacing="0" cellpadding="0">
              										<tr>
                										<td width="18%">&nbsp;</td>
                										<td width="82%" class="STYLE1">���ᱨ������</td>
              										</tr>
            										</table>
            									</td>
          									</tr>
          									<tr><td background="../images/main_51.gif" id="submenu6">
			 										<div class="sec_menu" >  
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
              												<tr><td>
               													 	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  													<tr>
                    													<td width="16%" height="25">
                    														<div align="center">
                    															<img src="../images/left.gif" width="10" height="10" />
                    														</div>
                    													</td>
                    													<td width="84%" height="23">
                    														<table width="95%" border="0" cellspacing="0" cellpadding="0">
                        														<tr>
                          															<td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                          																<span class="STYLE3"><a href="addRepairs.jsp">�������</a></span>
                          															</td>
                        														</tr>
                   														 	</table>
                   														 </td>
                  													</tr>
                                                        			</table>
                                                 				</td></tr>
                                                            <tr>
                                                             	<td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
              												 </tr>
                                                         </table>
                                                     </div>
                                                 </td></tr>      
                                        </table>
                                </td></tr>
    						</table>
    					</td>
  				</tr>
  				<tr>
    				<td height="18" background="../images/main_58.gif">
    					<table width="100%" border="0" cellspacing="0" cellpadding="0">
      						<tr>
        						<td height="18" valign="bottom">
        							<div align="center" class="STYLE3">All copyright&copy;2019&nbsp;</div>
        						</td>
      						</tr>
    					</table>
    				</td>
                </tr>
            </table>
    	</div>
    	<div id="content">
    		<form id="updatePwdForm" name="updatePwdForm" method="post" action="../SUpdatePwdServlet">
    			<table align="center" class="addUserTab" border="0" cellspacing="0" cellpadding="11px">
    			<tr>
					<td>��ǰ�û�����</label></td>
					<td><input id="username" name="username" type="text" value=<%=username %> readonly="readonly"></td>
				</tr>
    			<tr>
    				<td>ԭ���룺</td>
    				<td><input id="password" name="formerPwd" type="password"></td>
    			</tr>
    			<tr>
    				<td>�����룺</td>
    				<td><input id="password" name="newPwd" type="password"></td>
    			</tr>
    			<tr>
    				<td>ȷ�����룺</td>
    				<td><input id="password" name="pwdRepeat" type="password"></td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input name="submit" type="submit" value="ȷ���޸�" onclick="javascript:alert('�޸ĳɹ���')">
						<input name="reset" type="reset" value="����">
    				</td>
    			</tr>
    		</form>
    	</div>
    </div>
</div>
</body>
</html>