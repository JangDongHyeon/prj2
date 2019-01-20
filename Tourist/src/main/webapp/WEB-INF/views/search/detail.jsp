<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../nav.jsp" %>
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3563eb87889701f4bab3b419b70c1471" charset="utf-8"></script>
<script>
function mapCon(obj){
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
mapOption = { 
        center: new daum.maps.LatLng(obj.mapx, obj.mapy), // 지도의 중심좌표
        level: obj.mlevel // 지도의 확대 레벨
    };


var map = new daum.maps.Map(container, mapOption); //지도 생성 및 객체 리턴

//마커가 표시될 위치입니다 
var markerPosition  = new daum.maps.LatLng(obj.mapx, obj.mapy); 

// 마커를 생성합니다
var marker = new daum.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
	
}
$(document).ready(function(){
	var obj=${detailObj};
	getObj(obj);
	mapCon(obj);
});
function getObj(obj){
	str="";
	str2="";
	str+="<img src='"+obj.firstimage+"' class='img-thumbnail' style='height:350px; width: 500px;'>"
	$("#getImg").append(str);
	if(obj.title==='undefined') str2+="<p>제목:"+obj.title+"</p>";
	else str2+="<p>제목:제목이 없습니다</p>";
	if(obj.tel==='undefined') str2+="<p>전화번호:"+obj.tel+"</p>";
	else str2+="<p>전화번호:번호가 없습니다</p>";
	str2+="<p>등록일:"+moment(obj.modifiedtime).format('MMMM Do YYYY, h:mm:ss a')+"</p>";
	if(obj.homepage==='undefined') str2+="<p>홈페이지주소:<a href='"+obj.homepage+"'>"+obj.homepage+"</a></p>";
	else str2+="<p>홈페이지주소:홈페이지주소가 없습니다</p>";
	if(obj.addr1) str2+="<p>주소:"+obj.addr1+"</p>";
	else str2+="<p>주소:주소가 없습니다</p>"
	$("#getTourist").append(str2);
}	

</script>
 <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h1>영화상세</h1>
                    <hr class="star-primary">

                    
                </div>
                <div class="row">
                	 	<div class='col-sm-6 portfolio-item' id="getImg">
                    	 
                    	</div>
                    	<div class='col-sm-6 portfolio-item' id="getTourist">
                    	 
                    	</div>
                </div>
                   <div class="row">
                      <div class="col-lg-12 text-center">
                      		<div id="map" style="width:600px;height:600px;"></div>
                      </div>     
                   </div>
       		</div>
       	</div>
 </section>