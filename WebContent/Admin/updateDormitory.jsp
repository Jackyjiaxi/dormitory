<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<%@ page import="jl.utils.DbUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>编辑宿舍信息</title>
<link href="../css/adminframe.css" rel="stylesheet">
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
<div id="container">
    <div id="header">
    	<h1><b>学生宿舍管理系统---管理员端</b></h1>
    </div>
    <div id="guide">
    	<label for="userlabel">当前用户：<%=session.getAttribute("username") %></label> 	
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
                										<td width="82%" class="STYLE1">系统管理</td>
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
                          																<span class="STYLE3"><a href="addUser.jsp">添加用户</a></span>
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
                          															<span class="STYLE3"><a href="../QueryServlet">用户信息维护</a></span>
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
                          															<span class="STYLE3"><a href="updatePwd.jsp">密码修改</a></span>
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
                										<td width="82%" class="STYLE1">宿舍信息管理</td>
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
                          																<span class="STYLE3"><a href="addDormitory.jsp">宿舍信息登记</a></span>
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
                          															<span class="STYLE3"><a href="../QueryallDorServlet">宿舍信息维护</a></span>
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
            									<td height="23" background="../images/main_47.gif" id="imgmenu3" class="menu_title" 
            									       onMouseOver="this.className='menu_title2';" onClick="showsubmenu(3)" 
            									       onMouseOut="this.className='menu_title';" style="cursor:hand">
            										<table width="100%" border="0" cellspacing="0" cellpadding="0">
              										<tr>
                										<td width="18%">&nbsp;</td>
                										<td width="82%" class="STYLE1">学生入住管理</td>
              										</tr>
            										</table>
            									</td>
          									</tr>
          									<tr><td background="../images/main_51.gif" id="submenu3">
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
                          																<span class="STYLE3"><a href="addStudent.jsp">学生入住登记</a></span>
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
                          															<span class="STYLE3"><a href="../QueryallStuServlet">入住信息查询</a></span>
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
                          															<span class="STYLE3"><a href="studentChange.jsp">学生宿舍调换</a></span>
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
                          															<span class="STYLE3"><a href="studentLeave.jsp">学生离校管理</a></span>
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
            									<td height="23" background="../images/main_47.gif" id="imgmenu4" class="menu_title" 
            									       onMouseOver="this.className='menu_title2';" onClick="showsubmenu(4)" 
            									       onMouseOut="this.className='menu_title';" style="cursor:hand">
            										<table width="100%" border="0" cellspacing="0" cellpadding="0">
              										<tr>
                										<td width="18%">&nbsp;</td>
                										<td width="82%" class="STYLE1">卫生检查管理</td>
              										</tr>
            										</table>
            									</td>
          									</tr>
          									<tr><td background="../images/main_51.gif" id="submenu4">
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
                          																<span class="STYLE3"><a href="addHealth.jsp">卫生检查登记</a></span>
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
                          															<span class="STYLE3"><a href="../QueryallHelServlet">卫生情况查询</a></span>
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
                										<td width="82%" class="STYLE1">宿舍报修管理</td>
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
                          																<span class="STYLE3"><a href="../QueryallReServlet">报修情况登记</a></span>
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
                          															<span class="STYLE3"><a href="../QueryallLrServlet">报修情况查询</a></span>
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
<%
request.setCharacterEncoding("GB18030");
int id=Integer.parseInt(request.getParameter("id"));
String sql="SELECT * FROM dormitory WHERE do_id='"+id+"';";
System.out.println(sql);
ResultSet rs=DbUtil.executeQuery(sql);
rs.next();
session.setAttribute("id",id);
%>
<form name=updateinfo method="post" action="../UpdateDorServlet">
<table align="center"  class="updatedorinfo" border="0" cellspacing="0" cellpadding="11px">
<tr>
	<td>【原始信息】</td>
	<td>【将要更改的信息】</td>
