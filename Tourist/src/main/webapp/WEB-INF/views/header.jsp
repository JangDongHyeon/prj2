
<%@include file="nav.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
var ch=[false,false,false];
	$(document).ready(function(){
		getArea(1);
	});
function getArea(areaPage){
	
	$.ajax({
		url:'${path}/keyword/area/'+areaPage,
		dataType:'json',
		success:function(data){
			str="";
			console.log(data);
			 str+="<select class='form-control' id='sel1' name='areaSelect'>";
			 str+="<option value='sel'>선택해주세요</option>"
			$(data).each(function(key,item){
				 str+="<option value='"+item.code+"'>"+item.name+"</option>";
			});
			if(areaPage===1){
			str+="<option value='nextSel1'>다음</option>";
			}else{
				str+="<option value='perSel1'>이전</option>";
			}
			
			str+="</select>";
			$("#sel1ra").append(str);
			
			$("select[name='areaSelect']").change(function(){
				var code = $(this).val();
				if(code==='nextSel1'){
						$("#sel1").remove();
						getArea(2);
				}else if(code==='perSel1'){
					$("#sel1").remove();
					getArea(1);
				}else if(code==='sel'){
					 $("select[name='districtSelect']").remove();
					 $("#sel1").remove();
					 getArea(1);
				}
				else{
					if(ch[0]){
						 $("select[name='districtSelect']").remove();
					}
					if(ch[1]){
						 $("select[name='typeSelect']").remove();
					}
					getAreaGu(code,1);
				}
			  	
			});
		}
	});
}
function getAreaGu(areaCode,areaPage){	
	$.ajax({
		url:'${path}/keyword/area/'+areaCode+'/'+areaPage,
		dataType:'json',
		success:function(data){
			ch[0]=true;
			str="";
			 str+="<select class='form-control' id='sel2' name='districtSelect'>";
			 str+="<option value='sel'>선택해주세요</option>"
			 $(data).each(function(key,item){
				 str+="<option value='"+item.code+"'>"+item.name+"</option>"; 
			 });
			 if(areaPage===1){
					str+="<option value='nextSel2'>다음</option>";
					}else{
						str+="<option value='perSel2'>이전</option>";
					}
			 str+="</select>";
			 
			 $("#sel2ra").append(str);
			 
			 $("select[name='districtSelect']").change(function(){
				 var code = $(this).val();
					if(code==='nextSel2'){
							$("#sel2").remove();
							getAreaGu(areaCode,areaPage+1);
					}else if(code==='perSel2'){
						$("#sel2").remove();
						getAreaGu(areaCode,areaPage-1);
					}else{
						if(ch[1]){
							$("#sel3").remove();
						}
						typeSelect();
					}
			 });
			 
			 
		},
		error:function(){
			$("#sel2").remove();
			str="";
			 str+="<select class='form-control' id='sel2' name='districtSelect'>";
			 str+="<option>선택</option>";
			 str+="<option value='perSel2'>이전</option>";
 			str+="</select>";
			 $("#sel2ra").append(str);
			 $("select[name='districtSelect']").change(function(){
					$("#sel2").remove();
					getAreaGu(areaCode,areaPage-1);
			 });
			 }
		
	});
}
function typeSelect(){
	$.ajax({
		url:'${path}/keyword/typeSelect',
		dataType:'json',
		success:function(data){
			str="";
			ch[1]=true;
			 str+="<select class='form-control' id='sel3' name='typeSelect'>";
			 str+="<option value='sel'>선택해주세요</option>"
			$(data).each(function(key,item){
				 str+="<option value='"+item.code+"'>"+item.name+"</option>"; 
			});
 			str+="</select>";
			 $("#sel3ra").append(str);
		}
	});
}

</script>
<header class="masthead text-center text-white d-flex">
	<div class="container my-auto">
	<form action="${path}/keyword/search">
		<div class="row">
			<div class="col-lg-6 mx-auto">
				<h1 class="text-uppercase">
					<strong>관광지 놀러가자!!!</strong>
				</h1>
				<hr>
			</div>
		</div>
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label id="sel1ra">지역</label>
			</div>
		</div>
		
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label  id="sel2ra">지역구</label>

			</div>
		</div>
		
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label id="sel3ra">타입</label> 

			</div>
		</div>
		

		<div class="col-lg-10 mx-auto">
			<input class="form-control" type="text" id="formGroupInputLarge" name="keyword"
				placeholder="가고싶은 관광지 키워드 검색">
		</div>
		<div class="col-lg-10 mx-auto">
			<input type="submit" class="btn btn-danger btn-block" value="검색">
		</div>
		</form>
	</div>
</header>