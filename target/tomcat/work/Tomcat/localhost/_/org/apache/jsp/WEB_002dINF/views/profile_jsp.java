/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-04-28 10:48:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Amicoz</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("<script src=\"js/dropdown.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/settingsform.js\"></script>\r\n");
      out.write("<script src=\"js/searchbox.js\"></script>\r\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=PT+Sans'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("<!-- \t\t<a href=\"/index\"><div id=\"logo\">Amicoz</div></a> -->\r\n");
      out.write("\t\t<a href=\"/frontPage\"><div id=\"logo\">Amicoz</div></a>\r\n");
      out.write("\t\t<div id=\"user\">\r\n");
      out.write("\t\t\t<div id=\"img\"></div>\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" class=\"dropbtn\" onclick=\"dropLink()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s_imgsrc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"userpic\" /> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s_fullname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content\" id=\"profiledrop\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/profile?userid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s_userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">My Profile</a> <a\r\n");
      out.write("\t\t\t\t\t\thref=\"/profile_settings\">Settings</a> <a href=\"/logout\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"logout\">Logout</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t<input type=\"text\" class=\"searchbox\"\r\n");
      out.write("\t\t\t\tplaceholder=\"Search.. ( [firstname] [lastname] ) ex. John Smith\"\r\n");
      out.write("\t\t\t\tmaxlength=\"32\"></input>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<div id=\"userbar\">\r\n");
      out.write("\t\t\t<div id=\"profilepicture\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile_picture}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"profilepic\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"userinformation\">\r\n");
      out.write("\t\t\t\t<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fullname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"profileInfo\">\r\n");
      out.write("\t\t\t\t\t<h1 id = \"profilename\"></h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${hidden_friend_button}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("\t\t\t\t\t<input type=submit value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend_status}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' class='add'\r\n");
      out.write("\t\t\t\t\t\tstyle='background-color: #4CAF50; color: white; font-size: 20px; display: inline-block; cursor: pointer;'\r\n");
      out.write("\t\t\t\t\t\tid='friendButton' onclick=\"manageFriend(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${to_userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(")\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=submit value=Block id=\"blockButton\"\r\n");
      out.write("\t\t\t\t\t\tstyle='background-color: #4CAF50; color: white; font-size: 20px; display: inline-block; cursor: pointer;' />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"box\" class=\"profileposts\">\r\n");
      out.write("\t\t\t<div class=\"title\" style=\"margin-bottom: 5px;\">Timeline</div>\r\n");
      out.write("\t\t\t<ul class=\"timelineposts\" id=\"timelineposts\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var count =0;\r\n");
      out.write("var name;\r\n");
      out.write("var profile_info = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile_information}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("$('#profileInfo').append('<p id=\"profile_information\">');\r\n");
      out.write("$.each(profile_info, function(index, data) {\r\n");
      out.write("\tif(count ==0){\r\n");
      out.write("\t\tname = data;\r\n");
      out.write("\t\tconsole.log(name);\r\n");
      out.write("\t\tcount=count+1;\r\n");
      out.write("\t}else if(count==1){\r\n");
      out.write("\t\tname+= \" \"+data;\r\n");
      out.write("\t\tconsole.log(name);\r\n");
      out.write("\t\tcount=count+1;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tvar info = data;\t\t\r\n");
      out.write("\t\tif(info!=\"\")\r\n");
      out.write("\t\t$('#profileInfo').append(info+'<br>');\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("$('#profileInfo').append('</p>');\r\n");
      out.write("$('#profilename').append(name);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar friendStatusValue = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend_status}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\r\n");
      out.write("\tif(friendStatusValue != 'Remove Friend'){\r\n");
      out.write("\t\t$('#blockButton').hide();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$('#blockButton').click(function(){\r\n");
      out.write("\t\tvar user = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profileUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t\talert(user);\r\n");
      out.write("\t\tvar value = $(this).attr('value');\r\n");
      out.write("\t\tvar flag = 'X';\r\n");
      out.write("\t\tvar newVal=\"\";\r\n");
      out.write("\t\tif(value == 'Block'){\r\n");
      out.write("\t\t\t//alert(value);\r\n");
      out.write("\t\t\tflag = 'Y';\r\n");
      out.write("\t\tnewVal = 'Unblock';\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tflag='N';\r\n");
      out.write("\t\t\tnewVal = 'Block';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\turl: 'updateBlocked',\r\n");
      out.write("\t\t\tdata: {user: user, flag: flag},\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t$('#blockButton').prop('value',newVal);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t });\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function manageFriend(user){\r\n");
      out.write("\t\r\n");
      out.write("\t//alert(\"inside manageFriend\");\r\n");
      out.write("\t//alert(\"data: \"+user);\r\n");
      out.write("\t//alert(\"list id\"+ liId);\r\n");
      out.write("\tvar buttonValue = document.getElementById(\"friendButton\").value;\r\n");
      out.write("\talert(buttonValue);\r\n");
      out.write("\tconsole.log('inside addFriend');\r\n");
      out.write("\t//alert(\"inside addFriend\");\r\n");
      out.write("\tif(buttonValue == 'Add Friend'){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\turl: 'addFriend',\r\n");
      out.write("\t\t\tdata: {user: user},\r\n");
      out.write("\t\t\tsuccess: function(data1){\r\n");
      out.write("\t\t\t\tif(data1 != \"-1\"){\r\n");
      out.write("\t\t\t\t\tconsole.log('inside if success');\r\n");
      out.write("\t\t\t\t\t$('#friendButton').prop('value','Cancel Request');\r\n");
      out.write("\t\t\t\t\t$('#blockButton').hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(buttonValue == 'Confirm Friend'){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\turl: 'confirmFriend',\r\n");
      out.write("\t\t\tdata: {user: user},\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t console.log(data);\r\n");
      out.write("\t\t\t\t//alert(\"success\");\r\n");
      out.write("\t\t\t\tif(data != \"-1\"){\r\n");
      out.write("\t\t\t\t\tconsole.log('inside if success');\r\n");
      out.write("\t\t\t\t\t$('#friendButton').prop('value','Remove Friend');\r\n");
      out.write("\t\t\t\t\t$('#blockButton').show();\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(buttonValue == 'Cancel Request'){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\turl: 'cancelRequest',\r\n");
      out.write("\t\t\tdata: {user: user},\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t //console.log(data1);\r\n");
      out.write("\t\t\t\t//alert(\"success\");\r\n");
      out.write("\t\t\t\tif(data != \"-1\"){\r\n");
      out.write("\t\t\t\t\tconsole.log('inside if success');\r\n");
      out.write("\t\t\t\t\t$('#friendButton').prop('value','Add Friend');\r\n");
      out.write("\t\t\t\t\t$('#blockButton').hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(buttonValue == 'Remove Friend'){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\turl: 'removeFriend',\r\n");
      out.write("\t\t\tdata: {user: user},\r\n");
      out.write("\t\t\tsuccess: function(data1){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t //console.log(data1);\r\n");
      out.write("\t\t\t\t//alert(\"success\");\r\n");
      out.write("\t\t\t\tif(data1 != \"-1\"){\r\n");
      out.write("\t\t\t\t\tconsole.log('inside if success');\r\n");
      out.write("\t\t\t\t\t$('#friendButton').prop('value','Add Friend');\r\n");
      out.write("\t\t\t\t\t$('#blockButton').hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true; \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var posts = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${groupPosts}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("console.log(\"posts: \" + posts);\r\n");
      out.write("console.log(posts);\r\n");
      out.write("$.each(posts,function(index,data){\r\n");
      out.write("\tvar pid = data.postID;\r\n");
      out.write("\tvar userInfo = '<div class=\"userinfo\"><img src=\"'+data.profilePicUrl+'\" class=\"profilepic\" /> <span class=\"username\"><a href=\"profile?userid='+data.userID+'\">'+data.userName+'</a></span><br/><span class=\"datetime\">'+data.time+'</span><br/></div>';\r\n");
      out.write("\t\r\n");
      out.write("\tvar postContent = '<div class=\"post\">'+data.postText+'</div>';\r\n");
      out.write("\tconsole.log(postContent);\r\n");
      out.write("\tvar likesDislikes = '<div class=\"likebar\" hidden><a href=\"#likes\">'+data.likeCount+'<img src=\"imgs/like.png\"/ class=\"like\"></a><a href=\"#dislikes\">'+data.dislikeCount+'<img src=\"imgs/dislike.png\"/ class=\"like\"></a></div>';\r\n");
      out.write("\t\r\n");
      out.write("\tconsole.log(\"posts id\" + data.postID);\r\n");
      out.write("\tconsole.log(\"posts by: \"+data.userName);\r\n");
      out.write("\tconsole.log(\"post time: \"+data.time);\r\n");
      out.write(" \tvar commentsList = \"<ul id='comments\"+data.postID+\"' class='comments'>\";\r\n");
      out.write("\tif(typeof data.comments !== 'undefined') {\r\n");
      out.write("\t\tvar comments = data.comments;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.each(comments,function(index2,data2){\r\n");
      out.write("\t\t\tcommentsList += '<li><img src=\"'+data2.profilePicUrl+'\" class=\"friendcommentpic\" /> <span class=\"username\"><a href=\"profile?userid='+data.userID+'\">'+data.userName+'</a></span><div class=\"usercomment\">'+data2.comment+'</div></li>';\r\n");
      out.write("\t\t\tconsole.log(\"comment id\"+data2.commentId);\r\n");
      out.write("\t\t\tconsole.log(\"comment\"+data2.comment);\r\n");
      out.write("\t\t\tconsole.log(\"timestamp\"+data2.timeStamp);\r\n");
      out.write("\t\t\tconsole.log(\"username\"+data2.userName);\r\n");
      out.write("\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tcommentsList += \"</ul>\";\r\n");
      out.write("\tcommentsList += '<img src=\"https://www.accrinet.com/clientuploads/authorship_profile.jpg\" class=\"mycommentpic\" /><textarea id=\"commentbox\" class=\"commentbox\" placeholder=\"Say something!\"></textarea>';\r\n");
      out.write(" \t$(\"#timelineposts\").append(userInfo+postContent+likesDislikes+commentsList);\r\n");
      out.write(" \tconsole.log(\"info.....\");\r\n");
      out.write(" \t\t\tconsole.log(userInfo);\r\n");
      out.write(" \t\t\tconsole.log(likesDislikes);\r\n");
      out.write(" \t\t\t\t\t//$(\"#timelineposts\").append(userInfo+postContent+likesDislikes);\r\n");
      out.write("\t\t\t\t\t$('.commentbox').keypress(function (e) {\r\n");
      out.write("\t\t\t\t\t\tvar comment = $(this).val();\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"keypress\");\r\n");
      out.write("\t\t\t\t\t    if (e.which == 13) {\r\n");
      out.write("\t\t\t\t\t      if (comment.length < 1) {\r\n");
      out.write("\t\t\t\t\t        alert(\"Your comment must have at least 1 character in order to be valid!\");\r\n");
      out.write("\t\t\t\t\t      } else if (comment.length > 250) {\r\n");
      out.write("\t\t\t\t\t        alert(\"Your comment cannot exceed 250 characters!\");\r\n");
      out.write("\t\t\t\t\t      } else {\r\n");
      out.write("\t\t\t\t\t    \t   comment = $(this).val();\r\n");
      out.write("\t\t\t\t\t\t\t   console.log(comment);\r\n");
      out.write("\t\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t    \t  $.ajax({\r\n");
      out.write("\t\t\t\t\t    \t  \t\r\n");
      out.write("\t\t\t\t\t \t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\t\t\t        url:\"/commentSave\",\r\n");
      out.write("\t\t\t\t\t\t        dataType: \"json\", \t\r\n");
      out.write("\t\t\t\t\t\t        data : {\r\n");
      out.write("\t\t\t\t\t\t        \t\"userId\" :  uid,\r\n");
      out.write("\t\t\t\t\t\t        \t\"comment\" : comment,\r\n");
      out.write("\t\t\t\t\t\t        \t\"postId\" : pid\r\n");
      out.write("\t\t\t\t\t\t        },\t\r\n");
      out.write("\t\t\t\t\t\t\t\tsuccess: function(data3){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(\"commentSave returns :\"+data3);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//window.location.href = \"/group.jsp\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//alert(data);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//$(\"#success_message\").html(\"\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(data3==1){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#comments\"+data.postID).append('<li><img src=\"\" class=\"friendcommentpic\" /> <span class=\"username\"><a href=\"profile?userid='+data.userID+'\">'+data.userName+'</a></span><div class=\"usercomment\">' + comment + '</div></li>');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"in else\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t       \r\n");
      out.write("\t\t\t\t        //alert($(this).parent().parent().get(0).tagName + \" \" + $(this).parent().parent().attr('class'));\r\n");
      out.write("\t\t\t\t        // Returns successful data submission message when the entered information is stored in database.\r\n");
      out.write("\t\t\t\t        console.log(\"In comment enter\");\r\n");
      out.write("\t\t\t\t    \t   \r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t\t      return false;    //<---- Add this line\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t  });\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}