</tr>
<tr><td>宿舍ID：<%=id %></td></tr>
<tr>
	<td>宿舍区栋：<%=rs.getString("do_section") %></td>
	<td>
		<label>区：</label>
    		<select id="selDor" name="dorSection1">
				<option value="一区" <%if(rs.getString("do_section").substring(0,2).equals("一区")) out.print("selected='selected'"); %>>一区</option>
				<option value="二区" <%if(rs.getString("do_section").substring(0,2).equals("二区")) out.print("selected='selected'"); %>>二区</option>
				<option value="三区" <%if(rs.getString("do_section").substring(0,2).equals("三区")) out.print("selected='selected'"); %>>三区</option>
				<option value="四区" <%if(rs.getString("do_section").substring(0,2).equals("四区")) out.print("selected='selected'"); %>>四区</option>
				<option value="五区" <%if(rs.getString("do_section").substring(0,2).equals("五区")) out.print("selected='selected'"); %>>五区</option>
				<option value="六区" <%if(rs.getString("do_section").substring(0,2).equals("六区")) out.print("selected='selected'"); %>>六区</option>
				<option value="七区" <%if(rs.getString("do_section").substring(0,2).equals("七区")) out.print("selected='selected'"); %>>七区</option>
				<option value="八区" <%if(rs.getString("do_section").substring(0,2).equals("八区")) out.print("selected='selected'"); %>>八区</option>
			</select>&nbsp;
		<label>栋：</label>
    		<select id="selDor" name="dorSection2">
				<option value="一栋" <%if(rs.getString("do_section").substring(2).equals("一栋")) out.print("selected='selected'"); %>>一栋</option>
				<option value="二栋" <%if(rs.getString("do_section").substring(2).equals("二栋")) out.print("selected='selected'"); %>>二栋</option>
				<option value="三栋" <%if(rs.getString("do_section").substring(2).equals("三栋")) out.print("selected='selected'"); %>>三栋</option>
				<option value="四栋" <%if(rs.getString("do_section").substring(2).equals("四栋")) out.print("selected='selected'"); %>>四栋</option>
			</select>
	</td>
</tr>
<tr>
	<td>宿舍号：<%=rs.getInt("do_number") %></td>
	<td><input id="number" name="upNumber" type="text" value=<%=rs.getInt("do_number") %>></td>
</tr>
<tr>
	<td>宿舍床位数：<%=rs.getInt("do_bed") %></td>
	<td><input id="bed" name="upBed" type="text" value=<%=rs.getInt("do_bed") %>></td>
</tr>
<tr>
	<td>宿舍空床位数：<%=rs.getInt("do_emptybeds") %></td>
	<td><input id="emptybeds" name="upEmptybeds" type="text" value=<%=rs.getInt("do_emptybeds") %>></td>
</tr>
<tr>
	<td>宿舍类型：<%=rs.getString("do_type") %></td>
	<td>
		<select id="selDor" name="dorType">
			<option value="公寓" <%if(rs.getString("do_type").equals("公寓")) out.print("selected='selected'"); %>>公寓</option>
			<option value="普宿" <%if(rs.getString("do_type").equals("普宿")) out.print("selected='selected'"); %>>普宿</option>
		</select>
	</td>
</tr>
<tr>
	<td>宿舍水表底数：<%=rs.getString("do_water") %></td>
	<td><input id="water" name="upWater" type="text" value=<%=rs.getString("do_water") %>></td>
</tr>
<tr>
	<td>宿舍电表底数：<%=rs.getString("do_elec") %></td>
	<td><input id="elec" name="upElec" type="text" value=<%=rs.getString("do_elec") %>></td>
</tr>
<tr>
	<td>备注：<%=rs.getString("do_remark") %></td>
	<td><input id="remark" name="upRemark" type="text" value=<%=rs.getString("do_remark") %>></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input name="submit" type="submit" value="确认修改" onclick="javascript:alert('信息修改成功！')"> 
		<input name="reset" type="reset" value="重置">
	</td>
</tr>
</table>
</form>
<%rs.close(); %>
    	</div>
    </div>
</div>
</body>
</html>