<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Vessel Owner</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
    </head>
    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>
                <form method="POST" enctype="multipart/form-data" action="/vessel/add_vessel_owner">
                <%@ include file="add_owner_header.jsp" %>
                     
                    <!-- Main page content-->
                    <div class="container-fluid px-4">
                        <!-- Account page navigation--> 
                        <nav class="nav nav-borders">
                            <a class="nav-link active ms-0">Profile</a>
                            <a class="nav-link" href="/vessel/add_other_docs">Documents</a>
                        </nav>
                        <hr class="mt-0 mb-4" />
                        <div class="row">
                            <div class="col-xl-2">
                                <!-- Profile picture card-->
                                <div class="card mb-2 mb-xl-0">
                                    <div class="card-header">Vessel Owner Picture</div>
                                    <div class="card-body text-center">
										<!-- Profile picture image-->
										 <img class="img-account-profile rounded-circle mb-2"
											src="../assets/img/illustrations/profiles/profile-1.png"
											alt="" id='preview'/> 
											
											<input type='file' id='file-input' hidden name="image">																						
											
										<div id='container'>
											<!-- Profile picture help block-->
											<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
											<!-- Profile picture upload button-->
											<button id="myBtn" class="btn btn-primary" type="button">Upload an image</button>
											
										</div>
									
								</div>
                                </div>
                            </div>
                            <div class="col-xl-10">
                                <!-- Account details card-->
                                <div class="card mb-6">
                                    <div class="card-header">Add Profile</div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="ownerName">Vessel Owner Name</label>
                                                    <input class="form-control" id="ownerName" type="text" placeholder="Enter vessel owner name" value="" name="ownerName" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="website">WebSite</label>
                                                    <input class="form-control" id="website" type="text" placeholder="Enter company website address" value="" name="website"/>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="emailId">EmailID</label>
                                                    <input class="form-control" id="emailId" type="text" placeholder="Enter company email ID" value="" name="emailId"/>
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="primaryFlag" name="primaryFlag">Primary Flag</label>
												<select class="form-select" aria-label="Default select example">
													<option selected disabled>Select a Primary Flag:</option>
													<option value="xd">Adelie Land</option><option value="af" >Afghanistan</option><option value="ax" >Aland Islands</option><option value="xc" >Alaska</option><option value="al" >Albania</option><option value="dz" >Algeria</option><option value="as" >American Samoa</option><option value="ad" >Andorra</option><option value="ao" >Angola</option><option value="ai" >Anguilla</option><option value="aq" >Antarctica</option><option value="ag" >Antigua &amp; Barbuda</option><option value="ar" >Argentina</option><option value="am" >Armenia</option><option value="aw" >Aruba</option><option value="xe" >Ascension Island</option><option value="au" >Australia</option><option value="at" >Austria</option><option value="az" >Azerbaijan</option><option value="xa" >Azores</option><option value="bs" >Bahamas</option><option value="bh" >Bahrain</option><option value="bd" >Bangladesh</option><option value="bb" >Barbados</option><option value="by" >Belarus</option><option value="be" >Belgium</option><option value="bz" >Belize</option><option value="bj" >Benin</option><option value="bm" >Bermuda</option><option value="bt" >Bhutan</option><option value="bo" >Bolivia</option><option value="bq" >Bonaire,St Eustatius &amp; Saba</option><option value="ba" >Bosnia &amp; Herzegovina</option><option value="bw" >Botswana</option><option value="br" >Brazil</option><option value="io" >British Indian Ocean Ter.</option><option value="vg" >British Virgin Islands</option><option value="bn" >Brunei</option><option value="bg" >Bulgaria</option><option value="bf" >Burkina Faso</option><option value="bi" >Burundi</option><option value="kh" >Cambodia</option><option value="cm" >Cameroon</option><option value="ca" >Canada</option><option value="cv" >Cape Verde</option><option value="ky" >Cayman Islands</option><option value="cf" >Central Africa Rep (CAR)</option><option value="td" >Chad</option><option value="cl" >Chile</option><option value="cn" >China</option><option value="cx" >Christmas Island</option><option value="cc" >Cocos Islands</option><option value="co" >Colombia</option><option value="km" >Comoros</option><option value="cg" >Congo</option><option value="ck" >Cook Islands</option><option value="cr" >Costa Rica</option><option value="ci" >Cote d&#39;Ivoire</option><option value="hr" >Croatia</option><option value="xf" >Crozet Archipelago</option><option value="cu" >Cuba</option><option value="cw" >Curacao</option><option value="cy" >Cyprus</option><option value="cz" >Czech Rep</option><option value="kp" >DPR Korea</option><option value="cd" >DR Congo</option><option value="dk" >Denmark</option><option value="dj" >Djibouti</option><option value="dm" >Dominica</option><option value="do" >Dominican Rep</option><option value="tl" >East Timor</option><option value="ec" >Ecuador</option><option value="eg" >Egypt</option><option value="sv" >El Salvador</option><option value="gq" >Equatorial Guinea</option><option value="er" >Eritrea</option><option value="ee" >Estonia</option><option value="et" >Ethiopia</option><option value="fo" >Faeroe Islands</option><option value="fk" >Falkland Islands</option><option value="fj" >Fiji</option><option value="fi" >Finland</option><option value="fr" >France</option><option value="pf" >French Polynesia</option><option value="ga" >Gabon</option><option value="gm" >Gambia</option><option value="ge" >Georgia</option><option value="de" >Germany</option><option value="gh" >Ghana</option><option value="gi" >Gibraltar</option><option value="gr" >Greece</option><option value="gl" >Greenland</option><option value="gd" >Grenada</option><option value="gp" >Guadeloupe</option><option value="gu" >Guam</option><option value="gt" >Guatemala</option><option value="gg" >Guernsey</option><option value="gf" >Guiana</option><option value="gn" >Guinea</option><option value="gw" >Guinea-Bissau</option><option value="gy" >Guyana</option><option value="ht" >Haiti</option><option value="hm" >Heard Isl &amp; McDonald Isls</option><option value="hn" >Honduras</option><option value="hk" >Hong Kong</option><option value="hu" >Hungary</option><option value="is" >Iceland</option><option value="in" >India</option><option value="id" >Indonesia</option><option value="ir" >Iran</option><option value="iq" >Iraq</option><option value="ie" >Ireland</option><option value="im" >Isle of Man</option><option value="il" >Israel</option><option value="it" >Italy</option><option value="jm" >Jamaica</option><option value="jp" >Japan</option><option value="je" >Jersey</option><option value="jo" >Jordan</option><option value="kz" >Kazakhstan</option><option value="ke" >Kenya</option><option value="xg" >Kerguelen Islands</option><option value="ki" >Kiribati</option><option value="kr" >Korea</option><option value="kw" >Kuwait</option><option value="kg" >Kyrgyz Rep</option><option value="la" >Laos</option><option value="lv" >Latvia</option><option value="lb" >Lebanon</option><option value="ls" >Lesotho</option><option value="lr" >Liberia</option><option value="ly" >Libya</option><option value="li" >Liechtenstein</option><option value="lt" >Lithuania</option><option value="lu" >Luxembourg</option><option value="mo" >Macao</option><option value="mk" >Macedonia</option><option value="mg" >Madagascar</option><option value="xb" >Madeira</option><option value="mw" >Malawi</option><option value="my" >Malaysia</option><option value="mv" >Maldives</option><option value="ml" >Mali</option><option value="mt" >Malta</option><option value="mh" >Marshall Islands</option><option value="mq" >Martinique</option><option value="mr" >Mauritania</option><option value="mu" >Mauritius</option><option value="yt" >Mayotte</option><option value="mx" >Mexico</option><option value="fm" >Micronesia</option><option value="md" >Moldova</option><option value="mc" >Monaco</option><option value="mn" >Mongolia</option><option value="me" >Montenegro</option><option value="ms" >Montserrat</option><option value="ma" >Morocco</option><option value="mz" >Mozambique</option><option value="mm" >Myanmar</option><option value="mp" >N. Mariana Isl</option><option value="na" >Namibia</option><option value="nr" >Nauru</option><option value="np" >Nepal</option><option value="nl" >Netherlands</option><option value="an" >Netherlands Antilles</option><option value="nc" >New Caledonia</option><option value="nz" >New Zealand</option><option value="ni" >Nicaragua</option><option value="ne" >Niger</option><option value="ng" >Nigeria</option><option value="nu" >Niue</option><option value="nf" >Norfolk Island</option><option value="no" >Norway</option><option value="om" >Oman</option><option value="pk" >Pakistan</option><option value="pw" >Palau</option><option value="ps" >Palestine</option><option value="pa" >Panama</option><option value="pg" >Papua New Guinea</option><option value="py" >Paraguay</option><option value="pe" >Peru</option><option value="ph" >Philippines</option><option value="pn" >Pitcairn Island</option><option value="pl" >Poland</option><option value="pt" >Portugal</option><option value="pr" >Puerto Rico</option><option value="qa" >Qatar</option><option value="re" >Reunion</option><option value="ro" >Romania</option><option value="ru" >Russia</option><option value="rw" >Rwanda</option><option value="gs" >S.Georgia &amp; S.Sandwich Isls</option><option value="sh" >Saint Helena</option><option value="mf" >Saint Martin (FR)</option><option value="ws" >Samoa</option><option value="sm" >San Marino</option><option value="st" >Sao Tome &amp; Principe</option><option value="sa" >Saudi Arabia</option><option value="sn" >Senegal</option><option value="rs" >Serbia</option><option value="sc" >Seychelles</option><option value="sl" >Sierra Leone</option><option value="sg" >Singapore</option><option value="sx" >Sint Maarten (NL)</option><option value="sk" >Slovakia</option><option value="si" >Slovenia</option><option value="sb" >Solomon Islands</option><option value="so" >Somalia</option><option value="za" >South Africa</option><option value="ss" >South Sudan</option><option value="es" >Spain</option><option value="lk" >Sri Lanka</option><option value="kn" >St Kitts &amp; Nevis</option><option value="lc" >St Lucia</option><option value="xi" >St Paul &amp; Amsterdam Isl</option><option value="pm" >St Pierre &amp; Miquelon</option><option value="vc" >St Vincent &amp; Grenadines</option><option value="sd" >Sudan</option><option value="sr" >Suriname</option><option value="sj" >Svalbard &amp; Jan Mayen</option><option value="sz" >Swaziland</option><option value="se" >Sweden</option><option value="ch" >Switzerland</option><option value="sy" >Syria</option><option value="xh" >Tahiti</option><option value="tw" >Taiwan</option><option value="tj" >Tajikistan </option><option value="tz" >Tanzania</option><option value="th" >Thailand</option><option value="tg" >Togolese Rep</option><option value="tk" >Tokelau</option><option value="to" >Tonga</option><option value="tt" >Trinidad &amp; Tobago</option><option value="tn" >Tunisia</option><option value="tr" >Turkey</option><option value="tm" >Turkmenistan</option><option value="tc" >Turks &amp; Caicos Isl</option><option value="tv" >Tuvalu</option><option value="um" >US Minor Outlying Isls</option><option value="vi" >US Virgin Islands</option><option value="ug" >Uganda</option><option value="ua" >Ukraine</option><option value="ae" >United Arab Emirates (UAE)</option><option value="gb" >United Kingdom (UK)</option><option value="us" >United States (USA)</option><option value="zz" >Unknown</option><option value="uy" >Uruguay</option><option value="uz" >Uzbekistan</option><option value="vu" >Vanuatu</option><option value="va" >Vatican</option><option value="ve" >Venezuela</option><option value="vn" >Vietnam</option><option value="wf" >Wallis and Futuna</option><option value="eh" >Western Sahara</option><option value="ye" >Yemen</option><option value="zm" >Zambia</option><option value="zw" >Zimbabwe</option>
												</select>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="regFlag">Registered Flag</label>
												<select class="form-select" aria-label="Default select example" name="regFlag">
													<option selected disabled>Select a Registered Flag:</option>
													<option value="xd">Adelie Land</option><option value="af" >Afghanistan</option><option value="ax" >Aland Islands</option><option value="xc" >Alaska</option><option value="al" >Albania</option><option value="dz" >Algeria</option><option value="as" >American Samoa</option><option value="ad" >Andorra</option><option value="ao" >Angola</option><option value="ai" >Anguilla</option><option value="aq" >Antarctica</option><option value="ag" >Antigua &amp; Barbuda</option><option value="ar" >Argentina</option><option value="am" >Armenia</option><option value="aw" >Aruba</option><option value="xe" >Ascension Island</option><option value="au" >Australia</option><option value="at" >Austria</option><option value="az" >Azerbaijan</option><option value="xa" >Azores</option><option value="bs" >Bahamas</option><option value="bh" >Bahrain</option><option value="bd" >Bangladesh</option><option value="bb" >Barbados</option><option value="by" >Belarus</option><option value="be" >Belgium</option><option value="bz" >Belize</option><option value="bj" >Benin</option><option value="bm" >Bermuda</option><option value="bt" >Bhutan</option><option value="bo" >Bolivia</option><option value="bq" >Bonaire,St Eustatius &amp; Saba</option><option value="ba" >Bosnia &amp; Herzegovina</option><option value="bw" >Botswana</option><option value="br" >Brazil</option><option value="io" >British Indian Ocean Ter.</option><option value="vg" >British Virgin Islands</option><option value="bn" >Brunei</option><option value="bg" >Bulgaria</option><option value="bf" >Burkina Faso</option><option value="bi" >Burundi</option><option value="kh" >Cambodia</option><option value="cm" >Cameroon</option><option value="ca" >Canada</option><option value="cv" >Cape Verde</option><option value="ky" >Cayman Islands</option><option value="cf" >Central Africa Rep (CAR)</option><option value="td" >Chad</option><option value="cl" >Chile</option><option value="cn" >China</option><option value="cx" >Christmas Island</option><option value="cc" >Cocos Islands</option><option value="co" >Colombia</option><option value="km" >Comoros</option><option value="cg" >Congo</option><option value="ck" >Cook Islands</option><option value="cr" >Costa Rica</option><option value="ci" >Cote d&#39;Ivoire</option><option value="hr" >Croatia</option><option value="xf" >Crozet Archipelago</option><option value="cu" >Cuba</option><option value="cw" >Curacao</option><option value="cy" >Cyprus</option><option value="cz" >Czech Rep</option><option value="kp" >DPR Korea</option><option value="cd" >DR Congo</option><option value="dk" >Denmark</option><option value="dj" >Djibouti</option><option value="dm" >Dominica</option><option value="do" >Dominican Rep</option><option value="tl" >East Timor</option><option value="ec" >Ecuador</option><option value="eg" >Egypt</option><option value="sv" >El Salvador</option><option value="gq" >Equatorial Guinea</option><option value="er" >Eritrea</option><option value="ee" >Estonia</option><option value="et" >Ethiopia</option><option value="fo" >Faeroe Islands</option><option value="fk" >Falkland Islands</option><option value="fj" >Fiji</option><option value="fi" >Finland</option><option value="fr" >France</option><option value="pf" >French Polynesia</option><option value="ga" >Gabon</option><option value="gm" >Gambia</option><option value="ge" >Georgia</option><option value="de" >Germany</option><option value="gh" >Ghana</option><option value="gi" >Gibraltar</option><option value="gr" >Greece</option><option value="gl" >Greenland</option><option value="gd" >Grenada</option><option value="gp" >Guadeloupe</option><option value="gu" >Guam</option><option value="gt" >Guatemala</option><option value="gg" >Guernsey</option><option value="gf" >Guiana</option><option value="gn" >Guinea</option><option value="gw" >Guinea-Bissau</option><option value="gy" >Guyana</option><option value="ht" >Haiti</option><option value="hm" >Heard Isl &amp; McDonald Isls</option><option value="hn" >Honduras</option><option value="hk" >Hong Kong</option><option value="hu" >Hungary</option><option value="is" >Iceland</option><option value="in" >India</option><option value="id" >Indonesia</option><option value="ir" >Iran</option><option value="iq" >Iraq</option><option value="ie" >Ireland</option><option value="im" >Isle of Man</option><option value="il" >Israel</option><option value="it" >Italy</option><option value="jm" >Jamaica</option><option value="jp" >Japan</option><option value="je" >Jersey</option><option value="jo" >Jordan</option><option value="kz" >Kazakhstan</option><option value="ke" >Kenya</option><option value="xg" >Kerguelen Islands</option><option value="ki" >Kiribati</option><option value="kr" >Korea</option><option value="kw" >Kuwait</option><option value="kg" >Kyrgyz Rep</option><option value="la" >Laos</option><option value="lv" >Latvia</option><option value="lb" >Lebanon</option><option value="ls" >Lesotho</option><option value="lr" >Liberia</option><option value="ly" >Libya</option><option value="li" >Liechtenstein</option><option value="lt" >Lithuania</option><option value="lu" >Luxembourg</option><option value="mo" >Macao</option><option value="mk" >Macedonia</option><option value="mg" >Madagascar</option><option value="xb" >Madeira</option><option value="mw" >Malawi</option><option value="my" >Malaysia</option><option value="mv" >Maldives</option><option value="ml" >Mali</option><option value="mt" >Malta</option><option value="mh" >Marshall Islands</option><option value="mq" >Martinique</option><option value="mr" >Mauritania</option><option value="mu" >Mauritius</option><option value="yt" >Mayotte</option><option value="mx" >Mexico</option><option value="fm" >Micronesia</option><option value="md" >Moldova</option><option value="mc" >Monaco</option><option value="mn" >Mongolia</option><option value="me" >Montenegro</option><option value="ms" >Montserrat</option><option value="ma" >Morocco</option><option value="mz" >Mozambique</option><option value="mm" >Myanmar</option><option value="mp" >N. Mariana Isl</option><option value="na" >Namibia</option><option value="nr" >Nauru</option><option value="np" >Nepal</option><option value="nl" >Netherlands</option><option value="an" >Netherlands Antilles</option><option value="nc" >New Caledonia</option><option value="nz" >New Zealand</option><option value="ni" >Nicaragua</option><option value="ne" >Niger</option><option value="ng" >Nigeria</option><option value="nu" >Niue</option><option value="nf" >Norfolk Island</option><option value="no" >Norway</option><option value="om" >Oman</option><option value="pk" >Pakistan</option><option value="pw" >Palau</option><option value="ps" >Palestine</option><option value="pa" >Panama</option><option value="pg" >Papua New Guinea</option><option value="py" >Paraguay</option><option value="pe" >Peru</option><option value="ph" >Philippines</option><option value="pn" >Pitcairn Island</option><option value="pl" >Poland</option><option value="pt" >Portugal</option><option value="pr" >Puerto Rico</option><option value="qa" >Qatar</option><option value="re" >Reunion</option><option value="ro" >Romania</option><option value="ru" >Russia</option><option value="rw" >Rwanda</option><option value="gs" >S.Georgia &amp; S.Sandwich Isls</option><option value="sh" >Saint Helena</option><option value="mf" >Saint Martin (FR)</option><option value="ws" >Samoa</option><option value="sm" >San Marino</option><option value="st" >Sao Tome &amp; Principe</option><option value="sa" >Saudi Arabia</option><option value="sn" >Senegal</option><option value="rs" >Serbia</option><option value="sc" >Seychelles</option><option value="sl" >Sierra Leone</option><option value="sg" >Singapore</option><option value="sx" >Sint Maarten (NL)</option><option value="sk" >Slovakia</option><option value="si" >Slovenia</option><option value="sb" >Solomon Islands</option><option value="so" >Somalia</option><option value="za" >South Africa</option><option value="ss" >South Sudan</option><option value="es" >Spain</option><option value="lk" >Sri Lanka</option><option value="kn" >St Kitts &amp; Nevis</option><option value="lc" >St Lucia</option><option value="xi" >St Paul &amp; Amsterdam Isl</option><option value="pm" >St Pierre &amp; Miquelon</option><option value="vc" >St Vincent &amp; Grenadines</option><option value="sd" >Sudan</option><option value="sr" >Suriname</option><option value="sj" >Svalbard &amp; Jan Mayen</option><option value="sz" >Swaziland</option><option value="se" >Sweden</option><option value="ch" >Switzerland</option><option value="sy" >Syria</option><option value="xh" >Tahiti</option><option value="tw" >Taiwan</option><option value="tj" >Tajikistan </option><option value="tz" >Tanzania</option><option value="th" >Thailand</option><option value="tg" >Togolese Rep</option><option value="tk" >Tokelau</option><option value="to" >Tonga</option><option value="tt" >Trinidad &amp; Tobago</option><option value="tn" >Tunisia</option><option value="tr" >Turkey</option><option value="tm" >Turkmenistan</option><option value="tc" >Turks &amp; Caicos Isl</option><option value="tv" >Tuvalu</option><option value="um" >US Minor Outlying Isls</option><option value="vi" >US Virgin Islands</option><option value="ug" >Uganda</option><option value="ua" >Ukraine</option><option value="ae" >United Arab Emirates (UAE)</option><option value="gb" >United Kingdom (UK)</option><option value="us" >United States (USA)</option><option value="zz" >Unknown</option><option value="uy" >Uruguay</option><option value="uz" >Uzbekistan</option><option value="vu" >Vanuatu</option><option value="va" >Vatican</option><option value="ve" >Venezuela</option><option value="vn" >Vietnam</option><option value="wf" >Wallis and Futuna</option><option value="eh" >Western Sahara</option><option value="ye" >Yemen</option><option value="zm" >Zambia</option><option value="zw" >Zimbabwe</option>
												</select>
											</div>																						
										</div>
										<div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Primary Contact</label>
                                                    <input class="form-control" id="length" type="text" placeholder="Enter Primary Contact" value="" name="primaryContact"/>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="beam">Registered Contact</label>
                                                    <input class="form-control" id="beam" type="text" placeholder="Enter Registered Contact" value="" name="regContact"/>
                                                </div>                                              
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Primary Address</label>
                                                    <textarea class="lh-base form-control" type="text" name="primaryAddr" placeholder="" rows="4"></textarea>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Registered Address</label>
                                                    <textarea class="lh-base form-control" type="text" name="regAddr" placeholder="" rows="4"></textarea>
                                                </div>                                                
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="yearOfStart">Year of Start</label>
                                                    <input class="form-control" id="yearOfStart" type="text" placeholder="Enter Operations Start Year" value="" name="yearOfStart"/>
                                                </div>                                                
                                                
                                            </div>										
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Next</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    </form>
                </main>
                
                <%@ include file="../includes/copyright.jsp" %>
                
            </div>
        </div>
        
        <%@ include file="../includes/bottom_includes.jsp" %>
       
</body>

<script>

var input = document.querySelector("#file-input");

document.getElementById("myBtn").addEventListener("click", function () {
  input.click();
});

input.addEventListener("change", preview);
function preview() {
  var fileObject = this.files[0];
  var fileReader = new FileReader();
  fileReader.readAsDataURL(fileObject);
  fileReader.onload = function () {
    var result = fileReader.result;
    var img = document.querySelector("#preview");
    img.setAttribute("src", result);
  };
}

</script>  
</html>
