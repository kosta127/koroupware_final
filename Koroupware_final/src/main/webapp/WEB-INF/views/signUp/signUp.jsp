<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var fullAddr = ''; // ���� �ּ� ����
                var extraAddr = ''; // ������ �ּ� ����

                // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
                if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                    fullAddr = data.roadAddress;

                } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
                    fullAddr = data.jibunAddress;
                }

                // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
                if(data.userSelectedType === 'R'){
                    //���������� ���� ��� �߰��Ѵ�.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // �ǹ����� ���� ��� �߰��Ѵ�.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
               // document.getElementById('sample6_postcode').value = data.zonecode; //5�ڸ� �������ȣ ���
                document.getElementById('sample6_address').value = fullAddr;
            }
        }).open();
    }
    
    function cancel() {
    	history.back();
	}
</script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css); 
.main-font1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 55px;
}

.main-font2{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font3{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font4{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #F9A825;
   font-size: 50px;
}
.main-font5{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font6{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 50px;
}
.main-font7{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font8{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #F9A825;
   font-size: 50px;
}
.main-font9{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #0080c0;
   font-size: 50px;
}
.main-font10{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
} 
.logo-font{
 text-align: center;
 margin-top: 30px;
 margin-bottom: 30px; 
}
input{
 margin-top: 6px;
 margin-bottom: 6px;
}
span{
  font-family: 'Noto Sans KR', sans-serif; 
  font-size: 15px;
}
.signUp-submit{
background-color : #0080c0;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.signUp-submit:hover{
background-color : #0080c0;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.cancel-button{
background-color : #E64A19;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.cancel-button:hover{
background-color : #E64A19;
color : white;
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
}
.addressSearch-button{
font-family: 'Noto Sans KR', sans-serif; 
  font-size: 13px;
} 
.font-div{
 text-align : center;
 margin-top: 10px; 
}
  
.center-form{
 border-radius: 15px;
 margin-top : 30px;
 box-shadow: 5px 5px 5px 5px lightgray; 
}

.center-form-bottom{
 margin-top: 40px;
 margin-bottom: 20px; 
}

.bottom-void{
 height: 30px;
}
</style>
</head>
<body>
<div class="col-md-2"></div> <!-- ���� ���� div -->
<div class="col-md-8">
<div class="col-md-12 center-form">
<div class="col-md-12 logo-font">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
</div>
<form action=""> <!-- �� ���� -->
<div class="col-md-12"> 
<div class="col-md-2 font-div"> <!-- ���̵� ����  -->
<span>���̵�</span> 
</div> 
<div class="col-md-4">
<input type="text" class="form-control" name="emp_id">
</div> <!-- ���̵� ��  -->
<div class="col-md-2 font-div"> <!-- �̸� ���� -->
<span>�̸�</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_name">
</div>
</div> <!-- �̸� �� -->
<div class="col-md-12"> <!-- ��й�ȣ ���� -->
<div class="col-md-2 font-div">
<span>��й�ȣ</span>
</div>
<div class="col-md-4">
 <input type="password" class="form-control emp_password1" name="emp_password">
</div>
<div class="col-md-2 font-div"> 
<span>��й�ȣ Ȯ��</span>
</div> 
<div class="col-md-4">
<input type="password" class="form-control emp_password2">
</div>
</div> <!-- ��й�ȣ �� -->
<div class="col-md-12 passError"></div> <!-- ��й�ȣ ����ĭ -->
<div class="col-md-12"> <!-- �ֹι�ȣ ���� -->
<div class="col-md-2 font-div">
<span>�ֹε�Ϲ�ȣ</span>
</div>
<div class="col-md-5">
<input type="text" class="form-control" name="emp_residentnumber_left"> 
</div>
<div class="col-md-5">
<input type="password" class="form-control" name="emp_residentnumber_right">
</div>
</div> <!-- �ֹι�ȣ �� -->
<div class="col-md-12"> <!-- �̸��� ����  -->
<div class="col-md-2 font-div">
<span>�̸���</span>
</div>
<div class="col-md-4">
  <input type="text" class="form-control" name="emp_email">
</div>
<div class="col-md-2 font-div">
<span >�������Ű</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control" name="emp_elec_auth_signkey">
</div>
</div> <!-- �̸��� �� -->
<div class="col-md-12"> <!-- ��ȭ��ȣ ����  -->
<div class="col-md-2 font-div">
<span>��ȭ��ȣ</span>
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="3" class="form-control inputs" name="tel_telephone_left">  
</div> 
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control inputs" name="tel_telephone_center">
</div>
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control" name="tel_telephone_right">
</div> <!-- ��ȭ��ȣ �� --> 
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>�ּ�</span>
</div>
<div class="col-md-8">
<input type="text" id="sample6_address" class="form-control" name="emp_address">
</div>
<div class="col-md-2">
<input type="button" onclick="sample6_execDaumPostcode()" value="�ּ�ã��" class="btn btn-block addressSearch-button"> <!-- butto�±׷� �ϸ� �ȵ� -->
</div>
</div>
<div class="col-md-12 center-form-bottom">
 <div class="col-md-2">
</div>
<div class="col-md-4">
</div>
<div class="col-md-2"></div>
<div class="col-md-2">
<input type="submit" class="btn btn-block signUp-submit" value="Ȯ��"> <!-- �� �� -->
</div>
<div class="col-md-2">
<input type="button" onclick="cancel()" value="���" class="btn btn-block cancel-button"> <!-- ��� ��ư -->
</div>
</div> 
</form>
<div class="col-md-12 bottom-void"></div>
</div>
</div>
<div class="col-md-2"></div> <!-- ������ ���� div -->
</body>
</html>