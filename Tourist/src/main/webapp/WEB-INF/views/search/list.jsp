<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../nav.jsp" %>
<script>
$(document).ready(function(){
	var list=${map.list};
	var body=${map.body};
	getList(list,body);
});
function getList(list,body){
	str="";
	console.log(body);
	console.log(list);
	$(list).each(function(key,item){
		 str+="<tr>";
		 if(item.firstimage2===undefined){
			 str+="<td><img src='${path}/resources/img/noimage.jpg' style='height:200px; width: 200px;' class='img-thumbnail'></td>";
		 }else str+="<td><a href='${path}/keyword/getDetail?contentId="+item.contentid+"'><img src='"+item.firstimage2+"' style='height:200px; width: 200px;' class='img-thumbnail'></a></td>";
		 if(item.addr1===undefined){
			 str+="<td>제목이없습니다!</td>"
		 } else str+="<td>"+item.title+"</td>";
		if(item.addr1===undefined){
			str+="<td>주소가없습니다</td>";
		}else str+="<td>"+item.addr1+"</td>";
		if(item.tel===undefined){
			str+="<td>번호가없습니다</td>";
		}else 	str+="<td>"+item.tel+"</td>";
		str+="<td>"+moment(item.modifiedtime).format('MMMM Do YYYY, h:mm:ss a')+"</td></tr>"; 		
	});
	
	$("#tbo").append(str);
}
</script>
<div class="container">
	<h2>검색결과</h2>  
	<div class="table-responsive">
	  <table class="table">
	    <thead>
	      <tr>
		<th>(상세보기 이미지 클릭)</th>
		<th>타이틀</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>등록일</th>		
	      </tr>
	    </thead>
	    <tbody id="tbo">
	     
	    </tbody>
	  </table>
	  <nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  <c:if test="${map.pageMaker.perPage}">
				 <li class="page-item">
      <a class="page-link" href="${path}/keyword/search?pageNo=${map.pageMaker.startBlock-1}&areaSelect=${areaSelect}
			      &districtSelect=${districtSelect}&typeSelect=${typeSelect}" 
      aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
	</c:if>
	
	<c:forEach begin="${map.pageMaker.startBlock}"
				end="${map.pageMaker.endBlock}" var="num">
				<c:choose>
					<c:when test="${map.pageMaker.critia.page==num}">
					<li class="page-item active">
					<li class="page-item active"><span class="page-link"> ${num}
									<span class="sr-only">(current)</span>
							</span></li>
					</c:when>
					<c:otherwise>
					 <li class="page-item"><a class="page-link" href="${path}/keyword/search?pageNo=${num}&areaSelect=${areaSelect}
			      &districtSelect=${districtSelect}&typeSelect=${typeSelect}">${num}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${map.pageMaker.nextPage&&map.pageMaker.endBlock>0}">
				 <li class="page-item">
			      <a class="page-link" href="${path}/keyword/search?pageNo=${map.pageMaker.endBlock+1}&areaSelect=${areaSelect}
			      &districtSelect=${districtSelect}&typeSelect=${typeSelect}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			        <span class="sr-only">Next</span>
			      </a>
			    </li>
			</c:if>
   
  </ul>
</nav>
	</div>
</div>
