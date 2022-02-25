<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Vessel</title>
    
        <%@ include file="../includes/header_includes.jsp" %>
    </head>
    <body class="nav-fixed">
    <%@ include file="../includes/top_nav_bar.jsp" %>
       
       
        <div id="layoutSidenav">
        
        <%@ include file="../includes/sidebar.jsp" %>
            
            <div id="layoutSidenav_content">
                <main>                
                <form method="POST" enctype="multipart/form-data" action="/vessel/add_vessel">
                <%@ include file="add_vessel_header.jsp" %>
                    
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
                                    <div class="card-header">Vessel Picture</div>
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
                                        <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="vesselName">Vessel Name</label>
                                                    <input class="form-control" name="vesselName" type="text" placeholder="Enter vessel name" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="imo">IMO</label>
                                                    <select class="form-select" aria-label="Default select example" name="vesselOwnerId">
														<option selected disabled>Select Owner of this Vessel:</option>
														<c:forEach items="${vesselOwners}" var="owner">
															<option value="${owner.id}">${owner.ownerName}</option>
														</c:forEach>
												</select>
                                                </div>
                                               
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                 <label class="small mb-1" for="callSign">CallSign</label>
                                                 <input class="form-control" name="callSign" type="text" placeholder="Enter call sign" value="" />
                                          		 </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="imo">IMO</label>
                                                    <input class="form-control" name="imo" type="text" placeholder="Enter IMO" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="mmsi">MMSI</label>
                                                    <input class="form-control" name="mmsi" type="text" placeholder="Enter MMSI" value="" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											<div class="col-md-4">
												<label class="small mb-1" for="flag">Flag</label>
												<select class="form-select" aria-label="Default select example" name="flag">
													<option selected disabled>Select a Flag:</option>
													<option value="xd" >Adelie Land</option><option value="af" >Afghanistan</option><option value="ax" >Aland Islands</option><option value="xc" >Alaska</option><option value="al" >Albania</option><option value="dz" >Algeria</option><option value="as" >American Samoa</option><option value="ad" >Andorra</option><option value="ao" >Angola</option><option value="ai" >Anguilla</option><option value="aq" >Antarctica</option><option value="ag" >Antigua &amp; Barbuda</option><option value="ar" >Argentina</option><option value="am" >Armenia</option><option value="aw" >Aruba</option><option value="xe" >Ascension Island</option><option value="au" >Australia</option><option value="at" >Austria</option><option value="az" >Azerbaijan</option><option value="xa" >Azores</option><option value="bs" >Bahamas</option><option value="bh" >Bahrain</option><option value="bd" >Bangladesh</option><option value="bb" >Barbados</option><option value="by" >Belarus</option><option value="be" >Belgium</option><option value="bz" >Belize</option><option value="bj" >Benin</option><option value="bm" >Bermuda</option><option value="bt" >Bhutan</option><option value="bo" >Bolivia</option><option value="bq" >Bonaire,St Eustatius &amp; Saba</option><option value="ba" >Bosnia &amp; Herzegovina</option><option value="bw" >Botswana</option><option value="br" >Brazil</option><option value="io" >British Indian Ocean Ter.</option><option value="vg" >British Virgin Islands</option><option value="bn" >Brunei</option><option value="bg" >Bulgaria</option><option value="bf" >Burkina Faso</option><option value="bi" >Burundi</option><option value="kh" >Cambodia</option><option value="cm" >Cameroon</option><option value="ca" >Canada</option><option value="cv" >Cape Verde</option><option value="ky" >Cayman Islands</option><option value="cf" >Central Africa Rep (CAR)</option><option value="td" >Chad</option><option value="cl" >Chile</option><option value="cn" >China</option><option value="cx" >Christmas Island</option><option value="cc" >Cocos Islands</option><option value="co" >Colombia</option><option value="km" >Comoros</option><option value="cg" >Congo</option><option value="ck" >Cook Islands</option><option value="cr" >Costa Rica</option><option value="ci" >Cote d&#39;Ivoire</option><option value="hr" >Croatia</option><option value="xf" >Crozet Archipelago</option><option value="cu" >Cuba</option><option value="cw" >Curacao</option><option value="cy" >Cyprus</option><option value="cz" >Czech Rep</option><option value="kp" >DPR Korea</option><option value="cd" >DR Congo</option><option value="dk" >Denmark</option><option value="dj" >Djibouti</option><option value="dm" >Dominica</option><option value="do" >Dominican Rep</option><option value="tl" >East Timor</option><option value="ec" >Ecuador</option><option value="eg" >Egypt</option><option value="sv" >El Salvador</option><option value="gq" >Equatorial Guinea</option><option value="er" >Eritrea</option><option value="ee" >Estonia</option><option value="et" >Ethiopia</option><option value="fo" >Faeroe Islands</option><option value="fk" >Falkland Islands</option><option value="fj" >Fiji</option><option value="fi" >Finland</option><option value="fr" >France</option><option value="pf" >French Polynesia</option><option value="ga" >Gabon</option><option value="gm" >Gambia</option><option value="ge" >Georgia</option><option value="de" >Germany</option><option value="gh" >Ghana</option><option value="gi" >Gibraltar</option><option value="gr" >Greece</option><option value="gl" >Greenland</option><option value="gd" >Grenada</option><option value="gp" >Guadeloupe</option><option value="gu" >Guam</option><option value="gt" >Guatemala</option><option value="gg" >Guernsey</option><option value="gf" >Guiana</option><option value="gn" >Guinea</option><option value="gw" >Guinea-Bissau</option><option value="gy" >Guyana</option><option value="ht" >Haiti</option><option value="hm" >Heard Isl &amp; McDonald Isls</option><option value="hn" >Honduras</option><option value="hk" >Hong Kong</option><option value="hu" >Hungary</option><option value="is" >Iceland</option><option value="in" >India</option><option value="id" >Indonesia</option><option value="ir" >Iran</option><option value="iq" >Iraq</option><option value="ie" >Ireland</option><option value="im" >Isle of Man</option><option value="il" >Israel</option><option value="it" >Italy</option><option value="jm" >Jamaica</option><option value="jp" >Japan</option><option value="je" >Jersey</option><option value="jo" >Jordan</option><option value="kz" >Kazakhstan</option><option value="ke" >Kenya</option><option value="xg" >Kerguelen Islands</option><option value="ki" >Kiribati</option><option value="kr" >Korea</option><option value="kw" >Kuwait</option><option value="kg" >Kyrgyz Rep</option><option value="la" >Laos</option><option value="lv" >Latvia</option><option value="lb" >Lebanon</option><option value="ls" >Lesotho</option><option value="lr" >Liberia</option><option value="ly" >Libya</option><option value="li" >Liechtenstein</option><option value="lt" >Lithuania</option><option value="lu" >Luxembourg</option><option value="mo" >Macao</option><option value="mk" >Macedonia</option><option value="mg" >Madagascar</option><option value="xb" >Madeira</option><option value="mw" >Malawi</option><option value="my" >Malaysia</option><option value="mv" >Maldives</option><option value="ml" >Mali</option><option value="mt" >Malta</option><option value="mh" >Marshall Islands</option><option value="mq" >Martinique</option><option value="mr" >Mauritania</option><option value="mu" >Mauritius</option><option value="yt" >Mayotte</option><option value="mx" >Mexico</option><option value="fm" >Micronesia</option><option value="md" >Moldova</option><option value="mc" >Monaco</option><option value="mn" >Mongolia</option><option value="me" >Montenegro</option><option value="ms" >Montserrat</option><option value="ma" >Morocco</option><option value="mz" >Mozambique</option><option value="mm" >Myanmar</option><option value="mp" >N. Mariana Isl</option><option value="na" >Namibia</option><option value="nr" >Nauru</option><option value="np" >Nepal</option><option value="nl" >Netherlands</option><option value="an" >Netherlands Antilles</option><option value="nc" >New Caledonia</option><option value="nz" >New Zealand</option><option value="ni" >Nicaragua</option><option value="ne" >Niger</option><option value="ng" >Nigeria</option><option value="nu" >Niue</option><option value="nf" >Norfolk Island</option><option value="no" >Norway</option><option value="om" >Oman</option><option value="pk" >Pakistan</option><option value="pw" >Palau</option><option value="ps" >Palestine</option><option value="pa" >Panama</option><option value="pg" >Papua New Guinea</option><option value="py" >Paraguay</option><option value="pe" >Peru</option><option value="ph" >Philippines</option><option value="pn" >Pitcairn Island</option><option value="pl" >Poland</option><option value="pt" >Portugal</option><option value="pr" >Puerto Rico</option><option value="qa" >Qatar</option><option value="re" >Reunion</option><option value="ro" >Romania</option><option value="ru" >Russia</option><option value="rw" >Rwanda</option><option value="gs" >S.Georgia &amp; S.Sandwich Isls</option><option value="sh" >Saint Helena</option><option value="mf" >Saint Martin (FR)</option><option value="ws" >Samoa</option><option value="sm" >San Marino</option><option value="st" >Sao Tome &amp; Principe</option><option value="sa" >Saudi Arabia</option><option value="sn" >Senegal</option><option value="rs" >Serbia</option><option value="sc" >Seychelles</option><option value="sl" >Sierra Leone</option><option value="sg" >Singapore</option><option value="sx" >Sint Maarten (NL)</option><option value="sk" >Slovakia</option><option value="si" >Slovenia</option><option value="sb" >Solomon Islands</option><option value="so" >Somalia</option><option value="za" >South Africa</option><option value="ss" >South Sudan</option><option value="es" >Spain</option><option value="lk" >Sri Lanka</option><option value="kn" >St Kitts &amp; Nevis</option><option value="lc" >St Lucia</option><option value="xi" >St Paul &amp; Amsterdam Isl</option><option value="pm" >St Pierre &amp; Miquelon</option><option value="vc" >St Vincent &amp; Grenadines</option><option value="sd" >Sudan</option><option value="sr" >Suriname</option><option value="sj" >Svalbard &amp; Jan Mayen</option><option value="sz" >Swaziland</option><option value="se" >Sweden</option><option value="ch" >Switzerland</option><option value="sy" >Syria</option><option value="xh" >Tahiti</option><option value="tw" >Taiwan</option><option value="tj" >Tajikistan </option><option value="tz" >Tanzania</option><option value="th" >Thailand</option><option value="tg" >Togolese Rep</option><option value="tk" >Tokelau</option><option value="to" >Tonga</option><option value="tt" >Trinidad &amp; Tobago</option><option value="tn" >Tunisia</option><option value="tr" >Turkey</option><option value="tm" >Turkmenistan</option><option value="tc" >Turks &amp; Caicos Isl</option><option value="tv" >Tuvalu</option><option value="um" >US Minor Outlying Isls</option><option value="vi" >US Virgin Islands</option><option value="ug" >Uganda</option><option value="ua" >Ukraine</option><option value="ae" >United Arab Emirates (UAE)</option><option value="gb" >United Kingdom (UK)</option><option value="us" >United States (USA)</option><option value="zz" >Unknown</option><option value="uy" >Uruguay</option><option value="uz" >Uzbekistan</option><option value="vu" >Vanuatu</option><option value="va" >Vatican</option><option value="ve" >Venezuela</option><option value="vn" >Vietnam</option><option value="wf" >Wallis and Futuna</option><option value="eh" >Western Sahara</option><option value="ye" >Yemen</option><option value="zm" >Zambia</option><option value="zw" >Zimbabwe</option>
												</select>
											</div>											
											<div class="col-md-4">
												<label class="small mb-1" for="vesselTypeId">Vessel Type</label>
												<select class="form-select" aria-label="Default select example" name="vesselTypeId">
													<option selected disabled>Select a Type:</option>
													<c:forEach items="${vesselTypes}" var="vesselType">
														<option value="${vesselType.typeId}">${vesselType.desc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-md-4">
												<label class="small mb-1" for="vesselSubTypeId">Vessel Sub Type</label>
												<select class="form-select" aria-label="Default select example" name="vesselSubTypeId">
													<option selected disabled>Select a Sub-Type:</option>
													<c:forEach var="optionGroup" items="${vesselSubTypeMap}">
												       <optgroup label="${optionGroup.key}">
												       <c:forEach var="option" items="${optionGroup.value}">
												          <option value="${option.typeId}">${option.desc}</option>                             
												       </c:forEach>                                                          
												       </optgroup>
												    </c:forEach>
												    
													<c:forEach items="${vesselSubTypes}" var="vesselSubType">
														<optgroup label="Cargo">
															<option value="${vesselSubType.typeId}">${vesselSubType.desc}</option>
														</optgroup>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Length Overall (m)</label>
                                                    <input class="form-control" id="length" name="length" type="text" placeholder="Enter Overall Lenth in meters" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="beam">Beam (m)</label>
                                                    <input class="form-control" id="beam" name="beam" type="text" placeholder="Enter Beam length in meters" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="draught">Draught (m)</label>
                                                    <input class="form-control" id="draught" name="draught" type="text" placeholder="Enter Draught length in meters" value="" />
                                                </div>                                                
                                            </div>
                                            <div class="row gx-3 mb-3">
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="yearOfBuilt">Year of Built</label>
                                                    <input class="form-control" id="yearOfBuilt" name="yearOfBuilt" type="text" placeholder="Enter Gross Tonnage" value="" />
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="length">Homeport</label>
                                                    <select class="form-select" aria-label="Select a Home-Port" name="homeportId">
														<option selected disabled>Select a Home-Port</option>
														<option value="1">Port 1</option>
														<option value="2">Port 2</option>
														<option value="3">Port 3</option>
													</select>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="small mb-1" for="grossTon">Gross Tonnage</label>
                                                    <input class="form-control" name="grossTon" type="text" placeholder="Enter vessel name" value="" />
                                                </div>
                                            </div>
										<div class="row gx-3 mb-3">
											
											<div class="col-md-4">
												Vessel Description <i class="text-muted" data-feather="info"
													data-bs-toggle="tooltip" data-bs-placement="left"
													title="The post preview text shows below the post title, and is the post summary on blog pages."></i>
												<textarea class="lh-base form-control" type="text" name="vesselDesc" placeholder="" rows="4"></textarea>
											</div>											
										</div>
										<!-- Save changes button-->
                                            <button class="btn btn-primary" type="submit">Next</button>
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
