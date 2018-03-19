<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.BuyDataBeans"%>
<%@ page import="beans.UserDataBeans"%>
<%@ page import=" java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴詳細</title>
<jsp:include page="/baselayout/head.html" />
<%
	UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
	ArrayList<BuyDataBeans> itemDetail = (ArrayList<BuyDataBeans>) request.getAttribute("itemDetail");
%>
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h4 class=" col s12 light">購入詳細</h4>
		</div>
		<!--  購入 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table>
							<thead>
								<tr>
									<th class="center" style="width: 20%;">購入日時</th>
									<th class="center">配送方法</th>
									<th class="center" style="width: 20%">合計金額</th>
								</tr>
							</thead>
							<%
								for (BuyDataBeans item : itemDetail) {
							%>
							<tbody>
								<tr>
									<td class="center"><%=item.getBuyDate()%></td>
									<td class="center"><%=item.getDeliveryMethodName()%></td>
									<td class="center"><%=item.getTotalPrice()%></td>
								</tr>
							</tbody>
							<%
								break;}
							%>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 詳細 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th class="center">商品名</th>
									<th class="center" style="width: 20%">単価</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (BuyDataBeans item : itemDetail) {
								%>
								<tr>
									<td class="center"><%=item.getItemNm()%></td>
									<td class="center"><%=item.getPrice()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
							<tbody>
								<%
									for (BuyDataBeans item : itemDetail) {
								%>
								<tr>
									<td class="center"><%=item.getDeliveryMethodName()%></td>
									<td class="center"><%=item.getDeliveryMethodPrice()%></td>
								</tr>
								<%
									break;}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
</body>
</html>