<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Store Application</title>
</head>
<body>
		<center>
		<h1>Books Management</h1>
		<h2>
		  <a href="/new">Add New Book</a>
		  <a href="/list">List All Book</a>
		</h2>
		</center>
		<div align="center">
			<c:if test="${book ! = null}">
			<form action="update" method="post">
			</c:if>
			<c:if test="${book == null}">
			<form action = "insert" method="post">
			</c:if>
			<table border="1" cellpadding="5">
			<caption>
			  <h2>
			  <c:if test="${book !=null}"></h2>
			  Edit Book
			  </c:if>
			  <c:if test="${book == null}">
			  Add New Book
			  </c:if>
			  </h2>
			</caption>
			<c:if test="${book !=null }">
			<input type="hidden" name="id" value="<c:out value="${book.id }" />"/>
			</c:if>
			<tr>
			<th>Title: </th>
			<td>
			<input type="text" name="title" sixe="30" value="<c:out value="${book.title}"	/>"
			/>
			</td>		  
			  </tr>
			  <tr>
			  <th>Author : </th>
			  <td>
			  <input type="text" name="author" size="30" value="<c:out value="${book.author}" />"
			  />
			  </td>
			  </tr>
			  <tr>
			  <th> Price: </th>
			  <td>
			  <input type="text" name="price" size="4" value="<c:out value="${book.price}"  />"
			  />
			  </td>
			  </tr>
			  <tr>
			  <td aligh="center">
			  <input type="submit" value="Save"  />
			  </td>
			  </tr>
			  </table>
			  </form>
			  </div>
			  </body>
			  </html>
			  
			  
			  
			  
			  
			  
			
			
			</caption></table>			
			
			
			
			</form>
		
		</div>

</body>
</html>